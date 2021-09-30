function pWCC(input, output) {
	if (input.length === 0) {
		console.log(output);
		return;
	}

	let op1 = output + input.slice(0,1);
	let op2 = output + input.slice(0,1).toUpperCase();
	input = input.slice(1);
	pWCC(input, op1);
	pWCC(input, op2);
	return;
}

const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

readline.question('Enter input string ', (ip) => {
        pWCC(ip , '');
        readline.close();
});

