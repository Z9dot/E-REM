
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;


class homeScreen extends JFrame implements ActionListener {
    public static void main(String[] args) throws IOException {
        homeScreen hs = new homeScreen();
        hs.setVisible(true);


        }


    JPanel home1;
    JPanel home2;
    JPanel homeSidebar;
    JPanel homeSidebarUpper;

    private JButton b2;



    // Adding all buttons here so that we can set their actions using 1 method instead of separate methods for all
    JButton sidebarButton1;
    JButton sidebarButton2;
    JButton sidebarButton3;
    JButton sidebarButton4;
    JButton sidebarButton5;
    JButton sidebarButton6;
    private String b2val;




    public homeScreen() throws IOException {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1366, 768);
        setResizable(false);
        setTitle("E-REM V 1.0");
        setLayout(null);
        //hS.setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(244, 246, 248));


        home1 = new JPanel();
        home1.setBackground(new Color(244, 246, 248));
        BoxLayout h1L = new BoxLayout(home1, BoxLayout.X_AXIS);
        home1.setLayout(h1L);
        home1.setBounds(300, 0, 1100, 140);


        // ICON 1 OF BTN1
        ImageIcon btn1Image = new ImageIcon("email.png");
        Image btn1modified = btn1Image.getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
        btn1Image = new ImageIcon(btn1modified);

        //ICON 2 OF BTN 2
        ImageIcon btn2Image = new ImageIcon("tasks.png");
        Image btn2modified = btn2Image.getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
        btn2Image = new ImageIcon(btn2modified);

        ImageIcon btn3Image = new ImageIcon("contacts.png");
        Image btn3modified = btn3Image.getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
        btn3Image = new ImageIcon(btn3modified);
        //ICON 3 OF BTN 3


        //  accCredentials.setHorizontalAlignment(JLabel.CENTER);

        JButton b1 = new JButton();
        b1.setText("5");
        b1.setFont(new Font("Calibri", Font.BOLD, 35));
        b1.setFocusable(false);
        b1.setMaximumSize(new Dimension(280, 80));
        b1.setBackground(new Color(244, 246, 248));
        b1.setIcon(btn1Image);
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING);
        b1.setIconTextGap(180);
        b1.setBorder(new TitledBorder("SENT EMAILS"));

        b2 = new JButton();
        b2.setText("12");
        b2val= String.valueOf(b2.getText());
        b2.setFont(new Font("Calibri", Font.BOLD, 35));
        b2.setFocusable(false);
        b2.setMaximumSize(new Dimension(280, 80));
        b2.setBackground(new Color(244, 246, 248));
        b2.setIcon(btn2Image);
        // b1.setHorizontalAlignment(JButton.LEFT);
        b2.setVerticalTextPosition(AbstractButton.CENTER);
        b2.setHorizontalTextPosition(AbstractButton.LEADING);
        b2.setIconTextGap(180);
        b2.setBorder(new TitledBorder("OVERDUE TASKS"));

      //  btnValue= b2.getText();


        JButton b3 = new JButton();
        b3.setText("15");
        b3.setFont(new Font("Calibri", Font.BOLD, 35));
        b3.setFocusable(false);
        b3.setMaximumSize(new Dimension(280, 80));
        b3.setBackground(new Color(244, 246, 248));
        b3.setIcon(btn3Image);
        // b1.setHorizontalAlignment(JButton.LEFT);
        b3.setVerticalTextPosition(AbstractButton.CENTER);
        b3.setHorizontalTextPosition(AbstractButton.LEADING);
        b3.setIconTextGap(180);
        b3.setBorder(new TitledBorder("TOTAL CONTACTS"));


        home2 = new JPanel();
        BoxLayout h2L = new BoxLayout(home2, BoxLayout.Y_AXIS);
        home2.setLayout(h2L);
        home2.setBackground(new Color(244, 246, 248));
        home2.setBounds(300, 140, 1050, 600);

        homeSidebar = new JPanel();
        homeSidebar.setBackground(new Color(255, 182, 117));
        // homeSidebar.setBackground(Color.WHITE);
        BoxLayout h3L = new BoxLayout(homeSidebar, BoxLayout.Y_AXIS);
        homeSidebar.setLayout(h3L);
        homeSidebar.setBounds(0, 120, 300, 780);


        homeSidebarUpper = new JPanel();
        BoxLayout hsuL = new BoxLayout(homeSidebarUpper, BoxLayout.Y_AXIS);
        homeSidebarUpper.setBackground(Color.WHITE);
        homeSidebarUpper.setLayout(hsuL);
        homeSidebarUpper.setBorder(new LineBorder(new Color(255, 182, 117), 4));
        homeSidebarUpper.setBounds(0, 0, 300, 250);
        homeSidebarUpper.setAlignmentX(Component.LEFT_ALIGNMENT);

        // The account icon section
        ImageIcon accIcon = new ImageIcon("account icon tp.png");
        Image aiOriginal = accIcon.getImage();
        Image aiModified = aiOriginal.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        accIcon = new ImageIcon(aiModified);
        JLabel accCredentials = new JLabel();
        accCredentials.setText("<html>digitalhamayun@gmail.com<br>Status: Active</html>");
        accCredentials.setFont(new Font(Font.SERIF, Font.BOLD, 15));
        accCredentials.setIcon(accIcon);

        ImageIcon sbi1 = new ImageIcon("dashboard.png");
        Image sbi1Modified = sbi1.getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH);
        sidebarButton1 = new JButton();
        sidebarButton1.setText("DASHBOARD");
        sidebarButton1.setBackground(new Color(244, 246, 248));
        sidebarButton1.setFont(new Font("Open Sans", Font.BOLD, 16));
        sidebarButton1.setFocusable(false);
        sidebarButton1.setIcon(new ImageIcon(sbi1Modified));

        sidebarButton1.setHorizontalAlignment(AbstractButton.LEFT);
        sidebarButton1.setVerticalTextPosition(AbstractButton.CENTER);
        sidebarButton1.setIconTextGap(20);
        sidebarButton1.setForeground(Color.BLACK);

        sidebarButton1.setMaximumSize(new Dimension(350, 50));

        ImageIcon sbi2 = new ImageIcon("single email.png");
        Image sbi2Modified = sbi2.getImage().getScaledInstance(42, 42, Image.SCALE_SMOOTH);
        sidebarButton2 = new JButton();
        sidebarButton2.setText("COMPOSE EMAIL");
        sidebarButton2.setFont(new Font("Open Sans", Font.BOLD, 16));
        sidebarButton2.setFocusable(false);
        sidebarButton2.setIcon(new ImageIcon(sbi2Modified));

        sidebarButton2.setHorizontalAlignment(AbstractButton.LEFT);
        sidebarButton2.setVerticalTextPosition(AbstractButton.CENTER);
        sidebarButton2.setIconTextGap(20);
        sidebarButton2.setBackground(Color.WHITE);
        sidebarButton2.setMaximumSize(new Dimension(300, 50));

        ImageIcon sbi3 = new ImageIcon("bulk email.png");
        Image sbi3Modified = sbi3.getImage().getScaledInstance(42, 42, Image.SCALE_SMOOTH);
        sidebarButton3 = new JButton();
        sidebarButton3.setText("BULK EMAIL");

        sidebarButton3.setFont(new Font("Open Sans", Font.BOLD, 16));
        sidebarButton3.setFocusable(false);
        sidebarButton3.setIcon(new ImageIcon(sbi3Modified));
        sidebarButton3.setHorizontalAlignment(AbstractButton.LEFT);
        sidebarButton3.setVerticalTextPosition(AbstractButton.CENTER);
        sidebarButton3.setIconTextGap(20);
        sidebarButton3.setBackground(Color.WHITE);
        sidebarButton3.setMaximumSize(new Dimension(350, 50));

        ImageIcon sbi4 = new ImageIcon("task manager.png");
        Image sbi4Modified = sbi4.getImage().getScaledInstance(42, 42, Image.SCALE_SMOOTH);
        sidebarButton4 = new JButton();
        sidebarButton4.setText("TASK MANAGER");

        sidebarButton4.setFont(new Font("Open Sans", Font.BOLD, 16));
        sidebarButton4.setFocusable(false);
        sidebarButton4.setIcon(new ImageIcon(sbi4Modified));

        sidebarButton4.setHorizontalAlignment(AbstractButton.LEFT);
        sidebarButton4.setVerticalTextPosition(AbstractButton.CENTER);
        sidebarButton4.setIconTextGap(20);
        sidebarButton4.setBackground(Color.WHITE);
        sidebarButton4.setMaximumSize(new Dimension(350, 50));

        ImageIcon sbi5 = new ImageIcon("contact manager.png");
        Image sbi5Modified = sbi5.getImage().getScaledInstance(42, 42, Image.SCALE_SMOOTH);
        sidebarButton5 = new JButton();
        sidebarButton5.setText("MANAGE CONTACTS");

        sidebarButton5.setFont(new Font("Open Sans", Font.BOLD, 16));
        sidebarButton5.setFocusable(false);
        sidebarButton5.setIcon(new ImageIcon(sbi5Modified));

        sidebarButton5.setHorizontalAlignment(AbstractButton.LEFT);
        sidebarButton5.setVerticalTextPosition(AbstractButton.CENTER);
        sidebarButton5.setIconTextGap(20);
        sidebarButton5.setBackground(Color.WHITE);
        sidebarButton5.setMaximumSize(new Dimension(350, 50));

        ImageIcon sbi6 = new ImageIcon("gmail.png");
        Image sbi6Modified = sbi6.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
        sidebarButton6 = new JButton();
        sidebarButton6.setText(" ");
        sidebarButton6.setFocusable(true);
        sidebarButton6.setIcon(new ImageIcon(sbi6Modified));
        sidebarButton6.setBorder(null);
        sidebarButton6.setVerticalTextPosition(AbstractButton.CENTER);
        sidebarButton6.setBackground(null);
        // sidebarButton6.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        sidebarButton6.setHorizontalTextPosition(AbstractButton.LEADING);
        sidebarButton6.setIconTextGap(102);


        home1.add(Box.createRigidArea(new Dimension(85, 0)));
        home1.add(b1);
        home1.add(Box.createRigidArea(new Dimension(25, 0)));
        home1.add(b2);
        home1.add(Box.createRigidArea(new Dimension(25, 0)));
        home1.add(b3);
        home1.add(Box.createRigidArea(new Dimension(15, 0)));

        homeSidebarUpper.add(Box.createRigidArea(new Dimension(44, 25)));
        homeSidebarUpper.add(accCredentials);

        homeSidebar.add(Box.createRigidArea(new Dimension(0, 30)));
        homeSidebar.add(sidebarButton1);
        homeSidebar.add(Box.createRigidArea(new Dimension(0, 50)));
        homeSidebar.add(sidebarButton2);
        homeSidebar.add(Box.createRigidArea(new Dimension(0, 30)));
        homeSidebar.add(sidebarButton3);
        homeSidebar.add(Box.createRigidArea(new Dimension(0, 30)));
        homeSidebar.add(sidebarButton4);
        homeSidebar.add(Box.createRigidArea(new Dimension(0, 30)));
        homeSidebar.add(sidebarButton5);
        homeSidebar.add(Box.createRigidArea(new Dimension(0, 75)));
        homeSidebar.add(sidebarButton6);


        // Adding actions to sidebar buttons
        sidebarButton1.addActionListener(this);
        sidebarButton2.addActionListener(this);
        sidebarButton3.addActionListener(this);
        sidebarButton4.addActionListener(this);
        sidebarButton5.addActionListener(this);
        sidebarButton6.addActionListener(this);




        home1.setVisible(true);
        home2.setVisible(true);

        homeSidebar.setVisible(true);
        homeSidebarUpper.setVisible(true);


        add(home1);
        add(home2);
        add(homeSidebar);
        add(homeSidebarUpper);




    }
    public String getB2val(){
        return b2val;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sidebarButton1) {
            homeScreen hs= null;
            try {
                hs = new homeScreen();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            hs.setVisible(true);
            dispose();
        }
        if (e.getSource() == sidebarButton2) {
            sendSingleEmail sse= null;
            try {
                sse = new sendSingleEmail(null, null, null);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            sse.setVisible(true);
            dispose();

        }
        if (e.getSource() == sidebarButton3) {
            sendBulkEmail sbe= null;
            try {
                sbe = new sendBulkEmail();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            sbe.setVisible(true);
            dispose();
        }
        if (e.getSource() == sidebarButton4) {
            // open tasks management frame
        }
        if (e.getSource() == sidebarButton5) {
            // open contacts management frame
        }
        if (e.getSource() == sidebarButton6) {
            // open gmail account of user on browser
            try {
                Desktop userDesktop = java.awt.Desktop.getDesktop();


                URI Url = new URI("https://gmail.com");
                userDesktop.browse(Url);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}