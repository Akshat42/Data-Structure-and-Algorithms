function reverse(stack) {
	if(stack.length === 0) return;
	let temp = stack.pop();
	reverse(stack);
	stack.unshift(temp);
	return stack;
}


const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

readline.question('Enter Stack elements:  ', ele => {
        let arr = ele.split(' ');
        let stack = [];
        arr.forEach(ele => {
                 stack.push(Number(ele));
        })
        reverse(stack);
        console.log(stack);
        readline.close();
});

