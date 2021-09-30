import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class MaxDuplicates {
    public static void main(String[] args) {
        String s = "Java is a programming language. Python is also a programming language. programming";

        s=s.toLowerCase();

        String[] arr = s.split(" ");
        List<String> words = Arrays.asList(arr);

        HashSet<String> uniqueWords = new HashSet<>(words);

        int max =0;
        String word="";
        for (String str:uniqueWords) {
            System.out.println(str+" : "+ Collections.frequency(words, str));
            if(Collections.frequency(words, str)>max) {
                max = Collections.frequency(words, str);
                word = str;
            }
        }

        System.out.println(word);

    }
}
