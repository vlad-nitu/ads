package commons;

public class Palindrome {

    public static boolean isPalindrome (String s) {
        if (s == null)
            return false;
         String reversed = reverse(s);
        return (s.equals(reversed));
    }

    private static String reverse(String s) {
        StringBuilder builder = new StringBuilder();
        builder.append(s);
        return builder.reverse().toString();
    }

}
