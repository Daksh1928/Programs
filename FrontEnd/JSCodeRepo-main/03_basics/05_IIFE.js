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