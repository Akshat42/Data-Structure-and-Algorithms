function josephus(arr, n, k, cur) {
	if (arr.length === 1) {
		console.log(arr);
		return;
	}
	cur = (cur + k) % arr.length;
	arr.splice(cur, 1);
	josephus(arr, n, k, cur);
}

const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

readline.question('Enter N ', n => {
	readline.question('Enter K ', k => {
		let arr = [];
		for (let i = 1; i <= n; i++) {
			arr.push(i);
		}
		josephus(arr, n, --k, 0);
		readline.close();
	});
});

