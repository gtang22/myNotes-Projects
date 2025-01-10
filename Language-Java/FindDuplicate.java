import java.util.*;

public class FindDuplicate {

    // uses index to correlate with values

    public static void main(String[] args) {
        //int[] test = { 1, 2, 2, 4, 5, 5, 7, 6, 7, 10 };
        int[] test2 = { 1, 2, 400};
        System.out.println(findSmallest(test2));

    }

    // find missing elements from 0 - n-1 from the array
    // uses another array (takes up more space)
    public static ArrayList<Integer> findMissing(int[] arr) {

        int[] temp = new int[arr.length];
        ArrayList<Integer> ans = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            temp[arr[i] - 1]++;
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    // space is smallest (only uses original array)
    // works by turning numbers into negatives, checks for indexes with positive
    // because
    // those are the numbers missing

    public static ArrayList<Integer> findMissingTwo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;
            arr[index] = Math.abs(arr[index]) * -1;
        }

        ArrayList<Integer> ans = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    // uses the smallest amount of space
    // finds the numbers that appear in the arry twice

    public static ArrayList<Integer> findDoubleDuplicates(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] < 0) {
                ans.add(Math.abs(arr[i]));
            } else {
                arr[index] = (arr[index]) * -1;
            }

        }

        return ans;

    }

    public static ArrayList<Integer> findOnceAppear(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;
            arr[index] = arr[index] * -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    // numbers are random, find the smallest positive number
    // ex: {2, 4, 6, 7, 8} ans: 1
    // ex: {1, 100} ans: 2

    public static int findSmallest(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= arr.length) {
                int index = Math.abs(arr[i]) - 1;
                arr[index] = Math.abs(arr[index]) * -1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }

        return arr.length + 1;
    }
}
