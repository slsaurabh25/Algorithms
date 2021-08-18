import java.util.*;

/*Given a string(word), S, print the number of distinct words with or without meaning that can be formed with the letters of the given word.

        Note: Each word should start with a consonant.


        Input Format
        The only line of input consists of a string, S

        Constraints
        1<= |S| <=20

        Output Format
        Print the number of distinct words in a separate line.

        Sample TestCase 1
        Input
        CAT
        Output
        4
        Explanation
        CAT, CTA, TAC, TCA. (ACT, ATC are not valid words, as they start with vowel letter)

*/
public class DistinctWords {
    public static void main(String args[] ) {

        //Write code here
        Scanner sc = new Scanner(System.in);
        String str= sc.nextLine();

        int len = str.length();
        HashSet<String> allStrings=new HashSet<String>();

        generatePermutation(str, 0, len, allStrings);
        System.out.println(allStrings.size());
    }

    public static void generatePermutation(String str, int start, int end, Set<String> allStrings) {
        if (start == end-1 && isCons(str.charAt(0))) {
            allStrings.add(str);
        }
        else {
            for (int i = start; i < end; i++) {
                str = swapString(str,start,i);
                generatePermutation(str,start+1,end, allStrings);
                str = swapString(str,start,i);
            }
        }
    }

    public static String swapString(String a, int i, int j) {
        char[] b =a.toCharArray();
        char ch;
        ch = b[i];
        b[i] = b[j];
        b[j] = ch;
        return String.valueOf(b);
    }

    static boolean isCons(char ch) {
        return (ch != 'A' && ch != 'E' &&
                ch != 'I' && ch != 'O' &&
                ch != 'U');
    }

}
