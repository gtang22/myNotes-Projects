public class PrefixSum {
    public static int[] sumArray;
    public static int[][] sum2D;

    public static void main(String[] args) {

        //int[] test = { 1, 3, 6, 2, 5, 1 };
        //PrefixSum temp = new PrefixSum(test);

        // System.out.println(temp.rangeSum(0, 30));

        int[][] test2 = { { 1, 2, 3, 4, 5 }, { 4, 3, 2, 1, 5 }, { 5, 3, 4, 1, 2 } };
        PrefixSum temp2 = new PrefixSum(test2);

        System.out.println(temp2.rangeSum(0, 2, 1, 4));

    }

    public PrefixSum(int[] arr) {
        sumArray = new int[arr.length];
        sumArray[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sumArray[i] = sumArray[i - 1] + arr[i];
        }

    }

    public PrefixSum(int[][] arr) {
        sum2D = new int[arr.length][arr[0].length];

        sum2D[0][0] = arr[0][0];

        // first column
        for (int i = 1; i < arr.length; i++) {
            sum2D[i][0] = sum2D[i - 1][0] + arr[i][0];
        }
        // first row
        for (int i = 1; i < arr[0].length; i++) {
            sum2D[0][i] = sum2D[0][i - 1] + arr[0][i];
        }
        // the rest elements
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                 sum2D[i][j] = sum2D[i - 1][j] + sum2D[i][j - 1] - sum2D[i-1][j-1] + arr[i][j];
            }
        }

    }

    // range sum from index i to j
    // numbers in array are random
    // inclusive of i, exclusive of j
    // O(1) due to the creation of the sumArray with the constructor

    public int rangeSum(int i, int j) {
        j = Math.min(sumArray.length, j);

        return i == 0 ? sumArray[j - 1] : sumArray[j - 1] - sumArray[i - 1];
    }

    // both (i, j)s are inclusive
    public int rangeSum(int i1, int j1, int i2, int j2) {
        j1 = Math.min(sum2D[0].length, Math.max(0, Math.min(j1, j2)));
        j2 = Math.min(sum2D[0].length, Math.max(0, Math.max(j1,j2)));
        i1 = Math.max(0, Math.min(sum2D.length, Math.min(i1, i2)));
        i2 = Math.max(0, Math.min(sum2D.length, Math.max(i1, i2)));
       
        if(i1 == 0 && j1 == 0){
            return sum2D[i2][j2];
        }

        if(i1 == 0){
            return sum2D[i2][j2] - sum2D[i2][j1-1];
        }
        if(j1 == 0){
            return sum2D[i2][j2] - sum2D[i1-1][j2];
        }
       
        return sum2D[i2][j2] - sum2D[i1-1][j2] - sum2D[i2][j1-1] + sum2D[i1][j1];

    }
}
