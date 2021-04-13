import java.util.Scanner;

class PrintAllSubsets {
		static void printSubset(String s) {
				subsetRec("",s);
		}

		static void subsetRec(String soFar, String remaining) {
				if(remaining.length() == 0)
						System.out.println(soFar);
				else {
						String next = soFar + Character.toString(remaining.charAt(0));
						String leftOf = remaining.substring(1);
						subsetRec(next,leftOf);
						subsetRec(soFar,leftOf);
				}
		}
		public static void main (String args[]) {
				Scanner sc = new Scanner(System.in);
				String s = sc.nextLine();
				printSubset(s);
		}
}
