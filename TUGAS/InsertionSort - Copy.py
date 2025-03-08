# Program Pengurutan Data Menggunakan Insertion Sort
def insertion_sort(data):
    for i in range(1, len(data)):
        key = data[i]
        j = i - 1
        # Pindahkan elemen-elemen yang lebih besar dari key ke satu posisi ke depan
        while j >= 0 and key < data[j]:
            data[j + 1] = data[j]
            j -= 1
        data[j + 1] = key
    return data

# Data kota yang akan diurutkan
kota = ["Semarang", "Malang", "Jakarta", "Cianjur", "Bogor", "Denpasar"]

# Cetak hasil sebelum dan sesudah pengurutan
print("Data sebelum diurutkan:", kota)
kota_terurut = insertion_sort(kota[:])  # Menggunakan salinan data untuk menjaga data asli
print("Data setelah diurutkan:", kota_terurut)

# Output:
# Data sebelum diurutkan: ['Semarang', 'Malang', 'Jakarta', 'Cianjur', 'Bogor', 'Denpasar']
# Data setelah diurutkan: ['Bogor', 'Cianjur', 'Denpasar', 'Jakarta', 'Malang', 'Semarang']

