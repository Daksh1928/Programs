


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

