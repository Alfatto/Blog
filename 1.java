import java.util.*;
import java.lang.Integer;
public class Main {
   if (N == 0){
           return 0;
       }
       int fact = 1;
       while (N > 1){
           fact *= N;
           System.out.println(fact);
           N--;
       }
      return Integer.parseInt(Integer.toString(fact).substring(0,1));
   }
}