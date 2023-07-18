
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class homeScreen extends JFrame implements ActionListener {
    public static void main(String[] args) throws IOException {
        homeScreen hs = new homeScreen();
        hs.setVisible(true);

    }

    JPanel home1;
    JPanel home2;
    JPanel homeSidebar;
    JPanel homeSidebarUpper;

    // Adding all buttons here so that we can set their actions using 1 method
    // instead of separate methods for all
    JButton dashboard_button;
    JButton composeMail_Button;
    JButton bulkMail_Button;
    JButton manageContact_Button;
    JButton logOut;

    private String b2val;

    private JButton addNewButton(JButton button, String title, String pathname) throws IOException {

        BufferedImage image = ImageIO.read(new File(pathname));
        Image icon = image.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        button = new JButton();
        button.setText(title);

        button.setFont(new Font("Open Sans", Font.BOLD, 18));
        button.setFocusable(false);
        button.setIcon(new ImageIcon(icon));
        button.setHorizontalAlignment(AbstractButton.LEFT);
        button.setVerticalTextPosition(AbstractButton.CENTER);
        button.setIconTextGap(20);
        button.setBackground(Color.WHITE);
        button.setMaximumSize(new Dimension(350, 50));
        return button;
    }

    private Component accountCredentials(String emailAddress, String imagePath) throws IOException {
        // The account icon section
        BufferedImage image = ImageIO.read(new File(imagePath));
        Image icon = image.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        JLabel accCredentials = new JLabel();
        accCredentials.setText("<html>" + emailAddress + "<br>Status: Active</html>");
        accCredentials.setFont(new Font(Font.SERIF, Font.BOLD, 15));
        accCredentials.setIcon(new ImageIcon(icon));
        return accCredentials;
    }

    public homeScreen() throws IOException {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1366, 768);
        setResizable(false);
        setTitle("E-REM V 1.0");
        setLayout(null);
        // hS.setLocationRelativeTo(null);
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

        // ICON 2 OF BTN 2
        ImageIcon btn2Image = new ImageIcon("tasks.png");
        Image btn2modified = btn2Image.getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
        btn2Image = new ImageIcon(btn2modified);

        ImageIcon btn3Image = new ImageIcon("contacts.png");
        Image btn3modified = btn3Image.getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
        btn3Image = new ImageIcon(btn3modified);
        // ICON 3 OF BTN 3

        // accCredentials.setHorizontalAlignment(JLabel.CENTER);

        JButton sent_Mails = new JButton();
        sent_Mails.setText("5");
        sent_Mails.setFont(new Font("Calibri", Font.BOLD, 35));
        sent_Mails.setFocusable(false);
        sent_Mails.setMaximumSize(new Dimension(280, 80));
        sent_Mails.setBackground(new Color(244, 246, 248));
        sent_Mails.setIcon(btn1Image);
        sent_Mails.setVerticalTextPosition(AbstractButton.CENTER);
        sent_Mails.setHorizontalTextPosition(AbstractButton.LEADING);
        sent_Mails.setIconTextGap(180);
        sent_Mails.setBorder(new TitledBorder("SENT EMAILS"));

        // btnValue= b2.getText();
        JButton contacts_Count = new JButton();
        contacts_Count.setText("15");
        contacts_Count.setFont(new Font("Calibri", Font.BOLD, 35));
        contacts_Count.setFocusable(false);
        contacts_Count.setMaximumSize(new Dimension(280, 80));
        contacts_Count.setBackground(new Color(244, 246, 248));
        contacts_Count.setIcon(btn3Image);
        // sent_Mails.setHorizontalAlignment(JButton.LEFT);
        contacts_Count.setVerticalTextPosition(AbstractButton.CENTER);
        contacts_Count.setHorizontalTextPosition(AbstractButton.LEADING);
        contacts_Count.setIconTextGap(180);
        contacts_Count.setBorder(new TitledBorder("TOTAL CONTACTS"));

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

        dashboard_button = addNewButton(new JButton(), "Dashboard", "dashboard.png");
        composeMail_Button = addNewButton(new JButton(), "Compose Mail", "single email.png");
        bulkMail_Button = addNewButton(new JButton(), "Bulk Email", "bulk email.png");
        manageContact_Button = addNewButton(new JButton(), "Contacts", "contact manager.png");

        home1.add(Box.createRigidArea(new Dimension(100, 0)));
        home1.add(sent_Mails);
        home1.add(Box.createRigidArea(new Dimension(50, 0)));
        home1.add(contacts_Count);
        home1.add(Box.createRigidArea(new Dimension(15, 0)));

        homeSidebarUpper.add(Box.createRigidArea(new Dimension(44, 25)));
        homeSidebarUpper.add(accountCredentials("email_Address", "account icon tp.png"));

        homeSidebar.add(Box.createRigidArea(new Dimension(0, 50)));
        homeSidebar.add(dashboard_button);
        homeSidebar.add(Box.createRigidArea(new Dimension(0, 50)));
        homeSidebar.add(composeMail_Button);
        homeSidebar.add(Box.createRigidArea(new Dimension(0, 50)));
        homeSidebar.add(bulkMail_Button);
        homeSidebar.add(Box.createRigidArea(new Dimension(0, 50)));
        homeSidebar.add(manageContact_Button);
        homeSidebar.add(Box.createRigidArea(new Dimension(0, 75)));

        // Adding actions to sidebar buttons
        dashboard_button.addActionListener(this);
        composeMail_Button.addActionListener(this);
        bulkMail_Button.addActionListener(this);
        manageContact_Button.addActionListener(this);

        home1.setVisible(true);
        // home2.setVisible(true);

        homeSidebar.setVisible(true);
        homeSidebarUpper.setVisible(true);

        add(home1);
        // add(home2);
        add(homeSidebar);
        add(homeSidebarUpper);

    }

    public String getB2val() {
        return b2val;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dashboard_button) {
            homeScreen hs = null;
            try {
                hs = new homeScreen();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            hs.setVisible(true);
            dispose();
        }
        if (e.getSource() == composeMail_Button) {
            sendSingleEmail sse = null;
            try {
                sse = new sendSingleEmail(null, null, null);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            sse.setVisible(true);
            dispose();

        }
        if (e.getSource() == bulkMail_Button) {
            sendBulkEmail sbe = null;
            try {
                sbe = new sendBulkEmail();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            sbe.setVisible(true);
            dispose();
        }

        if (e.getSource() == manageContact_Button) {
            // open contacts management frame
        }

    }
}

/*
 * if (e.getSource() == sidebarButton6) {
 * // open gmail account of user on browser
 * try {
 * Desktop userDesktop = java.awt.Desktop.getDesktop();
 * 
 * URI Url = new URI("https://gmail.com");
 * userDesktop.browse(Url);
 * } catch (Exception ex) {
 * ex.printStackTrace();
 * }
 * }
 */
