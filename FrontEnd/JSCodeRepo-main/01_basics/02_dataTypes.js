"use strict"; //treat all JS code as newer version

// alert(3+3); // we are using nodejs , not browser

let name = "Devanshu Rana";
let age = 18;
let isLoggedIn = false;

// numbers => 2 to power 53 => 8, 9 quadrillion
// bigint => for numbers larger than 2 to power 53
// string => "Devanshu Rana" or 'Devanshu Rana' or `Devanshu Rana`
// boolean => true/false
// null => null is a stand alone value
// symble => used to create unique identifiers for objects
// object => {key : value} pairs
//undefined => undefined is a value assigned to a variable that has not been assigned a value yet
//object => {key : value} pairs
//array => [item1, item2, item3] ordered list of items
console.log(typeof name);
console.log(typeof age);
console.log(typeof isLoggedIn);

let myVariable = null;
console.log(myVariable);
console.log(typeof myVariable); // object => this is a bug in JS but we have to live with it

let anotherVariable;
console.log(anotherVariable);
console.log(typeof anotherVariable); // undefined   
