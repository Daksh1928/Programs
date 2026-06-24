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