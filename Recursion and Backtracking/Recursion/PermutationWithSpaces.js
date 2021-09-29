function permutationWithSpaces(input, output) {
//	console.log(input,output);
	if (input.length === 0) {
		console.log(output);
		return;
	}

	let op1 = output + input.slice(0,1);
	let op2 = output + '-' + input.slice(0,1);
	input = input.slice(1);
	permutationWithSpaces(input, op1);
	permutationWithSpaces(input, op2);
	return;
}

const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

readline.question('Enter input string ', (ip) => {
        permutationWithSpaces(ip.slice(1), ip.slice(0,1));
        readline.close();
});
