import java.util.*;

public class Level1{
 public static int SumOfThe(int N, int [] data){
		int result = 0;
		for (int k: data) {
			for (int i : data) {
				if (i != k) {
					result += i;
				}
			}
			if (result == k) {
				break;
			}
			result = 0;
		}
		return result;
	}	
}
