public class Selection_Sort {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("Array sebelum diurutkan:");
        printArray(arr);
        
        selectionSort(arr);
        
        System.out.println("\nArray setelah diurutkan:");
        printArray(arr);
    }
    
    static void selectionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            
            int temp = arr[min_idx];
            arr[min_idx] = arr[i]; 
            arr[i] = temp;
        }
    }
    
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
