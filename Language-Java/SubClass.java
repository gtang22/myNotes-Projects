public class SubClass extends MainClass{
    public void m1(){
        System.out.println("8");
    }

    public static void main(String[] args){
        MainClass x = new SubClass();

        ((MainClass)x).m1(); 
    }
}
