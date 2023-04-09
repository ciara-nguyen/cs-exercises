public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        int[] a = new int[m * n];
        for (int i = 0; i < (m * n); i++) a[i] = i;
        //Randomize k cells contains mines
        for (int i = 0; i < (m * n); i++) {
            int r = i + (int) (Math.random() * (m * n - i));
            int ex = a[i];
            a[i] = a[r];
            a[r] = ex;
        }
        //Creat m-by-n grid
        String[][] grid = new String[m][n];
        for (int i = 0; i < k; i++) {
            int x = a[i] / n;
            int y = a[i] % n;
            grid[x][y] = "*";
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] != "*") {
                    int mines = 0;
                    for (int x = Math.max(0, i - 1); x <= Math.min(m - 1, i + 1); x++)
                        for (int y = Math.max(0, j - 1); y <= Math.min(n - 1, j + 1); y++)
                            if (grid[x][y] == "*") mines++;
                    grid[i][j] = Integer.toString(mines);
                }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(grid[i][j] + "  ");
            System.out.println();
        }
    }
}
