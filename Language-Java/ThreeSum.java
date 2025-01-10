import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] test = { -1, 0, 1, 2, -1, -4 };

        ArrayList<int[]> ans = threeSum(test, 0);
        for (int[] temp : ans) {
            System.out.println(Arrays.toString(temp));
        }
    }

    public static ArrayList<int[]> threeSum(int[] arr, int sum) {
        ArrayList<int[]> threesums = new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            if (i > 0 && arr[i - 1] == arr[i])
                continue;

            int diff = sum - arr[i];

            ArrayList<int[]> twoSums = twoSumWithDup(arr, diff, i + 1);
            for (int[] two : twoSums) {
                int[] three = { arr[i], two[0], two[1] };
                threesums.add(three);
            }
        }
        return threesums;
    }

    public static ArrayList<int[]> twoSumWithDup(int[] arr, int sum, int start) {
        ArrayList<int[]> sums = new ArrayList<>();

        int b = arr.length - 1;
        int a = start;
        while (a < b) {
            int com = arr[a] + arr[b];
            if (com == sum) {
                int[] temp = { arr[a], arr[b] };
                sums.add(temp);

                a++;
                int theValue = arr[a];
                while (a < b && arr[a] == theValue)
                    a++;

                b--;
                theValue = arr[b];
                while (a < b && arr[b] == theValue)
                    b--;
                    
            } else if (com > sum) {
                b--;
            } else {
                a++;
            }
        }
        return sums;
    }
}
