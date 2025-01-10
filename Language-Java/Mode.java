import java.util.*;

public class Mode {
    public static void main(String[] args) {
        int[] test = { 1, 4, 5, 5, 3, 5, 5, 2, 5, 6, 5 };
        System.out.println((modeHalf(test)));
    }

    public static int modeFunc(int[] arr) {
        Map<Integer, Integer> temp = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            temp.put(arr[i], temp.getOrDefault(arr[i], 0) + 1);
        }

        int ansValue = 0;
        int ans = 0;

        for (Map.Entry<Integer, Integer> e : temp.entrySet()) {
            if (e.getValue() > ansValue) {
                ansValue = e.getValue();
                ans = e.getKey();
            }
        }

        return ans;
    }

    public static int modeFuncValue(int[] arr) {
        Map<Integer, Integer> temp = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            temp.put(arr[i], temp.getOrDefault(arr[i], 0) + 1);
        }

        int ansValue = 0;

        for (Map.Entry<Integer, Integer> e : temp.entrySet()) {
            if (e.getValue() > ansValue) {
                ansValue = e.getValue();
            }
        }

        return ansValue;
    }

    public static int[] modeArray(int[] arr) {
        int mode = modeFunc(arr);

        int start = 0;
        while (arr[start] != mode)
            start++;

        int end = arr.length - 1;
        while (arr[end] != mode)
            end--;

        return Arrays.copyOfRange(arr, start, end);

    }

    // prompt: mode takes up more than half the array
    //Boyer - Moore Majority voting Algorithm 
    public static int modeHalf(int[] arr) {
        int count = 1, value = arr[0];

        for (int i = 0; i < arr.length - 1; i++) {
            if (count == 1 && arr[i + 1] != value) {
                value = arr[i + 1];
            } else {
                if (arr[i] == value) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        //Makes sure the mode actually occurs more than half of the array
        int occ = 0;

        for(int i = 0; i <arr.length; i++){
            if(value == arr[i]){
                occ++;
            }
        }

        return occ <= (arr.length/2) ? -1 : value;
    }
}
