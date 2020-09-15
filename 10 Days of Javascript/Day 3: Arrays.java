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


function getSecondLargest(nums) {
    let max1 = -1, max2 = -1;

    for(var i = 0; i < nums.length; i++){
        if(max1 < nums[i]){
            max2 = max1;
            max1 = nums[i];
        }


        if(max1 > nums[i] && max2 < nums[i]){
            max2 = nums[i];
        }
    }

    return max2;
}


function main() {
    const n = +(readLine());
    const nums = readLine().split(' ').map(Number);
    
    console.log(getSecondLargest(nums));
}
