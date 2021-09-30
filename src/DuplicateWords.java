import java.util.*;

public class DuplicateWords {

    /*public static void main(String[] args) {
        String s = "Java is a programming language. Python is also a programming language. programming";
        s = s.toLowerCase();

        String[] arr=s.split(" ");

        List<String> duplicates = new ArrayList<>();
        HashSet<String> uniqueWords = new HashSet<>();

        for(String str : arr) {
            if(!uniqueWords.add(str)){
                duplicates.add(str);
            }
        }

        System.out.println(duplicates);

    }*/

    public static void main(String[] args) {
        String s = "Java is a programming language. Python is also a programming language. programming";
        s = s.toLowerCase();

        String[] arr=s.split(" ");

        List<String> words = Arrays.asList(arr);

        HashSet<String> uniqueWords = new HashSet<>(words);

        List<String> repeated = new ArrayList<>();

        for(String str: uniqueWords) {
            if (Collections.frequency(words, str)>1) {
                repeated.add(str);
            }
        }

        System.out.println(repeated);
    }
}
