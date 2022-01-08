import java.util.*;

public class Level1{
	public static int [] SynchronizingTables(int N, int [] ids, int [] salary){

		int[] resultArray = new int[N];
		int[] sortIds = Arrays.copyOf(ids, ids.length);
		int[] sortSalary = Arrays.copyOf(salary, salary.length);
		int meaning = 0;

		Arrays.sort(sortIds);
		Arrays.sort(sortSalary);

		for (int i = 0; i < ids.length; i++){
			meaning = ids[i];
			for (int k = 0; k < sortIds.length; k++){
				if (meaning == sortIds[k]){
					meaning = k;
				}
			}
			resultArray[i] = sortSalary[meaning];
		}
		return resultArray;
	}
}