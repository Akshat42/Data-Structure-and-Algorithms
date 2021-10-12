function permute(input, output) {

	if (input.length === 0) {
		console.log(output);
		return;
	}

	for(let i = 0; i < input.length; i++) {
		let op1 = output + input[i];
		let ip1 = input.slice(0,i) + input.slice(i+1);
		permute(ip1, op1);
	}
}


const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

readline.question('Enter input string ', (ip) => {
        permute(ip, '');
        readline.close();
});
