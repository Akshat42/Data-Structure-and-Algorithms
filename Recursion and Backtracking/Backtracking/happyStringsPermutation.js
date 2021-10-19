// Question Link: https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/

let res = [];
function getHappyString(n, k) {
    let s = "abc";
    if(n === 1) {
        return s[k - 1] || "";
    }
    for(let i = 0; i < s.length; i++) {
        solve(s, s[i], n, i);
    }
    let r = res[k - 1] || "";
    res = [];
    return r;
};

function solve(input, output, n, i) {
    if (output.length === n) {
        res.push(output);
        return;
    }
    if (i === 0) {
        let op1 = output + input[i+1];
        let op2 = output + input[i+2];
        solve(input,op1,n,i+1);
        solve(input,op2,n,i+2);
    } else if (i === 1) {
        let op1 = output + input[i-1];
        let op2 = output + input[i+1];
        solve(input, op1, n, i-1);
        solve(input, op2, n, i+1);
    } else {
        let op1 = output + input[i-2];
        let op2 = output + input[i-1];
        solve(input, op1, n, i-2);
        solve(input, op2, n, i-1);
    }
    
}

const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

readline.question('Enter N ', (N) => {
	readline.question('Enter K ', (K) => {
		console.log(getHappyString(Number(N), Number(K)));
		readline.close();
	});
});



