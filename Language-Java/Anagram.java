import java.util.*;
public class Anagram {
    public static void main(String[] args){
        System.out.println(isAnagramThree("below", "elbow"));
    }
    //Longest operation time and space is biggest

    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> charCountS = new HashMap<Character, Integer>(); 
        Map<Character, Integer> charCountT = new HashMap<Character, Integer>(); 
        
        for(int i = 0; i < s.length(); i++){
            charCountS.put(s.charAt(i), charCountS.getOrDefault(s.charAt(i), 0) + 1);
            charCountT.put(t.charAt(i), charCountT.getOrDefault(t.charAt(i), 0) + 1);
        }

        if(!charCountS.equals(charCountT)){
            return false;
        }

        return true;
    }

    public static boolean isAnagramTwo(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        int[] charCountS = new int[256]; 
        int[] charCountT = new int[256]; 
        
        for(int i = 0; i < s.length(); i++){
            charCountS[s.charAt(i)]++;
            charCountT[t.charAt(i)]++;
           
        }

        if(!Arrays.equals(charCountS, charCountT)){
            return false;
        }

        return true;
    }
    //smallest operation time and space(space is negitable)
    public static boolean isAnagramThree(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        int[] charCountS = new int[256]; 
        
        for(int i = 0; i < s.length(); i++){
            charCountS[s.charAt(i)]++;
            charCountS[t.charAt(i)]--;
        }

        for (int i = 0; i < 256; i ++) {
            if (charCountS[i] != 0) return false;
        }

        return true;
    }
}
