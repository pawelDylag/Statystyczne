
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by paweldylag on 27/10/15.
 */
public class RandomGenerator {

    /**
     * @return - a number (-1, 1)
     */
    public double normalNumber() {
        boolean hasResults = false;
        double result = 0;
        while(!hasResults) {
            Random random = new Random();
            // wygenerowanie liczby x
            double x = (random.nextDouble() * 2) - 1;
            // wygenerowanie liczby y
            double y = (random.nextDouble() * 2) - 1;
            // wygenerowanie liczby z
            double z = Math.pow(x, 2) + Math.pow(y, 2);
            // sprawdzenie warunku
            if (z < 1) {
                double sqrt = Math.sqrt((-2 / z) * Math.log(z));
                result = x * sqrt;
                hasResults = true;
            }
        }
        return result;
    }


    /**
     * @return - a number (min, max)
     */
    public double normalNumber(int min, int max) {
        Random random = new Random();
        boolean hasResults = false;
        double result = 0;
        while(!hasResults) {
            double r = random.nextGaussian();
            if ((Double.compare(r, min) >= 0) && (Double.compare(r,max) <= 0)) {
                hasResults = true;
                result = r;
            }
        }
        return result;
    }


    /**
     * @return - a number N(0, 1)
     */
    public double gaussian() {
        Random random = new Random();
        return random.nextGaussian();
    }

    public double uniformNumber() {
        Random random = new Random();
        return random.nextDouble();
    }

    public double uniformNumber(int min, int max) {
        Random random = new Random();
        int range = Math.abs(max) - Math.abs(min);
        return random.nextDouble() * range + min;
    }

    public int poisson(double a) {
        Random random = new Random();
        double limit = Math.exp(-a), prod = random.nextDouble();
        int n;
        for (n = 0; prod >= limit; n++)
            prod *= random.nextDouble();
        return n;
    }

}
