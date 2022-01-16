import java.util.Scanner;

/*

In how many ways, can you pay N rupees with 1 rupee, 2 rupee & 5 rupee denominations, in such a way that the number of 1 rupee coins are always greater than that of 2 rupee coins and number of 2 rupee coins are always greater than that of 5 rupee coins.

        Note: At least one coin should be given from each denomination.


        Input Format
        The only line of input consists of a single integer, N, the amount in rupees.


        Constraints
        1 <= N <= 100

        Output Format
        Print the number of ways in which you can pay the amount as described.

        Sample TestCase 1
        Input
        10
        Output
        0
        Explanation
        There is no way we can achieve this following the given conditions.

        Sample TestCase 2
        Input
        15
        Output
        2
        Explanation
        Possible ways in which you can pay 15 rupees are (1 5rs, 2 2rs, 6 1rs) and (1 5rs, 3 2rps, 4 1rps).
*/

public class CoinCombination {

    public static void main(String args[] ) {

        //Write code here
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        
        int result = countWaysToProduceGivenAmountOfMoney(amount);
        System.out.println(result);
    }

    public static int countWaysToProduceGivenAmountOfMoney(int amount) {

        int result = 0;
        for(int a = 0;a<=amount;a++){
            for(int b = 0;b<=amount/2;b++){
                for(int c = 0;c<=amount/5;c++){
                    if(a + 2*b + 5*c == amount){
                        //System.out.println("1 cents :"+a+", 5 cents:"+b+", 10 cents:"+c);
                        if (c>0 && a>b && b>c) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }
}
