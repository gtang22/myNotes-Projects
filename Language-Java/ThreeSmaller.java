import java.util.*;

public class ThreeSmaller {
    public static void main(String[] args) {
        int[] test = { -1, 0, 1, 2, -4, 6, 7 };

        ArrayList<int[]> ans = threeSmaller(test, 0);
        // ArrayList<int[]> ans2 = threeClosestOne(test, 11);
        // ArrayList<int[]> ans = twoPointer(test, 0);
        for (int[] temp : ans) {
            System.out.println(Arrays.toString(temp));
        }
    }

    public static ArrayList<int[]> threeSmaller(int[] arr, int num) {
        Arrays.sort(arr);

        ArrayList<int[]> close = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            // if (i > 0 && arr[i-1] == arr[i]) continue;

            int a = i + 1;
            int b = arr.length - 1;
            while (a < b) {
                int temp = arr[i] + arr[a] + arr[b];

                if (temp < num) {
                    for (int j = a+1; j <= b; j++) {
                        int[] threeVar = { arr[i], arr[a], arr[j] };
                        close.add(threeVar);
                    }
                    a++;

                } else {
                    b--;
                }
            }

        }
        return close;

    }
}
