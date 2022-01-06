import java.util.*;
public class Main {
   public static int squirrel(int N){
       int fact = 1;
       while (N > 1){
           fact *= N;
           N--;
       }
        return Integer.parseInt(Integer.toString(fact).substring(0,1));
   }
}