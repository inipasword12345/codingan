import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataKaryawan1 {

    private static final Map<String, Integer> dataKaryawan = new HashMap<>();
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        tampilkanMenu();
    }

    private static void tampilkanMenu() {
        System.out.println("======================================");
        System.out.println("          Menu Data Karyawan          ");
        System.out.println("======================================");

        System.out.println("1. Tambah Data Karyawan");
        System.out.println("2. Hapus Data Karyawan");
        System.out.println("3. Tampilkan Data Karyawan");
        System.out.println("4. Hitung Total Gaji Karyawan");
        System.out.println("5. Keluar");

        System.out.print("Pilih menu: ");
        int pilihan = input.nextInt();

        switch (pilihan) {
            case 1:
                tambahDataKaryawan();
                break;
            case 2:
                hapusDataKaryawan();
                break;
            case 3:
                tampilkanDataKaryawan();
                break;
            case 4:
                hitungTotalGajiKaryawan();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Menu tidak tersedia");
        }
    }

    private static void tambahDataKaryawan() {
        while (true) {
            System.out.print("Masukkan nama karyawan (ketik 'selesai' jika sudah selesai): ");
            String nama = input.next();

            if (nama.equalsIgnoreCase("selesai")) {
                break;
            }

            System.out.print("Masukkan gaji karyawan: ");
            int gaji = input.nextInt();

            dataKaryawan.put(nama, gaji);
        }
    }

    private static void hapusDataKaryawan() {
        System.out.print("Masukkan nama karyawan yang ingin dihapus: ");
        String namaKaryawan = input.next();

        if (dataKaryawan.containsKey(namaKaryawan)) {
            dataKaryawan.remove(namaKaryawan);
        } else {
            System.out.println("Nama karyawan tidak ditemukan");
        }
    }

    private static void tampilkanDataKaryawan() {
        System.out.println("======================================");
        System.out.println("          Data Karyawan          ");
        System.out.println("======================================");

        for (Map.Entry<String, Integer> entry : dataKaryawan.entrySet()) {
            System.out.println("Nama: " + entry.getKey() + ", Gaji: " + entry.getValue());
        }
    }

    private static void hitungTotalGajiKaryawan() {
        int totalGaji = 0;
        for (Integer gaji : dataKaryawan.values()) {
            totalGaji += gaji;
        }
        System.out.println("Total gaji karyawan: " + totalGaji);
    }
}