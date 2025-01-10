public class BinaryAdd {
    public static void main(String[] arg){
        System.out.println(binaryAdd1("10111", "1"));
    }
    public static String binaryAdd(String s, String t){
        int decimalS = Integer.parseInt(s, 2);
        int decimalT = Integer.parseInt(t, 2);

        int ans = decimalS + decimalT;

        return Integer.toBinaryString(ans);

    }

    //Can't turn into Integer first
    public static String binaryAddTwo(String s, String t){
        
       while(s.length() != t.length()){
            if(s.length() > t.length()){
                t = "0" + t;
            }
            else{
                s = "0" + s;
            }
       }

       String ans = "";
       int count = 0;

       for(int i = s.length()-1; i >= 0; i --){
            if(s.charAt(i) == '0' && t.charAt(i) == '1' || t.charAt(i) == '0' && s.charAt(i) == '1'  ){
                if(count > 0){
                    ans = "0" + ans;
                }
                else{
                    ans = "1" + ans;
                }
            }
            else if(s.charAt(i) == '0' && t.charAt(i) == '0'){
                if(count > 0){
                    ans = "1" + ans;
                    count = 0;
                }
                else{
                    ans = "0" + ans;
                }
            }
            else{
                if(count > 0){
                    ans = "1" + ans;
                }
                else{
                    ans = "0" + ans;
                    count = 1;
                }
            }

       }

       if(count > 0){
        ans = "1" + ans;
       }
       
      return ans;

    }

    //used an array (Polished ver.)

    public static String binaryAdd1(String s, String t){
        String lStr = s.length() > t.length() ? s : t;
        String sStr = s.length() > t.length() ? t : s;

       char[] ans = new char[lStr.length()];

       int flag = 0;
        int j = sStr.length() - 1;
       for(int i = lStr.length() - 1; i >= 0; i --, j --){
        //char to int (if don't understand, refer to ACSII)
            int tempS = lStr.charAt(i) - '0';
            int tempT = j >= 0 ? sStr.charAt(j) - '0' : 0;
            int tempAdd = tempS + tempT + flag;

            if (tempAdd >= 2) {
                flag = 1;
                tempAdd -= 2;
            } else {
                flag = 0;
            }
            //int to char
            ans[i] = (char)(tempAdd + '0');
       }

       String realAns = new String(ans);
       
       //Note: 
       return flag > 0 ? "1" + realAns : realAns;
    }
    

    public static String binaryAddArray(String s, String t){
        
        while(s.length() != t.length()){
            if(s.length() > t.length()){
                t = "0" + t;
            }
            else{
                s = "0" + s;
            }
        }
        
        Character[] tempS = new Character[s.length()];
        Character[] tempT = new Character[t.length()];

       for(int i = 0; i < s.length(); i++){
            tempS[i] = s.charAt(i);
            tempT[i] = t.charAt(i);
       }

       char[] ans = new char[s.length()];

       int flag = 0;

       for(int i = ans.length - 1; i >= 0; i --){
            if(tempS[i] == '0' && tempT[i] == '1' || tempT[i] == '0' && tempS[i] == '1'  ){
                if(flag > 0){
                    //ans = "0" + ans;
                    ans[i] = '0';
                }
                else{
                    //ans = "1" + ans;
                    ans[i] = '1';
                }
            }
            else if(tempS[i] == '0' && tempT[i] == '0'){
                if(flag > 0){
                    //ans = "1" + ans;
                    ans[i] = '1';
                    flag = 0;
                }
                else{
                    //ans = "0" + ans;
                    ans[i] = '0';
                }
            }
            else{
                if(flag > 0){
                    //ans = "1" + ans;
                    ans[i] = '1';
                }
                else{
                    //ans = "0" + ans;
                    ans[i] = '0';
                    flag = 1;
                }
            }

       }

       String realAns = new String(ans);

       if(flag > 0){
        realAns = "1" + realAns;
       }
       
      return realAns;


    }
}
