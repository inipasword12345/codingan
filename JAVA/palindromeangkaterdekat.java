import java.util.Scanner;

public class palindromeangkaterdekat {

    // Method untuk memeriksa apakah sebuah angka adalah palindrome
    public static boolean isPalindrome(int number) {
        String str = Integer.toString(number);
        String reversedStr = new StringBuilder(str).reverse().toString();
        return str.equals(reversedStr);
    }

    // Method untuk menemukan palindrome berikutnya
    public static int nextPalindrome(int number) {
        int nextNumber = number + 1; // Mulai dari angka setelah input
        while (!isPalindrome(nextNumber)) {
            nextNumber++;
        }
        return nextNumber;
    }

    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Masukkan angka: ");
            int input = scanner.nextInt();
            
            int result = nextPalindrome(input);
            
            System.out.println("Bilangan palindrome terdekat selanjutnya dari: " + result);
        }
    }
}