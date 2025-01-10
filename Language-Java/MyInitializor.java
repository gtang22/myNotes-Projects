public class MyInitializor {
    private static int a;
    private static int b;
    private int c;
    private int d;

    static {
        a = 0;
        b = 1;
        System.out.println("static initailzor block");
    }

    {
        c = 0;
        d = 1;
        System.out.println("non-static initailzor block");
    }

    public MyInitializor() {
        c = 1;
        d = 2;
        System.out.println("constructor");
    }

    public static void main(String[] srgs) {
        MyInitializor m = new MyInitializor();

        MyInitializor m1 = new MyInitializor();
    }
}
