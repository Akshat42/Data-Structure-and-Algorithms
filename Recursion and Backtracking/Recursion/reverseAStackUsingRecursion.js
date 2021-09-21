function reverse(stack) {
	if(stack.length === 0) return;
	let temp = stack.pop();
	reverse(stack);
	insertAtBottom(stack, temp);
	return stack;
}

function insertAtBottom(stack, temp) {
	if(stack.length === 0) {
		stack.push(temp);
		return;
	}
	let top = stack.pop();
	insertAtBottom(stack,temp);
	stack.push(top);
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

