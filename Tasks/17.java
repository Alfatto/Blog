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
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            start++;

            if (s.charAt(i) != '*') {
                astra = false;
            }

            if (s.charAt(i) == '*' && !astra) {
                astra = true;
                flag = true;
                end = i;
            }

            if (i == s.length() - 1 && astra) {
                break;
            }

            if (i != 0) {
                sequence.append(s.charAt(i));
            }

            if (flag && ((s.length() - 1) % (start - 1)) != 0) {
                astra = false;
                break;
            }


            for (int k = 0; k < s.length() && flag; k++) {
                if (end < s.length()) {
                    if (k == 0 && s.substring(start, end + i + 1).contentEquals(sequence)) {
                        astra = true;
                        start += sequence.length() - 1;
                        end += sequence.length() + i;
                    } else if (k > 0 && s.substring(start + 1, end + 1).contentEquals(sequence)){
                        astra = true;
                        start += sequence.length();
                        end += sequence.length();
                    } else {
                        astra = false;
                    }
                    k = end;
                    i = k;

                }
            }
        }

        

        if (astra) {
            result = true;
        }

        return result;
    }
}