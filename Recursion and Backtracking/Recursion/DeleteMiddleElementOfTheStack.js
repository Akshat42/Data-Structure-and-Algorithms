function deleteMiddleElement(stack) {
	let middle = Math.floor((stack.length + 1) / 2);
	deleteMS(stack, middle);
	return stack;
}

function deleteMS(stack, middle) {
	if(middle === 1) {
		stack.pop();
		return;
	}
	let temp = stack.pop();
	deleteMS(stack, middle-1);
	stack.push(temp);
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
        deleteMiddleElement(stack);
        console.log(stack);
        readline.close();
});
