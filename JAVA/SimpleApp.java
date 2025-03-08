import java.util.Scanner;

public class SimpleApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Aplikasi Sederhana ===");
        System.out.println("Pilih opsi:");
        System.out.println("1. Tambah");
        System.out.println("2. Kurang");
        System.out.println("3. Kali");
        System.out.println("4. Bagi");

        int choice = scanner.nextInt();
        System.out.print("Masukkan angka pertama: ");
        double num1 = scanner.nextDouble();
        System.out.print("Masukkan angka kedua: ");
        double num2 = scanner.nextDouble();
        double result;

        switch (choice) {
            case 1:
                result = num1 + num2;
                System.out.printf("Hasil: %.2f + %.2f = %.2f%n", num1, num2, result);
                break;
            case 2:
                result = num1 - num2;
                System.out.printf("Hasil: %.2f - %.2f = %.2f%n", num1, num2, result);
                break;
            case 3:
                result = num1 * num2;
                System.out.printf("Hasil: %.2f * %.2f = %.2f%n", num1, num2, result);
                break;
            case 4:
                if (num2 != 0) {
                    result = num1 / num2;
                    System.out.printf("Hasil: %.2f / %.2f = %.2f%n", num1, num2, result);
                } else {
                    System.out.println("Error! Pembagian dengan nol.");
                }
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
        scanner.close();
    }
}
