public class BandMatrix {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);
        String str;
        for (int i = 1; i <= n; i++) {
            str = "";
            for (int j = 1; j <= n; j++)
                if (Math.abs(i - j) > r) str += "0  ";
                else str += "*  ";
            System.out.println(str);
        }
    }
}
