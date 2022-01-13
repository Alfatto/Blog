import java.util.*;

public class Level1{
 public static int SumOfThe(int N, int [] data){
		int result = 0;
		for (int k: data) {
			result += k;
		}
		for (int i: data){
			result -= i;
			for (int r: data){
				if (result == r){
					return result;
				}
			}
		}
		return result;
	}
}
