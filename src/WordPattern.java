import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba";

        String s = "dog cat dog dog";

        boolean ans = wordPattern(pattern, s);

        System.out.println("ans::"+ans);

    }

    public static boolean wordPattern(String pattern, String s) {

        char[] patternArray = pattern.toCharArray();
        String[] sArray = s.split(" ");

        System.out.println("patternArray::"+patternArray);
        System.out.println("sArray::"+sArray);

        Map<Character, String> map = new HashMap<>();

        if (patternArray.length != sArray.length) {
            return false;
        }

        for (int i=0;i< sArray.length;i++) {
            if (map.get(patternArray[i]) != null) {
               if (!sArray[i].equals(map.get(patternArray[i]))) {
                   return false;
               }
            } else {
                if (map.containsValue(sArray[i])) {
                    return false;
                }
                map.put(patternArray[i], sArray[i]);
            }
        }

        return true;
    }
}
