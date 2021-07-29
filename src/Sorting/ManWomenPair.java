package Sorting;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ManWomenPair {

    public static void main(String []s) {

        int N;
        int number_of_clues;

        Scanner input  = new Scanner(System.in);
        N = input.nextInt();
        number_of_clues = input.nextInt();

        String isEqual;
        Integer women;
        Integer men;

        HashMap<Integer, List<Integer>> finalMap = new HashMap<>();

        for(int i=0;i<N;i++) {
            finalMap.put(i+1, IntStream.rangeClosed(1, N)
                    .boxed().collect(Collectors.toList()));
        }

        for(int i=0;i<number_of_clues;i++) {
            isEqual = input.next();
            women = input.nextInt();
            men = input.nextInt();

            if(isEqual.equals("=")) {
                for (final Map.Entry<Integer, List<Integer>> entry : finalMap.entrySet()) {
                    if (women.equals(entry.getKey())) {
                        List<Integer> tempArray = entry.getValue();
                        tempArray.clear();
                        tempArray.add(men);
                        finalMap.put(entry.getKey(), tempArray);
                    } else {
                        List<Integer> tempArray = entry.getValue();
                        tempArray.remove(men);
                        finalMap.put(entry.getKey(), tempArray);
                    }
                }
            } else if(isEqual.equals("#")) {
                List<Integer> tempArray = finalMap.get(women);
                tempArray.remove(men);
                finalMap.put(women, tempArray);
            }

        }

        for(int i=0;i<N;i++) {
            List<Integer> tempArray = finalMap.get(i+1);

            if(tempArray.size() == 1) {
                int tempVal = tempArray.get(0);

                for(int j=0;j<N;j++) {

                    if(i != j) {
                        List<Integer> tempArray1 = finalMap.get(j+1);
                        tempArray1.remove(new Integer(tempVal));
                    }
                }
            }
        }

        List<Integer> tempArray1 = new ArrayList<>();

        for(int i=0;i<N;i++) {
            List<Integer> tempArray = finalMap.get(i+1);
            tempArray1.add(tempArray.get(0));
        }

        String output = Arrays.toString(tempArray1.toArray()).replace(",", "").replace("[", "").replace("]", "");
        System.out.print(output);

    }

}
