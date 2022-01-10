import java.util.*;

public class Level1{

public static int [] WordSearch(int len, String s, String subs){
		StringBuilder builder = new StringBuilder("");

		int N = 0;
		int indecs = 0;// для возврата со строки
		int resultLench = 0;
		int indecsArray =0;
		String[] words = s.split(" ");
		for (int k = 0; k < words.length; k++) {
			if (builder.length() + words[N].length() < len) {
				if (k != words.length - 1) {
					builder.append(words[N] + '_');
				} else {
					builder.append(words[N] + '_');
				}
				N++;
			} else if (words[N].length() >= 12) {
				builder.append(words[N]);
				N++;
			} else {
				for (int i = builder.length(); i < len; i++) {
					builder.append('?');
				}
				len += 12;
				k--;
			}
		}
		
		indecs = s.indexOf(subs);

			logger.info(" Индекс " + indecs );
			resultLench = builder.length() / 12;
			indecs = s.indexOf(subs) / 12;
			logger.info(" Индекс четный " + indecs );

		if (builder.length() % 12 == 0){
			logger.info(" Индекс " + indecs );
			resultLench += 1;
			indecs += 1;
			logger.info(" Индекс не четный " + indecs );
		}

		int[] result = new int[resultLench];
		for (int i : result) {
			result[i] = 0;
		}
		result[indecs] = 1;
		return result;

	}

}