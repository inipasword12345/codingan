import pandas as pd

# 1. Membaca data dari file CSV
file_path = "data.csv"  # Ubah dengan nama file yang sesuai
df = pd.read_csv(file_path)

# 2. Menampilkan ringkasan statistik
print("Ringkasan Statistik Data:")
print(df.describe())

# 3. Memfilter data (contoh: memilih baris dengan nilai kolom 'nilai' lebih dari 70)
filtered_df = df[df['nilai'] > 70]

# 4. Menyimpan hasil ke file baru
filtered_df.to_csv("filtered_data.csv", index=False)

print("Data yang telah difilter disimpan sebagai 'filtered_data.csv'")
