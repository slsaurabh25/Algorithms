/*
 * Enter your code here. Read input from STDIN. Print your output to STDOUT.
 * Your class should be named CandidateCode.
 */

import java.io.*;
import java.util.*;
public class CandidateCode {
    public static void main(String args[] ) throws Exception {

        //Write code here
        Scanner sc = new Scanner(System.in);

        int result = 0;

        int nBira = sc.nextInt();
        int nPeople = sc.nextInt();

        ArrayList<Integer> weightBira = new ArrayList<>();
        ArrayList<Integer> weightPeople = new ArrayList<>();

        for(int i=0;i<nBira;i++) {
            weightBira.add(sc.nextInt());
        }
        for(int i=0;i<nPeople;i++) {
            weightPeople.add(sc.nextInt());
        }

        /*ArrayList<Integer> weightBira1 = new ArrayList<>();
        Collections.copy(weightBira1, weightBira);

        ArrayList<Integer> weightPeople1 = new ArrayList<>();
        Collections.copy(weightPeople1, weightPeople);*/

        Collections.sort(weightBira, Collections.reverseOrder());
        Collections.sort(weightPeople, Collections.reverseOrder());

        while(!weightBira.isEmpty()) {
            int i = 0;
            int j = 0;
            result = result + 1;

            while(j<nPeople && i<weightBira.size()) {
                int x = weightBira.get(i);
                int y = weightPeople.get(j);
                if(x<=y){
                    weightBira.remove(i);
                    i = 0;
                    j++;
                } else {
                    i++;
                }
            }

            result = result + 1;
        }

        System.out.print(result-1);
    }
}
