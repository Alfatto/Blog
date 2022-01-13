import java.util.*;

public class Level1{
 public static int SumOfThe(int N, int [] data){
		int result = 0;
		for (int k: data) {
			result += k;
		}
		for (int i: data){
			for (int r: data){
				if (i == result - r){
					return i;
				}
			}
		}
		return 0;
	}
}
