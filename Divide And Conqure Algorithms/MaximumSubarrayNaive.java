import java.util.Scanner;

class MaximumSubarrayNaive {
  static int MSN(int a[], int n) {
		  int sum = 0;
		  String s = "";
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < a.length; i++) {
      for (int j = i; j < a.length; j++) {
			  sum = sum + a[j];
        if (sum > max) {
			   s = i+" "+j;	
				max = sum;
		}

      }
	  sum = 0;
    }
	System.out.println(s);
    return max;
  }

//  static int findSum(int a[], int i, int j) {
//    int sum = 0;
//    for (int k = i; k <= j; k++) {
//      sum = sum + a[k];
//    }
//    return sum;
//  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int a[] = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    System.out.println(MSN(a, n));
  }
}
