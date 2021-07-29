public class HackerEarth1
{
    public static void main(String[] args)
    {
        String regex = ".@.";
        HackerEarth1.compare("Hacker@Earth.com", regex);
        HackerEarth1.compare("a@N", regex);
        HackerEarth1.compare("Java@Program", regex);
    }
    public static void compare(String str, String regex)
    {
        if (str.matches(regex))
        {
            System.out.println(str + " matches");
        }
        else
        {
            System.out.println(str + " does not match");
        }
    }
}