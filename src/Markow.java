import Jama.Matrix;

import java.util.Arrays;

/**
 * Created by paweldylag on 15/12/15.
 */
public class Markow {

    private static final double BOUND = 0.00001;

    public Markow() {
    }

    public void run() {

        double [][] p =  {{0.64, 0.32, 0.04},
                          {0.4, 0.5, 0.1},
                          {0.25, 0.5, 0.25}};

        Matrix matrixP = new Matrix(p);
        Matrix matrixPp = new Matrix(p);
        Matrix matrixPpp = new Matrix(3,3);

        boolean isStable = false;
        while (!isStable) {
            // multiply
            matrixPpp = matrixPp.times(matrixP);
            // check stability
            if (isStable(matrixPp, matrixPpp)) {
               isStable = true;
            }
            matrixPp = matrixPpp;
        }
        for (int i = 0; i < 3; i++){
            for (int j = 0; j< 3; j++) {
                System.out.print(matrixPp.get(i,j) + " ");
            }
            System.out.print("\n");
        }
    }

    private boolean isStable(Matrix m1, Matrix m2) {
        Matrix m = m2.minus(m1);
        for (int i = 0; i < m.getColumnDimension(); i++){
            for (int j = 0; j< m.getRowDimension(); j++) {
                if (Math.abs(m.get(i,j)) > BOUND) {
                    return false;
                }
            }
        }
        return true;
    }

}
