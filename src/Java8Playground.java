import java.util.*;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

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

        myList.stream()
                .filter(s -> s>9 && s<20)
                .forEach(System.out::println);

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

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = Arrays.stream(numbers).reduce(0, (a1, b) -> a1 + b);
        System.out.println(sum);

        int max2 = Arrays.stream(numbers).reduce(0, (a1, b) -> a1 > b ? a1 : b);  // 10
        int max1 = Arrays.stream(numbers).reduce(0, Integer::max);            // 10

        int min = Arrays.stream(numbers).reduce(0, (a1, b) -> a1 < b ? a1 : b);  // 0
        int min1 = Arrays.stream(numbers).reduce(0, Integer::min);

        class xyz {
            String storeNumber;
            Integer id;

            public xyz(final String storeNumber, final Integer id) {
                this.storeNumber = storeNumber;
                this.id = id;
            }
        }

        List<xyz> allStoreNumbers = new ArrayList<>();
        allStoreNumbers.add(new xyz("0123", 1));
        allStoreNumbers.add(new xyz("4234", 1));
        allStoreNumbers.add(new xyz("0001", 1));
        allStoreNumbers.add(new xyz("0012", 1));
        allStoreNumbers.add(new xyz("0013", 1));
        allStoreNumbers.add(new xyz("2343", 1));
        allStoreNumbers.add(new xyz("3454", 1));


        List<String> storeNumber = new ArrayList<>();
        storeNumber.add("123");
        storeNumber.add("4234");
        storeNumber.add("1");
        storeNumber.add("0011");

        List<String> storeNumbers = storeNumber.stream()
                .map(s -> StringUtils.leftPad(s, 4, "0"))
                .collect(Collectors.toList());

        List<xyz> storeNumberss = allStoreNumbers.stream()
                .filter(s-> storeNumbers.contains(s.storeNumber))
                .collect(Collectors.toList());

        System.out.println(storeNumberss);
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
