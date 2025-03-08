import math

def tampilkan_identitas():
    print("\n=== Identitas Mahasiswa ===")
    print("Nama: Satio Haryono Wibowo")
    print("NIM: 20240040111")
    print("Nomor Telepon: 085798197835")

def tipe_data():
    print("\n=== Jenis-Jenis Tipe Data dalam Python ===")
    print("1. Integer (int) -> Bilangan bulat, contoh: x = 10")
    print("2. Float (float) -> Bilangan desimal, contoh: y = 3.14")
    print("3. String (str) -> Kumpulan karakter, contoh: nama = 'John'")
    print("4. Boolean (bool) -> Nilai kebenaran, contoh: status = True")
    print("5. List -> Kumpulan data yang bisa diubah, contoh: angka = [1, 2, 3]")
    print("6. Tuple -> Kumpulan data yang tidak bisa diubah, contoh: koordinat = (4, 5)")
    print("7. Dictionary -> Kumpulan pasangan key-value, contoh: data = {'nama': 'Alice', 'umur': 25}")

def hitung_tiga_angka():
    angka1 = 5000
    angka2 = 2000
    angka3 = 200
    angka1 += 500
    angka2 += 500
    hasil = angka1 + angka2 - angka3
    print(f"\nHasil perhitungan (({angka1} + {angka2}) - {angka3}) = {hasil}")

def hitung_lingkaran_kubus():
    radius = float(input("\nMasukkan jari-jari lingkaran: "))
    keliling = 2 * math.pi * radius
    print(f"Keliling lingkaran: {keliling:.2f}")

    sisi = float(input("Masukkan panjang sisi kubus: "))
    volume = sisi ** 3
    print(f"Volume kubus: {volume:.2f}")

def main():
    while True:
        print("\n=== APLIKASI PYTHON ===")
        print("1. Tampilkan Identitas")
        print("2. Jenis-Jenis Tipe Data")
        print("3. Hitung Tiga Angka")
        print("4. Hitung Keliling Lingkaran dan Volume Kubus")
        print("5. Keluar")

        pilihan = input("Pilih menu (1-5): ")

        if pilihan == '1':
            tampilkan_identitas()
        elif pilihan == '2':
            tipe_data()
        elif pilihan == '3':
            hitung_tiga_angka()
        elif pilihan == '4':
            hitung_lingkaran_kubus()
        elif pilihan == '5':
            print("Terima kasih! Program selesai.")
            break
        else:
            print("Pilihan tidak valid. Silakan coba lagi.")

if __name__ == "__main__":
    main()

