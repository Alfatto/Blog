import java.util.*;

public class Level1{

public static String[] TreeOfLife(int H, int W, int N, String[] tree) {
        String[][] stringsCopy = new String[H][W];
        String tochka = ".";
        String plus = "+";
        String god = "1";


        //длина массива(количество строк)
        for (int i = 0; i < tree.length; i++) {
            //второй for для инициализации столбцов
            for (int k = 0; k < tree[0].length(); k++) {
                stringsCopy[i][k] = String.valueOf(tree[i].charAt(k));
            }
        }

        for (int j = 1; j <= N; j++) {
            //если год делится на 2 без остатка, то ветки уничтожаем
            for (int i = 0; i < stringsCopy.length; i++) {
                //второй for для инициализации столбцов
                for (int k = 0; k < stringsCopy[0].length; k++) {
                    if (j % 2 == 0) {
                        if (stringsCopy[i][k].equals(god)) {
                            //System.out.println("запуск " + j);
                            //левый верхний угол
                            if (i == 0 && k == 0) {
                                stringsCopy[i][k] = tochka;
                                stringsCopy[i + 1][k] = tochka;
                                stringsCopy[i][k + 1] = tochka;
                                //правый верхний угол
                            } else if (i == 0 && k + 1 == stringsCopy[0].length) {
                                stringsCopy[i][k] = tochka;
                                stringsCopy[i + 1][k] = tochka;
                                stringsCopy[i][k - 1] = tochka;
                                //верхняя средняя часть
                            } else if (i == 0 && k + 1 < stringsCopy[0].length) {
                                stringsCopy[i][k] = tochka;
                                stringsCopy[i][k + 1] = tochka;
                                stringsCopy[i][k - 1] = tochka;
                                stringsCopy[i + 1][k] = tochka;
                                //левая средняя часть
                            } else if (i + 1 < stringsCopy.length && k == 0) {
                                stringsCopy[i][k] = tochka;
                                stringsCopy[i + 1][k] = tochka;
                                stringsCopy[i - 1][k] = tochka;
                                stringsCopy[i][k + 1] = tochka;
                                //левый нижний угол
                            } else if (i + 1 == stringsCopy.length && k == 0) {
                                stringsCopy[i][k] = tochka;
                                stringsCopy[i - 1][k] = tochka;
                                stringsCopy[i][k + 1] = tochka;
                                //нижняя средняя часть
                            } else if (i + 1 == stringsCopy.length && k + 1 < stringsCopy[0].length) {
                                stringsCopy[i][k] = tochka;
                                stringsCopy[i - 1][k] = tochka;
                                stringsCopy[i][k + 1] = tochka;
                                stringsCopy[i][k - 1] = tochka;
                                //правый нижний угол
                            } else if (i + 1 == stringsCopy.length && k + 1 == stringsCopy[0].length) {
                                stringsCopy[i][k] = tochka;
                                stringsCopy[i - 1][k] = tochka;
                                stringsCopy[i][k - 1] = tochka;
                                //правая средняя часть
                            } else if (i + 1 < stringsCopy.length && k + 1 == stringsCopy[0].length) {
                                stringsCopy[i][k] = tochka;
                                stringsCopy[i - 1][k] = tochka;
                                stringsCopy[i + 1][k] = tochka;
                                stringsCopy[i][k - 1] = tochka;
                            } else {
                                stringsCopy[i][k] = tochka;
                                stringsCopy[i - 1][k] = tochka;
                                stringsCopy[i + 1][k] = tochka;
                                stringsCopy[i][k - 1] = tochka;
                                stringsCopy[i][k + 1] = tochka;
                            }
                        }
                    } else {
                        if (stringsCopy[i][k].equals(plus)) {
                            stringsCopy[i][k] = god;
                        } else if (stringsCopy[i][k].equals(god)) {
                            stringsCopy[i][k] = god;
                        } else {
                            stringsCopy[i][k] = plus;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < stringsCopy.length; i++) {
            //меняем год на +
            for (int k = 0; k < stringsCopy[0].length; k++){
                if (stringsCopy[i][k].equals(plus)){
                    stringsCopy[i][k] = tochka;
                }
                if (stringsCopy[i][k].equals(god))
                    stringsCopy[i][k] = plus;
            }
        }
        return tree;
    }

}