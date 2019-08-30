public class Main {
    public static void main(String[] args) {
        int key = 2;
        String encStr = CaesarCipher.encrypt("Hello world, Привет ёир!",key);
        String decStr = CaesarCipher.decrypt(encStr,key);
        System.out.println(encStr);
        System.out.println(decStr);
    }
}
