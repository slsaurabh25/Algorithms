package Sorting;

import java.util.*;

public class ArrayJourney {

    public static void main(String[] args) {
        List<Integer> path = new ArrayList<>();
        path.add(10);
        path.add(2);
        path.add(-10);
        path.add(5);
        path.add(20);

        int maxStep = 2;

        long ans = journey(path, maxStep);

        System.out.println("Ans::" + ans);
    }

    private static long journey(final List<Integer> path, final int maxStep) {

        if (path.isEmpty()) {
            return 0;
        }

        List<Long> output = new ArrayList<>();

        output.add(Long.valueOf(path.get(0)));

        for(int i=1;i<path.size();i++) {
            output.add(path.get(i) + maximum(i, output, maxStep));
        }
        System.out.println("output::"+output.toString());
        return output.get(output.size()-1);
    }

    private static Long maximum(final int i, final List<Long> output, final int maxStep) {
        List<Long> temp = new ArrayList<>();
        try {
            for (int j=1;j<=maxStep;j++) {
                if(null != output.get(i-j))
                    temp.add( output.get(i-j));
            }
        } catch (Exception ex) {
        }
        System.out.println("temp::"+temp.toString());
        return Collections.max(temp);
    }

}

