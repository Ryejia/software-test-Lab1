public class SinFunction {

    public static double calculate(double x) {
        int period = (int) (x / (Math.PI * 2));
        x -= period * Math.PI * 2;

        double result = 0;
        int sign = 1;
        for (int i = 0; i < 15; i++) {
            result += (sign * Math.pow(x, 2 * i + 1)) / getFactorial(2 * i + 1);
            sign = -sign;
        }
        return Math.round(result * 1000.0) / 1000.0;
    }

    private static long getFactorial(int f) {
        long result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }

    public static void main(String[] args) {
        double x = Math.PI/2;

        System.out.println(SinFunction.calculate(x));
    }
}
