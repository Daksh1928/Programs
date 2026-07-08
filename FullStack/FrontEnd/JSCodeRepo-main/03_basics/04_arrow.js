const user = {
    username: "Devanshu Rana",
    price: 999,

    welcomeMessage: function () {
        console.log(`${this.username} , welcome to website `)
        console.log(this);
    }
}
// user.welcomeMessage()
// user.username = "Rana "
// user.welcomeMessage()

// console.log(this);

// function chai() {
//     console.log(this)
// }

// chai();
//Normal function 
// const chai = function () {
//     let username = "Devanshu",
//         console.log(this.username);
// }
// Arrow function 
const chai = () => {
    let username = "Devanshu"
    console.log(this.username);
}
// chai();

//What is the difference between arrow funciton and normal function ?


// const addTwo = (num1, num2) => {
//     return num1 + num2
// }
//Implecit return arrow function 
const addTwo = (num1, num2) => (num1 + num2)
