import java.util.Scanner;
class BinarySearch {
    public static int binaryS(int arr[], int n,int key) {
	int left = 0;
	int right = arr.length-1;
	while(left<=right) {
	    int mid = (left+right)/2;
	    if(arr[mid] < key) {
		left = mid + 1;
	    }
	    else if(arr[mid] > key) {
		right = mid - 1;
	    }
	    else {
		return mid;
	    }
	}
	return -1;
    }
    public static void main (String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the number of elements in the array");
	int n = sc.nextInt();
	System.out.println("Enter the array elements(make sure that the elements are sorted)");
	int[] arr = new int[n];
	for(int i=0;i<n;i++) {
	    arr[i] = sc.nextInt();
	}
	System.out.println("Enter the key");
	int key = sc.nextInt();

	int found = binaryS(arr,n,key);
	if(found == -1) 
	    System.out.println("Not found!!!");
	else
	    System.out.println("Found element at index "+found);
    }
}
