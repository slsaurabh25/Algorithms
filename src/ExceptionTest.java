class ClassA {
    public static void method1(){
        System.out.println("parentclass method1");
    }
}

class ClassB extends ClassA {
    public static void method1(){
        System.out.println("subclass method1");
    }
}

public class ExceptionTest {
    public static void main(String[] args) {

        ClassB.method1();
        ClassA.method1();

        System.out.println(exceptionTest());

    }
    public static int exceptionTest()
    {
        int i=6;
        try{
            throw new NullPointerException();
        }
        catch(NullPointerException e)
        {
            i=10;
            throw e;
        }
        finally
        {
            i=20;
            System.out.println("In finally block");
            //return i;
        }
    }
}