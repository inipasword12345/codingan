import itertools
import string
import time
import sys

# Menambahkan warna untuk tampilan
class Colors:
    GREEN = '\033[92m'
    RED = '\033[91m'
    YELLOW = '\033[93m'
    RESET = '\033[0m'

def brute_force(target, length):
    characters = string.ascii_letters + string.digits  # Menggunakan huruf kecil, huruf kapital, dan angka
    attempts = itertools.product(characters, repeat=length)
    
    start_time = time.time()  # Mulai waktu pencarian
    total_attempts = 0  # Menghitung total percobaan
    for guess in attempts:
        guess_str = ''.join(guess)
        total_attempts += 1  # Increment total percobaan
        print(f'{Colors.GREEN}Mencoba: {guess_str} (Percobaan ke-{total_attempts}){Colors.RESET}')  # Menampilkan percobaan
        time.sleep(0.005)  # Mengurangi waktu pemrosesan untuk efek 'hacker'
        if guess_str == target:
            elapsed_time = time.time() - start_time  # Hitung waktu yang dibutuhkan
            return f'{Colors.YELLOW}Password ditemukan: {guess_str} dalam {elapsed_time:.2f} detik setelah {total_attempts} percobaan{Colors.RESET}'
    
    elapsed_time = time.time() - start_time  # Hitung waktu yang dibutuhkan
    return f'{Colors.RED}Password tidak ditemukan setelah {elapsed_time:.2f} detik dan {total_attempts} percobaan{Colors.RESET}'

def main():
    print(f"{Colors.YELLOW}=== PASSWORD ==={Colors.RESET}")
    target = input(f"{Colors.GREEN}Masukkan password yang ingin dicari: {Colors.RESET}").strip()
    length = int(input(f"{Colors.GREEN}Masukkan panjang password yang ingin dicari (1-8): {Colors.RESET}").strip())
    
    if 1 <= length <= 8:
        result = brute_force(target, length)
    else:
        result = f'{Colors.RED}Panjang password tidak valid. Silakan masukkan antara 1 hingga 8.{Colors.RESET}'
    
    print(result)

if __name__ == "__main__":
    main()                     