import java.util.*;
class Mergesort {
    public static void MergeSort(int arr[], int l,int r) {
	if(r > l) { // right index should be always greater than left index
	    int m = (l + r) / 2; // calculate the mid
	    MergeSort(arr ,l,m); // call MergeSort() for the first half of the array
	    MergeSort(arr ,m+1,r); // call MergerSort() for the second half of the array
	    merge(arr,l,m,r); // call merge() to Merge the left subarray and right subarray 
	}
    }
    public static void merge(int[] arr, int l,int m, int r) {
//	System.out.println("left "+l+" mid "+m+" right "+r);
	int n1 = m-l+1; // calculate n1 for storing the left subpart
	int n2 = r-m; // calculate n2 for storing the right subpart
	
	//initialize L[] and R[] array
	int L[] = new int[n1]; 
	int R[] = new int[n2];
	// copy the left subpart and right subpart in L[] and R[] array
	for(int i=0; i<n1; i++) 
	    L[i] = arr[l+i];
	for(int j=0; j<n2; j++)
	    R[j] = arr[m + 1 + j];

	int i=0,j=0;

	int k=l;
	//compare left and right subarray and insert it into the main array(arr)
	while(i<n1 && j<n2){
	    if(L[i] <= R[j]){
		arr[k] = L[i];
		i++;
	    }
	    else {
		arr[k] = R[j];
		j++;
	    }
	    k++;
	}

	//copy the remaining elements from L[] and R[] to main array(if present)
	while(i<n1){
	    arr[k] = L[i];
	    i++;
	    k++;
	}
	while(j<n2) {
	    arr[k] = R[j];
	    j++;
	    k++;
	}
    }
    public static void main (String args[]) {
	int arr[] = {38,27,43,3,9,82,10};
	MergeSort(arr,0,6);
	for(int i:arr)
	    System.out.print(i + " ");
	System.out.println();

    }
}
