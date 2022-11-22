import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = /*"Hello world"*/"ABCDz";
        System.out.println("Исходная строка: " + s);
        System.out.println("Зашифрованная строка: " + (s = OneTimeEncryptionSystem.encode(s)));
        System.out.println("Дешифрованная строка: " + (s = OneTimeEncryptionSystem.decode(s)));
        System.out.println(Arrays.toString(OneTimeEncryptionSystem.getKey()));
    }
}
