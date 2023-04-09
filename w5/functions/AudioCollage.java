public class AudioCollage {
    public static double[] amplify(double[] a, double alpha) {
        int n = a.length;
        double[] amplify = new double[n];
        for (int i = 0; i < n; i++) amplify[i] = a[i] * alpha;
        return amplify;
    }

    public static double[] reverse(double[] a) {
        int n = a.length;
        double[] reverse = new double[n];
        for (int i = 0; i < n; i++) reverse[i] = a[n - 1 - i];
        return reverse;
    }

    public static double[] merge(double[] a, double[] b) {
        int n1 = a.length;
        int n2 = b.length;
        double[] merge = new double[n1 + n2];
        for (int i = 0; i < n1; i++) merge[i] = a[i];
        for (int i = 0; i < n2; i++) merge[i + n1] = b[i];
        return merge;
    }

    public static double[] mix(double[] a, double[] b) {
        int max = Math.max(a.length, b.length);
        double[] mix = new double[max];
        for (int i = 0; i < max; i++) mix[i] = 0;
        for (int i = 0; i < a.length; i++) mix[i] += a[i];
        for (int i = 0; i < b.length; i++) mix[i] += b[i];
        return mix;
    }

    public static double[] changeSpeed(double[] a, double alpha) {
        int n = (int) (a.length / alpha);
        double[] changeSpeed = new double[n];
        for (int i = 0; i < n; i++) changeSpeed[i] = a[(int) (i * alpha)];
        return changeSpeed;
    }

    public static void main(String[] args) {
        double[] origin1 = StdAudio.read(args[0]);
        double[] origin2 = StdAudio.read(args[1]);
        double[] rev = reverse(origin1);
        double[] speed = changeSpeed(origin2, 3);
        double[] mi = mix(rev, speed);
        double[] mer = merge(mi, origin1);
        double[] am = amplify(mer, 0.75);
        StdAudio.play(am);
    }
}
