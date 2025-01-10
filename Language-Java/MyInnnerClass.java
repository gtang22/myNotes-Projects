import java.util.HashMap;
import java.util.Map;

public class MyInnnerClass {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");

        // Entry is a static inner class for Map
        for (Map.Entry<String, String> e : map.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }
}
