import java.util.*;
class MaxAreaRectangleInBinaryMatrix {
    public static int findMaxArea(Integer arr[][]) {
        List<Integer[]> mahArray = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                mahArray.add(arr[i]);
            } else {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] != 0) {
                        arr[i][j] = arr[i][j] + arr[i - 1][j];
                    }
                }
                mahArray.add(arr[i]);
            }
        }
        List<Integer> area = new ArrayList<>();
        for(Integer[] a: mahArray) {
            area.add(MAH(a));
        }
        return Collections.max(area);
    }

    public static int MAH(Integer[] arr) {
        List<Integer> left = NSL(arr);
        List<Integer> right = NSR(arr);
        List<Integer> area = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            area.add((right.get(i) - left.get(i) - 1) * arr[i]);
        }
        return Collections.max(area);
    }

    public static List<Integer> NSL(Integer arr[]) {
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

    public static List<Integer> NSR(Integer arr[]) {
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

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ener number of rows");
        int r = sc.nextInt();
        System.out.println("Enter number of columns");
        int c = sc.nextInt();
        Integer arr[][] = new Integer[r][c];
        System.out.println("Enter binary matrix");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(findMaxArea(arr));
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