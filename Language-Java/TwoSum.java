import java.util.*;

public class TwoSum {
    public static void main(String[] args) throws Exception {
        int[] arr = { -2, -2,-2, -4, -8,  0, -10, -10, -10, 12, 35 };
        // System.out.println(twoSumMax(arr));
        ArrayList<int[]> ans = twoSumWithDup(arr, -12);
        for(int[] temp: ans){
            System.out.println(Arrays.toString(temp));
        }

    }

    public static int[] twoSum(int[] arr, int sum) {
        /*
         * int max = arr[0];
         * 
         * for (int j = 0; j < arr.length - 1; j++) {
         * for (int i = j; i < arr.length - 1; i++) {
         * int temp = arr[i] + arr[i + 1];
         * if (temp > max) {
         * max = temp;
         * }
         * }
         * }
         */
        // Solved using Hashset

        Set<Integer> temp = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = sum - arr[i];
            if (temp.contains(diff)) {
                // found
                return new int[] { diff, arr[i] };
            } else {
                temp.add(arr[i]);
            }
        }
        return null;

    }

    public static ArrayList<int[]> twoSumWithDup(int[] arr, int sum) {
        ArrayList<int[]> sums = new ArrayList<>();

        Arrays.sort(arr);

        int b = arr.length - 1;
        int a = 0;
        while (a < b) {
            int com = arr[a] + arr[b];
            if (com == sum) {
                int[] temp = { arr[a], arr[b] };
                sums.add(temp);

                a ++;
                int theValue = arr[a];
                while (a < b && arr[a] == theValue)
                    a++;

                b--;
                theValue = arr[b];
                while (a < b && arr[b] == theValue)
                    b--;
                 
            } else if (com > sum) {
                b --;
            } else {
                a ++;
            }
        }
        return sums;
    }

}

// O(N^2)