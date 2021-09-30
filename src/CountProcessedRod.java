import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountProcessedRod {
    public static void main(String[] args) {
        Integer[] num = { 5,4,4,2,2,8 };

        List<Integer> numbers = Arrays.asList(num);

        List<Integer> output = new ArrayList<>();
        output.add(numbers.size());

        List<Integer> numbers2 = new ArrayList<>(numbers);

        do {

            List<Integer> numbers1 = new ArrayList<>();

            int min = Collections.min(numbers2);

            for (int i=0;i<numbers2.size();i++) {
                numbers1.add(numbers2.get(i) - min);
            }

            numbers2.clear();

            for (int i=0;i<numbers1.size();i++) {
                if (numbers1.get(i)>0) {
                    numbers2.add(numbers1.get(i));
                }
            }

            output.add(numbers2.size());
        } while (numbers2.size()>1);

        System.out.println(output);
    }
}
