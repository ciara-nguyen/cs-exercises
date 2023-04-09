public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = args.length;
        int[] a = new int[n];
        for (int i = 1; i < n; i++)
            a[i] = Integer.parseInt(args[i]);
        int[] S = new int[n];
        for (int i = 1; i < n; i++)
            S[i] = S[i - 1] + a[i];
        for (int i = 0; i < m; i++) {
            int r = (int) (Math.random() * S[n - 1]);
            int j = 0;
            while (r >= S[j]) j++;
            System.out.print(j + " ");
        }
    }
}
