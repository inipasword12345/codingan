import javax.swing.*; // Mengimpor kelas Swing
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoveMessage {
    public static void main(String[] args) {
        String myHeart = "I Love You";
        System.out.println(myHeart);
        System.out.println("My love for you is like a for loop… it's infinite!");
        
        // Loop to express love
        for (int i = 0; i < 5; i++) {
            System.out.println("You are my heart ❤️");
        }
        
        // Memanggil LoveCalculator setelah LoveMessage selesai
        LoveCalculator.main(args);
    }
}

class LoveCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Love Calculator");
        JTextField txtName = new JTextField(10);
        JTextField txtPartner = new JTextField(10);
        JButton btnCalculate = new JButton("Calculate Love %");
        JLabel resultLabel = new JLabel("");

        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                String partner = txtPartner.getText();
                int lovePercentage = (int)(Math.random() * 100); // Random percentage
                resultLabel.setText("Love Compatibility: " + lovePercentage + "%");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Your Name:"));
        panel.add(txtName);
        panel.add(new JLabel("Partner's Name:"));
        panel.add(txtPartner);
        panel.add(btnCalculate);
        panel.add(resultLabel);

        frame.add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}