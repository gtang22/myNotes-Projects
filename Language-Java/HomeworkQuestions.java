import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class HomeworkQuestions{
    // Homework 9
    public static Integer firstUniqueElementMethod(Iterator<Integer> elts) {
        Map<Integer, Integer> map = new LinkedHashMap<>();

        while (elts.hasNext()) {
            Integer i = elts.next();
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Integer firstFound = null;

        for (Map.Entry<Integer, Integer> e: map.entrySet()) {
            if (e.getValue() == 1) {
                firstFound = e.getKey();
                break;
            }
        }

        return firstFound;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(1);
        arr.add(3);
        arr.add(12);

        System.out.println(firstUniqueElementMethod(arr.iterator()));

        String s = "he said: \"we are human.\"";
        System.out.print("Hello, world.\n");
    }

    // Homework 8
    /* 2.)
     * public static void main(String[] args) {
     *      Scanner scanner = new Scanner(System.in);
     *      FileReader filereader;
     *      BufferedReader br;
     *      
     *      while (true) {
     *      String filename = scanner.next();
     *      try {
     *          filereader = new FileReader(new File(filename));
     *          br = new BufferedReader(filereader);
     *          String st = "";
     *          int lineCount = 0, charCount = 0;
     *          while ((st = br.readLine()) != null) {
     *              lineCount++;
     *              charCount += st.length() + 1;
     *          }
     * 
     *          System.out.println(lineCount);
     *          break;
     *      } catch (Exception e) {
     *          System.out.println ("Please input existing file");
     *      } finally {
     *          if (br != null) {
     *              br.close();
     *          }
     *      }  
     *      }
     * }
     * 
     * 
     * 
     * 
     * 3.)
     * public int largest() {
     *       int max = arr[numElts-1];
     *       int parentIndex = (numElts - 1)/2;
     *        for (int i =  numeElts - 2; i > parentIndex; i--) {
     *              max = Math.max(arr[i], max);
     *        }
     *        return max;
     * }
     * 
     * 
     */

     // Homework 6
     // 1.)

     // In NonEmptyList Class
     public static int max() throws ListIsEmptyException {
        int max; 

        try {
            max = next.max();
        } catch (Exception e) {
            return data;
        }

        return Math.max(data, max);
     }
     // In EmptyList Class
     public static int max() throws ListIsEmptyException {
        throw new ListIsEmptyException();
     }
    
     // 2.)

     public class Stack {
        Integer[] array;
        int numOfElts;

        public Stack(int size) {
            array = new Integer[Math.max(size, 10)]; 
            numOfElts = 0;
        }

        public boolean isEmpty() {
            return numOfElts == 0;
        }

        public Integer top() {
            if (isEmpty()) {
                return null;
            }
            return array[numOfElts];
        }

        public void pop() {
            if (numOfElts > 0) {
                numOfElts--;
            }
        }

        public void push(Integer item) {
            if (numOfElts < array.length) {
                array[numOfElts] = item;
                numOfElts++;
            }

        }
     }

     // Homework 5
     // 2.)
    public int sumNumbersBetween(int m, int n) {
        if (m >= n) {
            return 0;
        }
        return m + sumNumbersBetween(m + 1, n);
    }

    // 3.)
    public boolean palindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }

        return palindromeHelper(s, 0, s.length() - 1);
    }

    public boolean palindromeHelper(String s, int index1, int index2) {
        if (index1 >= index2) {
            return true;
        }
        if (s.charAt(index1) != s.charAt(index2)) {
            return false;
        }

        return palindromeHelper(s, index1 + 1, index2 - 1);
    }

    // 4.)
    public String repeat(char ch, int n) {
        if (n >= 0) {
            return "";
        }

        return ch + "" + repeat(ch, n - 1);
    }

    // 5.)
    public void copy(int[] from, int[] to) {
        if (from != null && to != null) {
            copyHelper(from, to, 0);
        }
    }

    public void copyHelper(int[] from, int[] to, int n) {
        if ( n < to.length && n < from.length) {
            to[n] = from[n];
            copyHelper(from, to, n + 1);
        }
    }
    // 6.)
    public int sum2DArr(int[][] arr) {
        return sum2DArrHelperOne(arr, 0);
    }

    public int sum2DArrHelperOne(int[][] arr, int n) {
        if (n >= arr.length) {
            return 0;
        }
        return sum2DArrHelperTwo(arr[n], 0) +  sum2DArrHelperOne(arr, n + 1);
    }

    public int sum2DArrHelperTwo(int[] arr, int n) {
        if (n >= arr.length) {
            return 0;
        }
        return arr[n] + sum2DArrHelperTwo(arr, n + 1);
    }

    // 7.)

    public static int findMax(int[] arr) throws NoSuchElementException{
        if (arr == null || arr.length == 0) {
            throw new NoSuchElementException();
        }

        return findMaxHelper(arr, 0);
    }

    public static int findMaxHelper(int[] arr, int n) {
        if (n >= arr.length - 1) {
            return arr[n];
        }

        return Math.max(arr[n], findMaxHelper(arr, n + 1));
    }

    // insert Polymorphic Lists
    // EmptyList

    public NonEmptyList insert(int value) {
        return new NonEmptyList(value, this);
    }

    // NonEmptyList

    public NonEmptyList insert(int value) {
        if (data > value) {
            return new NonEmptyList(value, this);
        }

        next = next.insert(value);
        return this;
    }
}
