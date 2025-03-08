from datetime import datetime

def hack_umur():
    try:
        tanggal_lahir = input("🔍 Masukkan tanggal lahir Anda (format: YYYY-MM-DD): ")
        print("💻 Mengakses data...")
        lahir = datetime.strptime(tanggal_lahir, "%Y-%m-%d")
        hari_ini = datetime.now()
        umur_tahun = hari_ini.year - lahir.year - ((hari_ini.month, hari_ini.day) < (lahir.month, lahir.day))
        print(f"🔓 Umur Anda berhasil diakses: {umur_tahun} tahun! Selamat merayakan hidup!")
    except ValueError:
        print("⚠️ Format tanggal salah! Gunakan format YYYY-MM-DD yang benar.")

if __name__ == "__main__":
    hack_umur()
