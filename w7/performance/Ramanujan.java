public class Ramanujan {
    public static boolean isRamanujan(long n) {
        long cb = (int) (Math.cbrt(n / 2));
        long i = 1;
        int count = 0;
        while (i <= cb && count < 2) {
            long j = Math.round((Math.cbrt(n - i * i * i)));
            long sum = i * i * i + j * j * j;
            if (n == sum) count++;
            i++;
        }
        if (count == 2) return true;
        else return false;
    }

    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        StdOut.println(isRamanujan(n));
    }
}
