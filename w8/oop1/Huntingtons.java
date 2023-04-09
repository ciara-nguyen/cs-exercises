public class Huntingtons {
    public static int maxRepeats(String dna) {
        int max = 0;
        int count = 0;
        int i = 0;
        while (i <= dna.length() - 3) {
            String s = dna.substring(i, i + 3);
            if (s.equals("CAG")) {
                count++;
                if (count > max) max = count;
                i = i + 3;
            } else {
                count = 0;
                i++;
            }
        }
        return max;
    }

    public static String removeWhitespace(String s) {
        String s1 = s.replaceAll(" ", "");
        String s2 = s1.replaceAll("\n", "");
        return s2.replaceAll("\t", "");
    }

    public static String diagnose(int maxRepeats) {
        if (maxRepeats > 9 && maxRepeats <= 35) return "normal";
        if (maxRepeats > 35 && maxRepeats <= 39) return "high risk";
        if (maxRepeats > 39 && maxRepeats <= 180) return "Huntington's";
        return "not human";
    }

    public static void main(String[] args) {
        In query = new In(args[0]);
        String input = query.readAll();
        String dna = removeWhitespace(input);
        int r = maxRepeats(dna);
        StdOut.println("max repeats = " + r);
        StdOut.println(diagnose(r));
    }
}
