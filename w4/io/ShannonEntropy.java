public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] s = new int[m + 1];
        int sum = 0;
        while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            s[x]++;
            sum++;
        }
        double h = 0.0000;
        for (int i = 1; i <= m; i++) {
            double p = ((double) s[i]) / ((double) sum);
            if (p != 0) h = h - p * (Math.log(p)) / (Math.log(2));
        }
        StdOut.println(String.format("%.5g%n", h));
    }
}
