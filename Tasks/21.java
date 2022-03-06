import java.util.*;

public class Level1{

	 private static boolean flag = false;
    private static SortedSet<String> sortedSet = new TreeSet();
    private static String[] list = new String[0];


    public static String BiggerGreater(String input) {
        String result = "";

        //проверка на возможность изменения
        for (int i = 0; i < input.length(); i++) {
            if (i > 0 && input.charAt(i - 1) == input.charAt(i)) {
                flag = true;
            }
        }
        if (flag) {
            flag = false;
            return "";
        }
        //перебираем все возможные варианты и упаковываем в лист
        permutation(input);
        list = sortedSet.toArray(list);
        for (int i = 0; i < list.length - 1; i++) {

            if (list[i].equals(input)) {
                result = list[i + 1];
            }
        }
        return result;
    }

    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            sortedSet.add(prefix);
        } else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }
}