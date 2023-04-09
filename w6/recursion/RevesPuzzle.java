public class RevesPuzzle {
    public static void hanoi(int n, int k, String from, String temp, String to) {
        if (n == 0) return;
        hanoi(n - 1, k, from, to, temp);
        int m = n + k;
        System.out.println("Move disc " + m + " from " + from + " to " + to);
        hanoi(n - 1, k, temp, from, to);
    }

    public static void rev(int n, String from, String temp1, String temp2, String to) {
        int k = n + 1 - (int) (Math.round(Math.sqrt(2 * n + 1)));
        if (k == 0) {
            System.out.println("Move disc " + 1 + " from " + from + " to " + to);
            return;
        }
        rev(k, from, to, temp2, temp1);
        hanoi(n - k, k, from, temp2, to);
        rev(k, temp1, temp2, from, to);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        rev(n, "A", "B", "C", "D");
    }
}

