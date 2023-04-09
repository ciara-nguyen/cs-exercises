public class ActivationFunction {
    public static double heaviside(double x) {
        double t;
        if (x == 0) t = 0.5;
        else {
            if (x > 0) t = 1;
            else {
                if (x < 0) t = 0;
                else t = x;
            }
        }
        return t;
    }

    public static double sigmoid(double x) {
        double t = 1 / (1 + Math.exp(-x));
        return t;
    }

    public static double tanh(double x) {
        double a = Math.exp(x);
        double b = Math.exp(-x);
        double t = (a - b) / (a + b);
        return t;
    }

    public static double softsign(double x) {
        double y = 1 + Math.abs(x);
        double t = x / y;
        return t;
    }

    public static double sqnl(double x) {
        double t;
        if (x <= -2) t = -1;
        else {
            if (x < 0) t = x + x * x / 4;
            else {
                if (x < 2) t = x - x * x / 4;
                else {
                    if (x >= 2) t = 1;
                    else t = x;
                }
            }
        }
        return t;
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        StdOut.println("heaviside(" + x + ") = " + heaviside(x));
        StdOut.println("  sigmoid(" + x + ") = " + sigmoid(x));
        StdOut.println("     tanh(" + x + ") = " + tanh(x));
        StdOut.println(" softsign(" + x + ") = " + softsign(x));
        StdOut.println("     sqnl(" + x + ") = " + sqnl(x));
    }
}
