import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
        In file = new In(args[0]);
        int k = Integer.parseInt(args[1]);
        String title = file.readLine();
        String xAxis = file.readLine();
        String source = file.readLine();
        BarChart chart = new BarChart(title, xAxis, source);
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();
        while (file.hasNextLine()) {
            String skip = file.readLine();
            int n = Integer.parseInt(file.readLine());
            String[] rec = new String[5];
            Bar[] bars = new Bar[n];
            for (int i = 0; i < n; i++) {
                String line = file.readLine();
                rec = line.split(",");
                int value = Integer.parseInt(rec[3]);
                bars[i] = new Bar(rec[1], value, rec[4]);
            }
            chart.setCaption(rec[0]);
            Arrays.sort(bars);
            for (int i = n - 1; i >= Math.max(0, n - k); i = i - 1) {
                chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
            }
            chart.draw();
            StdDraw.show();
            StdDraw.pause(100);
            StdDraw.clear();
            chart.reset();
        }
    }
}
