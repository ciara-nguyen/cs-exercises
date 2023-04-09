public class RightTriangle {
    public static void main(String[] args){
        //Declaration a,b,c
        int a=Integer.parseInt(args[0]);
        int b=Integer.parseInt(args[1]);
        int c=Integer.parseInt(args[2]);
        //Define the greatest number of a, b, c
        int d=Math.max(a,b);
        d=Math.max(d,c);
        //Declaration boolean
        boolean Right;
        Right=(a>0)&&(b>0)&&(c>0)&&((a*a+b*b+c*c-d*d)==d*d);
        System.out.println(Right);
    }}
