import java.util.*;

public class Level1{

 public static boolean LineAnalysis(String line) {

        if (line.charAt(0) != '*') {
            return false;
        }

        StringBuilder s = new StringBuilder(line);
        StringBuilder sequence = new StringBuilder();


        boolean astra = true;
        boolean result = false;
        boolean flag = false;
        int N = 0;
        int number = 0;

        for (int i = 0; i < s.length(); i++) {
            N++;

            if (s.charAt(i) != '*') {
                astra = false;
            }

            if (s.charAt(i) == '*' && !astra) {
                astra = true;
                flag = true;
                number = i;
            }

            if (i == s.length() - 1 && astra) {
                break;
            }

            if (i != 0) {
                sequence.append(s.charAt(i));
            }

            if (flag && ((s.length() - 1) % (N - 1)) != 0 || i == s.length() - 1 && astra) {
                astra = false;
                break;
            }
            
            for (int k = 0; k < s.length() && flag; k++) {
                if (number < s.length()) {
                    if (k == 0 && s.substring(k + i + 1, number + i + 1).contentEquals(sequence)) {
                        astra = true;
                        k += N - 1;
                        number += N;
                        i = number;
                    } else if (s.substring(k - 1, number).contentEquals(sequence)){
                        astra = true;
                    } else {
                        astra = false;
                    }
                    k += i;
                    number += N;
                }
            }
        }

        if (astra) {
            result = true;
        }

        return result;
    }
}