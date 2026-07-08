const arr = [1, 2, 3, 4, 5, 6, 7, 8];

const myArr2 = new Array(1, 2, 3, 4, 5, 6);

console.log(arr);
console.log(myArr2);

console.log(myArr2[1]);

arr.push(6);
arr.pop();
arr.push(7);

arr.unshift(9);
arr.shift();


console.log(arr.includes(5));

console.log(arr.indexOf(3));

const NewArr = arr.join();


console.log(arr);

console.log(NewArr)
console.log(typeof NewArr);



console.log("A ", arr);

const myn1 = arr.slice(1, 3);

console.log(myn1);

console.log("B ", arr);

const myn2 = arr.splice(1, 3);
console.log("C ", myn2);

console.log("D ", arr);

let myn3 = arr.splice(1, 0, 2, 3, 4);
console.log("E ", myn3);

console.log("F ", arr);

let name = "Devanshu Rana";
let age = 18;
console.log(`My name is  ${name} and My age is ${age}`);
console.log(`My name is ${name} and I have completed Arrays first part in JavaScript on 02_basics/01_arrays.js at 11/06/2026 by code aur chai`);