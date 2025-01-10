public class OuterClass {
    InnerClass c;

    public class InnerClass{

    }
    public static class StaticInnerClass{

    }

    public static void main(String[] args){
            OuterClass.StaticInnerClass c = new OuterClass.StaticInnerClass();
            
            OuterClass a = new OuterClass();
            OuterClass.InnerClass b = a.new InnerClass();

            OuterClass.InnerClass d = new OuterClass().new InnerClass(); 
    }
}
