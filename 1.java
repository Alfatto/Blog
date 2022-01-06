import java.util.*;
import java.lang.Integer;
public class Main {
   public static int squirrel(int N){
       int fact = 1;
       while (N > 1){
           fact *= N;
           N--;
       }
       int result = Integer.parseInt(Integer.toString(fact).substring(0,1));
       return result;
   }
}