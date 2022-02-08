import java.util.*;

public class Level1{

	public static boolean TankRush(int H1, int W1, String S1, int H2, int W2, String S2){
		String[] array1;
		String[] array2;

		array1 = S1.split("\\s");
		array2 = S2.split("\\s");

		for (int i = 0; i < array1.length - 1; i++){
			for (int k = 0; k < array2.length - 1; k++){
				if (array1[i].indexOf(array2[k]) == array1[i + 1].indexOf(array2[k + 1]) && -1 != array1[i].indexOf(array2[k])){
					return true;
				}
			}
		}
		return false;
	}

}