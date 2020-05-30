import java.util.*;
class BinaryAddition {
    public static void  BinaryAdd(int a[], int b[]) {
	int len1 = a.length;
	int len2 = b.length;
	int[] newArray;
	if(len1 > len2) {
	    System.out.println("Making the array of equal length by adding zeros");
	    newArray = new int[len1];
	    int j= len1-1;
	  //  for(int i = len2-2; i< newArray.length;i++) {
	//	newArray[i] = b[j];
	//	j++;
	   // }
	    for(int i=b.length-1;i>=0;i--){
		newArray[j] = b[i];
		j--;
	    }
	    b = newArray;
	}
	else if(len2 > len1) {
	    System.out.println("Making array of equal length by adding zeros");
	    newArray =  new int[len2];
	    int j=len2-1;
	    for(int i = a.length-1; i>=0;i--) {
		newArray[j] = a[i];
		j--;
	    }
	    a = newArray;
	}
//	print(a);
//	print(b);
	int out[] = new int[a.length+1];
	int carry = 0;
	int j=out.length-1;
	for(int i = a.length-1 ; i>=0; i--) {
	    if(((a[i] == 1 && b[i] == 0) || (a[i] == 0 && b[i] == 1)) && carry == 0) {
		out[j] = 1;
		j--;
	//	System.out.println("if1");
	//	print(out);
	    }
	    else if((a[i] == 1 && b[i] == 1) && carry == 0 ) {
		out[j] = 1;
		carry = 1;
		j--;
	//	System.out.println("if2");
	//	print(out);
	    }
	    else if(((a[i] == 1 && b[i] == 0) || (a[i] == 0 && b[i] == 1)) && carry == 1){
		out[j] = 1;
		carry = 1;
		j--;
	//	System.out.println("if3");
	//	print(out);
	    }
	    else if( a[i] == 1 && b[i] == 1 && carry == 1) {
		out[j] = 0;
		carry = 1;
		j--;
	//	System.out.println("if4");
	//	print(out);
	    }
	}
	if(carry == 1)
	    out[0] = 1;
//	System.out.println("Ans");
	print(out);
	
    }
    public static void print(int arr[]) {
	for(int i=0;i<arr.length;i++) {
	    System.out.print(arr[i] + " ");
	}
	System.out.println();
    }
    public static void main (String[] args) {
	Scanner sc = new Scanner(System.in);
	int len1 = sc.nextInt();
	int a[] = new int[len1];
	for(int i=0;i<len1;i++)
	    a[i] = sc.nextInt();
	int len2 = sc.nextInt();
	int b[] = new int[len2];
	for(int i=0;i<len2;i++)
	    b[i] = sc.nextInt();
	BinaryAdd(a,b);
    }

}

