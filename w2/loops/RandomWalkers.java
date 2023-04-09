public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        int x = 0;
        int y = 0;
        Double sum = 0.0;
        int j;
        Double k;
        if (r >= 0) {
            for (int i = 1; i <= t; i++) {
                j = 0;
                x = 0;
                y = 0;
                while ((Math.abs(x) + Math.abs(y)) != r) {
                    k = Math.random();
                    if (k < 0.25) x += 1;
                    else if (k < 0.5) x = x - 1;
                    else if (k < 0.75) y += 1;
                    else y = y - 1;
                    j++;
                }
                sum += j;
            }
            Double average = sum / t;
            System.out.println("average number of steps = " + average);
        } else System.out.println("The distance must be a positive integer. Please try again");
    }
}
