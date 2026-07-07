const form = document.getElementById('logInForm')

form.addEventListener("submit",function(events){
    events.preventDefault();
    const username = document.getElementById('Username').value;
    const password = document.getElementById('Password').value;
    username.trim();
    
})