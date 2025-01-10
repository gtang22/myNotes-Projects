

public class Palindrome {
    public static void main(String[] args) {
        String s = "dalad";
        System.out.println(removeOnePalin(s));
    }

    // only count letters (captalization doesn't matter) and numbers, ignore
    // everything else
    // add edge case (don't forget)
    public static boolean isPalin(String s) {
        int a = 0;
        int b = s.length() - 1;

        while (a < b) {

            while (a < b && !Character.isLetterOrDigit(s.charAt(a))) {
                a++;
            }

            while (a < b && !Character.isLetterOrDigit(s.charAt(b))) {
                b--;
            }

            if (s.charAt(a) != s.charAt(b)) {
                return false;
            }
            a++;
            b--;
        }

        return true;
    }

    public static int longestPalin(String s) {

        int length = 0;

        if (s.isEmpty()) {
            return length;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            int templength = palinFromMid(s, i, i);
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                templength = palinFromMid(s, i, i + 1);
            }
            length = Math.max(templength, length);
        }

        return length;

    }

    public static int palinFromMid(String s, int left, int right) {
        int a = left;
        int b = right;
        int length = 1 + right - left;

        while (a > 0 && b < s.length() - 1) {
            a--;
            b++;
            if (s.charAt(a) != s.charAt(b)) {
                return length;
            }
            length = length + 2;
        }

        return length;
    }

    public static boolean removeOnePalin(String s) {
        /*
         * for(int i = 0; i < s.length() - 1; i++){
         * String temp = s.substring(0, i) + s.substring(i + 1, s.length());
         * if(isPalin(temp) == true){
         * return true;
         * }
         * }
         * return false;
         */

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left ++;
            right --;
        }
        if (left >= right) return true;
        
        int left1 = left + 1;
        int right1 = right;
        while (left1 < right1) {
            if (s.charAt(left1) != s.charAt(right1)) {
                break;
            }
            left1 ++;
            right1 --;
        }
        if (left1 >= right1) return true;

        int left2 = left;
        int right2 = right - 1;
        while (left2 < right2) {
            if (s.charAt(left2) != s.charAt(right2)) {
                break;
            }
            left2 ++;
            right2 --;
        }
        if (left2 >= right2) return true;

        return false;

    }
}
