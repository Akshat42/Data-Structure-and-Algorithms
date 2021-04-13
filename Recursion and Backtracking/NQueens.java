import java.util.Scanner;

class NQueens {

  static boolean Solve(int[][] board, int col) {
    // This base case means that, we are done with the last row of placing the Queen and there is no
    // next column left.
    if (col >= board.length) return true;
    // Trying for each row
    for (int rowToTry = 0; rowToTry < board.length; rowToTry++) {
      if (IsSafe(board, rowToTry, col)) {
        PlaceQueen(board, rowToTry, col); // Place the queen if no attack is possible
        if (Solve(board, col + 1)) // Recurse For next Queen placement in next Column.
        return true; // if that choice works fine, then go for next Colum
        RemoveQueen(
            board, rowToTry,
            col); // else backtrack( or go to previous state, remove the placement and try again).
      }
    }
    return false;
  }

  // Place the queen if the position is safe
  static void PlaceQueen(int board[][], int row, int col) {
    board[row][col] = 1;
  }

  // Remove the Previous state of queen placement if decision seems to b wrong.
  static void RemoveQueen(int board[][], int row, int col) {
    board[row][col] = 0;
  }

  // Check if it is safe to place the queen at a particular location. If not returns false
  static boolean IsSafe(int[][] board, int row, int col) {
    //				System.out.println("Checking for point " + row + " "+ col);
    //				print(board, 4,4);

    //				System.out.println();

    // Row Check for conflict
    for (int i = 0; i < board.length; i++) {
      //		System.out.println("for index " +row+"," + i +"value "+ board[row][i]);
      if (board[row][i] == 1) {
        //								System.out.println("conflict at "+i+" "+col);
        return false;
      }
    }

    // Column Check for conflict
    for (int i = 0; i < board[row].length; i++) {
      if (board[i][col] == 1) return false;
    }

    // Diagonal Right-Up check for conflict
    int i = row;
    int j = col;
    while (i < board.length && j < board[i].length) {
      if (board[i][j] == 1) return false;
      i++;
      j++;
    }

    // Diagonal Left-Down check for conflict
    i = row;
    j = col;
    while (i >= 0 && j >= 0) {
      if (board[i][j] == 1) return false;
      i--;
      j--;
    }

    // Diagonal Left-Up check for conflict
    i = row;
    j = col;
    while (i >= 0 && j < board[i].length) {
      if (board[i][j] == 1) return false;
      i--;
      j++;
    }

    // Diagonal Right Down check for conflict
    i = row;
    j = col;
    while (i < board.length && j >= 0) {
      if (board[i][j] == 1) return false;
      i++;
      j--;
    }
    return true;
  }

  static void print(int board[][], int rows, int col) {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < col; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter rows x columns");
    int rows = sc.nextInt();
    int col = sc.nextInt();
    if (rows != col) {
      System.out.println("Invalid Configuration");
      return;
    }
    int board[][] = new int[rows][col];
    System.out.println(Solve(board, 0));
    print(board, rows, col);
  }
}
