const arrys = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

const myTotal = arrys.reduce(function (acc, curval) {
    return acc + curval
}, 10)

console.log(myTotal)
