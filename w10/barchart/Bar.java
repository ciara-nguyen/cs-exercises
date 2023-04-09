import java.util.Arrays;

public class Bar implements Comparable<Bar> {
    private String na;
    private int val;
    private String cate;

    public Bar(String name, int value, String category) {
        if ((name == null) || (value < 0) || (category == null)) throw new IllegalArgumentException();
        else {
            na = name;
            val = value;
            cate = category;
        }
    }

    public String getName() {
        return na;
    }

    public int getValue() {
        return val;
    }

    public String getCategory() {
        return cate;
    }

    public int getVal() {
        return val;
    }

    public String getCate() {
        return cate;
    }

    public String getNa() {
        return na;
    }

    @Override
    public int compareTo(Bar that) {
        if (that == null) throw new NullPointerException();
        else {
            if (val > that.val) return 1;
            else {
                if (val < that.val) return -1;
                else return 0;
            }
        }
    }

    public static void main(String[] args) {
        Bar[] bars = new Bar[10];
        bars[0] = new Bar("Beijing", 22674, "East Asia");
        bars[1] = new Bar("Cairo", 19850, "Middle East");
        bars[2] = new Bar("Delhi", 27890, "South Asia");
        bars[3] = new Bar("Dhaka", 19633, "South Asia");
        bars[4] = new Bar("Mexico City", 21520, "Latin America");
        bars[5] = new Bar("Mumbai", 22120, "South Asia");
        bars[6] = new Bar("Osaka", 20409, "East Asia");
        bars[7] = new Bar("São Paulo", 21698, "Latin America");
        bars[8] = new Bar("Shanghai", 25779, "East Asia");
        bars[9] = new Bar("Tokyo", 38194, "East Asia");
        Arrays.sort(bars);
        for (int i = 0; i < 10; i++)
            System.out.println(bars[i].getName() + " - " + bars[i].getValue() + " - " + bars[i].getCategory());

    }
}
