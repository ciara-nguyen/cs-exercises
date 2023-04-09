public class Threesort {
    public static void main(String[] args) {
        int a=Integer.parseInt(args[0]);
        int b=Integer.parseInt(args[1]);
        int c=Integer.parseInt(args[2]);
        int min=Math.min(a,b);
        min=Math.min(min,c);
        int max=Math.max(a,b);
        max=Math.max(max,c);
        int other=a+b+c-min-max;
        System.out.println("ascending order is: "+min+" "+other+" "+max);
    }
}
