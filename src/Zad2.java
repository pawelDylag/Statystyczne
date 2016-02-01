

import java.util.ArrayList;

/**
 * Created by paweldylag on 02/11/15.
 */
public class Zad2 {

//    public Zad2() {
//    }
//
//    public Chart run() {
//        // wielkosc probki
//        int size = 10000;
//        // funkcja generujaca N(2,9);
//        double sigma = 3;
//        double mean = 2;
//        // wlasnosci histogramu
//        int bins = 100;
//        double min = -13;
//        double max = 17;
//        // liczba liczb poza przedzialem
//        int counter = 0;
//        // liczba przedzialow
//        double sectionWidth = (Math.abs(min) + max)/bins;
//        // generator
//        RandomGenerator generator = new RandomGenerator();
//
//        // wygenerowanie poczatowego zestawu danych
//        ArrayList<Double> dataset1 = new ArrayList<Double>();
//        for (int i = 0; i < size; i++) {
//            double x = sigma * generator.normalNumber() + mean;
//            // jesli wynik jest poza przedzialem
//            if (x < min || x > max) {
//                counter++;
//            } else {
//                dataset1.add(x);
//            }
//        }
//
//        // wygenerowanie znormalizowanego zestawu danych
//        ArrayList<Double> dataset2 = new ArrayList<Double>();
//        for (int i = 0; i < bins; i++) {
//            double x = i + min;
//            double y = ( 1 / (Math.sqrt( 2 * Math.PI) * sigma)) * Math.exp((-Math.pow( x - mean, 2))/ 2 * Math.pow(sigma, 2) );
//            System.out.print(y + "\n");
//            dataset2.add(y);
//        }
//        // nazwa wykresu
//        String chartName = "probka=" + size + " (" + counter  + ")";
//
//        // zbudowanie histogramu
//        Histogram histogram1 = new Histogram(dataset1, bins, min, max);
//
//        // wygenerowanie danych do wykresu
//        Chart chart = new ChartBuilder().chartType(StyleManager.ChartType.Bar).xAxisTitle("X").yAxisTitle("Y").width(1024).height(1024).build();
//        chart.getStyleManager().setYAxisMin(0);
//        chart.getStyleManager().setYAxisMax(600);
//        chart.addSeries(chartName, histogram1.getxAxisData(), histogram1.getyAxisData());
//        chart.addSeries("f(x)", histogram1.getxAxisData(), dataset2);
//
//        // zwracam wykres
//        return chart;

//    }

}
