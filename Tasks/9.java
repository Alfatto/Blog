import java.util.*;

public class Level1{
public  static String TheRabbitsFoot(String s, Boolean encode){
		String result = "";
		StringBuilder builder = new StringBuilder();
		StringBuilder builderCopy = new StringBuilder();
		String[] stringDemo = s.split(" ");
		String[][] myAray;
		//вычисляем корень
		if (encode) {
			builder = new StringBuilder(s.replaceAll("\\s", ""));
			double sqrt = Math.sqrt(builder.length());
			int arayLench = (int) Math.round(sqrt);
			myAray = new String[arayLench][arayLench];
			//переводим в матрицу
			for (int i = 0; i < arayLench; i++){
				for (int k = 0; k < arayLench; k++){
					if (k < builder.length()) {
						myAray[i][k] = String.valueOf(builder.charAt(k));
					}
					if (k == arayLench - 1 && !builder.isEmpty()){
						builder.delete(0, arayLench);
					}
				}
			}//проходимся по массиву и записываем в builder
			for ( int e = 0; e < arayLench; e++){
				for (int d = 0; d < arayLench; d++){
					if (myAray[d][e] != null){
						builderCopy.append(myAray[d][e]);
					}
					if(d == arayLench - 1 && e != arayLench - 1){
						builderCopy.append(" ");
					}
				}
			}
			return result = new String(builderCopy);
		} else {
			//обратная расшифровка
			myAray = new String[stringDemo.length][stringDemo.length];
			for (int i = 0; i < stringDemo.length; i++) {
				for (int k = 0; k < stringDemo.length; k++) {
					if (k < stringDemo[i].length()) {
						myAray[i][k] = String.valueOf(stringDemo[i].charAt(k));
					}
				}
			}
			for (int i = 0; i < 5; i++) {
				for (int k = 0; k < 5; k++) {
					if (myAray[k][i] != null) {
						builder.append(myAray[k][i]);
					}
				}
			}
		}
		return result = new String(builder);
	}
}