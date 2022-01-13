import java.util.*;

public class Level1{

public static int[] WordSearch(int len, String s, String subs) {
		//создаем необходимые переменные
		String[] works = s.split(" ");//разбиваем строку s и создаем массив стрин
		StringBuilder bilder = new StringBuilder();// она принимает значения из массива строк
		StringBuilder bilderCopy = new StringBuilder();// оснавная переменная для записи bildera  в list
		ArrayList<StringBuilder> list = new ArrayList<>();
		boolean recordList;
		boolean myBolean = false;

		//первый цикл принимаем значение из массива стринг
		for (int i = 0; i < works.length; i++) {
			//если bilder равен нулю
			if (bilder.isEmpty()) {
				bilder.append(works[i]);
			}
			recordList = false;

			//запускаем второй цикл до тех пор пока biderCopy не обнулится
			do {
				if (bilder.length() > len) {
					bilderCopy.append(bilder.substring(0, len));
					bilder.delete(0, len);
					recordList = true;
				} else if (bilder.length() + bilderCopy.length() < len) {
					if (bilder.length() + bilderCopy.length() < len) {
						bilderCopy.append(bilder + " ");
					} else {
						bilderCopy.append(bilder);
					}
					bilder = new StringBuilder();
				} else if (bilder.length() + bilderCopy.length() == len) {
					bilderCopy.append(bilder);
					bilder = new StringBuilder();
					recordList = true;
				} else if (bilder.length() + bilderCopy.length() > len && bilder.length() <= len) {
					recordList = true;
				}

				//если record == true то записываем bilderCopy  в list и очищаем bilder
				if (recordList == true || i == works.length - 1) {
					list.add(bilderCopy);
					bilderCopy = new StringBuilder();
				}
				recordList = false;

			} while (!bilder.isEmpty());

		}

		StringBuilder[] stroke;
		stroke = list.toArray(list.toArray(new StringBuilder[0]));
		int[] result = new int[list.size()];

		for (int r = 0; r < stroke.length; r++) {
			String str = " ,.";

			if (s.equals("")) {
				myBolean = true;
			}
			for (int i = 0; i < stroke[r].length() && subs.length() <= stroke[r].length() - i; i++) {
				for (int c = 0; c < subs.length() && subs.charAt(c) == stroke[r].charAt(c + i); c++) {
					if (c == subs.length() - 1) {
						if (subs.length() == stroke[r].length()) {
							myBolean = true;
						} else if (c + 1 + i < stroke[r].length() && str.contains(Character.toString(stroke[r].charAt(c + i + 1)))) {
							myBolean = true;
						} else if (i == 0 && str.contains(Character.toString(stroke[r].charAt(c + i + 1)))) {
							myBolean = true;
						} else if (i > 0 && str.contains(Character.toString(stroke[r].charAt(i - 1)))) {
							myBolean = true;
						}
					}
				}
			}
			if (myBolean == true) {
				result[r] = 1;
				myBolean = false;
			}
		}
		return result;
	}
}