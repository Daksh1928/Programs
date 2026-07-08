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