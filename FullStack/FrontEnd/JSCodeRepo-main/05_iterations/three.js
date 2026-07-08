// for of 


// const arr = [1, 2, 3, 4, 5, 6];

// for (const num of arr) {
//     console.log(num);
// }

//Maps

const map = new Map();

map.set('IN', "India");
map.set('USA', "United state of America")
map.set('Fr', "France")

console.log(map);

// for (const key of map) {
//     console.log(key)
// }

// If you want to print every number saperatly 

for (const [key, value] of map) {
    console.log(key, ':-', value);
}


const myObject = {
    'game1': 'NFS',
    'game2': 'SpiderMan'
}
// Objects are not iterable if we use  forof loop 
for (const [key, value] of myObject) {
    console.log(key, ':-', value);
}