import java.util.*;

public class Level1{
	public static String BigMinus(String s1, String s2) {
		List<Integer> maxList;
		List<Integer> minList;
		List<Integer> result = new ArrayList<>();
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
				if (max[k] == 0) {
					result.add(10 - min[counter]);
					counter--;
					flagInt = true;
				} else if (max[k] < min[counter]) {
					result.add(10 - (min[counter] - max[k]));
					counter--;
					flagInt = true;
				} else {
					result.add(max[k] - min[counter]);
					counter--;
				}
			} else {
				if (k == 0 && max[k] == 0) {
					continue;
				}
				result.add(max[k]);
			}
		}
		Collections.reverse(result);

		return result.toString();
	}
}