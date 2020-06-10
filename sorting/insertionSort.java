import java.util.*;

class insertionSort {
    public static int[] IS(int input[]) {
	for(int j=1; j<input.length; j++) {
	    int key = input[j]; // The key which we wish to sort
	    int i = j-1; // The rightmost element index  
	    while(i >= 0 && input[i] > key) { // comparing key with the elements on the left and index should obviously be greater than zero
		input[i+1] = input[i]; // shifting the element right if it is greater that the key
		i = i - 1; // index for next left element to be compared
	    }
	    input[i+1] = key; // placing the key at the correct position after all the greater elements are shifted to right.
	}
	return input;
    }
    public static int[] recursiveIS(int input[],int n) { 
	if( n < 0 )
	    return new int[1];
	recursiveIS(input,n-1); // call till the last recursion, that is IS(input, n=1);
	int key = input[n]; // takiing the key that is to be inserted into the correct position;
	int j = n-1; //previous element index before key
	while(j >=0 && input[j] > key) { // comparing and replacing if previous elements are greater than key; 
	    input[j+1] = input[j];
	    j--;
	}
	input[j+1] = key; //placing key at the correct place
	return input;
    }
	
    public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the number to be sorted");
	int n = sc.nextInt();
	int[] input = new int[n]; //input
	System.out.println("Enter the inputs");
	for(int i=0;i<n;i++)
	    input[i] = sc.nextInt();
	int[] output = recursiveIS(input,n-1); //sorted output
	System.out.println("Sorted array is: ");
	for(int i=0; i < n; i++)
	    System.out.print(output[i] + " "); // printing output
	System.out.println();
    }
}
