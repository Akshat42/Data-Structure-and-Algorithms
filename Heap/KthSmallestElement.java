import java.util.*;

class KthSmallestElement {

    public static int solve(int arr[], int k) {
        // max heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for(int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() > k)  pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter k");
        int k = sc.nextInt();
        System.out.println("Enter n");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solve(arr,k));
    }
}