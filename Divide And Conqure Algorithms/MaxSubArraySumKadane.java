import java.util.Scanner;

class MaxSubArraySumKadane {
		static int MSK(int a[]) {
				int maxSum  = a[0];
				int maxSubArraySum = a[0];
				for(int i=1;i<a.length;i++) {
						maxSum = Math.max(a[i], maxSum+a[i]);
						if(maxSum > maxSubArraySum)
								maxSubArraySum = maxSum;
				}
				return maxSubArraySum;
		}
		public static void main (String args[]) {
				Scanner sc = new Scanner(System.in);
				int n = sc.nextInt();
				int a[] = new int[n];
				for(int i=0;i<n;i++)
						a[i] = sc.nextInt();
				System.out.println(MSK(a));
		}
}
