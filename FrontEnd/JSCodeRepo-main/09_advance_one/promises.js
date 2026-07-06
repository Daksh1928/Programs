const promiseOne = new Promise(function (resolve, reject) {
  //Do an async task
  //DB calls ,cryptography, netWork
  setTimeout(() => {
    console.log("Async task is completed ");
    resolve();
  }, 1000);
});

promiseOne.then(function () {
  console.log("Promise consumed");
});

new Promise(function (resolve, reject) {
  setTimeout(function () {
    console.log("Async task 2 ");
    resolve();
  }, 1000);
}).then(function () {
  console.log("Promise consumed at Async two ");
});

const promiseThree = new Promise(function (resolve, reject) {
  setTimeout(function () {
    resolve({ username: "Devanshu", email: "devanshu@example.com" });
  }, 1000);
});

promiseThree.then(function (user) {
  console.log(user);
});

//Why do we have promise

const promiseFour = new Promise(function (resolve, reject) {
  setTimeout(function () {
    let error = true;
    if (!error) {
      resolve({ username: "Devanshur84", email: "devanshu@example.com" });
    } else {
      reject(
        "ERROR : something went wrong please refresh and try again sometime later ",
      );
    }
  }, 1000);
});
promiseFour
  .then((user) => {
    console.log(user);
    return user.username;
  })
  .then((username) => {
    console.log(username);
  })
  .catch(function (err) {
    console.log(err);
  })
  .finally(() => {
    console.log("Promise completed ");
  });

const promiseFive = new Promise(function (resolve, reject) {
  setTimeout(function () {
    let error = true;
    if (!error) {
      resolve({ username: "Devanshur84", email: "devanshu@example.com" });
    } else {
      reject("ERROR : Js went wrong");
    }
  }, 1000);
});

async function consumeing() {
  try {
    const responce = await promiseFive;
    console.log(responce);
  } catch (error) {
    console.log(error);
  }
}

consumeing();

// async function getAllUsers() {
//   try {
//     const response = await fetch("https://api.github.com/users/Daksh1928");
//     const data = await response.json();
//     console.log(data);
//   } catch (error) {
//     console.log("E : ", error);
//   }
// }

// getAllUsers();

fetch("https://api.github.com/users/Daksh1928")
  .then((response) => {
    return response.json();
  })
  .then((data) => {
    console.log(data);
  })
  .catch((error) => {
    console.log("E: ", error);
  });
