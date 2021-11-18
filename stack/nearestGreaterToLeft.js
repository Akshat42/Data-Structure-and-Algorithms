/* This question is similar to Next Greater Right (NGR) here we need to check the next greater element to the left of the array.
If we consider brute force we can do it in O(n^2) by running to for loops like:
for(let  i = 0; i < arr.length; i++) {
   for(let j = i; j >= 0; j--) {
       // logic
   }
}
Form here we can directly identify this is a stack question as j is dependent on i.
*/

// Optimal Solution

function NGL(arr) {
    let res = [];
    let st = []; // stack
    for (let i = 0; i < arr.length; i++) {
        if (st.length === 0) {
            res.push(-1); // this means there is no element on the left of the array
        } else if (peek(st) > arr[i]) { // if previous element is greater then push it
            res.push(peek(st));
        } else {
            while (st.length > 0 && peek(st) <= arr[i]) { // pop until stack becomes empty (no element is greater on the left) OR if element is present the push that.
                st.pop();
            }
            if (st.length === 0) {
                res.push(-1);
            } else {
                res.push(peek(st));
            }
        }
        st.push(arr[i]);
        //console.log(st);
    }
    return res;
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
    let res = NGL(numArr);
    console.log(res);
    readline.close();
});


