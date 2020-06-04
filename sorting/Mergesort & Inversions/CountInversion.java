/* Basically we are piggybacking the Merg Sort Algorithm. We are just counting the number of inversions with it.
    In MergCountInv(...) method when the element from the right subarray is smaller than the left subarray then the Inversion occures. 
    Since Both L[] and R[] are sorted, that means if left subarray element is greater than the right  subarray element, the elements in the leftsubarray after the compared element will all  be greater than the right subarray element */

    /* For example 
	L[] = {1,3,5}
	R[] = {2,4,6}
	when 3 is compared with 2, we got an inversion (3,2) and elements in L[] afte 3 will also get an inversion(here 5) whith the right 
	subarray element (2) , so at that step total number of inversion will be (3,2) and (5,2)
    */
    
    /* The Key Idea is 
	because the left and right subarray are sorted, so all remaining elements in L[i+1], L[i+2] ... L[mid] will get an inversion with R[j]
    */


class CountInversion {
    public static int MergSortCount(int arr[], int l,int r) {
	int count = 0;
	if(r>l) {
	    int m = (l+r)/2;
	    count = count + MergSortCount(arr,l,m);
	    count = count + MergSortCount(arr,m+1,r);
	    count = count + MergCountInv(arr,l,m,r);
	}
	return count;
    }
    public static int MergCountInv(int arr[], int l,int m,int r) {
//`	System.out.println(l + " " +m + " "+ r);
	int n1 = m - l + 1;
	int n2 = r - m;
	int swap = 0;

	int L[] = new int[n1];
	int R[] = new int[n2];

	for(int i=0; i < n1;i++)
	    L[i] = arr[l+i];
	
	for(int i=0; i<n2 ; i++)
	    R[i] = arr[m+1 +i];
	
//	print(L);
//	print(R);
	int i=0,j=0,k=l;
	while( i < n1 && j < n2 ) {
	    if(L[i] <= R[j]) {
		arr[k] = L[i];
		i++;
		k++;
	    } else {
		arr[k] = R[j];
		swap = swap + (m+1) - (l+i);
		j++;
		k++;
	    }
	}
	while ( i < n1) {
	    arr[k] = L[i];
	    i++;
	    k++;
	}

	while ( j < n2 ) {
	    arr[k] = R[j];
	    j++;
	    k++;
	}
//	System.out.print("arr ");
//	print(arr);
	return swap;
    }

    public static void print(int arr[]) {
	for(int i = 0 ;i < arr.length; i++) 
	    System.out.print(arr[i] + " ");
	System.out.println();
    }

    public static void main (String args[]) {
	int arr[] = {1,3,5,2,4,6};
	System.out.println("Number of inversions "+MergSortCount(arr,0,5));
	System.out.println("Sorted array");
	print(arr);
    }
}
