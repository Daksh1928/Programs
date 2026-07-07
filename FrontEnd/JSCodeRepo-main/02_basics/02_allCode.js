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


let marvel_heros = ["Thor", "Iron Man", "Captain America", "Hulk", "Black Widow"];
const dc_heros = ["superman", "batman", "wonder woman"];

// marvel_heros.push(dc_heros);

// console.log(marvel_heros);
// console.log(marvel_heros[3][0]);

// let all_heros = marvel_heros.concat(dc_heros);
// console.log(all_heros);

const all_new_heros = [...marvel_heros, ...dc_heros]

// console.log(all_new_heros);


const array2 = [1, 3, 2, [4, 3, 2], 6, 7, [8, 9, [1, 2, 3, 4, 5], 10], 11, 12];

const real_array2 = array2.flat(Infinity);
// console.log(real_array2);


console.log(Array.isArray("Devanshu Rana"));
console.log(Array.from("Devanshu Rana"));
console.log(Array.from({ name: "Devanshu" })); // Interesting case 



let score1 = 100;
let score2 = 200;
let score3 = 300;

console.log(Array.of(score1, score2, score3));

// singleton object

// object.create



// object literal
const mySymb = Symbol("key1");
const JsUser = {
    name: "Devanshu",
    "full name": "Devanshu Rana",
    [mySymb]: "my value",
    age: 18,
    location: "India",
    isLoggedIn: false,
    lastLoginDays: ["Monday", "Tuesday", "Wednesday"],
    email: "devasnhurana@google.com"
}


// console.log(JsUser.email);
JsUser["email"] = "devanshurana@microsoft.com";
// console.log(JsUser["email"]);

// console.log(JsUser["full name"]);
// console.log(JsUser[mySymb]);

// Object.freeze(JsUser);
// JsUser["email"] = "devanshurana@chatgpt.com";
// console.log(JsUser);

JsUser.greeting = function(){
    console.log("Hello JS user ");

}

JsUser.greeting2 = function(){
    console.log(`Hello Js user ,${this.name}`);
}
console.log(JsUser.greeting());
console.log(JsUser.greeting2());


const tinderUser = new Object();
// console.log(tinderUser);

tinderUser.id = "123abc";
tinderUser.name = "Devanshu";
tinderUser.isLoggedIn = false;
// console.log(tinderUser);

const regulerUser = {
    email: "devanshurana@gmail.com",
    fullName: {
        userFullName: {
            firstName: "Devanshu",
            lastName: "Rana"
        }
    }
}

// console.log(regulerUser.fullName.userFullName.firstName);

const obj1 = { 1: "a", 2: "b" };
const obj2 = { 3: "c", 4: "d" };
const obj4 = { 5: "c", 6: "d" };
// const obj3 = { obj1, obj2 };
// const obj3 = Object.assign({}, obj1, obj2, obj4);

const obj3 = { ...obj1, ...obj2, ...obj4 };
// console.log(obj3);

const user = [{
    id: 1,
    name: "Devanshu",
    age: 18
},
{
    id: 2,
    name: "Rana",
    age: 19
}
];

console.log(user[1].name);
console.log(tinderUser)

console.log(Object.keys(tinderUser));
console.log(Object.values(tinderUser));
console.log(Object.entries(tinderUser));


console.log(tinderUser.hasOwnProperty("name"));

//########################################## OBJECT de-Structure and JSON API Introduction ##########################################




// const tinderUser = new Object();
// // console.log(tinderUser);

// tinderUser.id = "123abc";
// tinderUser.name = "Devanshu";
// tinderUser.isLoggedIn = false;
// // console.log(tinderUser);

// const regulerUser = {
//     email: "devanshurana@gmail.com",
//     fullName: {
//         userFullName: {
//             firstName: "Devanshu",
//             lastName: "Rana"
//         }
//     }
// }

// // console.log(regulerUser.fullName.userFullName.firstName);

// const obj1 = { 1: "a", 2: "b" };
// const obj2 = { 3: "c", 4: "d" };
// const obj4 = { 5: "c", 6: "d" };
// // const obj3 = { obj1, obj2 };
// // const obj3 = Object.assign({}, obj1, obj2, obj4);

// const obj3 = { ...obj1, ...obj2, ...obj4 };
// // console.log(obj3);

// const user = [{
//     id: 1,
//     name: "Devanshu",
//     age: 18
// },
// {
//     id: 2,
//     name: "Rana",
//     age: 19
// }
// ];

// console.log(user[1].name);
// console.log(tinderUser)

// console.log(Object.keys(tinderUser));
// console.log(Object.values(tinderUser));
// console.log(Object.entries(tinderUser));


// console.log(tinderUser.hasOwnProperty("name"));




const course = {
    courseName: "JS in Hidni",
    price: 999,
    courseInstructor: "Devanshu Rana"
}
// console.log(course.courseInstructor)

const { courseInstructor: instructor } = course;
console.log(instructor);

//React topic of De sturcted object
// const navBar = ({company}) => {

// }

// navBar(company = "devanshu")


//*****************************************APT ********************************************

// {
//     "name": "Devanshu",
//         "age": 18,
//             "location": "India",
//                 "isLoggedIn": false,
//                     "lastLoginDays": ["Monday", "Tuesday", "Wednesday"],
//                         "email": "devanshurana@gmail.com"
// }


// {
//     { }
//     {

//     },
//     {

//     }
// }


