import java.util.Scanner;
class Lcm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(effecientLcm(a,b));
    }

    // naive solution
    static int lcmNaive(int a, int b) {
        int res = Math.max(a,b);
        while (true) {
            if (res % a ==0 && res % b == 0) {
                break;
            }
            res++;
        }
        return res;
    }

    // effecient solution
    // we can use this formulae => a * b = gcd(a,b) * lcm(a,b)
    // lcm(a,b) = a * b / gcd(a,b)
    // finding gcd will take O(log(min(a,b)) and finding lcm is constant time.

    static int effecientLcm(int a, int b) {
        return a * b / gcd(a,b);
    }

    static  int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}