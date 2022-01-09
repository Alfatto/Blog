import java.util.*;

public class Level1{
	public static int [] SynchronizingTables(int N, int [] ids, int [] salary){

		List<Integer> intListDiagonal = Arrays.asList(4, 6, 7, 9);
		float[] summa = new float[N];
		float diagonal = 1.414215f;
		float odin = 1;
		char diagonalMatch = 'G';
		char vertMatch = 'V';
		char dva = '2';
		char[] charsArray = new char[hits.length];
		float value1 = 0;


		for (int i = 0; i < hits.length; i++) {
			if (hits[i] == 2) {
				charsArray[i] = dva;
			} else if (intListDiagonal.contains(hits[i]) == true) {
				charsArray[i] = diagonalMatch;
			} else {
				charsArray[i] = vertMatch;
			}
		}

		for (int k = 0; k < charsArray.length; k++) {
			if (k == 0) {
				continue;
			} else if (charsArray[k - 1] == '2' && charsArray[k] == 'G' ||
					charsArray[k - 1] == 'G' && charsArray[k] == '2') {
				summa[k - 1] = diagonal;
			} else {
				summa[k - 1] = odin;
			}
		}

		for (int j = 0; j < summa.length; j++) {
			value1 += summa[j];
		}

		int number = (int) (value1 * 100000);
		int number1 = Integer.parseInt(Integer.toString(number).replace("0", ""));

		String str = String.valueOf(number1);
		return str;
	}

}
