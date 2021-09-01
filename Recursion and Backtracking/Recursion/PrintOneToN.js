
function print(n) {
	if(n == 0) return;
	print(n-1);
	process.stdout.write(n+" ");
}

const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

readline.question('Enter n ', n => {
	print(n);
	readline.close();
});
