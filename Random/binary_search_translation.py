def binary_search(arr, target):
    left, right = 0, len(arr) - 1

    while left <= right:
        mid = left + (right - left) // 2

        # Jika elemen tengah adalah target yang dicari
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1

    # Jika elemen tidak ditemukan dalam array
    return -1

# Contoh penggunaan fungsi binary_search
if __name__ == "__main__":
    data = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    target = 7
    result = binary_search(data, target)

    if result != -1:
        print(f"🔍 Elemen ditemukan pada indeks: {result}")
    else:
        print("⚠️ Elemen tidak ditemukan dalam array.")
