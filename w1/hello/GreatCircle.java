public class GreatCircle {
    public static void main(String[] args) {
        //Convert x1, y1, x2, y2
        double x1=Math.toRadians(Double.parseDouble(args[0]));
        double y1=Math.toRadians(Double.parseDouble(args[1]));
        double x2=Math.toRadians(Double.parseDouble(args[2]));
        double y2=Math.toRadians(Double.parseDouble(args[3]));
        //calculate distance
        double h=Math.pow(Math.sin((x2-x1)/2),2.0)+Math.cos(x1)*Math.cos(x2)*Math.pow(Math.sin((y2-y1)/2),2.0);
        double distance=2.0*6371.0*Math.asin(Math.sqrt(h));
        // Prints out the disance to the terminal window
        System.out.println(distance+" kilometers");
    }
}
