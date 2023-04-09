public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        //Define sequence of bits
        int[] bit = new int[n];
        for (int i = 1; i < n; i++) {
            int k = (int) ((Math.log(i)) / (Math.log(2)));
            bit[i] = 1 - bit[i - (int) (Math.pow(2, k))];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (bit[i] == bit[j]) System.out.print("+  ");
                else System.out.print("-  ");
            }
            System.out.println();
        }
    }
}
