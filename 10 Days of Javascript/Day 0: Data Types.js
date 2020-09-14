'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => {
        return string.trim();
    });
    
    main();    
});

function readLine() {
    return inputString[currentLine++];
}

function performOperation(secondInteger, secondDecimal, secondString) {
    const firstInteger = 4;
    console.log(firstInteger + parseInt(secondInteger));  //+operator convert string to number (+secondInteger)


    const firstDecimal = 4.0;
    console.log(firstDecimal + parseFloat(secondDecimal)); //+operator convert string to number (+secondDecimal)
    
    const firstString = 'HackerRank ';
    console.log(firstString + secondString);
    
    
}


function main() {
    const secondInteger = readLine();
    const secondDecimal = readLine();
    const secondString = readLine();
    
    performOperation(secondInteger, secondDecimal, secondString);
}
