public class RecursiveSquares {
    public static void drawSquare(double x, double y, double length) {
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, length / 2);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, length / 2);
    }

    public static void draw(int n, double x, double y, double length) {
        if (n == 0) return;
        draw(n - 1, x + length / 2, y + length / 2, length / 2);
        draw(n - 1, x - length / 2, y + length / 2, length / 2);
        drawSquare(x, y, length);
        draw(n - 1, x + length / 2, y - length / 2, length / 2);
        draw(n - 1, x - length / 2, y - length / 2, length / 2);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.enableDoubleBuffering();
        draw(n, 0.5, 0.5, 0.5);
        StdDraw.show();
    }
}
