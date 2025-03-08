import java.util.Random;
import java.util.Scanner;

public class GameArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Mengatur ukuran array
        System.out.print("Masukkan ukuran array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        // Mengisi array dengan angka acak
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100); // Angka acak antara 0-99
        }

        // Menampilkan array
        System.out.println("Array yang dihasilkan:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Menutup scanner
        scanner.close();
    }
}

