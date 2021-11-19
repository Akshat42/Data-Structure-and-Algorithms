// This question is also a variation of NGL here we need to find the nearest smaller element rather than the nearest larger. As in NGL j is dependent on i,
// So we will use Stack to optimise it.

import java.util.*;

class nextSmallerToLeft {
   public static void NSL(int arr[]) {
        Stack<Integer> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if (st.isEmpty()) {
                list.add(-1);
            } else if (st.peek() < arr[i]) {
                list.add(st.peek());
            } else {
                while (st.size() > 0 && arr[i] <= st.peek()) {
                    st.pop();
                }
                if (st.isEmpty()) list.add(-1);
                else list.add(st.peek());
            }
            st.push(arr[i]);
        }
        System.out.println(list);
   }

   public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array Length");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter Array elements");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        NSL(arr);
   }
}
