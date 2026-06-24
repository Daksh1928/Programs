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


