// Date 

let myDate = new Date();
console.log(myDate);
// console.log(myDate.toString());
// console.log(myDate.toDateString());
// console.log(myDate.toISOString());
// console.log(myDate.toJSON());
// console.log(myDate.toLocaleDateString());
// console.log(myDate.toLocaleString());
// console.log(myDate.toLocaleTimeString());

let createdDate = new Date("01-14-2005");
console.log(createdDate.toDateString());

let myTimeStamp = Date.now();

// console.log(myTimeStamp);
// console.log(createdDate.getTime());
console.log(Math.floor(Date.now() / 1000));
let newDate = new Date();

newDate.toLocaleStirng('default', {
    weekday: "long",
})
console.log(newDate.toLocaleString('default', {
    weekday: "long",
    year: "numeric",
    month: "long",
    day: "numeric",
    hour: "numeric",
    minute: "numeric",
    second: "numeric",
}));

const name = "Devanshu Rana";
console.log(`My name is ${name} I had completed Date in JAVASCRIPT BASICS on 11/06/2026`);