import java.util.ArrayList;
import java.util.List;

public class Asach {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Ana");
        names.add("Mary");
        names.add("Anthony");
        names.add("Mark");

        List<String> names1 = new ArrayList<>();
        names1.add("John");
        names1.add("Ana");

        names.removeIf(names1::contains);

        System.out.println(names);

        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);

        List<Integer> ints1 = new ArrayList<>();
        ints1.add(1);
        ints1.add(2);

        ints.removeIf(ints1::contains);

        System.out.println(ints);

        //B1 a = new A1();
        //a.xyz();
    }


}

class A1 {
    public void xyz() {
        System.out.println("A1");
    }
}
class B1 extends A1 {
    public void xyz() {
        System.out.println("B1");
    }
}