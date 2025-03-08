import java.util.Arrays;
import java.util.Comparator

public class BinarySearchDictionary {
    static class Entry {
        String english;
        String indonesian;

        Entry(String english, String indonesian) {
            this.english = english;
            this.indonesian = indonesian;
        }
    }

    private static Entry[] dictionary = {
        new Entry("apple", "apel"),
        new Entry("banana", "pisang"),
        new Entry("cat", "kucing"),
        new Entry("dog", "anjing"),
        new Entry("elephant", "gajah"),
        new Entry("fruit", "buah"),
        new Entry("grape", "anggur"),
        new Entry("house", "rumah"),
        new Entry("ice", "es"),
        new Entry("juice", "jus")
    };

    public static void main(String[] args) {
        // Sort the dictionary array based on the english word
        Arrays.sort(dictionary, Comparator.comparing(entry -> entry.english));
        System.out.println(translateToIndonesian("cat"));
        
        // Sort the dictionary array based on the indonesian word
        Arrays.sort(dictionary, Comparator.comparing(entry -> entry.indonesian));
        System.out.println(translateToEnglish("anjing"));
        
        // Sort the dictionary array back based on the english word
        Arrays.sort(dictionary, Comparator.comparing(entry -> entry.english));
    }

    public static String translateToIndonesian(String englishWord) {
        int index = Arrays.binarySearch(dictionary, new Entry(englishWord, null), Comparator.comparing(entry -> entry.english));
        if (index >= 0) {
            return dictionary[index].indonesian;
        } else {
            return "Word not found";
        }
    }

    public static String translateToEnglish(String indonesianWord) {
        int index = Arrays.binarySearch(dictionary, new Entry(null, indonesianWord), Comparator.comparing(entry -> entry.indonesian));
        if (index >= 0) {
            return dictionary[index].english;
        } else {
            return "Word not found";
        }
    }
}