import java.util.*;

public class Level1{


	 public static String[] ShopOLAP(int N, String[] items) {

        String[] predResult = new String[items.length*2];
        String[] stroka;
        ArrayList<String> list = new ArrayList<>();
        String[] result = new String[predResult.length];
        int lenchArray = 0;
        int counter = 0;
        int summ = 0;
        int number1 = 0;
        int number2 = 0;

        for (String s: items){
            stroka = s.split(" ");
            predResult[counter] = stroka[0];
            counter++;
            predResult[counter] = stroka[1];
            counter++;
            stroka = null;
        }

        //плюсуем
        counter = 2;
        for (int i = 0; i < predResult.length - 1;){
            summ = Integer.parseInt(predResult[i+1]);
            for (int k = 2; k < predResult.length - 1 && Integer.parseInt(predResult[i + 1]) != 0;){
                if (predResult[i].equals(predResult[k]) && k != predResult.length - counter && i != k){
                    summ += Integer.parseInt(predResult[k + 1]);
                    predResult[k + 1] = "0";
                }
                k+=counter;
            }
            if (Integer.parseInt(predResult[i+1]) != 0){
                list.add(predResult[i] + " " + summ);
                result[i] = predResult[i];
                result[i + 1] = "" + summ;
                lenchArray++;
            }
            i+=counter;
        }

        predResult = new String[list.size() * counter];
        counter = 0;

        for (String s: list){
            stroka = s.split(" ");

            predResult[counter] = stroka[0];
            counter++;
            predResult[counter] = stroka[1];
            counter++;
            stroka = null;
        }


        stroka = new String[2];
        counter = 2;

        for (int i = 1; i <= predResult.length - counter;){
            number1 = Integer.parseInt(predResult[i]);
            number2 = Integer.parseInt(predResult[i+counter]);
            if (number1 < number2){
                stroka[0] = predResult[i + counter];//забираем большее
                stroka[1] = predResult[i + 1];
                predResult[i + 1] = predResult[i - 1];//вставляем меньшее
                predResult[i + counter] = predResult[i];
                predResult[i - 1] = stroka[1];
                predResult[i] = stroka[0];
                i = 1;
            } else {
                i += counter;
            }
        }


        result = new String[predResult.length / 2];
        lenchArray = 0;
        for (int j = 1; j < predResult.length;){
            result[lenchArray] = (predResult[j - 1] + " " + predResult[j]);
            lenchArray++;
            j += counter;
        }
        return result;
    }
}