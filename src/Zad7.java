import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by paweldylag on 19/01/16.
 * Procesy markowa, stany.
 */
public class Zad7 {

    private static final int MAX_TIME = 20;
    private static final int ITER = 100000;

    public Zad7() {
    }

    /**
     * Rysuje wykres schodkowy dla losowania
     */
    public void run() {
        RandomGenerator rand = new RandomGenerator();
        double lambda = 1;
        double time = 0;
        int states = 0;

        try {
            PrintWriter out = new PrintWriter("/Users/paweldylag/Desktop/dane.dat");
            while (time < MAX_TIME) {
                time += (- Math.log(rand.uniformNumber())) / lambda;
                states++;
                out.println(time + " " + states);
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void run2() {
        RandomGenerator rand = new RandomGenerator();
        double lambda = 1;
        double[] zliczenia = new double[60];
        double[] poisson = new double[60];
        System.out.println("STARTING " + ITER +  " ITERATIONS");
        for (int i = 0; i < ITER; i ++) {
            double time = 0;
            int states = -1;
            while (time < MAX_TIME) {
                time += (- Math.log(rand.uniformNumber())) / lambda;
                states++;
            }
            // poisson
            int bucket = (int) Math.floor(getPoisson(MAX_TIME));
            poisson[bucket]++;
            zliczenia[states]++ ;
        }

        try {
            PrintWriter out = new PrintWriter("/Users/paweldylag/Desktop/dane.dat");
            for(int i = 0; i < zliczenia.length; i++) {
                out.println(i + " " + zliczenia[i] / ITER);
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            PrintWriter out = new PrintWriter("/Users/paweldylag/Desktop/dane2.dat");
            for(int i = 0; i < zliczenia.length; i++) {
                out.println(i + " " + poisson[i] / ITER);
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("FINISHED");




    }


    public int getPoisson(double lambda) {
        double L = Math.exp(-lambda);
        double p = 1.0;
        int k = 0;

        do {
            k++;
            p *= Math.random();
        } while (p > L);

        return k - 1;
    }



}
