// const form = document.getElementById('logInForm')

// form.addEventListener("submit",function(events){
//     events.preventDefault();
//     const username = document.getElementById('Username').value.trim();
//     const password = document.getElementById('Password').value.trim();
     
//     if(username === "" || password === ""){
//         alert("Please fill in all fields");
//         return;
//     }
//      if(username.length<5 || username.length>20){
//         alert("Username must be between 5 and 20 characters long");
//         return;
//      }
//     if(password.length<8 || password.length>20){
//         alert("Password must be between 8 and 20 characters long");
//         return;
//     }

// })
// usernameInput.classList.add("error");





// Advanced login UX script for the current page.
// Works with the existing HTML ids:
// form#logInForm, input#Username, input#Password

(() => {
  'use strict';

  const form = document.getElementById('logInForm');
  const usernameInput = document.getElementById('Username');
  const passwordInput = document.getElementById('Password');
  const rememberMe = document.querySelector('.remember-forget input[type="checkbox"]');
  const submitBtn = document.querySelector('.btn');

  if (!form || !usernameInput || !passwordInput || !submitBtn) {
    console.error('Login script: required elements not found. Check your HTML ids.');
    return;
  }

  // ---------- Configuration ----------
  const CONFIG = {
    minUsername: 4,
    maxUsername: 20,
    minPassword: 8,
    maxPassword: 64,
    maxAttempts: 5,
    lockMs: 30_000,
    storageKey: 'demo_login_state_v1',
    rememberKey: 'demo_login_remember_v1',
    themeKey: 'demo_login_theme_v1',
  };

  // Demo credentials (frontend-only demo; real auth must happen on backend)
  const DEMO_USER = 'devanshu';
  const DEMO_PASS = 'devanshu';

  // ---------- Small helpers ----------
  const qs = (sel, root = document) => root.querySelector(sel);
  const qsa = (sel, root = document) => [...root.querySelectorAll(sel)];
  const now = () => Date.now();
  const sleep = (ms) => new Promise((r) => setTimeout(r, ms));

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

  const escapeHTML = (str) =>
    String(str)
      .replaceAll('&', '&amp;')
      .replaceAll('<', '&lt;')
      .replaceAll('>', '&gt;')
      .replaceAll('"', '&quot;')
      .replaceAll("'", '&#39;');

  // ---------- UI helpers ----------
  function ensureStyles() {
    if (document.getElementById('login-extra-styles')) return;

    const style = document.createElement('style');
    style.id = 'login-extra-styles';
    style.textContent = `
      .field-error {
        border-color: #ff5b5b !important;
        box-shadow: 0 0 0 3px rgba(255, 91, 91, 0.18) !important;
      }
      .field-success {
        border-color: #59d98e !important;
        box-shadow: 0 0 0 3px rgba(89, 217, 142, 0.16) !important;
      }
      .shake {
        animation: shake 0.38s linear 1;
      }
      @keyframes shake {
        0%, 100% { transform: translateX(0); }
        20% { transform: translateX(-8px); }
        40% { transform: translateX(8px); }
        60% { transform: translateX(-6px); }
        80% { transform: translateX(6px); }
      }
      .toast-host {
        position: fixed;
        right: 16px;
        top: 16px;
        z-index: 99999;
        display: grid;
        gap: 10px;
        pointer-events: none;
      }
      .toast {
        min-width: 260px;
        max-width: 340px;
        padding: 12px 14px;
        border-radius: 14px;
        color: #fff;
        font-size: 14px;
        line-height: 1.35;
        backdrop-filter: blur(12px);
        box-shadow: 0 12px 30px rgba(0,0,0,.22);
        transform: translateY(-6px);
        opacity: 0;
        transition: opacity .2s ease, transform .2s ease;
      }
      .toast.show { opacity: 1; transform: translateY(0); }
      .toast.info { background: rgba(23, 82, 204, .92); }
      .toast.success { background: rgba(19, 128, 77, .92); }
      .toast.error { background: rgba(176, 36, 36, .92); }
      .toast.warn { background: rgba(163, 99, 0, .92); }
      .field-msg {
        margin-top: 8px;
        font-size: 12.5px;
        line-height: 1.35;
        min-height: 16px;
        color: #fff;
        opacity: .95;
      }
      .field-msg.error { color: #ffb3b3; }
      .field-msg.success { color: #b8ffd2; }
      .password-meter {
        margin-top: -18px;
        margin-bottom: 18px;
        height: 8px;
        border-radius: 999px;
        overflow: hidden;
        background: rgba(255,255,255,.12);
      }
      .password-meter > span {
        display: block;
        height: 100%;
        width: 0%;
        border-radius: inherit;
        transition: width .2s ease;
        background: linear-gradient(90deg, #ff4d4d, #ffcc00, #63d471);
      }
      .strength-label {
        font-size: 12px;
        margin-top: 6px;
        margin-bottom: 18px;
        min-height: 16px;
        color: rgba(255,255,255,.9);
      }
      .eye-btn {
        position: absolute;
        right: 14px;
        top: 50%;
        transform: translateY(-50%);
        border: none;
        background: transparent;
        color: #fff;
        cursor: pointer;
        font-size: 18px;
        padding: 6px;
        line-height: 1;
      }
      .eye-btn:focus { outline: 2px solid rgba(255,255,255,.8); outline-offset: 2px; }
      .caps-lock {
        margin-top: 8px;
        font-size: 12px;
        color: #ffd36b;
        min-height: 16px;
      }
      .btn[disabled] {
        opacity: .72;
        cursor: not-allowed;
        filter: grayscale(.25);
      }
      .theme-toggle {
        margin-top: 16px;
        width: 100%;
        border: 1px solid rgba(255,255,255,.22);
        background: rgba(255,255,255,.08);
        color: #fff;
        padding: 10px 14px;
        border-radius: 999px;
        cursor: pointer;
        font: inherit;
      }
      .theme-light body,
      body.theme-light {
        background: #eef5ff !important;
      }
      body.theme-light .wrapper {
        color: #1f2937;
        border-color: rgba(0,0,0,.08);
        background: rgba(255,255,255,.4);
      }
      body.theme-light .input-box input,
      body.theme-light .remember-forget a,
      body.theme-light .remember-forget label,
      body.theme-light .register-link p,
      body.theme-light .register-link a,
      body.theme-light .caps-lock,
      body.theme-light .strength-label,
      body.theme-light .field-msg {
        color: #1f2937;
      }
      body.theme-light .input-box input::placeholder { color: rgba(31,41,55,.65); }
      body.theme-light .input-box input { border-color: rgba(0,0,0,.16); }
    `;
    document.head.appendChild(style);
  }

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

  function getOrCreateMsgBox(input) {
    let box = input.parentElement.querySelector('.field-msg');
    if (!box) {
      box = document.createElement('div');
      box.className = 'field-msg';
      input.parentElement.appendChild(box);
    }
    return box;
  }

  function setFieldState(input, state, message = '') {
    input.classList.remove('field-error', 'field-success');
    if (state === 'error') input.classList.add('field-error');
    if (state === 'success') input.classList.add('field-success');

    const box = getOrCreateMsgBox(input);
    box.className = `field-msg${state ? ` ${state}` : ''}`;
    box.textContent = message;
  }

  function clearFieldState(input) {
    input.classList.remove('field-error', 'field-success');
    const box = input.parentElement.querySelector('.field-msg');
    if (box) {
      box.className = 'field-msg';
      box.textContent = '';
    }
  }

  function setButtonLoading(isLoading) {
    submitBtn.disabled = isLoading;
    submitBtn.dataset.originalText ||= submitBtn.textContent;
    submitBtn.textContent = isLoading ? 'Logging in...' : submitBtn.dataset.originalText;
  }

  function shakeForm() {
    form.classList.remove('shake');
    void form.offsetWidth; // restart animation
    form.classList.add('shake');
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
    passwordInput.parentElement.insertAdjacentElement('afterend', meter);

    const label = document.createElement('div');
    label.className = 'strength-label';
    label.id = 'strengthLabel';
    passwordInput.parentElement.insertAdjacentElement('afterend', label);
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
      const next = document.body.classList.toggle('theme-light');
      localStorage.setItem(CONFIG.themeKey, next ? 'light' : 'dark');
      toast(`Theme changed to ${next ? 'light' : 'dark'} mode`, 'info');
    });
  }

  function passwordStrength(password) {
    let score = 0;
    const tests = [
      password.length >= 8,
      /[a-z]/.test(password),
      /[A-Z]/.test(password),
      /\d/.test(password),
      /[^A-Za-z0-9]/.test(password),
    ];
    score = tests.filter(Boolean).length;

    const labels = ['Very weak', 'Weak', 'Fair', 'Good', 'Strong'];
    return {
      score,
      percent: (score / 5) * 100,
      label: labels[Math.max(0, score - 1)] || 'Very weak',
    };
  }

  function updateStrengthUI() {
    const meter = document.querySelector('#passwordMeter > span');
    const label = document.getElementById('strengthLabel');
    if (!meter || !label) return;

    const { percent, label: text } = passwordStrength(passwordInput.value);
    meter.style.width = `${percent}%`;
    label.textContent = passwordInput.value ? `Password strength: ${text}` : '';
  }

  function isValidUsername(username) {
    // accepts letters, numbers, dot, underscore; 4-20 chars
    return /^[A-Za-z0-9._]+$/.test(username) && username.length >= CONFIG.minUsername && username.length <= CONFIG.maxUsername;
  }

  function isValidPassword(password) {
    // at least 8 chars, 1 upper, 1 lower, 1 digit, 1 special
    const strong = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[^A-Za-z0-9]).{8,64}$/;
    return strong.test(password) && password.length >= CONFIG.minPassword && password.length <= CONFIG.maxPassword;
  }

  function sanitizeLoginInput(value) {
    return value.trim().replace(/\s+/g, ' ');
  }

  function getState() {
    return loadJSON(CONFIG.storageKey, {
      attempts: 0,
      lockedUntil: 0,
      lastUsername: '',
      lastLoginAt: '',
      history: [],
    });
  }

  function setState(nextState) {
    saveJSON(CONFIG.storageKey, nextState);
  }

  function isLocked() {
    const state = getState();
    return state.lockedUntil && state.lockedUntil > now();
  }

  function renderLockStatus() {
    const state = getState();
    let lockBox = document.getElementById('lockStatus');
    if (!lockBox) {
      lockBox = document.createElement('div');
      lockBox.id = 'lockStatus';
      lockBox.className = 'caps-lock';
      form.insertBefore(lockBox, submitBtn);
    }

    if (state.lockedUntil > now()) {
      const sec = Math.ceil((state.lockedUntil - now()) / 1000);
      lockBox.textContent = `Too many attempts. Try again in ${sec}s.`;
    } else {
      lockBox.textContent = '';
    }
  }

  function setRememberedUsername() {
    const remembered = localStorage.getItem(CONFIG.rememberKey);
    if (remembered) {
      usernameInput.value = remembered;
      if (rememberMe) rememberMe.checked = true;
    }

    const state = getState();
    if (!remembered && state.lastUsername) {
      usernameInput.value = state.lastUsername;
    }
  }

  function saveLoginHistory(username, success) {
    const state = getState();
    state.history.unshift({
      username,
      success,
      time: new Date().toISOString(),
    });
    state.history = state.history.slice(0, 10);
    state.lastUsername = username;
    if (success) state.lastLoginAt = new Date().toISOString();
    setState(state);
  }

  function handleCapsLock(event) {
    const box = document.getElementById('lockStatus');
    if (!box) return;
    const capsOn = event.getModifierState && event.getModifierState('CapsLock');
    if (capsOn) {
      box.textContent = 'Caps Lock is ON';
    } else if (!isLocked()) {
      box.textContent = '';
    }
  }

  // ---------- Validation ----------
  function validateUsername(show = true) {
    const value = sanitizeLoginInput(usernameInput.value);
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
    if (!/^[A-Za-z0-9._]+$/.test(value)) {
      if (show) setFieldState(usernameInput, 'error', 'Use only letters, numbers, dot, or underscore.');
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

  // ---------- Login flow ----------
  async function loginFlow(username, password) {
    // Demo network delay, so the UI feels like a real app
    await sleep(700);

    // Frontend demo check only.
    // Replace this with fetch() to your backend later.
    return username === DEMO_USER && password === DEMO_PASS;
  }

  async function handleSubmit(event) {
    event.preventDefault();

    if (isLocked()) {
      renderLockStatus();
      toast('Account is temporarily locked. Please wait.', 'warn');
      shakeForm();
      return;
    }

    const username = sanitizeLoginInput(usernameInput.value);
    const password = passwordInput.value.trim();

    usernameInput.value = username;
    passwordInput.value = password;

    const ok = validateForm(true);
    if (!ok) {
      toast('Please fix the highlighted fields.', 'error');
      shakeForm();
      return;
    }

    setButtonLoading(true);
    toast('Checking credentials...', 'info', 1400);

    try {
      const success = await loginFlow(username, password);
      if (success) {
        const state = getState();
        state.attempts = 0;
        state.lockedUntil = 0;
        state.lastUsername = username;
        if (rememberMe?.checked) {
          localStorage.setItem(CONFIG.rememberKey, username);
        } else {
          localStorage.removeItem(CONFIG.rememberKey);
        }
        setState(state);
        saveLoginHistory(username, true);

        toast(`Welcome back, ${escapeHTML(username)}!`, 'success');
        setFieldState(usernameInput, 'success', 'Authenticated.');
        setFieldState(passwordInput, 'success', 'Authenticated.');

        // Example redirect hook:
        // window.location.href = '/dashboard.html';
      } else {
        const state = getState();
        state.attempts += 1;
        const remaining = CONFIG.maxAttempts - state.attempts;

        if (remaining <= 0) {
          state.lockedUntil = now() + CONFIG.lockMs;
          state.attempts = 0;
          toast('Too many failed attempts. Account locked for 30 seconds.', 'error', 3600);
        } else {
          toast(`Invalid credentials. ${remaining} attempt(s) left.`, 'error');
        }

        setState(state);
        saveLoginHistory(username, false);
        setFieldState(passwordInput, 'error', 'Invalid username or password.');
        shakeForm();
      }
    } catch (err) {
      console.error(err);
      toast('Something went wrong. Try again.', 'error');
    } finally {
      setButtonLoading(false);
      renderLockStatus();
    }
  }

  // ---------- Advanced / UX events ----------
  function bindEvents() {
    form.addEventListener('submit', handleSubmit);

    usernameInput.addEventListener('input', () => {
      clearFieldState(usernameInput);
      validateUsername(false);
    });

    passwordInput.addEventListener('input', () => {
      clearFieldState(passwordInput);
      updateStrengthUI();
      validatePassword(false);
    });

    passwordInput.addEventListener('keydown', handleCapsLock);
    passwordInput.addEventListener('keyup', handleCapsLock);

    usernameInput.addEventListener('blur', () => validateUsername(true));
    passwordInput.addEventListener('blur', () => validatePassword(true));

    usernameInput.addEventListener('keydown', (e) => {
      if (e.key === 'Enter') {
        e.preventDefault();
        passwordInput.focus();
      }
    });

    passwordInput.addEventListener('keydown', (e) => {
      if (e.key === 'Enter') {
        e.preventDefault();
        form.requestSubmit();
      }
    });

    document.addEventListener('keydown', (e) => {
      if (e.key === 'Escape') {
        form.reset();
        clearFieldState(usernameInput);
        clearFieldState(passwordInput);
        updateStrengthUI();
        toast('Form cleared.', 'info', 1400);
      }
    });

    // Offline / online awareness
    window.addEventListener('offline', () => toast('You are offline.', 'warn'));
    window.addEventListener('online', () => toast('Connection restored.', 'success'));

    // Auto save username locally while typing
    usernameInput.addEventListener('input', () => {
      const state = getState();
      state.lastUsername = usernameInput.value.trim();
      setState(state);
    });
  }

  // ---------- Init ----------
  function initTheme() {
    const saved = localStorage.getItem(CONFIG.themeKey);
    document.body.classList.toggle('theme-light', saved === 'light');
  }

  function init() {
    ensureStyles();
    initTheme();
    makePasswordToggle();
    makeStrengthUI();
    makeThemeToggle();
    setRememberedUsername();
    bindEvents();
    updateStrengthUI();
    renderLockStatus();
    usernameInput.focus();

    // Gentle auto-validation after load
    if (usernameInput.value) validateUsername(false);
    if (passwordInput.value) validatePassword(false);

    // Tick lock countdown if needed
    setInterval(renderLockStatus, 1000);
  }

  init();
})();
