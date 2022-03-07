import java.util.*;

public class Level1{
	public static boolean SherlockValidString(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        StringBuilder stringBuilderCopy;
        int sovpadeniy = 0;
        int arhivSovpadeniy = 0;
        //перебираем варианты строки
        for (int i = 0; i < stringBuilder.length() + 1; i++) {
            //System.out.println("запускаем первый цикл " + i);
            stringBuilderCopy = new StringBuilder(stringBuilder);
            if (i == 0) {
                stringBuilderCopy = stringBuilder;
            } else {
                stringBuilderCopy = new StringBuilder(stringBuilderCopy.deleteCharAt(i - 1));
            }

            //выбираем элемент строки
            // System.out.println("запускаем второй цикл " + stringBuilderCopy);
            for (int k = 0; k < stringBuilderCopy.length(); k++) {
                //выбранный элемент должен повторяться одинаковое число раз
                for (int j = 0; j < stringBuilderCopy.length(); j++) {
                    //если элемент равен элементу из 3-го цикла, то увеличиваем счетчик
                    if (stringBuilderCopy.charAt(k) == stringBuilderCopy.charAt(j)) {
                        sovpadeniy++;
                    }
                }
                //после прохода 3-го цикла отправляем совпадения в архив, и обнуляем совпадения
                arhivSovpadeniy += sovpadeniy;
                sovpadeniy = 0;
            }
            //если архив совпадений делится на количество элементов строки без остатка, то строка валидна
            if (arhivSovpadeniy % stringBuilderCopy.length() == 0) {
                return true;
            }
            //если не было совпадения обнуляем архив совпадений
            arhivSovpadeniy = 0;
        }
        return false;
    }

}