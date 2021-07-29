
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int K = Integer.parseInt(line[1]);
            String[] arr_Capacity = br.readLine().split(" ");
            int[] Capacity = new int[K];
            for(int i_Capacity = 0; i_Capacity < arr_Capacity.length; i_Capacity++)
            {
                Capacity[i_Capacity] = Integer.parseInt(arr_Capacity[i_Capacity]);
            }
            String[] Preference = new String[N];
            for(int i_Preference = 0; i_Preference < N; i_Preference++)
            {
                Preference[i_Preference] = br.readLine();
            }

            String out_ = solve(N, K, Capacity, Preference);
            System.out.println(out_);

        }

        wr.close();
        br.close();
    }
    static String solve(int N, int K, int[] Capacity, String[] Preference){
        // Write your code here
        String result = "";

        int noOfCapacity = Arrays.stream(Capacity).sum();

        if (N > noOfCapacity) {
            return "NO";
        }

        HashMap<Integer, List<Integer>> students = new HashMap<>();

        for(int i=0;i<N;i++) {
            List<Integer> allPreferences = new ArrayList<>();
            int[] temp = Arrays.stream(Preference[i].split(",")).mapToInt(Integer::parseInt).toArray();

            allPreferences.addAll(Arrays.stream(temp).boxed().collect(Collectors.toList()));

            students.put(i+1, allPreferences);
        }

        int counter = 0;

        while(true) {

            counter++;
            List<Integer> allPreferences2 = new ArrayList<>();

            List<Integer> listStudents1 = new ArrayList<Integer>(students.keySet());
            for(int i=0; i<listStudents1.size();i++) {
                allPreferences2.addAll(students.get(listStudents1.get(i)));
            }

            Map<Integer, Long> counts = allPreferences2.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

            List<Integer> listCounts = new ArrayList<Integer>(counts.keySet());
            for (int i = 0; i<listCounts.size();i++) {
                int temp = listCounts.get(i);
                if(Capacity[temp-1] >= counts.get(temp)){

                    List<Integer> listStudents = new ArrayList<Integer>(students.keySet());
                    for(int j=0;j<listStudents.size();j++) {
                        List<Integer> temp2 = students.get(listStudents.get(j));
                        if(temp2.contains(temp)){
                            students.remove(listStudents.get(j));
                        }

                    }

                }
            }

            if(students.isEmpty()){
                return "YES";
            }

            if(counter == 10) {
                return "NO";
            }
        }

    }
}