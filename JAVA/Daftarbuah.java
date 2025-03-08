import java.util.ArrayList;

public class DaftarBuah {
    public static void main(String[] args) {
        // Membuat ArrayList untuk menyimpan nama buah
        ArrayList<String> buah = new ArrayList<>();

        // Menambahkan buah ke dalam ArrayList
        buah.add("Apel");
        buah.add("Pisang");
        buah.add("Jeruk");
        buah.add("Mangga");
        buah.add("Anggur");

        // Menampilkan daftar buah
        System.out.println("Daftar Buah:");
        for (String b : buah) {
            System.out.println(b);
        }

        // Menghapus buah dari daftar
        buah.remove("Jeruk");
        System.out.println("\nSetelah menghapus Jeruk:");
        
        // Menampilkan daftar buah setelah penghapusan
        for (String b : buah) {
            System.out.println(b);
        }

        // Memeriksa apakah ada buah tertentu dalam daftar
        if (buah.contains("Mangga")) {
            System.out.println("\nDaftar masih mengandung Mangga.");
        } else {
            System.out.println("\nDaftar tidak mengandung Mangga.");
        }
    }
}