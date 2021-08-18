import java.util.*;
import java.util.stream.Collectors;

public class Java8Playground {
    public static void main(String[] args) {
        int a =5;
        Time time = new Time("xyz", "ABC");
        method1(a, time);
        System.out.println(a);

        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32,10,15,8);

        //find even numbers
        List<Integer> output = myList.stream()
                .filter(n -> n%2==0)
                .collect(Collectors.toList());

        System.out.println(output);

        //numbers starts with 1
        List<Integer> output1 = myList.stream()
                .map(s->s + "")
                .filter(s->s.startsWith("1"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        System.out.println(output1);

        //duplicate numbers
        Set<Integer> set = new HashSet();
        List<Integer> output2 = myList.stream()
                .filter(n -> !set.add(n))
                .collect(Collectors.toList());

        System.out.println(output2);

        //count of numbers
        long count =  myList.stream()
                .count();
        System.out.println(count);

        //maximum number in list
        int max =  myList.stream()
                .max(Integer::compare)
                .get();
        System.out.println(max);

        String input = "Java Hungry Blog Alive is Awesome";

        List<String> list = Arrays.asList(input);

        list.stream()
                .filter(i->i.startsWith("a") && i.length() == 3)
                .collect(Collectors.toList());
    }

    private static void method1(int a, final Time time) {
        a = a+10;
        time.setEndTime("ASD");
    }

    static class Time {

        String StartTime;
        String EndTime;

        public String getStartTime() {
            return StartTime;
        }

        public void setStartTime(final String startTime) {
            StartTime = startTime;
        }

        public String getEndTime() {
            return EndTime;
        }

        public void setEndTime(final String endTime) {
            EndTime = endTime;
        }

        public Time(final String startTime, final String endTime) {
            StartTime = startTime;
            EndTime = endTime;
        }
    }
}
