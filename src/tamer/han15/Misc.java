package tamer.han15;

import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.util.FastMath;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Misc {

    public static void concatenate(RealVector x, RealMatrix Z, RealMatrix xZ) {
        int numCols = Z.getColumnDimension();
        int numRows = x.getDimension();
        for (int row = 0; row < numRows; row++) {
            xZ.setEntry(row, 0, x.getEntry(row));
            for (int col = 0; col < numCols; col++) {
                xZ.setEntry(row, col + 1, Z.getEntry(row, col));
            }
        }
    }

    public static void dotMultiply(RealMatrix M, RealVector v, RealMatrix Mv) {
        for (int row = 0; row < M.getRowDimension(); row++) {
            for (int col = 0; col < M.getColumnDimension(); col++) {
                Mv.setEntry(row, col, M.getEntry(row, col) * v.getEntry(row));
            }
        }
    }

    public static void getDiagonal(RealMatrix sqMat, RealVector diag) {
        for (int i = 0; i < sqMat.getRowDimension(); i++) {
            diag.setEntry(i, sqMat.getEntry(i, i));
        }
    }

    public static void print(RealMatrix mat) {
        for (int row = 0; row < mat.getRowDimension(); row++) {
            for (int col = 0; col < mat.getColumnDimension(); col++) {
                System.out.print(mat.getEntry(row, col) + ", ");
            }
            System.out.println("");
        }
    }

    public static void print(List<Double[]> list) {
        for (int i = 0; i < list.size(); i++) {
            for (Double datum : list.get(i)) {
                System.out.print(datum + ", ");
            }
            System.out.println("");
        }
    }

    public static List<Double[]> readData(String relativePath) {
        File file = new File(relativePath);
        List<Double[]> data = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine(); // first line: header
            String[] splitLine = line.split(",");
            int numCols = splitLine.length;
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                splitLine = line.split(",");
                Double[] numbers = new Double[splitLine.length];
                int col = -1;
                for (String number : splitLine) {
                    double value = Double.parseDouble(number);
                    numbers[++col] = value;
                }
                data.add(numbers);
            }
        } catch (FileNotFoundException e) {
        }
        return data;
    }

    public static void sqrt(RealVector vec, RealVector sqrt) {
        for (int i = 0; i < vec.getDimension(); i++) {
            sqrt.setEntry(i, FastMath.sqrt(vec.getEntry(i)));
        }
    }
}
