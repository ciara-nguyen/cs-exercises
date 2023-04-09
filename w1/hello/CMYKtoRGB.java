public class CMYKtoRGB {
    public static void main(String[] args) {
        //Declare c,m,y,k
        double c=Double.parseDouble(args[0]);
        double m=Double.parseDouble(args[1]);
        double y=Double.parseDouble(args[2]);
        double k=Double.parseDouble(args[3]);
        //Calculate RGB
        double w=1.0-k;
        int r=(int)Math.round(255.0*w*(1.0-c));
        int g=(int)Math.round(255.0*w*(1.0-m));
        int b=(int)Math.round(255.0*w*(1.0-y));
        //Print out RGB to terminal window
        System.out.println("red   = "+r);
        System.out.println("green = "+g);
        System.out.println("blue  = "+b);
    }
}
