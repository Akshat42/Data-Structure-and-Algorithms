// print n-bit binary number where No 1s is greater that or equal to no if 0s
function printNBit(n) {
	let res = [];
	print(n, 0, 0, '', res);
	console.log(res);
}

function print(n, no0, no1, output, res) {
	if (n === 0) {
		res.push(output);
		return;
	}
	else if (no1 > no0 && n !== 0) {
		let op1 = output + '1';
		let n1 = no1 + 1;
		let totalN = n - 1;
		print(totalN, no0, n1, op1, res);

		let op2 = output + '0';
		let n0 = no0 + 1;
		let totalN2 = n - 1;
		print(totalN2, n0, no1, op2, res);
	} else if (no0 === no1 && n !== 0) {
		let op1 = output + '1';
		let n1 = no1 + 1;
		let totalN = n - 1;
		print(totalN, no0, n1, op1, res);
	} 
	return;
}

const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

readline.question('Enter n ', n => {
        printNBit(Number(n));
        readline.close();
});


