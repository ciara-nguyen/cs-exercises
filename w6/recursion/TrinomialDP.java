public class TrinomialDP {
    public static long trinomial(int n, int k) {
        long[][] t = new long[n + 1][2 * n + 1];
        t[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            t[i][0] = 1;
            t[i][1] = i;
            for (int j = 2; j <= 2 * i; j++) {
                t[i][j] = t[i - 1][j - 2] + t[i - 1][j - 1] + t[i - 1][j];
            }
        }
        if (k < -n || k > n) return 0;
        else return t[n][n + k];
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        long t = trinomial(n, k);
        System.out.println(t);
    }
}
