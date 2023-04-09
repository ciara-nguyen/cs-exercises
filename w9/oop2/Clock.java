public class Clock {
    private int hour;
    private int min;

    public Clock(int h, int m) {
        if (h < 0 || h > 23 || m < 0 || m > 59) throw new IllegalArgumentException();
        else {
            hour = h;
            min = m;
        }
    }

    public Clock(String s) {
        if (s.length() != 5) throw new IllegalArgumentException();
        else {
            if (!((s.substring(2, 3)).equals(":"))) throw new IllegalArgumentException();
            else {
                int h = Integer.parseInt(s.substring(0, 2));
                int m = Integer.parseInt(s.substring(3, 5));
                if (h < 0 || h > 23 || m < 0 || m > 59) throw new IllegalArgumentException();
                else {
                    hour = h;
                    min = m;
                }
            }
        }
    }

    public String toString() {
        String hh;
        String mm;
        if (hour < 10) hh = "0" + hour;
        else hh = "" + hour;
        if (min < 10) mm = "0" + min;
        else mm = "" + min;
        return hh + ":" + mm;
    }


    public boolean isEarlierThan(Clock that) {
        if (hour < that.hour) return true;
        else {
            if ((hour == that.hour) && (min < that.min)) return true;
            else return false;
        }
    }

    public void tic() {
        this.hour = (this.hour + (this.min + 1) / 60) % 24;
        this.min = (this.min + 1) % 60;
    }

    public void toc(int delta) {
        if (delta < 0) throw new IllegalArgumentException();
        else {
            this.hour = (this.hour + (this.min + delta) / 60) % 24;
            this.min = (this.min + delta) % 60;
        }
    }

    public static void main(String[] args) {
        int hh = Integer.parseInt(args[0]);
        int mm = Integer.parseInt(args[1]);
        String ss = args[2];
        int d = Integer.parseInt(args[3]);
        Clock clock1 = new Clock(hh, mm);
        Clock clock2 = new Clock(ss);
        System.out.println(clock1.isEarlierThan(clock2));
        System.out.println(clock1.toString() + "  " + clock2.toString());
        clock1.tic();
        System.out.println(clock1.toString());
        clock2.toc(d);
        System.out.println(clock2.toString());
    }
}
