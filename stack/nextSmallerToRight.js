// This question is similar to NSL, refer it for explanation

function NSR(arr) {
    let stack = [];
    let res = [];
    for (let i = arr.length - 1; i >= 0; i--) {
        if (stack.length === 0) {
            res.push(-1);
        } else if (peek(stack) < arr[i]) {
            res.push(peek(stack));
        } else {
            while (stack.length > 0 && peek(stack) >= arr[i]) {
                stack.pop();
            }
            if (stack.length === 0) {
                res.push(-1);
            } else {
                res.push(peek(stack));
            }
        }
        stack.push(arr[i]);
    }
    return res.reverse();
}

function peek(st) {
    return st[st.length - 1];
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
    let res = NSR(numArr);
    console.log(res);
    readline.close();
});
