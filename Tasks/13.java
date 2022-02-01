import java.util.*;

public class Level1{

	public static int[] UFO(int N, int [] data, boolean octal){
		StringBuilder s = new StringBuilder();
		int sum = 0;
		int numberSystem;

		if (octal) {
			numberSystem = 8;
		} else {
			numberSystem = 16;
		}

		for (int i = 0; i < data.length; i++){
			sum += data[i] * (int) Math.pow(numberSystem, data.length - (i + 1));
		}

		while(sum > 0) {
			s.insert(0, sum % 10);
			sum = sum / 10;
		}

		int[] result = new int[s.length()];

		for (int i = 0; i < s.length(); i++) {
			result[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
		}

		return result;
	}
}