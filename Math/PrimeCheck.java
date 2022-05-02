import java.util.Scanner;

class PrimeCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(checkPrimeEffieient(n));
    }

    // Time complexity O(n)
    static boolean checkPrimeNaive(int n) {
        if (n == 1) return false;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Time complexity O(sqRoot(n))
    static boolean checkPrimeEffieient(int n) {
        if (n == 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // more effectent solution
    // with extra check for divisibility with 2 and 3 we can save many more iterations
    // it is almost 3 times faster that the previous effecient solution
    static boolean checkPrimeEffieient(int n) {
        if (n == 1) return false;
        if (n == 1 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false
        for (int i = 5; i <= Math.sqrt(n); i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}