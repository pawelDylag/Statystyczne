import com.sun.jmx.remote.internal.ArrayQueue;
import com.sun.jnlp.IntegrationServiceImpl;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by paweldylag on 26/01/16.
 */
public class Zad8 {


    private static final int SIMULATION_TIME_MILLIS = 20000;
    private static final double LAMBDA_1 = 15;
    private static final double LAMBDA_2 = 20;

    public Zad8() {
    }

    public void run () {

//        try {
//            PrintWriter out = new PrintWriter("/Users/paweldylag/Desktop/dane_servery.dat");
//            while (time < MAX_TIME) {
//                out.println(time + " " + states);
//            }
//            out.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        long startTime = System.currentTimeMillis();
        long endTime = startTime + SIMULATION_TIME_MILLIS;
        int taskCounter = 0;

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        while (System.currentTimeMillis() < endTime) {
            // generujemy nowe zadanie
            final Task task = new Task(taskCounter++);
            long taskArrivalTime = task.arrivalTime;
            try {
                // czekamy na przyjscie zadania
                System.out.println("Main dispatcher waiting for new task");
                Thread.sleep(taskArrivalTime);
                // wrzucamy je do kolejki
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            long taskWorkTime = task.generateWorkTime(LAMBDA_2);
                            System.out.println("Thread " + Thread.currentThread().getId() + " starts new task");
                            task.start();
                            Thread.sleep(taskWorkTime);
                            task.finish();
                            System.out.println(task.toString());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }

    private class Task {

        /**
         * Czas po ktorym bedzie dostepne
         */
        private final long arrivalTime;
        private long workTime;
        private final int id;
        /**
         * 1. pobrany
         * 2. start pracy
         * 3. skonczony
         */
        private long[] timestamps = new long[3];

        public Task(int id) {
            RandomGenerator rand = new RandomGenerator();
            this.arrivalTime = (long) ((- Math.log(rand.uniformNumber())) / LAMBDA_1 * 10000);
            this.timestamps[0] = System.currentTimeMillis();
            this.id = id;
        }

        public long generateWorkTime(double lambda) {
            RandomGenerator rand = new RandomGenerator();
            this.workTime = (long) ((- Math.log(rand.uniformNumber())) / lambda * 10000);
            return workTime;
        }

        public void start() {
            this.timestamps[1] = System.currentTimeMillis();
        }

        public void finish() {
            this.timestamps[2] = System.currentTimeMillis();
        }


        @Override
        public String toString() {
            long queueWait = timestamps[1] - timestamps[0] - arrivalTime;
            SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");
            return "Task " + id + " (arriveTime = " + arrivalTime + " , queueTime = " + queueWait + " workTime = " + workTime +
                    ") Generated at: " + f.format(new Date(timestamps[0])) +
                    ", Started at: " + f.format( new Date(timestamps[1])) +
                    ", Finished at: " + f.format(new Date(timestamps[2])) +
                    '}';
        }
    }
}
