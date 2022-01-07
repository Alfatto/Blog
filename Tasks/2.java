import java.util.*;
public class Level1{
  public static int odometer(int [] oksana){
   int result = 0;
        int time = 0;
        int time1;

        for (int i = 0; i < oksana.length; i++) {
            if (i % 2 != 0){
                time1 = oksana[i] - time;
                time = oksana[i];
                result += oksana[i -1] * time1;
            }
        }
    return result; 
    }
}