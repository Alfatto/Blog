import java.util.*;

public class Level1{
	public static int Unmanned(int L, int N, int [][] track){
		int result = 0;
		int flag = 0;

		for (int i = 0; i < L ; i++){
			if (L < track[0][0]){
				return  L;
			} else
			if (i == track[0][flag] - 1){
				result += track[1][0] - track[0][0] + 1;
			} else {
				result++;
			}
		}
		return  result;
	}
}
