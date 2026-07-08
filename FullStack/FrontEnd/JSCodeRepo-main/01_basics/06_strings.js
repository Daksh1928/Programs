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
