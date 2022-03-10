import java.util.*;

public class Level1{
 static int i = 0;
    static int k = 0;
    static int n = 0;
    static String[][] result;
    static int kolStroke;
    static int dlStroke;
    static String[][] resultCopy;

    public static void MatrixTurn(String[] Matrix, int M, int N, int T) {

        result = new String[M][N];
        kolStroke = M;
        dlStroke = N;
        resultCopy = new String[M][N];
        //переводим одномерный массив в многомерный
        for (int i = 0; i < Matrix.length; i++) {
            for (int k = 0; k < Matrix[0].length(); k++) {
                result[i][k] = String.valueOf(Matrix[i].charAt(k));
            }
        }
        //вызываем поворот массива
        while (T > 0) {
            checking(result);
            T--;
        }

        //результат переводим в одномерную матрицу
//        Matrix = Matrix;
        StringBuilder stringBuilder = new StringBuilder();
        for (int l = 0; l < resultCopy.length; l++) {
            for (int a = 0; a < resultCopy[0].length; a++) {
                stringBuilder.append(resultCopy[l][a]);
            }
            Matrix[l] = new String(stringBuilder);
            stringBuilder = new StringBuilder();
        }
    }

    public static String[][] krug(String[][] result) {

        //верх
        kolStroke = result.length - n;
        dlStroke = result[0].length - n;
        k++;
        while (k > n && k <= dlStroke - 1) {
            resultCopy[i][k] = result[i][k - 1];
            k++;
        }
        k--;
        //справа
        i++;
        while (i > n && i <= kolStroke - 1) {
            resultCopy[i][k] = result[i - 1][k];
            i++;
        }
        i--;
        k--;

        //снизу
        while (k >= n) {
            resultCopy[i][k] = result[i][k + 1];
            k--;
        }
        k++;
        i--;
        //слева
        while (i >= n) {
            resultCopy[i][k] = result[i + 1][k];
            i--;
        }
        //нам нужно вернуть исходняе значения
        i++;
        //теперь прибавляем, что бы на следующем круге пойти с более внутреннего круга
        i++;
        k++;
        //n это стартовая точка для i и k
        n++;
        return resultCopy;
    }

    //количество запросов для прохода по всей матрице
    public static String[][] checking(String[][] result) {

        int number = result.length / 2;
        while (number > 0) {
            krug(result);
            number--;
        }
        return resultCopy;
    }

}