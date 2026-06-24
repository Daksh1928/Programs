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
