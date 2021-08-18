import java.util.*;

public class OneITTest {

    public static Double addValues (Double[] values) {
        // return the total
        double result = 0;
        for(Double value:values) {
            if(value!=null){
                result += value;
            } else {
                return null;
            }
        }
        return result;
    }

    public static String getUserName (String firstName, String lastName) {
        // return the user name as LastName, FirstName e.g. Smith, John
        if(lastName !=null) {
            return capitaliseFirstLetter(lastName) + ", " + capitaliseFirstLetter(firstName);
        } else {
            return capitaliseFirstLetter(firstName);
        }
    }


    public static String capitaliseFirstLetter (String s) {
        if (s == null || s.length() < 1) {
            return s;
        }

        char[] chars = s.toCharArray();

        chars[0] = Character.toUpperCase(chars[0]);

        return String.valueOf(chars);
    }
}
