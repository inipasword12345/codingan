import java.util.ArrayList;
import java.util.Scanner;

public class AplikasiBelanja {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> keranjangBelanja = new ArrayList<>();
        ArrayList<Double> hargaBelanja = new ArrayList<>();
        boolean selesai = false;

        System.out.println("===================================");
        System.out.println(        "  Selamat datang!");
        System.out.println("===================================");

        while (!selesai) {
            System.out.println("\n===================================");
            System.out.println("Pilih opsi:");
            System.out.println("1. Tambah barang ke keranjang");
            System.out.println("2. Lihat keranjang");
            System.out.println("3. Hapus barang dari keranjang");
            System.out.println("4. Selesai belanja");
            System.out.println("===================================");
            System.out.print("Masukkan pilihan Anda: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            switch (pilihan) {
                case 1:
                    boolean tambahLagi = true;
                    while (tambahLagi) {
                        System.out.print("Masukkan nama barang: ");
                        String barang = scanner.nextLine();
                        System.out.print("Masukkan harga barang: ");
                        double harga = scanner.nextDouble();
                        scanner.nextLine(); // Membersihkan newline
                        keranjangBelanja.add(barang);
                        hargaBelanja.add(harga);
                        System.out.println("\n===================================");
                        System.out.println(barang + " telah ditambahkan ke keranjang.");
                        System.out.println("===================================");
                        System.out.print("Apakah Anda ingin menambah barang lagi? (y/n): ");
                        String jawaban = scanner.nextLine();
                        if (!jawaban.equalsIgnoreCase("y")) {
                            tambahLagi = false;
                        }
                    }
                    break;
                case 2:
                    System.out.println("\n===================================");
                    System.out.println("Isi keranjang belanja:");
                    for (int i = 0; i < keranjangBelanja.size(); i++) {
                        System.out.println((i + 1) + ". " + keranjangBelanja.get(i) + " - Rp" + hargaBelanja.get(i));
                    }
                    System.out.println("===================================");
                    break;
                case 3:
                    System.out.print("Masukkan nomor barang yang ingin dihapus: ");
                    int nomorBarang = scanner.nextInt();
                    if (nomorBarang > 0 && nomorBarang <= keranjangBelanja.size()) {
                        String barangDihapus = keranjangBelanja.remove(nomorBarang - 1);
                        double hargaDihapus = hargaBelanja.remove(nomorBarang - 1);
                        System.out.println("\n===================================");
                        System.out.println(barangDihapus + " telah dihapus dari keranjang.");
                        System.out.println("===================================");
                    } else {
                        System.out.println("\n===================================");
                        System.out.println("Nomor barang tidak valid.");
                        System.out.println("===================================");
                    }
                    break;
                case 4:
                    selesai = true;
                    double totalHarga = 0;
                    for (double h : hargaBelanja) {
                        totalHarga += h;
                    }
                    System.out.println("\n===================================");
                    System.out.println("Terima kasih telah berbelanja!");
                    System.out.println("Total harga yang harus dibayar: Rp" + totalHarga);
                    System.out.println("===================================");
                    break;
                default:
                    System.out.println("\n===================================");
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    System.out.println("===================================");
            }
        }

        scanner.close();
    }
}