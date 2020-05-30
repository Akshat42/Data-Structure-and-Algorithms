class SelectionSort {
    public static void SS(int arr[],int n) {
	for(int i=0;i<n;i++) {
	    int max = -1;
	    int maxIndex = -1;
	    for(int j=i ;j<n; j++) {
		if(arr[j] > max){
		    max = arr[j];
		    maxIndex = j;
		}
	    }
	    swap(i,maxIndex,arr);
	}
	print(arr);
    }
    public static void swap(int i,int j,int arr[]) {
	int temp  = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
    }
    public static void print(int arr[]) {
	for(int i : arr)
	    System.out.print(i+ " ");
	System.out.println();
    }
    public static void main (String args[]) {
	int arr[] = {9,2,5,1,6,3};
	SS(arr,6);
    }
}
	

