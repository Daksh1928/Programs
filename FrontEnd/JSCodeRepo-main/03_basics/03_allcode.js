


function sayMyName() {
    console.log("D");
    console.log("E");
    console.log("V");
    console.log("A");
    console.log("N");
    console.log("S");
    console.log("H");
    console.log("U");

}

// sayMyName(); // calling the function


// function addTwoNumbers(Number1, Number2) {
//     console.log(Number1 + Number2);
// }

function addTwoNumbers(Number1, Number2) {
    let result = Number1 + Number2;
    return result;
}
const result = addTwoNumbers(3, 10)

// console.log("Result : ", result);


// function loginUserMessage(username) {
//     // if (typeof username === undefined) {
//     //     console.log("Please enter a username ");
//     //     return;
//     // }
//     if (!username) {
//         console.log("Please enter a username ");
//         return;
//     }
//     return `${username} just logged in`
//}
function loginUserMessage(username = "Sam") {
    // if (typeof username === undefined) {
    //     console.log("Please enter a username ");
    //     return;
    // }
    if (!username) {
        console.log("Please enter a username ");
        return;
    }
    return `${username} just logged in`
}

console.log(loginUserMessage())
// console.log(loginUserMessage("Devanshu Rana"));




function sayMyName() {
    console.log("D");
    console.log("E");
    console.log("V");
    console.log("A");
    console.log("N");
    console.log("S");
    console.log("H");
    console.log("U");

}

// sayMyName(); // calling the function


// function addTwoNumbers(Number1, Number2) {
//     console.log(Number1 + Number2);
// }

function addTwoNumbers(Number1, Number2) {
    let result = Number1 + Number2;
    return result;
}
const result = addTwoNumbers(3, 10)

// console.log("Result : ", result);


// function loginUserMessage(username) {
//     // if (typeof username === undefined) {
//     //     console.log("Please enter a username ");
//     //     return;
//     // }
//     if (!username) {
//         console.log("Please enter a username ");
//         return;
//     }
//     return `${username} just logged in`
//}
function loginUserMessage(username = "Sam") {
    // if (typeof username === undefined) {
    //     console.log("Please enter a username ");
    //     return;
    // }
    if (!username) {
        console.log("Please enter a username ");
        return;
    }
    return `${username} just logged in`
}

// console.log(loginUserMessage())
// console.log(loginUserMessage("Devanshu Rana"));

// ############################# 2 #################################
//for creating dynamic number of function arguments 

// function calculateCartPrice(...num1) {
//     return num1;
// }
// if in case we first pass two varialbles and then crearte rest operater 
function calculateCartPrice(val1, val2, ...num1) {
    return val1 + val2 + num1;
}

// console.log(calculateCartPrice(20, 200, 2000, 122));


const user = {
    username: "Devasnhu ",
    price: 1999
}


function handleObject(anyobject) {
    console.log(`UserName is ${anyobject.username} and price is ${anyobject.price}`)
}

// handleObject(user)
handleObject({
    username: "Rana",
    price: 399
})

const MyNewArray = [200, 300, 30, 344]

function returnSecondValue(getArray) {
    return getArray[3];
}
// console.log(returnSecondValue(MyNewArray))
console.log(returnSecondValue([12, 13, 14, 154]))

//Local and global scope 

if (true) {
    let a = 10;
    const b = 20;
    var c = 30;
}


{ } // This bresis are known as scope in Js 

function one() {
    const username = "Devanshu Rana";

    function two() {
        const website = "Youtube"
        console.log(username)
    }
    // console.log(website)
    two()
}
// one();

if (true) {
    const username = "Devanshu Rana"
    if (username === "Devanshu Rana") {
        const website = "Youtube.com"
        console.log(username + website)
    }
}

// +++++++++++++++++++++++++++  interesting ++++++++++++++++++++++++++++++
// Normale function decleration 
// Note : We can access Normal function anywhere
console.log(addone(5))
function addone(num) {
    return num + 1;
}

console.log(addone(5));

//Expression 
//Note : we can't access Expression before decleration 
//addTwo(5); can't 
const addTwo = function addTwo(num) {
    return num + 2;
}
console.log(addTwo(5))


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



//                Immediately Invoked Function Expressions IIFE 

(function chai() {
    //Named IIFE 
    console.log(`DB connected `);
})();

// chai()

// For removing global scope pollution we use IIFE
// always use ; to stop first IIFE function 

(() => {
    //UnNamed IIFE 
    console.log(`DB CONNECTED TWO`)
})();


((name) => {
    console.log(`DB CONNECTED Three ${name}`)
})('Devanshu Rana');