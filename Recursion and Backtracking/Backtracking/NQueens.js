function nqueens(board, col, n) {
	if(col >= n) console.log(board);

	for(let row = 0; row < n; row++) {
		if (isSafe(board, row, col, n)) {
			placeQueen(board, row, col);
			nqueens(board, col + 1, n)
			removeQueen(board, row, col)
		}
	}
}

function isSafe(board, row, col, n) {
	// vertical up check
	let i = row;
	while (i >= 0) {
		if(board[i][col] === 'Q') return false;
		i--;
	}
	
	i = row;
	// vertical down
	while (i < n) {
		if(board[i][col] === 'Q') return false;
		i++;
	}

	i = col;
	// horizontal left
	while (i >= 0) {
		if(board[row][i] === 'Q') return false;
		i--;
	}

	i = col;
	// horizontal right check
	while (i < n) {
		if(board[row][i] === 'Q') return false;
		i++;
	}

	// diagonal left-up
	let r = row;
	let c = col;
	while (r >= 0 && c >= 0) {
		if (board[r][c] === 'Q') return false;
		r--;
		c--;
	} 

	// diagonal right-down
	r = row;
	c = col;

	while (r < n && c < n) {
		if(board[r][c] === 'Q') return false;
		r++;
		c++;
	}

	// diagonal right-up
	r = row;
	c = col;

	while (r >= 0 && c < n) {
		if(board[r][c] === 'Q') return false
		r--;
		c++;
	}

	// diagonal left-down
	r = row;
	c = col;

	while (r < n && c >= 0) {
		if(board[r][c] === 'Q') return false;
		r++;
		c--;
	}
	return true;
}

function placeQueen(board, row, col) {
	board[row][col] = 'Q'
}

function removeQueen(board, row, col) {
	board[row][col] = '-';
}


const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

readline.question('Enter Chess size(n) ', n => {
	let board = [];
	let row = [];
	for (let i = 0; i < n; i++) {
		row.push('-');
	}
	for (let i = 0; i < n; i++) {
		board[i] = [...row];
	}
        nqueens(board, 0, Number(n));
//	for(let i = 0; i < n; i++) {
//		for(let j = 0; j < n; j++) {
//			process.stdout.write(board[i][j]+" ");
//		}
//		console.log();
//	}
        readline.close();
});

