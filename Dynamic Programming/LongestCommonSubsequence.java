import java.util.Scanner;

class LongestCommonSubsequence {

    // Recursive solution
    public static int LCSRecursive(String s1, String s2, int m, int n) {
        // base cases
        if(m == 0 || n ==0) { // if either of string is empty there is no point of comparision
            return 0;
        // if the last character is matching then at least one sequence is common and we need to compare m - 1 and n - 1 strings
        } else if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + LCSRecursive(s1, s2, m - 1, n - 1);
        // else, we need to check both m - 1, n and m, n - 1 and take the max of it.
        } else {
            return Math.max(LCSRecursive(s1, s2, m - 1, n), LCSRecursive(s1, s2, m, n -1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String 1");
        String s1 = sc.nextLine();
        System.out.println("Enter string 2");
        String s2 = sc.nextLine();
        System.out.println(LCSRecursive(s1,s2,s1.length(), s2.length()));
    }
}