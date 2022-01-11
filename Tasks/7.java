import java.util.*;

public class Level1{

static boolean podstroka(String A, String B) {
		String str = " ,.";

		if (B.equals("")) {
			return true;
		}

		for (int i = 0; i < A.length() && B.length() <= A.length() - i; i++) {
			for (int c = 0; c < B.length() && B.charAt(c) == A.charAt(c + i); c++) {
				if (c == B.length() - 1) {
					if (B.length() == A.length()) {
						return true;
					} else if (c + 1 + i < A.length() && str.contains(Character.toString(A.charAt(c + i + 1)))) {
						return true;
					} else if (i == 0 && str.contains(Character.toString(A.charAt(c + i + 1)))) {
						return true;
					} else if (i > 0 && str.contains(Character.toString(A.charAt(i - 1)))) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static int WordSearch(int len, String s, String subs) {
		int N = 0;
		int resultLench = 0;
		int indecsArray = 0;
		String abc = "";
		String[] words = s.split(" ");
		StringBuilder builder = new StringBuilder("");
		final int lenCopy = len;

		if (s.length() != 0) {
			indecsArray++;
		}

		for (int k = 0; k < words.length; k++) {

			if (builder.length() + words[N].length() <= len) {
				if (k != words.length - 1) {
					builder.append(words[N] + ' ');
				} else {
					builder.append(words[N]);
				}
				N++;
			} else if (words[N].length() >= len) {
				builder.append(words[N] + ' ');
				N++;
			} else {
				for (int i = builder.length(); i < len; i++) {
					builder.append(' ');
				}
				indecsArray++;
				len += lenCopy;
				k--;
			}
		}
		int[] result = new int[indecsArray];


		for (int i = 0; i < result.length; i++) {
			result[i] = 0;
		}

		String[] stroke = new String[indecsArray];
		for (int b = 0, c = lenCopy; b < result.length; b++) {
			if (b == result.length - 1) {
				stroke[b] = builder.substring(c - lenCopy, builder.length());
			} else {
				stroke[b] = builder.substring(c - lenCopy, c);
			}
			c += lenCopy;
		}

		for (int i = 0; i < stroke.length; i++) {
			if (podstroka(stroke[i], subs)) {
				result[i] = 1;
			}
		}
		return result;
	}
}