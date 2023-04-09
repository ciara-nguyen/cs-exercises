public class Divisors {
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int max = Math.max(a, b);
            int min = Math.min(a, b);
            if (min == 0) {
                a = max;
                b = 0;
            } else {
                a = min;
                b = max % min;
            }
        }
        return Math.max(a, b);
    }

    public static int lcm(int a, int b) {
        int t;
        if ((a * b) == 0) t = 0;
        else t = Math.abs(a) / (gcd(a, b)) * Math.abs(b);
        return t;
    }

    public static boolean areRelativelyPrime(int a, int b) {
        boolean t = false;
        if (gcd(a, b) == 1) t = true;
        return t;
    }

    public static int totient(int n) {
        int t = 0;
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                if (areRelativelyPrime(i, n)) t++;
            }
        }
        return t;
    }

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
        System.out.println("lcm(" + a + ", " + b + ") = " + lcm(a, b));
        System.out.println("areRelativelyPrime(" + a + ", " + b + ") = " + areRelativelyPrime(a, b));
        System.out.println("totient(" + a + ") = " + totient(a));
        System.out.println("totient(" + b + ") = " + totient(b));
    }
}
