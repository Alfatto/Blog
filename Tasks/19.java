import java.util.*;

public class Level1{


	public static String[] ShopOLAP(int N, String[] items) {

        String[] predResult = new String[items.length*2];//для разделенных строк
        String[] stroka;
        ArrayList<String> list = new ArrayList<>();
        String[] result = new String[predResult.length];
        int lenchArray = 0;
        int counter = 0;
        int summ;
        int number1;
        int number2;
        int NumberFromString1;
        int NumberFromString2;

        //разбиваем строки по пробелу и заполняем массив
        for (String s: items){
            stroka = s.split(" ");
            predResult[counter] = stroka[0];
            counter++;
            predResult[counter] = stroka[1];
            counter++;
            stroka = null;
        }

        counter = 2;

        //считаем сумму количеств продаж вещей
        for (int i = 0; i < predResult.length - 1;){//ячейка i это вещь i+1 это количество продаж
            summ = Integer.parseInt(predResult[i+1]);
            //запускаем подцикл он проходит и считает сколько продаж есть у вещи из первого цикла
            for (int k = 2; k < predResult.length - 1 && Integer.parseInt(predResult[i + 1]) != 0;){//цикл запускается тогда когда summa не равна нулю
                if (predResult[i].equals(predResult[k]) && k != predResult.length - counter && i != k){//ищем совпадения по ячейки i, исключаем вариант
                    //когда номер ячеек одинаковый
                    summ += Integer.parseInt(predResult[k + 1]);
                    predResult[k + 1] = "0";//ячейку где хранятся количество продаж вещей обнуляем, что бы не считать повторно
                }
                k+=counter;
            }
            if (Integer.parseInt(predResult[i+1]) != 0){//собрали сумму, записываем в лист, почему не массив? потому, что не знаем какой длины создавать массив
                list.add(predResult[i] + " " + summ);
                result[i] = predResult[i];
                result[i + 1] = "" + summ;
                lenchArray++;
            }
            i+=counter;
        }

        predResult = new String[list.size() * counter];
        counter = 0;

        //опять приходится разбивать строки на массив
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

        //эти переменные для того что бы подсчитывать номер вещи (платье23)
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();

        for (int i = 1; i <= predResult.length - counter;){

            //вещи отправляем в строки что бы вычеслить число
            String s1 = predResult[i - 1];
            String s2 = predResult[i + 1];

            //вычесляем число первой вещи
            for (int d = 0; d < s1.length(); d++){
                if (Character.isDigit(s1.charAt(d))){
                    stringBuilder1.append(s1.charAt(d));
                }
            }

            //второй вещи
            for (int d = 0; d < s2.length(); d++){
                if (Character.isDigit(s2.charAt(d))){
                    stringBuilder2.append(s2.charAt(d));
                }
            }
            //переводим строковое занчение в числовое
            NumberFromString1 = Integer.parseInt(String.valueOf(stringBuilder1));
            NumberFromString2 = Integer.parseInt(String.valueOf(stringBuilder2));

            //тут считываем количество продаж вещей
            number1 = Integer.parseInt(predResult[i]);
            number2 = Integer.parseInt(predResult[i+counter]);

            if (number1 < number2){//проверяем что бы расстановка была согласно уменьшению количество продаж
                stroka[0] = predResult[i + counter];//забираем большее
                stroka[1] = predResult[i + 1];
                predResult[i + 1] = predResult[i - 1];//вставляем меньшее
                predResult[i + counter] = predResult[i];
                predResult[i - 1] = stroka[1];
                predResult[i] = stroka[0];
                i = 1;
            } else if (NumberFromString1 > NumberFromString2 && number1 == number2){//вариант когда количество продаж одинаково
                //сортируем по лексеграфическому возрастанию
                stroka[0] = predResult[i - 1];//забираем меньшее
                stroka[1] = predResult[i];

                predResult[i - 1] = predResult[i + 1];//вставляем большее
                predResult[i ] = predResult[i + counter];
                predResult[i + 1] = stroka[0];
                predResult[i + counter] = stroka[1];
                i = 1;
            } else {
                i += counter;
            }

            stringBuilder1 = new StringBuilder();
            stringBuilder2 = new StringBuilder();
        }

        //инициализирем маасив
        result = new String[predResult.length / 2];
        lenchArray = 0;

        //заполняем масив
        for (int j = 1; j < predResult.length;){
            result[lenchArray] = (predResult[j - 1] + " " + predResult[j]);
            lenchArray++;
            j += counter;
        }
        return result;
    }
}