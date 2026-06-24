


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