function sort(arr) {

	if(arr.length == 1) return; // Single element in the array is sorted
	let temp = arr.pop(); // Reduce the array by one and store the element as temp
	sort(arr); // Call sort for reduced input 
	insert(arr, temp); // Insert temp at its appropriate place
	return arr;
}

function insert(arr, temp) {
	//console.log(arr,temp);
	if(arr[0] >= temp) { // if temp is smaller then first element
		arr.unshift(temp); // insert in begining of array
		return;
	}
	if(arr[arr.length - 1] <= temp) {
		arr.push(temp); // insert at last
		return;
	}
	let last = arr.pop(); // take out the last element and call insert on small input to insert temp
	insert(arr,temp);
	arr.push(last); // finally push the last element at the end, whenre it was
	return arr;
}

const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

readline.question('Enter Array elements:  ', ele => {
	let arr = ele.split(' ');
	let numArr = []
	arr.forEach( ele => {
		 numArr.push(Number(ele));
	})
	sort(numArr);
	console.log(numArr);
  	readline.close();
});




