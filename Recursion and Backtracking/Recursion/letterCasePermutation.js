function lCP(input, output) {
	if(input.length === 0) {
		console.log(output);
		return;
	}
	let temp = input.slice(0,1);
	input = input.slice(1);
	if(Number(Number(temp) || Number(temp) === 0)) {
		let op = output + temp;
		lCP(input, op);
		return;
	}
	else if(temp === temp.toUpperCase()) {
		let op1 = output + temp;
		let op2 = output + temp.toLowerCase();
		lCP(input, op1);
		lCP(input, op2);
		return;
	}
	else {
		let op1 = output + temp;
		let op2 = output + temp.toUpperCase();
		lCP(input, op1);
		lCP(input, op2);
		return;
	}
	return;

}

const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

readline.question('Enter input string ', (ip) => {
        lCP(ip , '');
        readline.close();
});

