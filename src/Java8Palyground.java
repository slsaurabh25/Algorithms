import java.util.Objects;

public class Java8Palyground {
    public static void main(String[] args) {
        String s = "i love india";

        long s1 = s.chars().filter(a -> a == 'i').count();

        System.out.println(s1);

        Employee em1 = new Employee("10", "Saurabh");
        Employee em2 = new Employee("10", "Saurabh");
        System.out.println(em1.equals(em2));
        System.out.println("Hello World");

        Thread t = Thread.currentThread();
        System.out.println(t.getPriority());

    }

    static class Employee {
        String id;
        String name;

        public Employee(String id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return Objects.equals(id, employee.id) && Objects.equals(name, employee.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }
}
