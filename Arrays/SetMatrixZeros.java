class SetMatrixZeros {

    // ? Reference - https://takeuforward.org/data-structure/set-matrix-zero/
	/**  
        // ? Brute force - traverse and if a[i][j] is zero the make the row and col as INteger.min + 100 except 
	    // ? the one which is zero at last replace Integer.min + 100 with zeros  
	*/
    public void setZeroesBrute(int[][] a) {
        int n = a[0].length;
        int m = a.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 0) {
                    // make row elements as -1 except if a[i][j] is zero.
                    int p = i;
                    // int q = 0;
                    for(int q = 0; q < n; q++) {
                        if (a[p][q] != 0) {
                            a[p][q] = Integer.MIN_VALUE + 100;
                        }
                    }
                    // make colum elements as -1 except if a[i][j] is zero
                    // int r = 0;
                    int s = j;

                    for(int r = 0; r < m; r++) {
                        if (a[r][s] != 0) {
                            a[r][s] = Integer.MIN_VALUE + 100;
                        }
                    }
                }
            }
        }
        // make -1 as zeros again
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(a[i][j] == Integer.MIN_VALUE + 100) {
                    a[i][j] = 0;
                }
            }
        }
        print(a);
    }

    public void setZeroBetter(int [][] a) {
        int m = a.length;
        int n = a[0].length;

        int[] mArr = new int[m];
        int[] nArr = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 0) {
                    mArr[i] = 1;
                    nArr[j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mArr[i] == 1 || nArr[j] == 1) {
                    a[i][j] = 0;
                }
            }
        }
        print(a);
    }

    static void print(int a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i]. length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
}