/*
Problem Statement: We are given an array of stock prices day1 day2 ... dayn. We need to find out, for a given stock price at day[i], the number of consequtive previous
 days where the stock price is less than or equal to day[i] price.
Approach:
This can be easily done with brute force with 2 loops and counting the stocks which is less than or equal to the price at day i.
Optimal Approach:
If we pay attention we need to find the NEAREST GREATER TO LEFT ELEMENT. So whatever there is betwwen the given element and Next Greater to LEFT elemnt, we get the
number of stocks.
To store the Stock we need to store the element and its index in the stack.
When we get the NGL element we can store its index rather than the element
To get the number of stocks we can run a for loop and subtract the index and i of result array (index - i).
 */

import java.util.*;

class StockSpanProblem {
    public static int[] Solve(int arr[]) {
        Stack<StackObj> stack = new Stack<>();
        List<Integer> index = new ArrayList<>(); // to store the index of NGL element
        int res[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                index.add(-1);
            } else if (stack.peek().value > arr[i]) {
                index.add(stack.peek().index);
            } else {
                while (stack.size() > 0 && stack.peek().value <= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    index.add(-1);
                } else {
                    index.add(stack.peek().index);
                }
            }
            stack.push(new StackObj(arr[i], i));
        }
        for (int i = 0; i < arr.length; i++) {
            res[i] = i - index.get(i);
        }
        return res;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array Length");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter Array elements");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(Solve(arr)));
    }
}

class StackObj {
    int value;
    int index;

    StackObj(int value, int index) {
        this.value = value;
        this.index = index;
    }
}