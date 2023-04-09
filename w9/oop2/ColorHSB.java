public class ColorHSB {
    private final int hue;
    private final int satu;
    private final int bright;

    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359) throw new IllegalArgumentException("hue value is out of range (0-359)");
        else {
            if (s < 0 || s > 100) throw new IllegalArgumentException("saturation value is out of range(0-100)");
            else {
                if (b < 0 || b > 100) throw new IllegalArgumentException("brightness value is out of range (0-100)");
                else {
                    hue = h;
                    satu = s;
                    bright = b;
                }
            }
        }

    }

    public String toString() {
        return "(" + hue + ", " + satu + ", " + bright + ")";
    }

    public boolean isGrayscale() {
        if (satu == 0 || bright == 0) return true;
        else return false;
    }

    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) throw new IllegalArgumentException();
        else {
            int minh = Math.min(Math.abs(hue - that.hue), 360 - Math.abs(hue - that.hue));
            return (int) (Math.pow(minh, 2) + Math.pow(satu - that.satu, 2) + Math.pow(bright - that.bright, 2));
        }
    }

    public static void main(String[] args) {
        String name = "";
        String namedefine;
        int h1 = Integer.parseInt(args[0]);
        int s1 = Integer.parseInt(args[1]);
        int b1 = Integer.parseInt(args[2]);
        ColorHSB test = new ColorHSB(h1, s1, b1);
        int dis = 52401;
        ColorHSB nearest = new ColorHSB(0, 0, 0);
        while (!StdIn.isEmpty()) {
            namedefine = StdIn.readString();
            int h2 = StdIn.readInt();
            int s2 = StdIn.readInt();
            int b2 = StdIn.readInt();
            ColorHSB define = new ColorHSB(h2, s2, b2);
            if (test.distanceSquaredTo(define) < dis) {
                dis = test.distanceSquaredTo(define);
                nearest = define;
                name = namedefine;
            }
        }
        StdOut.println(name + " " + nearest.toString());
    }
}
