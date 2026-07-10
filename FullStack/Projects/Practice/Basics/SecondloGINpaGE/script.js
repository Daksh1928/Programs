(() => {
  'use strict';

  const form = document.getElementById('loginForm');
  const usernameInput = document.getElementById('username');
  const passwordInput = document.getElementById('password');
  const rememberMe = document.getElementById('rememberMe');
  const submitBtn = document.querySelector('.btn');

  if (!form || !usernameInput || !passwordInput || !submitBtn) {
    console.error('Login page elements were not found. Check your HTML ids.');
    return;
  }

  const CONFIG = {
    minUsername: 4,
    maxUsername: 20,
    minPassword: 8,
    maxPassword: 64,
    maxAttempts: 5,
    lockMs: 30_000,
    storageKey: 'modern_login_state_v1',
    rememberKey: 'modern_login_remember_v1',
    themeKey: 'modern_login_theme_v1'
  };

  const DEMO_USER = 'devanshu';
  const DEMO_PASS = 'devanshu';

  const now = () => Date.now();
  const sleep = (ms) => new Promise((resolve) => setTimeout(resolve, ms));

  const loadJSON = (key, fallback) => {
    try {
      const raw = localStorage.getItem(key);
      return raw ? JSON.parse(raw) : fallback;
    } catch {
      return fallback;
    }
  };

  const saveJSON = (key, value) => {
    localStorage.setItem(key, JSON.stringify(value));
  };

  const getState = () => loadJSON(CONFIG.storageKey, {
    attempts: 0,
    lockedUntil: 0,
    lastUsername: '',
    lastLoginAt: '',
    history: []
  });

  const setState = (nextState) => saveJSON(CONFIG.storageKey, nextState);

  const sanitize = (value) => value.trim().replace(/\s+/g, ' ');

  function ensureToastHost() {
    let host = document.querySelector('.toast-host');
    if (!host) {
      host = document.createElement('div');
      host.className = 'toast-host';
      document.body.appendChild(host);
    }
    return host;
  }

  function toast(message, type = 'info', ttl = 2600) {
    const host = ensureToastHost();
    const el = document.createElement('div');
    el.className = `toast ${type}`;
    el.textContent = message;
    host.appendChild(el);

    requestAnimationFrame(() => el.classList.add('show'));

    window.setTimeout(() => {
      el.classList.remove('show');
      window.setTimeout(() => el.remove(), 220);
    }, ttl);
  }

  function getOrCreateMessage(input) {
    let node = input.parentElement.querySelector('.field-msg');
    if (!node) {
      node = document.createElement('div');
      node.className = 'field-msg';
      input.parentElement.appendChild(node);
    }
    return node;
  }

  function setFieldState(input, state, message = '') {
    input.classList.remove('field-error', 'field-success');
    if (state === 'error') input.classList.add('field-error');
    if (state === 'success') input.classList.add('field-success');

    const msg = getOrCreateMessage(input);
    msg.className = `field-msg${state ? ` ${state}` : ''}`;
    msg.textContent = message;
  }

  function clearFieldState(input) {
    input.classList.remove('field-error', 'field-success');
    const msg = input.parentElement.querySelector('.field-msg');
    if (msg) {
      msg.className = 'field-msg';
      msg.textContent = '';
    }
  }

  function shakeForm() {
    form.classList.remove('shake');
    void form.offsetWidth;
    form.classList.add('shake');
  }

  function setLoading(isLoading) {
    submitBtn.disabled = isLoading;
    submitBtn.classList.toggle('is-loading', isLoading);
  }

  function makePasswordToggle() {
    if (document.getElementById('passwordToggleBtn')) return;

    const btn = document.createElement('button');
    btn.type = 'button';
    btn.id = 'passwordToggleBtn';
    btn.className = 'eye-btn';
    btn.setAttribute('aria-label', 'Show password');
    btn.textContent = '👁';

    passwordInput.parentElement.appendChild(btn);

    btn.addEventListener('click', () => {
      const isHidden = passwordInput.type === 'password';
      passwordInput.type = isHidden ? 'text' : 'password';
      btn.textContent = isHidden ? '🙈' : '👁';
      btn.setAttribute('aria-label', isHidden ? 'Hide password' : 'Show password');
      passwordInput.focus();
    });
  }

  function makeStrengthUI() {
    if (document.getElementById('passwordMeter')) return;

    const meter = document.createElement('div');
    meter.className = 'password-meter';
    meter.id = 'passwordMeter';
    meter.innerHTML = '<span></span>';

    const label = document.createElement('div');
    label.className = 'strength-label';
    label.id = 'strengthLabel';

    passwordInput.parentElement.insertAdjacentElement('afterend', meter);
    meter.insertAdjacentElement('afterend', label);
  }

  function makeThemeToggle() {
    if (document.getElementById('themeToggle')) return;

    const btn = document.createElement('button');
    btn.type = 'button';
    btn.id = 'themeToggle';
    btn.className = 'theme-toggle';
    btn.textContent = 'Toggle dark / light mode';
    form.appendChild(btn);

    btn.addEventListener('click', () => {
      const light = document.body.classList.toggle('theme-light');
      localStorage.setItem(CONFIG.themeKey, light ? 'light' : 'dark');
      toast(`Theme changed to ${light ? 'light' : 'dark'} mode`, 'info');
    });
  }

  function passwordStrength(password) {
    const score = [
      password.length >= 8,
      /[a-z]/.test(password),
      /[A-Z]/.test(password),
      /\d/.test(password),
      /[^A-Za-z0-9]/.test(password)
    ].filter(Boolean).length;

    const labels = ['Very weak', 'Weak', 'Fair', 'Good', 'Strong'];
    return {
      percent: (score / 5) * 100,
      label: labels[Math.max(0, score - 1)] || 'Very weak'
    };
  }

  function updateStrengthUI() {
    const bar = document.querySelector('#passwordMeter > span');
    const label = document.getElementById('strengthLabel');
    if (!bar || !label) return;

    if (!passwordInput.value) {
      bar.style.width = '0%';
      label.textContent = '';
      return;
    }

    const strength = passwordStrength(passwordInput.value);
    bar.style.width = `${strength.percent}%`;
    label.textContent = `Password strength: ${strength.label}`;
  }

  function isValidUsername(value) {
    return /^[A-Za-z0-9._]+$/.test(value) && value.length >= CONFIG.minUsername && value.length <= CONFIG.maxUsername;
  }

  function isValidPassword(value) {
    return /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[^A-Za-z0-9]).{8,64}$/.test(value);
  }

  function validateUsername(show = true) {
    const value = sanitize(usernameInput.value);

    if (!value) {
      if (show) setFieldState(usernameInput, 'error', 'Username is required.');
      return false;
    }
    if (value.length < CONFIG.minUsername) {
      if (show) setFieldState(usernameInput, 'error', `Username must be at least ${CONFIG.minUsername} characters.`);
      return false;
    }
    if (value.length > CONFIG.maxUsername) {
      if (show) setFieldState(usernameInput, 'error', `Username must be at most ${CONFIG.maxUsername} characters.`);
      return false;
    }
    if (!isValidUsername(value)) {
      if (show) setFieldState(usernameInput, 'error', 'Use letters, numbers, dot, or underscore only.');
      return false;
    }

    if (show) setFieldState(usernameInput, 'success', 'Looks good.');
    return true;
  }

  function validatePassword(show = true) {
    const value = passwordInput.value;

    if (!value) {
      if (show) setFieldState(passwordInput, 'error', 'Password is required.');
      return false;
    }
    if (value.length < CONFIG.minPassword) {
      if (show) setFieldState(passwordInput, 'error', `Password must be at least ${CONFIG.minPassword} characters.`);
      return false;
    }
    if (value.length > CONFIG.maxPassword) {
      if (show) setFieldState(passwordInput, 'error', `Password must be at most ${CONFIG.maxPassword} characters.`);
      return false;
    }
    if (!isValidPassword(value)) {
      if (show) setFieldState(passwordInput, 'error', 'Use uppercase, lowercase, number, and symbol.');
      return false;
    }

    if (show) setFieldState(passwordInput, 'success', 'Strong password.');
    return true;
  }

  function validateForm(show = true) {
    const okUser = validateUsername(show);
    const okPass = validatePassword(show);
    return okUser && okPass;
  }

  function isLocked() {
    return getState().lockedUntil > now();
  }

  function renderLockStatus() {
    const state = getState();
    let box = document.getElementById('lockStatus');

    if (!box) {
      box = document.createElement('div');
      box.id = 'lockStatus';
      box.className = 'strength-label';
      form.insertBefore(box, submitBtn);
    }

    if (state.lockedUntil > now()) {
      const seconds = Math.ceil((state.lockedUntil - now()) / 1000);
      box.textContent = `Too many attempts. Try again in ${seconds}s.`;
    } else {
      box.textContent = '';
    }
  }

  function saveLoginHistory(username, success) {
    const state = getState();
    state.history.unshift({
      username,
      success,
      time: new Date().toISOString()
    });
    state.history = state.history.slice(0, 10);
    state.lastUsername = username;
    if (success) state.lastLoginAt = new Date().toISOString();
    setState(state);
  }

  async function fakeAuth(username, password) {
    await sleep(700);
    return username === DEMO_USER && password === DEMO_PASS;
  }

  async function handleSubmit(event) {
    event.preventDefault();

    if (isLocked()) {
      renderLockStatus();
      toast('Account is temporarily locked. Please wait.', 'warn', 3200);
      shakeForm();
      return;
    }

    const username = sanitize(usernameInput.value);
    const password = passwordInput.value.trim();
    usernameInput.value = username;
    passwordInput.value = password;

    if (!validateForm(true)) {
      toast('Please fix the highlighted fields.', 'error');
      shakeForm();
      return;
    }

    setLoading(true);
    toast('Checking credentials...', 'info', 1200);

    try {
      const success = await fakeAuth(username, password);

      if (success) {
        const state = getState();
        state.attempts = 0;
        state.lockedUntil = 0;
        state.lastUsername = username;
        setState(state);
        saveLoginHistory(username, true);

        if (rememberMe?.checked) {
          localStorage.setItem(CONFIG.rememberKey, username);
        } else {
          localStorage.removeItem(CONFIG.rememberKey);
        }

        setFieldState(usernameInput, 'success', 'Authenticated.');
        setFieldState(passwordInput, 'success', 'Authenticated.');
        toast(`Welcome back, ${username}!`, 'success');

        // Replace with your real redirect when backend is ready.
        // window.location.href = 'dashboard.html';
      } else {
        const state = getState();
        state.attempts += 1;
        const remaining = CONFIG.maxAttempts - state.attempts;

        if (remaining <= 0) {
          state.lockedUntil = now() + CONFIG.lockMs;
          state.attempts = 0;
          toast('Too many failed attempts. Locked for 30 seconds.', 'error', 3600);
        } else {
          toast(`Invalid credentials. ${remaining} attempt(s) left.`, 'error');
        }

        setState(state);
        saveLoginHistory(username, false);
        setFieldState(passwordInput, 'error', 'Invalid username or password.');
        shakeForm();
      }
    } catch (error) {
      console.error(error);
      toast('Something went wrong. Try again.', 'error');
    } finally {
      setLoading(false);
      renderLockStatus();
    }
  }

  function applySavedTheme() {
    const theme = localStorage.getItem(CONFIG.themeKey);
    document.body.classList.toggle('theme-light', theme === 'light');
  }

  function applyRememberMe() {
    const remembered = localStorage.getItem(CONFIG.rememberKey);
    if (remembered) {
      usernameInput.value = remembered;
      if (rememberMe) rememberMe.checked = true;
      return;
    }

    const state = getState();
    if (state.lastUsername && !usernameInput.value) {
      usernameInput.value = state.lastUsername;
    }
  }

  function bindEvents() {
    form.addEventListener('submit', handleSubmit);

    usernameInput.addEventListener('input', () => {
      clearFieldState(usernameInput);
      validateUsername(false);

      const state = getState();
      state.lastUsername = usernameInput.value.trim();
      setState(state);
    });

    passwordInput.addEventListener('input', () => {
      clearFieldState(passwordInput);
      validatePassword(false);
      updateStrengthUI();
    });

    usernameInput.addEventListener('blur', () => validateUsername(true));
    passwordInput.addEventListener('blur', () => validatePassword(true));

    passwordInput.addEventListener('keydown', (event) => {
      if (event.key === 'Enter') {
        event.preventDefault();
        form.requestSubmit();
      }
    });

    usernameInput.addEventListener('keydown', (event) => {
      if (event.key === 'Enter') {
        event.preventDefault();
        passwordInput.focus();
      }
    });

    document.addEventListener('keydown', (event) => {
      if (event.key === 'Escape') {
        form.reset();
        clearFieldState(usernameInput);
        clearFieldState(passwordInput);
        updateStrengthUI();
        toast('Form cleared.', 'info', 1400);
      }
    });

    passwordInput.addEventListener('keydown', (event) => {
      const lockStatus = document.getElementById('lockStatus');
      if (event.getModifierState && event.getModifierState('CapsLock') && lockStatus) {
        lockStatus.textContent = 'Caps Lock is ON';
      }
    });

    passwordInput.addEventListener('keyup', (event) => {
      const lockStatus = document.getElementById('lockStatus');
      if (lockStatus && (!event.getModifierState || !event.getModifierState('CapsLock')) && !isLocked()) {
        lockStatus.textContent = '';
      }
    });

    window.addEventListener('offline', () => toast('You are offline.', 'warn'));
    window.addEventListener('online', () => toast('Connection restored.', 'success'));
  }

  function init() {
    applySavedTheme();
    makePasswordToggle();
    makeStrengthUI();
    makeThemeToggle();
    applyRememberMe();
    bindEvents();
    updateStrengthUI();
    renderLockStatus();
    usernameInput.focus();

    if (usernameInput.value) validateUsername(false);
    if (passwordInput.value) validatePassword(false);

    setInterval(renderLockStatus, 1000);
  }

  init();
})();