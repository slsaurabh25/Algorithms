package Sorting;

import java.util.Scanner;

public class guess {
    static int number_of_clues;
    static GuessPojo[] word;


    static void checkParameter(String str)
    {
        boolean done = true;
        for (int i=0; i<number_of_clues; i++) {
            if (!word[i].isCorrect(str)) {
                done=false;
                break;
            }
        }

        if (done) {
            System.out.println(str);
        }

    }


    static void ghostProtocol(String str) {

        if (str.length()==4) {
            checkParameter(str);
            return;
        }

        for (int i=0; i<4; i++)
            ghostProtocol(str+((char)(i + 'A')));
    }

    public static void main(String []s) {

        Scanner input  = new Scanner(System.in);
        number_of_clues = input.nextInt();
        word = new GuessPojo[number_of_clues];
        System.out.flush();
        String clueword;
        int BULL;
        int COW;
        for(int i=0;i<number_of_clues;i++) {
            clueword = input.next();
            BULL = input.nextInt();
            COW = input.nextInt();
            word[i] = new GuessPojo(clueword, BULL, COW);
            System.out.flush();
        }

        ghostProtocol("");
    }
}

class GuessPojo {

    String str;
    int bulls;
    int cows;

    GuessPojo(String s, int b, int c) {
        str=s;
        bulls=b;
        cows=c;
    }

    boolean isCorrect(String str2) {
        int bulls2 = 0;
        int cows2 = 0;
        String str1 = str;

        for (int i=0; i<4; i++) {
            if (str1.charAt(i)==str2.charAt(i)) {
                bulls2++;
                str2 = deleteChar(str2,i);
                str1 = deleteChar(str1,i);
            }
        }

        for (int i=0; i<4; i++) {
            char ver = str1.charAt(i);
            int pos = str2.indexOf(ver);
            if (ver=='.')
                pos = -1;
            if (pos!=-1) {
                cows2++;
                str2 = deleteChar(str2,pos);
                str1 = deleteChar(str1,i);
            }
        }

        return ((bulls==bulls2)&&(cows==cows2));
    }


    String deleteChar(String str, int pos) {
        return (str.substring(0,pos)+"."+str.substring(pos+1));
    }
}