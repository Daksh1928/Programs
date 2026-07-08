const myObject = {
    js: 'Javascpipt',
    cpp: 'C++',
    rb: 'ruby',
    seift: "swift by apple"
}

for (const key in myObject) {
    console.log(`${key} shoetcut is for ${myObject[key]}`);
}

const arr = [1, 2, 3, 4, 5, 6];


for (const key in arr) {
    console.log(key)
}