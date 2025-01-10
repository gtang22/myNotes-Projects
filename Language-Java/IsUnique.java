public class IsUnique {
    public static void main(String[] args){
        String s = "english";
        System.out.println(isUnique(s));
    }

    public static boolean isUnique(String s){
        int[] charCount = new int[256];

        for(int i = 0; i < s.length(); i++){
            charCount[s.charAt(i)]++;
            if(charCount[s.charAt(i)] > 1){
                return false;
            }
        }
        return true; 
    }
}
