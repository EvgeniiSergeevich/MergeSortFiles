public class Convert {
    String[] in;


    public Convert(String[] in) {
        this.in = in;
    }
    public static boolean isNumeric (String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public int[] convertArray (String[] in) {
        int[] result1 = new int[in.length];
        for (int i = 0; i < in.length; i++) {
            if (isNumeric(in[i])) {
                result1[i] = Integer.parseInt(in[i]);
            }
        }
        return result1;
    }
}
