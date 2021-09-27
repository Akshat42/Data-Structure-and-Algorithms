let set = new Set();

function printUniqueSubset(input, output) {
	if(input.length === 0) {
		set.add(output);
		return;
	}
	let op1 = output;
	let op2 = output + input.slice(0,1);
	input = input.slice(1);

	printUniqueSubset(input, op1);
	printUniqueSubset(input, op2);
	return;
}

const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})


readline.question('Enter input string ', (ip) => {
        printUniqueSubset(ip, '');
	set.forEach(s => console.log(s));
        readline.close();
});


