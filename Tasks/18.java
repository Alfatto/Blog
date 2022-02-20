import java.util.*;

public class Level1{

 public static boolean MisterRobot(int N, int[] data) {
        boolean possibleToArrange = false;

        ArrayList<Integer> data1 = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            data1.add(data[i]);
        }
        int index;
        int current;
        for (int i = 0; i < data.length - 3; i++) {
            index = data1.indexOf(1);
            if (index != 0 && index != 1) {
                data1.remove(index);
                while (index >= 0) {
                    index -= 2;
                }
                index -= 2;
                data1.add(index, 1);
            }
            index = data1.indexOf(1);
            if (index == 1) {
                current = data1.get(0);
                data1.set(0, data1.get(1));
                data1.set(1, data1.get(2));
                data1.set(2, current);
            }
            index = data1.indexOf(1);
            if (index == 0) {
                data1.remove(0);
                for (int j = 0; j < data1.size(); j++) {
                    data1.set(j, data1.get(j) - 1);
                }
            }
        }
        if (data1.get(0)==1&&data1.get(1)==2&&data1.get(2)==3){
            possibleToArrange=true;
        }
        if (data1.get(0)==2&&data1.get(1)==3&&data1.get(2)==1){
            possibleToArrange=true;
        }
        if (data1.get(0)==3&&data1.get(1)==1&&data1.get(2)==2){
            possibleToArrange=true;
        }
        return possibleToArrange;
    }

}