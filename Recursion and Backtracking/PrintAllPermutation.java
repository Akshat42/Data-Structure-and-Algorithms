import java.util.Scanner;

class PrintAllPermutation {

  static void Permutation(String s) {
    RecPermute("", s);
  }

  static void RecPermute(String soFar, String remaining) {
    if (remaining.length() == 0) System.out.println(soFar);
    else {
      for (int i = 0; i < remaining.length(); i++) {
        String next = soFar + Character.toString(remaining.charAt(i));
        String nextRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
        RecPermute(next, nextRemaining);
      }
    }
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the String");
    String s = sc.nextLine();
    Permutation(s);
  }
}
