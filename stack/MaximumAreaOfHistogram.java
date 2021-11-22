/*
Problem Description : https://leetcode.com/problems/largest-rectangle-in-histogram/
Approach: For each building height we need to check till how many other buildings it can span to left and right. If the left or right buillding is greater than or equal
to the current building then we can span to right or left. If it is smaller than current building we can't span. So we need to check when we incounter a smaller building
and stop the span. We can get the index before the smaller building in left/right and calculate the width and then the area for each building and return the maximum area.
Note:
If a building can span till 0th index to left then the index will be -1.
If a building can span till arr.length - 1 index then the index will be arr.length (pseudo index) as on arr.length index there is no building
So for each building we need to find NSL anf NSR (indexes) then area = (NSR - NSL - 1) * height[i];
 */

import java.util.*;

class MaximumAreaOfHistogram {

    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of buildings");
        int l = sc.nextInt();
        int heights[] = new int[l];
        System.out.println("Enter building heights");
        for (int i = 0; i < l; i++) {
            heights[i] = sc.nextInt();
        }
        System.out.println(largestRectangleArea(heights));
    }
    public static int largestRectangleArea(int[] heights) {
        List<Integer> left = NSL(heights);
        List<Integer> right = NSR(heights);

        List<Integer> area = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            area.add((right.get(i) - left.get(i) - 1) * heights[i]);
        }
        return Collections.max(area);
    }

    public static List<Integer> NSL(int arr[]) {
        //let sudoLeft = -1;
        Stack<StackObj> st = new Stack<>();
        List<Integer> left = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (st.size() == 0) {
                left.add(-1);
            } else if (st.peek().value < arr[i]) {
                left.add(st.peek().index);
            } else {
                while (st.size() > 0 && st.peek().value >= arr[i]) {
                    st.pop();
                }
                if (st.size() == 0) {
                    left.add(-1);
                } else {
                    left.add(st.peek().index);
                }
            }
            st.push(new StackObj(arr[i], i));
        }
        return left;
    }

    public static List<Integer> NSR(int arr[]) {
        Stack<StackObj> st = new Stack<>();
        List<Integer> right = new ArrayList<>();
        int sudoRight = arr.length;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (st.size() == 0) {
                right.add(sudoRight);
            } else if (st.peek().value < arr[i]) {
                right.add(st.peek().index);
            } else {
                while (st.size() > 0 && st.peek().value >= arr[i]) {
                    st.pop();
                }
                if (st.size() == 0) {
                    right.add(sudoRight);
                } else {
                    right.add(st.peek().index);
                }
            }
            st.push(new StackObj(arr[i], i));
        }
        Collections.reverse(right);
        return right;
    }
}

class StackObj {
    int value;
    int index;

    public StackObj(int value, int index) {
        this.value = value;
        this.index = index;
    }
}