import java.util.*;

public class Level1{

	public static String MassVote(int N, int [] Votes){

		String bolee50= "majority winner ";
		String menee50= "minority winner ";
		String no_winner = "no winner";
		int max1 = 0;
		int max2 = 0;
		double sum = 0;
		double golosProtcent;
		int K = -1;

		for (int i = 0; i < Votes.length; i++) {
			if (i == 0) {
				max1 = Votes[i];
				K = i + 1;
			} else if (max1 <= Votes[i]) {
				max2 = max1;
				max1 = Votes[i];
				K = i + 1;
			}
			sum += Votes[i];
		}

		golosProtcent = Math.round((( max1 / sum) * 100.0) * 1000.0) / 1000.0;

		if ( max1 == max2){
			return no_winner;
		} else if (golosProtcent <= 50){
			return menee50 + K;
		} else {
			return bolee50 + K;
		}
	}
}
