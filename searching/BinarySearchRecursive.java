import java.util.Scanner;

class BinarySearchRecursive {
  public static int BSR(int a[], int low, int high, int key) {
    if (low > high) return -1;
      int mid = (low + high) / 2;
      if (a[mid] == key) 
        return mid;
	  else if (a[mid] < key) 
        return BSR(a, mid + 1, high, key); 
	  else
	  return BSR(a, low, mid-1, key);
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int a[] = new int[n];
    System.out.println("Enter the array in sorted order");
    for (int i = 0; i < n; i++) a[i] = sc.nextInt();
    System.out.println("Enter key");
    int key = sc.nextInt();
    int index = BSR(a, 0, n - 1, key);
    if (index == -1) System.out.println("Key is not present in the array");
    else System.out.println("Element is present at index: " + index);
  }
}
