import java.util.*;

class SuffixArray {
  // naive approach for getting Suffix array. Its complexity when all the suffixes are sorted in
  // lexographical order will be O(n^2log n)
  public static void getSuffixArray(String s) {
    Map<String, Integer> mp = new TreeMap<>();
    int len = s.length();
    for (int i = 0; i < len; i++) {
      mp.put(s.substring(i, len), i);
    }
    System.out.println(mp.values());
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    getSuffixArray(s);
  }
}
