import java.util.*;

class LongestCommonSubsequence {

    // Recursive solution time complexity - O(2^n)
    public static int LCSRecursive(String s1, String s2, int m, int n) {
        // base cases
        if (m == 0 || n == 0) { // if either of string is empty there is no point of comparision
            return 0;
            // if the last character is matching then at least one sequence is common and we need to compare m - 1 and n - 1 strings
        } else if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + LCSRecursive(s1, s2, m - 1, n - 1);
            // else, we need to check both m - 1, n and m, n - 1 and take the max of it.
        } else {
            return Math.max(LCSRecursive(s1, s2, m - 1, n), LCSRecursive(s1, s2, m, n - 1));
        }
    }

    // memozized version
    public static int LCSMemoize(String s1, String s2, int m, int n, int memo[][]) {
        // base cases
        if (memo[m][n] != -1) return memo[m][n] = 0;
        if (m == 0 || n == 0) { // if either of string is empty there is no point of comparision
            return memo[m][n] = 0;
            // if the last character is matching then at least one sequence is common and we need to compare m - 1 and n - 1 strings
        } else if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return memo[m][n] = 1 + LCSMemoize(s1, s2, m - 1, n - 1, memo);
            // else, we need to check both m - 1, n and m, n - 1 and take the max of it.
        } else {
            return memo[m][n] = Math.max(LCSMemoize(s1, s2, m - 1, n, memo), LCSMemoize(s1, s2, m, n - 1, memo));
        }
    }

    // top - down version
    public static int LCSTopDown(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String 1");
        String s1 = sc.nextLine();
        System.out.println("Enter string 2");
        String s2 = sc.nextLine();
        int memo[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        System.out.println("LCS Memo Answer");
        System.out.println(LCSMemoize(s1, s2, s1.length(), s2.length(), memo));
        System.out.println("LCS Top Down Answer");
        System.out.println(LCSTopDown(s1, s2));
    }
}