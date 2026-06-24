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