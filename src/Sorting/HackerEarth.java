package Sorting;

import java.io.*;
import java.util.*;


public class HackerEarth {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            int K = Integer.parseInt(br.readLine().trim());
            String[] arr_A = br.readLine().split(" ");
            long[] A = new long[N];
            for(int i_A = 0; i_A < arr_A.length; i_A++)
            {
                A[i_A] = Long.parseLong(arr_A[i_A]);
            }

            int out_ = solve(N, K, A);
            System.out.println(out_);

        }

        ArrayList arr = new ArrayList();
        arr.add("as");
        arr.add(Boolean.TRUE);
        arr.remove("true");
        arr.add(1, "asd");

        System.out.println(arr);

        LinkedList<String> exaple = new LinkedList<>();
        exaple.add("A");
        exaple.addLast("B");
        exaple.add("C");
        exaple.addFirst("D");
        exaple.add(0, "E");

        Iterator<String> itr = exaple.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        wr.close();
        br.close();


    }
    static int solve(int N, int K, long[] A){
        // Write your code here
        int result = 0;

        for(int i=1;i<N;i++) {
            A[i] += A[i-1];

            if(A[i] > K || A[i] < -1 * K)
                result++;
        }

        if(A[0] > K || A[0] < -1 * K)
            result++;

        Arrays.sort(A);

        for(int i=0;i<N;i++)
            result += N - upper_bound(A, 0, N, A[i]+K);

        return result;

    }

    static int upper_bound(long[] A, int low, int high, long element) {
        while(low < high) {
            int middle = low + (high - low)/2;
            if(A[middle] > element)
                high = middle;
            else
                low = middle +1;
        }
        return low;
    }
}