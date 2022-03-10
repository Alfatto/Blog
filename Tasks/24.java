import java.util.*;

public class Level1{
 
 public static void MatrixTurn(String[] Matrix, int M, int N, int T) {
        StringBuffer[] matrix = new StringBuffer[M];
        for (int i = 0; i < M; i++) {
            matrix[i] = new StringBuffer(Matrix[i]);
        }
        int length;
        if (M > N) {
            length = N / 2;

        } else {
            length = M / 2;
        }
        for (int times = 1; times <= T; times++)
            for (int j = 0; j < length; j++) {
                for (int i = j; i < matrix.length - 1 - j; i++) {
                    matrix[i].insert(j, matrix[i + 1].charAt(j));
                    matrix[i + 1].delete(j, j + 1);
                }
                for (int i = matrix.length - 1 - j; i > j; i--) {
                    matrix[i].insert(matrix[i].length() - j, matrix[i - 1].charAt(matrix[i - 1].length() - 1 - j));
                    matrix[i - 1].delete(matrix[i - 1].length() - 1 - j, matrix[i - 1].length() - j);
                }
            }

        for (int i = 0; i < matrix.length; i++) {
            Matrix[i]=String.valueOf(matrix[i]);
        }

    }

}