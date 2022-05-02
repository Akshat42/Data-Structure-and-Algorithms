// Question - find the gcd of 2 given numbers
import java.util.Scanner;
class Gcd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(effecientGcd(a,b));
    }

    // here we know that the maximum GDC or HCF can be minimum of the 2 given numbers
    // so we initialize that as result and check backwards if that number divides both the given
    // number a and b. if not found the GDC/HCF will be one.
    // Time complexity - O(min(a,b))
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

    // to optimise this we can use Euclidian algorithm
    // euclidian algorithims says that if we have 2 numbers a and b
    // if a > b the gcd(a,b) = gcd(a-b,b) else gcd(a, b-a)
    static int gcdEculidianNaive(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    // insted of doing repeated miltiplication we can use modulo operation
    // gcd(10, 15) -> gcd(15, 10) -> gcd(10, 5) -> gcd(5, 0) -> 5
    // as we can see if in first call a < b then it simply swaps to numbers
    // in the remainder calls a will always b greater than b
    // and b will always become zero first.
    static int effecientGcd(int a, int b) {
        if (b == 0)
            return a;
        return effecientGcd(b , a % b);
    }
}