import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class loginScreen extends JFrame {
    public static void main(String[] args) {
        loginScreen lScreen = new loginScreen();
        lScreen.setVisible(true);
    }

    private String userPassword;
    private String userEmail;

    public loginScreen() {
        // Setting login frame
        setTitle("Login");
        setSize(500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel IconPanel, CredentialsPanel;

        IconPanel = new JPanel(new GridLayout(3, 0));
        ImageIcon icon = new ImageIcon("images/logo icon.png", "E-REM");
        JLabel image = new JLabel(icon);
        IconPanel.add(image);

        add(IconPanel);
        JLabel emailLabelField = new JLabel(" Email ");
        emailLabelField.setFont(new Font("Ariel", Font.PLAIN, 16));
        JTextField emailAddressField = new JTextField(10);
        emailAddressField.setFont(new Font("Ariel", Font.PLAIN, 16));

        JLabel passwordLabeField = new JLabel(" Password");
        passwordLabeField.setFont(new Font("Ariel", Font.PLAIN, 16));
        JPasswordField passwordField = new JPasswordField(10);
        passwordField.setFont(new Font("Ariel", Font.PLAIN, 16));

        CredentialsPanel = new JPanel(new GridLayout(5, 2));
        CredentialsPanel.setPreferredSize(new Dimension(500, 400));

        JPanel buttonPanel = new JPanel(null);
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 70, 170, 30);
        loginButton.setFocusable(false);
        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (verifyLogin(emailAddressField.getText(), passwordField.getPassword().toString())) {
                    try {
                        homeScreen homeScreen = new homeScreen();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(loginButton, "Invalid Credentials!", "Message",
                            ABORT, icon);
                }
            }

        });

        CredentialsPanel.add(emailLabelField);
        CredentialsPanel.add(emailAddressField);
        CredentialsPanel.add(new JLabel());
        CredentialsPanel.add(passwordLabeField);
        CredentialsPanel.add(passwordField);
        IconPanel.add(CredentialsPanel);
        buttonPanel.add(loginButton);
        IconPanel.add(buttonPanel);

    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    // Sample login verification method
    private boolean verifyLogin(String email, String password) {
        if (email.equals("zainhashmi692@gmail.com") && password.equals("alizainqurehi")) {
            return true;
        } else {
            return false;
        }
    }
}
// 674980207735-po7cdsn1s28gr547q58mbmdgt8621c7n.apps.googleusercontent.com