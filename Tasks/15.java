import java.util.*;

public class Level1{

public static boolean TankRush(int H1, int W1, String S1, int H2, int W2, String S2){
		boolean kart = false;
		String[] array1;
		String[] array2;

		array1 = S1.split("\\s");
		array2 = S2.split("\\s");

		for (String s1: array1) {
			for (String s2 : array2) {
				if (s1.contains(s2)){
					kart = true;
					break;
				}
			}
		}
		return kart;
	}

}