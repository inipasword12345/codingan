
import java.util.Scanner;

public class buah2 {
    public static void main(String[] args) {
        
        String[] buah = new String[5];

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < buah.length; i++){
            System.out.print("buah ke-" + i + ":");
            buah[i] = scan.nextLine();
        }

        System.out.println("-------------------------");
        
        for( String b : buah){
            System.out.println(b);
        }
    }
};