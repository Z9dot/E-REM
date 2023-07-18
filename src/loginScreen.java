import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

public class loginScreen extends JFrame {
    public static void main(String[] args) {
        loginScreen lScreen = new loginScreen();
        lScreen.setVisible(true);
    }

    private String userPassword;
    public String userEmail;
    private JPanel IconPanel, CredentialsPanel, buttonPanel;
    private JButton loginButton;
    private JLabel emailLabelField, passwordLabeField;
    private JTextField emailAddressField, passwordField;

    public loginScreen() {
        // Setting login frame
        setTitle("Login");
        setSize(500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        IconPanel = new JPanel(new GridLayout(3, 0));
        ImageIcon icon = new ImageIcon("images/logo icon.png", "E-REM");
        JLabel image = new JLabel(icon);
        IconPanel.add(image);

        add(IconPanel);
        emailLabelField = new JLabel(" Email ");
        emailLabelField.setFont(new Font("Ariel", Font.PLAIN, 16));
        emailAddressField = new JTextField(10);
        emailAddressField.setFont(new Font("Ariel", Font.PLAIN, 16));

        passwordLabeField = new JLabel(" Password");
        passwordLabeField.setFont(new Font("Ariel", Font.PLAIN, 16));
        passwordField = new JPasswordField(10);
        passwordField.setFont(new Font("Ariel", Font.PLAIN, 16));

        CredentialsPanel = new JPanel(new GridLayout(5, 2));
        CredentialsPanel.setPreferredSize(new Dimension(500, 400));

        buttonPanel = new JPanel(null);
        loginButton = new JButton("Login");
        loginButton.setBounds(150, 70, 170, 30);
        loginButton.setFocusable(false);
        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                userEmail = emailAddressField.getText();
                userPassword = passwordField.getText();
                homeScreen homescreen;
                try {
                    dispose();
                    System.out.println(userEmail);
                    homescreen = new homeScreen(userEmail);
                    homescreen.setVisible(true);
                } catch (IOException e1) {
                    e1.printStackTrace();
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

    public String getEmailAddressField() {
        return emailAddressField.getText().toString();

    }

    // Sample login verification method
    // private boolean verifyLogin(String email, String password) {
    // if (email.equals("zainhashmi692@gmail.com") &&
    // password.equals("alizainqurehi")) {
    // return true;
    // } else {
    // return false;
    // }
    // }
}
// 674980207735-po7cdsn1s28gr547q58mbmdgt8621c7n.apps.googleusercontent.com