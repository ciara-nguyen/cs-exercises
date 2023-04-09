public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int x = 0;
        int y = 0;
        int i = 0;
        Double k;
        System.out.println("(" + x + ", " + y + ")");
        if (r <= 0) System.out.println("The distance must be a positive integer. Please try again");
        else {
            while ((Math.abs(x) + Math.abs(y)) != r) {
                k = Math.random();
                if (k < 0.25) x += 1;
                else if (k < 0.5) x = x - 1;
                else if (k < 0.75) y += 1;
                else y = y - 1;
                System.out.println("(" + x + ", " + y + ")");
                i++;
            }
            System.out.println("steps = " + i);
        }
    }
}
