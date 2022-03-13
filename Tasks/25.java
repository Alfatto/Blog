import java.util.*;

public class Level1{

 public static boolean TransformTransform(int A[], int N) {
        boolean flag = false;
        ArrayList<Integer> B = newTransform(A, N);
        int[] myArray = new int[B.size()];
        for (int i = 0; i < B.size(); i++) {
            myArray[i] = Integer.valueOf(B.get(i));
        }
        ArrayList<Integer> B1 = newTransform(myArray, myArray.length);
        int sum = 0;
        for (int i = 0; i < B1.size(); i++) {
            sum += B1.get(i);
        }
        if (sum % 2 == 0) {
            flag = true;
        }
        return flag;
    }

    public static ArrayList newTransform(int A[], int N) {
        ArrayList<Integer> B = new ArrayList<>();
        int newMax = -1;
        int k;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <= A.length - 1 - i; j++) {
                k = i + j;
                for (int p = j; p <= k; p++) {
                    if (A[p] > newMax) {
                        newMax = A[p];
                    }
                }
                B.add(newMax);
                newMax = -1;
            }
        }
        return B;
    }



}