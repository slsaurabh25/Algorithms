import java.util.Scanner;

public class Chair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        str = str.toLowerCase();
        char[] ch  = str.toCharArray();
        int baseValue = 96;
        int count = 0;
        for (int i=0;i<ch.length;i++) {
            int temp = (int)ch[i];
            if ((i+1)==(temp-baseValue)) {
                count++;
            }
        }

        System.out.print(count);

    }
}
