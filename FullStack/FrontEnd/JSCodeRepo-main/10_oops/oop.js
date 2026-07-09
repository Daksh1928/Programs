const user = {
    username: "Devanshu",
    loginCount: 8,
    singedIn: true,

    getUserDetails: function(){
      console.log("Got user details from user database");
      console.log(`Username: ${this.username} Logedin count of this user is ${this.loginCount} and Singed status is ${this.singedIn}`)
    }
}



console.log(user.username);
console.log(user.getUserDetails());