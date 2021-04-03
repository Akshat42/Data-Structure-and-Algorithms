import java.util.Scanner;

class MaxSubArrayDivideAndConqure {
  public static int[] MS(int a[], int low, int high) {
    System.out.println("MS(a, " + low + " " + high);
    if (low == high) return new int[] {low, high, a[low]};
    else {
      int mid = (low + high) / 2;
      System.out.println("Mid " + mid);
      int left[] =
          MS(
              a, low,
              mid); // This recursive call will calculate the largest subarray for A[low...mid]
      int right[] =
          MS(
              a, mid + 1,
              high); // This recursive call will calculate the largest subarray for A[mid+1...high]
      int cross[] =
          maxCrossingSubarray(
              a, low, mid,
              high); // Since the largest subarray can be before and after mid, we calculate
      // largest subarray for A[i...j] low<=i<=mid mid<j<=high
      if (left[2] >= right[2] && left[2] >= cross[2])
        return left; // The Array format is A[leftMaxIndex, rightMaxIndex, (leftSum+rightSum)] here
                     // leftMax and rightMax are the indices for each small subarrays
      else if (right[2] >= left[2] && right[2] >= cross[2]) return right;
      else
        return cross; // At last we compare the Maximum subarray for left[] right[] and cross[] and
      // return it.
    }
  }

  public static int[] maxCrossingSubarray(
      int a[], int low, int mid, int high) { // This code is pretty much self explanatory :)
    System.out.println(
        "maxCrossingSubarray(a, "
            + low
            + " "
            + mid
            + " "
            + high); // Here we check for largest subarray for Crossing (mid)) subarray
    int sum = 0;
    int leftSum = Integer.MIN_VALUE;
    int maxLeft = -1;
    for (int i = mid; i >= low; i--) {
      sum = sum + a[i];
      if (leftSum < sum) {
        leftSum = sum;
        maxLeft = i;
      }
    }
    sum = 0;
    int rightSum = Integer.MIN_VALUE;
    int maxRight = Integer.MIN_VALUE;
    for (int j = mid + 1; j <= high; j++) {
      sum = sum + a[j];
      if (rightSum < sum) {
        rightSum = sum;
        maxRight = j;
      }
    }
    return new int[] {maxLeft, maxRight, leftSum + rightSum};
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int a[] = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    int res[] = MS(a, 0, n - 1);
    System.out.println("Max sum " + res[2]);
    System.out.println("Bound " + res[0] + " " + res[1]);
  }
}
