import java.io.IOException;
import java.io.StreamCorruptedException;
import java.io.*;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
public class loginScreen extends JFrame{
    public static void main(String[] args){
        loginScreen lScreen= new loginScreen();
        lScreen.setVisible(true);
    }

    private String userPassword;
    private String userEmail;
    public loginScreen() {
        JFrame f1 = new JFrame();
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setSize(1366, 768);
        f1.setResizable(false);
        f1.setTitle("E-REM V 1.0");
        f1.setLocationRelativeTo(null);
        f1.getContentPane().setBackground(new Color(233, 242, 246));

        JPanel pleft = new JPanel();
        BoxLayout box = new BoxLayout(pleft, BoxLayout.Y_AXIS);
        pleft.setLayout(box);
        pleft.setBackground(Color.white);
        pleft.setBounds(0, 0, 600, 768);


        // pleft.setBorder(new LineBorder(Color.ORANGE, 3));
        JButton btn= new JButton();
        btn.setBackground(Color.gray);
        btn.setMaximumSize(new Dimension(400, 600));
        btn.setBorder(null);
        btn.setFocusable(false);

        JPanel pright = new JPanel();
        pright.setLayout(null);
        pright.setBounds(100, 0, 766, 768);
        pright.setBackground(Color.ORANGE);

        pright.add(btn);

        // THE LOGIN FIELDS PANEL
        // JPanel loginFields= new JPanel();
        // BoxLayout boxLogin= new BoxLayout(loginFields, BoxLayout.Y_AXIS);
        //loginFields.setLayout(boxLogin);

        // gl.setVgap(1);

        // loginFields.setBounds(100, 100, loginFields.getWidth(), loginFields.getHeight());
        JLabel emailL = new JLabel("Enter Email: ");
        //   emailL.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField enterEmail = new JTextField(2);
        userEmail= enterEmail.getText();

        //enterEmail.setAlignmentX(Component.LEFT_ALIGNMENT);
        enterEmail.setMaximumSize(new Dimension(300, 40));
        //  enterEmail.setAlignmentX(Component.CENTER_ALIGNMENT);

        //enterEmail.setMaximumSize(new Dimension(700,100));

        JLabel passL = new JLabel("Enter Password: ");
        JTextField enterPass = new JTextField(2);
        userPassword= enterPass.getText();
        enterPass.setMaximumSize(new Dimension(300, 40));
        // enterPass.setAlignmentX(Component.CENTER_ALIGNMENT);
        // enterPass.setMaximumSize(new Dimension(700,100));

        //enterEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
        // enterPass.setAlignmentX(Component.CENTER_ALIGNMENT);


        //  loginFields.add(Box.createVerticalGlue());


        //  loginFields.setBounds(-30, 200, 600, 300);
        //   loginFields.setAlignmentX(Component.CENTER_ALIGNMENT);


        ImageIcon logo = new ImageIcon("erem logo.png");
        Image logoModified = logo.getImage().getScaledInstance(105, 145, Image.SCALE_SMOOTH);
        logo = new ImageIcon(logoModified);
        JLabel logoL = new JLabel(logo);
        logoL.setAlignmentX(Component.CENTER_ALIGNMENT);
        //logoL.setBounds(-30, -10, 600, 300);
        // label.setHorizontalAlignment(JLabel.CENTER);
        //label.setBackground(new Color(000000));
        //label.setFont(new Font("Verdana", Font.PLAIN, 25));
        //  logo.setVisible(true);


        // The account icon section
        ImageIcon accIcon = new ImageIcon("account icon.png");
        Image aiOriginal = accIcon.getImage();
        Image aiModified = aiOriginal.getScaledInstance(48, 48, Image.SCALE_SMOOTH);
        accIcon = new ImageIcon(aiModified);

        JLabel accCredentials = new JLabel();
        accCredentials.setText("<html>digitalhamayun@gmail.com<br>Status: Active</html>");
        accCredentials.setIcon(accIcon);
        //  accCredentials.setHorizontalAlignment(JLabel.CENTER);


        // The log in button


        ImageIcon loginButtonImage = new ImageIcon("sign in button.png");
        Image lbiModified = loginButtonImage.getImage().getScaledInstance(255, 80, Image.SCALE_SMOOTH);
        JButton logIn = new JButton(new ImageIcon(lbiModified));
        logIn.setMaximumSize(new Dimension(245, 60));
        logIn.setAlignmentX(Component.CENTER_ALIGNMENT);

        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    homeScreen homeS = new homeScreen();
                    homeS.setVisible(true);
                    dispose();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
        // logIn.setSize(240, 70);


        //logIn.setAlignmentX(Component.CENTER_ALIGNMENT);

        //loginButtonPanel.setMaximumSize(new Dimension(245, 60));
        // logIn.setAlignmentY(13);


        pleft.add(Box.createRigidArea(new Dimension(0, 70)));
        pleft.add(logoL);
        pleft.add(Box.createRigidArea(new Dimension(0, 100)));
        pleft.add(emailL, Component.LEFT_ALIGNMENT);
        pleft.add(enterEmail);
        pleft.add(Box.createRigidArea(new Dimension(0, 30)));
        pleft.add(passL);
        pleft.add(enterPass);
        pleft.add(Box.createRigidArea(new Dimension(0, 120)));
        pleft.add(logIn);
        pleft.setVisible(true);
        pright.setVisible(true);
        add(pleft);
        add(pright);

    }
    public String getUserEmail(){
        return userEmail;
    }
    public String getUserPassword(){
        return userPassword;
    }

}
