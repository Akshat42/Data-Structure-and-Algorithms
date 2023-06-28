import java.util.Arrays;
class MergeSort {
		public static void MS(int a[], int p, int r) {

				if(p < r) {
						// find the mid
						int q = ( p + r ) / 2;
						// call MS(...) on left half of subarray
						MS(a, p, q);
						// call MS(...) on the right half of subarray
						MS(a, q + 1, r);
						merge(a, p, q, r);
				}
		}
		
		public static void merge(int a[], int p, int q, int r) {
				System.out.println("Merge method starts");	
				System.out.println(p+" "+q+" "+r);
				int L1[] = new int[q-p+1];
				int L2[] = new int[r-q];	

				for(int i=0; i<L1.length;i++)
						L1[i] = a[p+i];
				System.out.println("L1 ");	
				System.out.println(Arrays.toString(L1));
				System.out.println(p+" "+q+" "+r);
				for(int j = 0; j<L2.length;j++)
						L2[j] = a[q+1+j];
				
				System.out.println("L2 ");
				System.out.println(Arrays.toString(L2));
				int i=0, j=0;
				int k = p;
				while(i<L1.length && j<L2.length) {
						if(L1[i] > L2[j]) {
								a[k] = L2[j];
								j++;
								k++;
						} else {
								a[k] = L1[i];
								i++;
								k++;
						}
				}
				System.out.println("sorted");
				while(i< L1.length) {
						a[k] = L1[i];
						i++;
						k++;
				}

				while(j< L2.length) {
						a[k] = L2[j];
						j++;
						k++;
				}
				System.out.println("Copying remaining elements");
				System.out.println("Array afer merging "+Arrays.toString(a));
		}
		public static void print(int a[]) {
				for(int ele:a) {
						System.out.print(ele+" ");
				System.out.println();
				}
		}

		public static void main (String args[]) {
				int a[] = {2,4,5,7,1,2,3,6};
				MS(a,0,7);
				for(int ele:a)
						System.out.print(ele+" ");
				System.out.println();
		}
}
