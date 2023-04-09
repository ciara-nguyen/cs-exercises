public class fiveno {

    public static void main(String[] args) {
	    // Randomize 5 numbers
        double n1=Math.random();
        double n2=Math.random();
        double n3=Math.random();
        double n4=Math.random();
        double n5=Math.random();
        // Calculate average, maximum, minimum values
        double average=(n1+n2+n3+n4+n5)/5.0;
        double max=Math.max(n1,n2);
        max=Math.max(max,n3);
        max=Math.max(max,n4);
        max=Math.max(max,n5);
        double min=Math.min(n1,n2);
        min=Math.min(min,n3);
        min=Math.min(min,n4);
        min=Math.min(min,n5);
        //Print out values to the terminal window
        System.out.println("five numbers is: "+n1+" "+n2+" "+n3+" "+n4+" "+n5);
        System.out.println("average = "+average);
        System.out.println("maximum = "+max);
        System.out.println("minimum = "+min);
    }
}
