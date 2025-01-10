import java.util.ArrayList;

public class MyGeneric {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
    
        myList.add("String");

        String s = myList.get(0);
    }

    public static void main1(String[] args) {
        ArrayList myList = new ArrayList();
    
        myList.add("String");

        String s = (String)myList.get(0);
    }
}
