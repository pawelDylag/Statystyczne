import java.util.ArrayList;

/**
 * Created by paweldylag on 24/11/15.
 */
public class Zad6 {

    public Zad6() {
    }

    public void run() {
        System.out.println("Zadanie 6:");
        double result = runSmall(10000);
        System.out.println("Probka 20 => " + result);
        double result2 = runLarge(10000);
        System.out.println("Probka 100 => " + result2);
    }


    public double runSmall(int count) {
        double allCount = count;
        double passedCount = 0d;
        int valuesCount = 20;
        int bucketCount = 3;
        final double limes = 10.117;

        for (int k = 0; k < allCount; k++) {
            RandomGenerator r = new RandomGenerator();
            ArrayList<Double> values = new ArrayList<Double>();
            for (int i = 0; i < valuesCount; i++) {
                values.add(r.uniformNumber(-3,3));
            }
            // generate buckets
            double[] buckets = new double[bucketCount];
            for (int i = 0; i < valuesCount; i++) {
                Double val = values.get(i);
                Double step = 1d / bucketCount;
                int bucketIndex = (int) Math.floor((val / step));
                buckets[bucketIndex]++;
            }

            double chiSquared = 0d;
            for (int i = 0; i < bucketCount; i++) {
                double npi = valuesCount / bucketCount;
                chiSquared += (Math.pow(buckets[i] - npi, 2) / npi);
            }
            if ( chiSquared < limes) {
                passedCount++;
            }
        }
        return passedCount/allCount;

    }

    public double runLarge(int count) {
        double allCount = count;
        double passedCount = 0d;
        int valuesCount = 100;
        int bucketCount = 10;
        final double limes = 77.0463;

        for (int k = 0; k < allCount; k++) {
            RandomGenerator r = new RandomGenerator();
            ArrayList<Double> values = new ArrayList<Double>();
            for (int i = 0; i < valuesCount; i++) {
                values.add(r.normalNumber(0, 1));
            }
            // generate buckets
            double[] buckets = new double[bucketCount];
            for (int i = 0; i < valuesCount; i++) {
                Double val = values.get(i);
                Double step = 1d / bucketCount;
                int bucketIndex = (int) Math.floor(val / step);
                buckets[bucketIndex]++;
            }

            double chiSquared = 0d;
            for (int i = 0; i < bucketCount; i++) {
                double npi = valuesCount / bucketCount;
                chiSquared += (Math.pow(buckets[i] - npi, 2) / npi);
            }
            if ( chiSquared < limes) {
                passedCount++;
            }
        }
        return passedCount/allCount;

    }

}
