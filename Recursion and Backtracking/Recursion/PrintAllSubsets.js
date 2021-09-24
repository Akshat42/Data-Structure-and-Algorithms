function printSubsets(input, output) {
	if(input.length === 0) {
		console.log(output);
		return;
	}
	let op1 = output;
	let op2 = output + input.slice(0, 1);
	input = input.slice(1);
	printSubsets(input, op1);
	printSubsets(input, op2);
	return;
}

const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

readline.question('Enter input string ', (ip) => {
	printSubsets(ip, '');
	readline.close();
});

