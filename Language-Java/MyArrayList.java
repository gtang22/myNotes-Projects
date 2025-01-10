import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArrayList {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(1);

        removeAll(arr, 1);

        System.out.println(Arrays.toString(arr.toArray()));
    }

    public static void removeAll(List<Integer> arr, int remove) {
        List<Integer> temp = new ArrayList<>();

        for(int i: arr){
            if(i != remove){
                temp.add(i);
            }
        }

       arr.clear();

       for(int i : temp){
            arr.add(i);
       }
    }
}
