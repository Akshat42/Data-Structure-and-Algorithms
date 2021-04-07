import java.util.Scanner;

class MatrixMultiplicationNaive {
  public static int[][] MMNaive(int a1[][], int a2[][], int m1, int n1, int m2) {
    int a[][] = new int[n1][m2];
    for (int i = 0; i < n1; i++) {
      for (int j = 0; j < m2; j++) {
        for (int k = 0; k < m1; k++) {
          a[i][j] = a[i][j] + a1[i][k] * a2[k][j];
        }
      }
    }
    return a;
  }

  public static void printMatrix(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of first matrix");
    int n1 = sc.nextInt();
    int m1 = sc.nextInt();
    System.out.println("Enter the Size of second matrix");
    int n2 = sc.nextInt();
    int m2 = sc.nextInt();
    if (m1 == n2)
      System.out.println(
          "Matrix multiplication is possible, The resultant matrix will be of size "
              + n1
              + " x "
              + m2);
    else {
      System.out.println("Matrix multiplication is not possible!");
      return;
    }
    int[][] a1 = new int[n1][m1];
    int[][] a2 = new int[n2][m2];
    System.out.println("Enter matrix 1");
    for (int i = 0; i < n1; i++) {
      for (int j = 0; j < m1; j++) {
        a1[i][j] = sc.nextInt();
      }
    }
    System.out.println("Enter matrix 2");
    for (int i = 0; i < n2; i++) {
      for (int j = 0; j < m2; j++) {
        a2[i][j] = sc.nextInt();
      }
    }
    int[][] out = MMNaive(a1, a2, m1, n1, m2);
    System.out.println("Resultant Matrix:");
    printMatrix(out);
  }
}
