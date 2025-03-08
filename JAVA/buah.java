public class Buah {
    private String nama;
    private String warna;
    private double berat;
    private double harga;

    public Buah(String nama, String warna, double berat, double harga) {
        this.nama = nama;
        this.warna = warna;
        this.berat = berat;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public String getWarna() {
        return warna;
    }

    public double getBerat() {
        return berat;
    }

    public double getHarga() {
        return harga;
    }

    @Override
    public String toString() {
        return nama + " " + warna + " " + berat + " " + harga;
    }

    public static void main(String[] args) {
        Buah apel = new Buah("Apel", "Merah", 150.0, 5000.0);
        System.out.println(apel);
    }
}

