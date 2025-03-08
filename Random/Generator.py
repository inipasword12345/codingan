import itertools
import string

def load_common_pins():
    # Daftar PIN umum (bisa diperluas)
    return [
        "1234", "0000", "1111", "2222", "3333",
        "4444", "5555", "6666", "7777", "8888",
        "9999", "12345", "54321", "112233", "98765"
    ]

def brute_force_pin(target_pin):
    common_pins = load_common_pins()  # Memuat PIN umum
    characters = string.digits  # Hanya menggunakan angka untuk PIN

    # Mencoba PIN umum terlebih dahulu
    for common_pin in common_pins:
        if common_pin == target_pin:
            print(f'\033[92mPIN ditemukan: {common_pin} (dari daftar PIN umum).\033[0m')
            return common_pin

    # Menentukan panjang PIN
    pin_length = len(target_pin)
    if pin_length == 4:
        print("Mencoba semua kombinasi PIN 4 digit...")
        for pin in range(10000):  # Mencoba semua kombinasi PIN 4 digit
            guess = str(pin).zfill(4)
            print(f'Mencoba: {guess}')  # Menampilkan proses percobaan
            if guess == target_pin:
                print(f'\033[92mPIN ditemukan: {guess}.\033[0m')  # Teks hijau
                return guess
    elif pin_length == 6:
        print("Mencoba semua kombinasi PIN 6 digit...")
        for pin in range(1000000):  # Mencoba semua kombinasi PIN 6 digit
            guess = str(pin).zfill(6)
            print(f'Mencoba: {guess}')  # Menampilkan proses percobaan
            if guess == target_pin:
                print(f'\033[92mPIN ditemukan: {guess}.\033[0m')  # Teks hijau
                return guess
    else:
        print('Panjang PIN tidak valid. Hanya mendukung PIN 4 atau 6 digit.')
        return None

    print('PIN tidak ditemukan setelah mencoba semua kemungkinan.')
    return None

# Contoh penggunaan
target_pin = input("Masukkan PIN yang akan digunakan: ")
brute_force_pin(target_pin)