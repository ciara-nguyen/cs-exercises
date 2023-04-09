public class Inversions {
    public static long count(int[] a) {
        long count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) count++;
            }
        }
        return count;
    }

    public static int[] generate(int n, long k) {
        int[] a = new int[n];
        int i = n - 1;
        while (k > i && k <= (n * (n - 1) / 2)) {
            a[n - 1 - i] = i;
            k = k - i;
            i = i - 1;
        }
        for (int j = n - 1 - i; j < n; j++) a[j] = j - (n - 1 - i);
        if (k > 0 && k <= i) {
            for (int j = n - 1; j >= (n - (int) k); j = j - 1) a[j] = a[j - 1];
            a[n - (int) k - 1] = i;
        }
        return a;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        if (k < 0 || k > ((long) n * (long) (n - 1) / 2)) System.out.println("not suitable");
        else {
            int[] a = generate(n, k);
            for (int i = 0; i < n; i++) StdOut.print(a[i] + " ");
            StdOut.println();
        }
    }
}
