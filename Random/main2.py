# Membuat pola segitiga menggunakan karakter ASCII
def buat_segitiga_ascii(baris):
    for i in range(1, baris + 1):
        print(' ' * (baris - i) + '*' * (2 * i - 1))

# Meminta input dari pengguna
jumlah_baris = int(input("Masukkan jumlah baris: "))
buat_segitiga_ascii(jumlah_baris)
