// brute force O(n^2)
function ngr(arr) {
    let res = [];
    for (let i = 0; i < arr.length; i++) {
        for (let j = i + 1; j < arr.length; j++) {
            if (arr[j] > arr[i]) {
                res.push(arr[j]);
                break;
            }
        }
    }
    return res;
}

// using stack O(n)

function ngr2(arr) {
    let stack = [];
    let res = [];
    for (let i = arr.length - 1; i >= 0; i--) {
        if (stack.length === 0) {
            res.push(-1);
        } else if (stack.length > 0 && stack[stack.length - 1] > arr[i]) {
            res.push(stack[stack.length - 1]);
        } else if (stack.length > 0 && stack[stack.length - 1] <= arr[i]) {
            while (stack.length > 0 && stack[stack.length - 1] <= arr[i]) {
                stack.pop();
            }
            if (stack.length == 0) {
                res.push(-1);
            } else {
                res.push(stack[stack.length - 1]);
            }
        }
        stack.push(arr[i]);
    }
    return res.reverse();
}

const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
});

readline.question('Enter Array elements:  ', ele => {
    let arr = ele.split(' ');
    let numArr = []
    arr.forEach(ele => {
        numArr.push(Number(ele));
    })
    res = ngr2(numArr);
    console.log(res);
    readline.close();
});
