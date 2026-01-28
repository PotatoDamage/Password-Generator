import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Project1 extends JFrame implements ActionListener {
    int length = 10;
    private JButton Upper_case; // each button that will be clicked
    private JButton Lower_case;
    private JButton SpecialChar;
    private JButton Generate;

    private String lowerLetters = "abcdefghijklmnopqrstuvwxyz";
    private String upperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String specialChars = "!@#$%^&*()";

    private boolean includeUpper = false; // we set everything to false, then true if clicked
    private boolean includeLower = false;
    private boolean includeSpecial = false;

    public Project1() {
        this.setVisible(true);
        this.setSize(400, 600);
        this.setTitle("Password Generator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);


        Lower_case = new JButton("Lower Case?"); // Here we just create some buttons
        Lower_case.setBounds(200, 50, 150, 30);
        this.add(Lower_case);
        Lower_case.addActionListener(this);

        SpecialChar  = new JButton("Special Characters?");
        SpecialChar .setBounds(20, 100, 150, 30);
        this.add(SpecialChar );
        SpecialChar.addActionListener(this);

        Upper_case = new JButton("Upper Case?");
        Upper_case.setBounds(20, 50, 150, 30);
        this.add(Upper_case);
        Upper_case.addActionListener(this);

        Generate = new JButton("Generate");
        Generate.setBounds(200, 100, 150, 30);
        this.add(Generate);
        Generate.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Upper_case) {
            includeUpper = !includeUpper;
        }

        if (e.getSource() == Lower_case) {
            includeLower = !includeLower;
        }

        if (e.getSource() == SpecialChar) {
            includeSpecial = !includeSpecial;
        }
        if (e.getSource() == Generate) { // if Generate was clicked, we check the pool and spit out the password
        String pool = ""; // first the pool is empty
        if (includeUpper) pool += upperLetters; // if statements to check if any of the buttons were clicked
        if (includeLower) pool += lowerLetters;
        if (includeSpecial) pool += specialChars;
        if (pool.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Select at least one option! ");
            return;
        }

            Random random = new Random();
            StringBuilder password = new StringBuilder();
            for(int i = 0; i < length; i++){ // a loop to go through the pool and build the password
                int index = random.nextInt(pool.length());
                    password.append(pool.charAt(index));
                }
            JOptionPane.showMessageDialog(null, password.toString());
        }
        }

    public static void main(String[] args) {
        new Project1(); // create and show the window
    }

    }






