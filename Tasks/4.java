import java.util.*;

public class Level1{
public static int [] MadMax(int N, int [] Tele){

		int middle = (N / 2) + 1;
		Arrays.sort(Tele);
		int[] copyTele = new int[Tele.length];

		for (int r = 0; r < Tele.length; r++){
			if (r < middle) {
				copyTele[r] = Tele[r];
			} else {
				copyTele[r] = Tele[((middle -1) * 3 + 1 ) - r];
			}
		}
		return Tele;
	}
}