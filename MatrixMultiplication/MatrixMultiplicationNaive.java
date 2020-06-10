import java.util.Scanner;
class MatrixMultiplicationNaive {
    public static int[][] MMNaive(int arr1[][],int arr2[][]) {
	int[][] out = new int[arr1.length][arr1.length];
	for(int i=0;i<arr1.length;i++){
	    for(int j=0;j<arr1.length;j++) {
		for(int k=0;k<arr1.length;k++) {
		    out[i][j] += arr1[i][k] * arr2[k][j];
		}
	    }
	}
	return out;
    }
    public static void printMatrix(int[][] arr) {
	for(int i=0;i<arr.length;i++) {
	    for(int j=0;j<arr.length;j++) {
		System.out.print(arr[i][j]+" ");
	    }
	    System.out.println();
	}
    }
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the size of matrix");
	int n = sc.nextInt();
	int[][] arr1 = new int[n][n];
	int[][] arr2 = new int[n][n];
	System.out.println("Enter matrix 1");
	for(int i=0;i<n;i++) {
	    for(int j=0;j<n;j++){
		arr1[i][j] = sc.nextInt();
	    }
	}
	System.out.println("Enter matrix 2");
	for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++){
                arr2[i][j] = sc.nextInt();
            }
        }
	int[][] out = MMNaive(arr1,arr2);
	printMatrix(out);
    }
}


