import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Translator {
    private static Map<String, String> indonesianToEnglish = new HashMap<>();
    private static Map<String, String> englishToIndonesian = new HashMap<>();

    static {
        // Mengisi map indonesianToEnglish dengan kata-kata yang dapat diterjemahkan
        indonesianToEnglish.put("halo", "hello");
        indonesianToEnglish.put("selamat pagi", "good morning");
        indonesianToEnglish.put("selamat siang", "good afternoon");
        indonesianToEnglish.put("selamat malam", "good evening");
        // ... dan seterusnya

        // Membuat map englishToIndonesian dengan kata-kata yang dapat diterjemahkan
        for (Map.Entry<String, String> entry : indonesianToEnglish.entrySet()) {
            englishToIndonesian.put(entry.getValue(), entry.getKey());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan kata dalam bahasa Indonesia: ");
        String indonesianWord = scanner.nextLine();

        if (indonesianToEnglish.containsKey(indonesianWord)) {
            System.out.println("Terjemahan ke bahasa Inggris: " + indonesianToEnglish.get(indonesianWord));
        } else {
            System.out.println("Kata tidak ditemukan dalam daftar terjemahan.");
        }

        System.out.print("Masukkan kata dalam bahasa Inggris: ");
        String englishWord = scanner.nextLine();

        if (englishToIndonesian.containsKey(englishWord)) {
            System.out.println("Terjemahan ke bahasa Indonesia: " + englishToIndonesian.get(englishWord));
        } else {
            System.out.println("Kata tidak ditemukan dalam daftar terjemahan.");
        }
    }
}