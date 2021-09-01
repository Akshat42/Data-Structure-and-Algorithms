function printNToOne(n) {
	if(n == 0) return;
	process.stdout.write(n+' ');
	printNToOne(n-1);
}

const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

readline.question("Enter n ", n => {
	printNToOne(n);
	console.log();
	readline.close();
})
