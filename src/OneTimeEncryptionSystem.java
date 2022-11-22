import java.util.Random;

public class OneTimeEncryptionSystem {
    private static int[] key;
    
    public static String encode(String s) {
        if (s.isEmpty())
            return "";

        key = new int[s.length()];
        Random random = new Random();
        for (int i = 0; i < s.length(); i++)
            key[i] = random.nextInt(26) + 1;


        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)) && Character.isUpperCase(s.charAt(i)))
                builder.append((char) ((s.charAt(i) - 'A' + key[i]) % 26 + 'A'));
            else if (Character.isLetter(s.charAt(i)) && Character.isLowerCase(s.charAt(i)))
                builder.append((char) ((s.charAt(i) - 'a' + key[i]) % 26 + 'a'));
            else
                builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    public static String decode(String s) {
        if (s.isEmpty())
            return "";

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)) && Character.isUpperCase(s.charAt(i)))
                if (s.charAt(i) - 'A' - key[i] < 0)
                    builder.append((char) ((s.charAt(i) - 'A' - key[i]) + 26 + 'A'));
                else
                    builder.append((char) ((s.charAt(i) - 'A' - key[i]) % 26 + 'A'));
            else if (Character.isLetter(s.charAt(i)) && Character.isLowerCase(s.charAt(i)))
                if (s.charAt(i) - 'a' - key[i] < 0)
                    builder.append((char) ((s.charAt(i) - 'a' - key[i]) + 26 + 'a'));
                else
                    builder.append((char) ((s.charAt(i) - 'a' - key[i]) % 26 + 'a'));
            else
                builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    public static int[] getKey() {
        return key;
    }
}
