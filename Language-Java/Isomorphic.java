import java.util.*;

public class Isomorphic {
    public static void main(String[] arg){
        String s = "title";
        String t = "paper";
        System.out.println(isIsomorphicTwo(s, t));
    }
    
    public static boolean isIsomorphic(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        int[] scounts = new int[256];
        int[] tcounts = new int[256];

        for(int i = 0; i < s.length(); i++){
            scounts[s.charAt(i)]++;
            tcounts[t.charAt(i)]++;
            if(scounts[s.charAt(i)] != tcounts[t.charAt(i)]){
                return false;
            }
        }
        return true;
    }

    public static boolean isIsomorphicTwo(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        
        Map<Character, Integer> charCountS = new HashMap<Character, Integer>(); 
        Map<Character, Integer> charCountT = new HashMap<Character, Integer>(); 
        
        for(int i = 0; i < s.length(); i++){
            charCountS.put(s.charAt(i), charCountS.getOrDefault(s.charAt(i), 0) + 1);
            charCountT.put(t.charAt(i), charCountT.getOrDefault(t.charAt(i), 0) + 1);

            if(charCountS.get(s.charAt(i)) != charCountT.get(t.charAt(i))){
                return false;
            }
        }

        return true;

    }
}
