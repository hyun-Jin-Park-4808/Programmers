const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];
let number;
rl.on('line', function (line) {
    input = line.split(' ');
}).on('close', function () {
    number = Number(input[0]);
    for(let i = 1; i <= number; i++) {
        console.log('*'.repeat(i));
    }
});