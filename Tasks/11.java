import java.util.*;
/*

Райнехарт и мистер Андерсон
РАЙНЕХАРТ

Наша компания - ведущая компания по разработке программного обеспечения в мире. И это все благодаря тому, что каждый отдельный служащий понимает, что он - часть целого. Таким образом, если служащий имеет проблему, это означает, что вся компания имеет проблему.
Пока ваша самая большая проблема, мистер Андерсон, что вы не выполнили в срок рабочее задание.
Пришло время делать выбор, мистер Андерсон. Либо вы сейчас же реализуете вычисление разностей BigInteger, либо вы будете вынуждены искать другую работу. Я ясно выражаюсь?


Требуется вычислить разницу между двумя целыми неотрицательными числами, заданными своим строковым представлением (например, "1234567890" и "321").
Числа задаются в диапазоне от 0 до 10^16 (включительно).

В некоторых языках есть поддержка так называемых BigInteger, которые потенциально не ограничены диапазонами, однако арифметические операции над ними выполняются не процессором, а эмуляционным кодом. По сути, для этих операций просто вызываются функции стандартных библиотек.

Возможно, в выбранном вами языке имеется поддержка BigInteger, однако в данной миссии надо обойтись без них.
Придумайте, как вычислять разность для любых заданных значений.

Функция

string BigMinus(string s1, string s2)
получает на вход два числа в формате строки (числа всегда корректные -- набор цифр), и возвращает абсолютное значение (модуль) разности -- первое число s1 минус второе число s2, также в формате строки.
Например,
BigMinus("1234567891", "1") = "1234567890"
BigMinus("1", "321") = "320"
*/

public class Level1{
	public static String BigMinus(String s1, String s2) {
		ArrayList<Integer> maxList;
		ArrayList<Integer> minList;
		StringBuilder sb = new StringBuilder();
		StringBuilder result = new StringBuilder();
		boolean s1BolscheS2 = true;
		boolean flagInt = false;

		if (s1.length() == s2.length() || s1.length() > s2.length()) {
			int s1a = Character.digit(s1.charAt(0), 10);
			int s2b = Character.digit(s2.charAt(0), 10);

			if (s1a <= s2b && s1.length() == s2.length()) {
				s1BolscheS2 = false;
			}
		} else {
			s1BolscheS2 = false;
		}

		if (s1BolscheS2) {
			maxList = new ArrayList<>(s1.length());
			minList = new ArrayList<>(s2.length());
		} else {
			maxList = new ArrayList<>(s2.length());
			minList = new ArrayList<>(s1.length());
		}
		//наполняем листы значениями
		for (int i = 0; i < s1.length(); i++) {
			if (s1BolscheS2) {
				maxList.add(Character.digit(s1.charAt(i), 10));
			} else {
				minList.add(Character.digit(s1.charAt(i), 10));
			}
		}
		for (int x = 0; x < s2.length(); x++) {
			if (s1BolscheS2) {
				minList.add(Character.digit(s2.charAt(x), 10));
			} else {
				maxList.add(Character.digit(s2.charAt(x), 10));
			}
		}
		//переводим листы в массивы
		Integer[] max = maxList.toArray(new Integer[0]);
		Integer[] min = minList.toArray(new Integer[0]);

		int counter = min.length - 1;//для отсекания меньшего массива из цикла итерации
		for (int k = max.length - 1; k >= 0; k--) {
			// если флаг инт равен true
			if (flagInt && max[k] == 0) {
				max[k] = 10 - 1;
				flagInt = true;
			} else if (flagInt) {
				max[k] = max[k] - 1;
				flagInt = false;
			}

			if (counter >= 0) {
				if (max[k] == 0 && min[counter] == 0) {
					result.append(max[k]);
					counter--;
				} else if (max[k] == 0) {
					result.append(10 - min[counter]);
					counter--;
					flagInt = true;
				} else if (max[k] < min[counter]) {
					result.append(10 - (min[counter] - max[k]));
					counter--;
					flagInt = true;
				} else {
					result.append(max[k] - min[counter]);
					counter--;
				}
			} else {
				if (k == 0 && max[k] == 0) {
					continue;
				}
				result.append(max[k]);
			}
		}

		result.reverse();

		boolean intNull = false;

		for (int s = 0; s < result.length(); s++) {
			if (result.charAt(s) != '0') {
				intNull = true;
			}
		}

		if (intNull == false) {
			result = new StringBuilder();
			//result.append(0);
		}

		return result.toString();
	}
}