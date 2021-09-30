package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class IngredientsExample {

    public static void main(String[] args) {

        Integer number = null;
        String text = ""+ number;

        Scanner sc = new Scanner(System.in);

        do {
            long n = sc.nextLong();
            ArrayList<Long> required = new ArrayList<>();
            ArrayList<Long> provided = new ArrayList<>();

            ArrayList<Long> result = new ArrayList<>();

            for (long j=0; j<n; j++) {
                required.add(2L);
            }

            for (long j=0; j<n; j++) {
                provided.add(4L);
            }
            for (long j=0; j<n; j++) {
                if (required.get(Math.toIntExact(j))!=0) {
                    result.add(provided.get(Math.toIntExact(j))/required.get(Math.toIntExact(j)));
                } else {
                    result.add(Long.MAX_VALUE);
                }

            }

            long ans = 0;
            if (!result.isEmpty()) {
                ans = Collections.min(result);
            }

            System.out.println(ans);
        } while (true);

    }
}
