import java.util.*;

public class MoveZeros {
    public static void main(String[] args) throws Exception {

        int[] test = { 4, 1, 3, 4, 4, 5, 6, 4, 9, 0, 0, 11 };
        ArrayList<Integer> temp = new ArrayList<>();
        for (int num : test) {
            temp.add(num);
        }
        removeNumber(temp, 4);
        System.out.println(temp.toString());
    }

    public static void moveZero(int[] arr) {

        int slowPtr = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[slowPtr] = arr[i];
                slowPtr++;
            }
        }

        for (int i = slowPtr; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    public static void removeNumber(ArrayList<Integer> arr, int num) {
        // two pointer
        int slowPtr = 0;

        for (int fastPtr = 0; fastPtr < arr.size(); fastPtr++) {
            if (arr.get(fastPtr) != num) {
                arr.set(slowPtr, arr.get(fastPtr));
                slowPtr++;
            }
        }

        for (int i = slowPtr; i < arr.size(); i++) {
            arr.set(i, 0);
        }
    }

    public static int[] moveZeroTwo(int[] arr) {
        int a = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[a] = arr[i];
                a++;
            }
        }

        while (a < arr.length) {
            arr[a] = 0;
            a++;
        }

        return arr;
    }
}
