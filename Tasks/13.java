import java.util.*;

public class Level1{

	public static int[] UFO(int N, int [] data, boolean octal){
		StringBuilder s = new StringBuilder();
		int sum = 0;
		int numberSystem;
		int[] result = new int[N];
		int n;

		if (octal) {
			numberSystem = 8;
		} else {
			numberSystem = 16;
		}

		for (int k = 0; k < N; k++) {
			s.append(data[k]);
			for (int i = 0; i < s.length(); i++) {
				n = Integer.parseInt(String.valueOf(s.charAt(i)));
				sum += n * (int) Math.pow(numberSystem, s.length() - (i + 1));
			}
			result[k] = sum;
			sum = 0;
			s = new StringBuilder();
		}
		return result;
	}
}