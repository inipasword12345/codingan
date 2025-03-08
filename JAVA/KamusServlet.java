import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Kamus {
    private Map<String, String> kamusInggrisKeIndonesia;
    private Map<String, String> kamusIndonesiaKeInggris;

    public Kamus() {
        kamusInggrisKeIndonesia = new HashMap<>();
        kamusIndonesiaKeInggris = new HashMap<>();
        initializeKamus();
    }

    private void initializeKamus() {
        kamusInggrisKeIndonesia.put("hello", "halo");
        kamusInggrisKeIndonesia.put("world", "dunia");
        kamusIndonesiaKeInggris.put("halo", "hello");
        kamusIndonesiaKeInggris.put("dunia", "world");
    }

    public String cariInggrisKeIndonesia(String kata) {
        return kamusInggrisKeIndonesia.getOrDefault(kata, "Kata tidak ditemukan");
    }

    public String cariIndonesiaKeInggris(String kata) {
        return kamusIndonesiaKeInggris.getOrDefault(kata, "Kata tidak ditemukan");
    }

    public static void main(String[] args) {
        Kamus kamus = new Kamus();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan kata dalam Bahasa Indonesia atau Inggris:");
        String kata = scanner.nextLine().toLowerCase();

        System.out.println("Pilih bahasa tujuan (1 untuk Inggris, 2 untuk Indonesia):");
        int pilihan = scanner.nextInt();

        if (pilihan == 1) {
            System.out.println("Terjemahan ke Bahasa Inggris: " + kamus.cariIndonesiaKeInggris(kata));
        } else if (pilihan == 2) {
            System.out.println("Terjemahan ke Bahasa Indonesia: " + kamus.cariInggrisKeIndonesia(kata));
        } else {
            System.out.println("Pilihan tidak valid");
        }

        scanner.close();
    }
}

