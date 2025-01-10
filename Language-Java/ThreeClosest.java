import java.util.*;

public class ThreeClosest {
    public static void main(String[] args){
        int[] test = {-1,0,1,2,-1,-4, 6, 7};

        ArrayList<int[]> ans = threeClosestTwo(test, 11);
        //ArrayList<int[]> ans2 = threeClosestOne(test, 11);
        //ArrayList<int[]> ans = twoPointer(test, 0);
        for(int[] temp: ans){
            System.out.println(Arrays.toString(temp));
        }
    }

    public static ArrayList<int[]> threeClosestOne(int[] arr, int num){
        Arrays.sort(arr);
        int diff = Math.abs(num - (arr[0] + arr[1] + arr[2]));
        ArrayList<int[]> close = new ArrayList<>();

        for(int i = 0; i < arr.length-2; i ++){
            for(int j = i + 1; j < arr.length-1; j++){
                for(int k = j +1; k< arr.length; k++){
                    int temp = Math.abs(num - (arr[i] + arr[j] + arr[k]));
                    if(temp < diff){
                        close.clear();
                    }
                    if(temp <= diff){
                        int[] closeThree = {arr[i], arr[j], arr[k]};
                        close.add(closeThree);
                        diff = temp;
                    }
                }
            }
        }
        
        return close; 

    }

    public static ArrayList<int[]> threeClosestTwo(int[] arr, int num){
        Arrays.sort(arr);

        int diff = Integer.MAX_VALUE;
        ArrayList<int[]> close = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            if (i > 0 && arr[i-1] == arr[i]) continue;

            int a = i + 1;
            int b = arr.length - 1;
            while (a < b) {
                int temp = arr[i] + arr[a] + arr[b];
                int temp1 = Math.abs(num - temp);

                if (temp1 < diff) {
                    close.clear();
                    diff = temp1;
                }

                if (temp1 == diff) {
                    int[] closeThree = {arr[i], arr[a], arr[b]};
                    close.add(closeThree);
                }
    
                if (temp > num) {
                    int theValue = arr[b];
                    while (a < b && arr[b] == theValue) b --;
                }
                else{
                    int theValue = arr[a];
                    while (a < b && arr[a] == theValue) a ++;
                } 

            }

        }
        return close;

    }
}
