/* 
	Assumption:
	[1,2,3,4] --> top
*/


function peek(stack) {
	return stack[stack.length-1];
}

function sortStack(stack) {

	if (stack.length === 1) return // stack with one element is already sorted

	let temp = stack.pop(); // reduce the input size
	sortStack(stack); // sort the rest of the stack
	insert(stack, temp); // insert the temp to it's appropriate position
	return stack;

}

function insert(stack, temp) {

	if (stack.length === 0) return stack.push(temp);
	if (peek(stack) <= temp) {
		stack.push(temp);
		return;
	}
	let last = stack.pop(); // store the top element
	insert(stack, temp); // try inserting the temp to the rest of the stack
	stack.push(last); // push the last element
	return stack;
}


const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

readline.question('Enter Stack elements:  ', ele => {
        let arr = ele.split(' ');
        let stack = []
        arr.forEach( ele => {
                 stack.push(Number(ele));
        })
        sortStack(stack);
        console.log(stack);
        readline.close();
});

