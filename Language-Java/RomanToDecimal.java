import java.util.*;
public class RomanToDecimal {
    //I, V, X, L, C, D, M
    public static void main(String[] args){
        System.out.println(intToRoman(99));
    }
    
    public static int romanToDecimal(String s){
        String tempS = s.toUpperCase();
        int ans = 0;
        Map<Character, Integer> romanNumbers = new HashMap<Character, Integer>(); 
        romanNumbers.put('I', 1);
        romanNumbers.put('V', 5);
        romanNumbers.put('X', 10);
        romanNumbers.put('L', 50);
        romanNumbers.put('C', 100);
        romanNumbers.put('D', 500);
        romanNumbers.put('M', 1000);

        for(int i = s.length()-1; i >= 0; i--){
            if(i < s.length() - 1){
                if(romanNumbers.get(tempS.charAt(i + 1)) > romanNumbers.get(tempS.charAt(i))){
                    ans = ans - romanNumbers.get(tempS.charAt(i));
                    continue;
                }

            }
                ans = ans + romanNumbers.get(tempS.charAt(i));
            
        }

        return ans;
    }

    public static String intToRoman(int n){
        int temp = n;
        String ans = "";
        int[] decimals = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int place = decimals.length - 1;

        while(temp != 0){
            if(temp - decimals[place] >= 0){
                ans = ans + roman[place];
                temp = temp - decimals[place];
            }
            else{
                place--;
            }
        }

        return ans;
    }
        
}
