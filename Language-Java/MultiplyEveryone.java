import java.util.*;

public class MultiplyEveryone {
    public static void main(String[] arg) {
        int[] test = {4,2,3};
        System.out.println(Arrays.toString(mulitplyEveryone(test)));

    }
    // Method requirements:
    // can't use division
    // performance has to be O(n)

    // Answer: Multiply prefix product (not including self) by the suffix product
    // (not including self)
    public static int[] mulitplyEveryone(int[] arr) {

        if(arr.length == 1){
            return new int[]{1};
        }


        int[] prefix = new int[arr.length];
        int[] suffix = new int[arr.length];
        
        prefix[0] = 1;
        suffix[arr.length - 1] = 1;

        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] * arr[i - 1];
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * arr[i + 1];
        }

        int[] ans = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            ans[i] = prefix[i] * suffix[i];
        }

        return ans;
    }

    
}
