public class Birthday {
    public static void main(String[] args) {
        int days = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] count = new int[days + 2];
        for (int i = 0; i < trials; i++) {
            boolean[] a = new boolean[days];
            int j = 1;
            int r = (int) (Math.random() * days);
            while (!a[r]) {
                j++;
                a[r] = true;
                r = (int) (Math.random() * days);
            }
            count[j]++;
        }
        double p = 0.0;
        double sum = 0.0;
        for (int j = 1; j <= days + 1; j++) {
            if (p < 0.5) {
                sum += count[j];
                p = sum / trials;
                System.out.printf("%-8d%-8d%8.6f", j, count[j], p);
                System.out.println();
            }
        }
    }
}
