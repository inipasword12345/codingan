import java.util.HashMap;
import java.util.Map;

public class Kamus {
    private Map<String, String> kamusInggrisKeIndonesia;
    private Map<String, String> kamusIndonesiaKeInggris;

    public Kamus() {
        kamusInggrisKeIndonesia = new HashMap<>();
        kamusIndonesiaKeInggris = new HashMap<>();
        initializeKamus();
    }

    private void initializeKamus() {
        // Contoh entri kamus
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
        System.out.println(kamus.cariInggrisKeIndonesia("hello")); // Output: halo
        System.out.println(kamus.cariIndonesiaKeInggris("dunia")); // Output: world
    }
}
