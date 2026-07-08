// All basics code at one place 

const accountId = 12202;
let accountEmail = "Devanshurana1928@gmail.com"
var accountPassword = "192837"
accountCity = "Meerut"
console.table([accountEmail,accountId,accountPassword,accountCity])
// accountId = 2 not allowed
accountPassword = "dev"
accountEmail = "Dev@gmail.com"
accountCity = "Jaipur"
console.table([accountEmail,accountId,accountPassword,accountCity])
/*
Var are no more in morden JS cause It doesn't have any scope 
use only let and const
*/
console.log(hell0);



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


// let score = "33abc";
// console.log(typeof score);

// let num = Number(score);
// console.log(typeof num);
// console.log(num);//it will print NaN (not a number);

//************************* Operstions ****************************//

//  let value = 3;
//  let negvalue = -value;
//  console.log(negvalue**negvalue);

let str1 = "hello";
let str2 = " Devanshu Rana";
let str3 = str1 + str2;
console.log(str3);
console.log(str1 + " " + str2);

let num1 = 3;
let num2 = 4;
console.log(num1 + num2);
console.log(num1 + " " + num2);
const name = "Devanshu";
const age = 18;
console.log(name + " is " + age + " years old.");
console.log(1 + 2 + "2");
console.log("1" + 2 + 3);

console.log(2 + 3 * 4 / 5);


// console.log(2 > 1);
// console.log(2 >= 1);
// console.log(2 <= 1);
// console.log(2 < 1);
// console.log(2 != 1);

// console.log("2" > 1);
// console.log("02" > 1);

// console.log(null > 0);
// console.log(null == 0);
// console.log(null >= 0);
//Upper type of comparision are not valid it give result but again not valid
// In JS we use ==== operater for data conversion
//Like example blow//
console.log("2" === 2);
console.log(2 === 2);
console.log("2" == 2);
console.log(null === 0);
console.log(null == 0);

// Primitive 
// 7 types : String,Number,Boolean,Null,undefined,Symbol,,BigInt
const score = 100;
const scoreValue = 100.3;

const isLoggedIn = false;
const outsideTemp = null;
let userName;

const id = Symbol('123');



//Reference (Non-Primitive)
//Array, Objects, Functions,


// const name = "Devanshu Rana";
// const repoCount = 1;
// console.log(`Hello my name is ${name} and my repo count is ${repoCount}`);
// console.log("Devanshu Rana");


const gameName = new String('devanshu-rana');

console.log(gameName[0]);
console.log(gameName.__proto__);
console.log(gameName.length);

console.log(gameName.toUpperCase());
console.log(gameName.charAt(7));
console.log(gameName.indexOf('h'));

const str = gameName.substring(0, 1);
console.log(str);

const str2 = gameName.slice(-8, 4);
console.log(str2);

const trimm = "       Devanshu      ";
console.log(trimm.trim());

const url = "https://dev.com/dev%20rana";
const url2 = url.trim();
console.log(url2.replace('%20', '-'));

console.log(url.includes('dev'));

console.log(gameName.split('-'));



let name = "Devanshu Rana";
let age = 18;
console.log(`My name is  ${name} and My age is ${age}`);



const score = 400;
console.log(score);
const balance = new Number(100);
console.log(balance);
console.log(balance.toString().length);
console.log(balance.toFixed(2));
const otherNumber = 123.91123434;
console.log(otherNumber.toPrecision(3));
const hundereds = 1000000;
console.log(hundereds.toLocaleString("en-IN"));
const num = Number.MAX_VALUE;
console.log(num);
const num2 = Number.MIN_VALUE;
console.log(num2);
//  ++++++++++++++++++++++++++++++ Maths ++++++++++++++++++++++++++++++++++++++++  //

console.log(Math);
console.log(Math.abs(-4));
console.log(Math.random);
console.log((Math.random() * 10) + 1);
console.log(Math.floor(Math.random() * 10) + 1);
const min = 10;
const max = 20;
console.log(Math.floor(Math.random() * (max - min + 1)) + min);
console.log(Math.PI.toFixed(3));
console.log(Math.E.toFixed(2));
const name = "Devanshu Rana";
console.log(`My name is ${name} I had completed Math and number in JAVASCRIPT BASICS on 11/06/2026`);

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