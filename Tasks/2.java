import java.util.*;
public class Level1{
  public static int odometer(int [] oksana){
        int result = 0;
        for (int i = 0; i < oksana.length; ) {
            result += oksana[i];
            i += 2;
        }
        return result;
    }
}