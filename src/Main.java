
public class Main {

    public static void main(String[] args) {
        double err = Double.NaN;
        System.out.println("Hello algorithms!");
        System.out.println(Math.abs(Integer.MIN_VALUE));
    }

    public static double sqrt(double c) {
        if (c < 0) return Double.NaN;
        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c / t) > err * t) {
            t = (c / t + t) / 2.0;
        }
        return t;
    }
}
