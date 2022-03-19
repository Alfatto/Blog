import java.util.*;

public class Level1{

	public static boolean white_walkers(String village) {
        if (village.length() < 5){
            return false;
        }

        char[] charsArray = village.toCharArray();
        int N1 = 0;
        int N2 = 0;
        boolean room = false;
        int hodoky = 0;

        for (int i = 0; i < charsArray.length - 4; i++){
            if (Character.isDigit(charsArray[i])){
                N1 += Character.getNumericValue(charsArray[i]);
                room = true;
            }

            for (int k = 1; k + i < charsArray.length && room; k++){
                if (charsArray[i + k] == '='){
                    hodoky++;
                }

                if (Character.isDigit(charsArray[k + i])){
                    N2 += Character.getNumericValue(charsArray[k + i]);
                    if (N1 == N2 || N1 + N2 != 10){
                        i = k;
                        break;
                    }

                }

                if (N1 + N2 == 10 && hodoky >= 3){
                    return  true;
                }
            }
            N2 = 0;
        }
        return false;
    }
}