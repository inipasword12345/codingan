# Program Konversi ASCII <-> Biner
# By 24/7 Community


def tampilkan_menu():
    print("\n=== Konversi ASCII ↔ Biner ===")
    print("1. ASCII to Biner")
    print("2. Biner to ASCII")
    print("3. Exit")
    pilihan = input("Pilih Menu (1/2/3): ").strip()

    if pilihan == "1":
        ascii_to_biner()
    elif pilihan == "2":
        biner_to_ascii()
    elif pilihan == "3":
        print("Terima kasih! Program selesai.")
        exit()
    else:
        print("Pilihan tidak valid! Coba lagi.")
        tampilkan_menu()


# Fungsi ASCII to Biner
def ascii_to_biner():
    teks = input("Masukkan teks ASCII: ").strip()
    biner = " ".join(format(ord(char), "08b") for char in teks)
    print(f"Hasil biner: {biner}")
    tampilkan_menu()


# Fungsi Biner to ASCII
def biner_to_ascii():
    biner = input("Masukkan biner (pisahkan tiap byte dengan spasi): ").strip()
    try:
        ascii_teks = "".join(chr(int(byte, 2)) for byte in biner.split())
        print(f"Hasil ASCII: {ascii_teks}")
    except ValueError:
        print("Input biner tidak valid! Pastikan formatnya benar.")
    tampilkan_menu()


if __name__ == "__game__":
    main()