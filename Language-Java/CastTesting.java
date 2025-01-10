public class CastTesting {
    public static void main(String[] args)
    {
        // Upcasting
        Parent p = new Child();
        p.name = "GeeksforGeeks";
 
        //Printing the parentclass name
        System.out.println(p.name);
        //parent class method is overriden method hence this will be executed
        p.method();

        p.method2();

        ((Parent)p).method();
        // cannot do p.method(2);
        // Trying to Downcasting Implicitly
        // Child c = new Parent(); - > compile time error
        ((Child)p).method3();

        p.specialMethod();
        // Downcasting Explicitly
        Child c = (Child)p;
 
        c.id = 1;
        System.out.println(c.name);
        System.out.println(c.id);

        c.method();

        c.method(2);
        
        ((Parent)c).method();
    }
}
// Java program to demonstrate
// Upcasting Vs Downcasting
 
// Parent class
class Parent {
    String name;
 
    // A method which prints the
    // signature of the parent class
    final void specialMethod(){
        System.out.println("Parent's special method");
    }

    void method()
    {
        System.out.println("Method from Parent");
    }

    void method2(){
        System.out.println("Still from Parent");
    }
}
 
// Child class
class Child extends Parent {
    int id;
 
    // Overriding the parent method
    // to print the signature of the
    // child class
    @Override void method()
    {
        System.out.println("Method from Child");
    }

    void method(int a)
    {
        System.out.println("Method from Child " + a);
    }

    void method3(){
        System.out.println("Child method 3");
    }
}
 
