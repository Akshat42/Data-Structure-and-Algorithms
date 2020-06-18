import java.util.Scanner;
import java.util.Arrays;
class BubbleSort {
    public static int[] bubbleSort(int input[], int n) {
	for(int i = n-1; i >= 0; i--) {
	    for(int j = n-1; j > 0 ; j--) {
		if(input[j] < input[j-1]){
		    swap(j ,j-1 ,input);
		}
	    }
	}
	return input;
    }

    public static void swap(int i, int j, int arr[]) {
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
    }
    
    public static void main (String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter number of elements");
	int n = sc.nextInt();
	int nn = n;
	int output[] = new int[n];
	int input[] = new int[n];
	System.out.println("Enter the elements");
	int i=0;

	while(n --> 0) {
	    input[i] = sc.nextInt();
	    i++;
	}
	System.out.println("Sorted Output");
	output = bubbleSort(input,nn);
	System.out.println(Arrays.toString(output));
    }
}
