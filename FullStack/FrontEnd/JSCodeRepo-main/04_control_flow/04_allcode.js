// IF 
// const isUserloggedIn = true;
// const temprature = 41;

// if (temprature < 50) {
//     console.log(": less than 50");
// }
// else {
//     console.log("Temprature is greater then 50 ")
// }
// if (false) {

// }

// conditnal < , > , <= ,>= , == , === (also check type knows strict equal ) , != 



// const score = 200;

// if (score > 100) {
//     const power = "Fly ";
//     console.log(`User power : ${power}`)
    
// }


const balance = 1000;

// if(balance > 500) console.log("test");

if(balance)

    const userLoggedIn = true;
    const debitCard = true;
    const userLoggedInFromEmail = true;
    const userLoggedInFromGoogle = false;
    if(userLoggedInFromEmail || userLoggedInFromGoogle){
        console.log("logged in ");
    }
    if(userLoggedIn  && debitCard){
        console.log("Allow to buy course ");
    }

    // switch (key) {
//     case value:

//         break;

//     default:
//         break;
// }


const month = 3;

switch (month) {
    case 1:
        console.log("Janurary");
        break;
    case 1:
        console.log("February");
        break;

    case 3:
        console.log("March");
        break;

    case 4:
        console.log("April");
        break;

    case 5:
        console.log("May");
        break;

    case 6:
        console.log("June");
        break;

    case 7:
        console.log("July");
        break;

    case 8:
        console.log("August");
        break;

    case 9:
        console.log("Septmber");
        break;

    case 10:
        console.log("October");
        break;

    case 11:
        console.log("November");
        break;

    case 12:
        console.log("December");
        break;


    default:
        break;
}




const userEmail = "h@hitesh.ai"

if (userEmail) {
    console.log("Got email ")
}
else {
    console.log("Don't get ")
}


// falsy values 

// false,0, -0, BigInt 0n, "" , null ,undefined ,NaN 

// truthy except falsy value all value are  truthy 
//"0" (Special case),'fasle'," ",[],{},function () {} 

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


//IMP
// Nullish Coalescing Operator (??)  : null undefined 


let val1;
// val1 = 5 ?? 10
// val1 = null ?? 10

val1 = undefined ?? null
// val1 = null ?? undefined







console.log(val1)




// Terniary Operator 

// condition ? true : false

const iceTeaPrice = 100;

iceTeaPrice >= 80 ? console.log("Less than 80") : console.log("Grater  than 80")
