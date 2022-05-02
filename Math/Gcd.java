// Question - find the gcd of 2 given numbers
import java.util.Scanner;
class Gcd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(gcdNaive(a,b));
    }

    // here we know that the maximum GDC or HCF can be minimum of the 2 given numbers
    // so we initialize that as result and check backwards if that number divides both the given
    // number a and b. if not found the GDC/HCF will be one.
    static int gcdNaive(int a, int b) {
        int res = Math.min(a,b);
        while (res > 0) {
            if (a % res == 0 && b % res == 0) {
                break;
            }
            res--;
        }
        return res;
    }
}