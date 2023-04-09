public class MaximumSquareSubmatrix {
    public static int size(int[][] a) {
        int n = a.length;
        int[][] b = new int[n][n];
        int sz = 0;
        for (int i = 0; i < n; i++) {
            b[i][0] = a[i][0];
            if (b[i][0] > sz) sz = b[i][0];
        }
        for (int i = 1; i < n; i++) {
            b[0][i] = a[0][i];
            if (b[0][i] > sz) sz = b[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (a[i][j] == 1) b[i][j] = a[i][j] + Math.min(Math.min(b[i - 1][j], b[i][j - 1]), b[i - 1][j - 1]);
                else b[i][j] = 0;
                if (b[i][j] > sz) sz = b[i][j];
            }
        }
        return sz;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = StdIn.readInt();
            }
        }
        StdOut.println(size(a));
    }
}
