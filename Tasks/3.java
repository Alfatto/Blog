import java.util.*;

public class Level1{
public static int ConquestCampaign(int N, int M, int L, int [] battalion) {
		int day = 0;
		if (L != 0) {
			day = 1;
		}
		int[][] oks = new int[N][M];
		int[][] oksCopy = new int[N][M];
		boolean prowerka;

		for (int i = 0; i < battalion.length; i++) {
			if (i != 0 & i % 2 != 0) {
				oks[battalion[i - 1] - 1][battalion[i] - 1] = 1;
			}
		}
		do {
			prowerka = false;
			for (int i = 0; i < oks.length; i++) {
				for (int k = 0; k < oks[0].length; k++) {
					if (oks[i][k] == 1) {
						if (k > 0) {
							oksCopy[i][k] = 1;
							oksCopy[i][k - 1] = 1;
						}
						if (k < oks[0].length - 1) {
							oksCopy[i][k + 1] = 1;
							oksCopy[i][k] = 1;
						}
						if (i > 0) {
							oksCopy[i][k] = 1;
							oksCopy[i - 1][k] = 1;
						}
						if (i < oks.length - 1) {
							oksCopy[i + 1][k] = 1;
							oksCopy[i][k] = 1;
						}
					}
				}
			}

			for (int i = 0; i < oks.length; i++) {
				for (int k = 0; k < oks[0].length; k++) {
					oks[i][k] = oksCopy[i][k];
				}
			}

			for (int i = 0; i < oks.length; i++) {
				for (int k = 0; k < oks[0].length; k++) {
					if (oks[i][k] == 0) {
						prowerka = true;
					}
				}
			}
			day++;

		} while (prowerka != false);
		return day;
	}
	
}