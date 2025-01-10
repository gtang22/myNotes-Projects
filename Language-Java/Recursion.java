public class Recursion {
    public static void printNum(int n){
        if(n == 1){
            System.out.print("1 ");
        }
        else{
            printNum(n - 1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] agrs){
        printNum(5);
    }
}
