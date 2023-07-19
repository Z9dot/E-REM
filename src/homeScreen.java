
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileSystemView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class homeScreen extends JFrame implements ActionListener {
    public static void main(String[] args) throws IOException {
        homeScreen hs = new homeScreen("Email Address");
        hs.setVisible(true);

    }

    JPanel statsPanel;
    JPanel dashboardPanel;
    JPanel homeSidebar;
    JPanel homeSidebarUpper;
    CardLayout card;

    // Adding all buttons here so that we can set their actions using 1 method
    // instead of separate methods for all

    JButton composeMail_Button;
    JButton bulkMail_Button;
    JButton manageContact_Button;
    JButton logOut;

    // single email panel
    private JPanel uploadFile;
    // private JPanel sidebar;
    private JPanel reciepentMailField;
    private JPanel subjectField;
    private JPanel messageBoxField;
    private JPanel buttonsPanel;
    // private JPanel field5;
    private JButton sendButton;
    private JButton scheduleButton;
    private JButton emailSuccessMessage;

    private JButton attachment;
    private JLabel rEmail;
    private JLabel eSubject;
    private JLabel rMessage;
    private JTextField rEmailField;
    private JTextField eSubjectField;
    private JTextArea rMessageField;

    private File file;
    private boolean attachmentPresent;

    private boolean isDateFromHomeScreen;

    private String b2val;
    private JPanel singleEmailPanel;
    private JPanel blankPanel;
    private JButton dashboard_button;

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

    private JPanel dashboardPanel() {
        dashboardPanel = new JPanel();
        dashboardPanel.setBounds(300, 140, 1000, 550);
        dashboardPanel.setVisible(true);
        return dashboardPanel;
    }

    private JPanel singleEmailPanel() {
        singleEmailPanel = new JPanel();
        BoxLayout h2L = new BoxLayout(singleEmailPanel, BoxLayout.Y_AXIS);
        singleEmailPanel.setLayout(h2L);
        singleEmailPanel.setBounds(300, 140, 1000, 550);

        // reciepent mail
        reciepentMailField = new JPanel();
        BoxLayout reciepentMailbox = new BoxLayout(reciepentMailField, BoxLayout.X_AXIS);
        reciepentMailField.setLayout(reciepentMailbox);
        reciepentMailField.setBackground(null);
        rEmail = new JLabel("Recipient Email: ");
        rEmail.setFont(new Font("Open Sans", Font.BOLD, 16));
        rEmailField = new JTextField(20);
        rEmailField.setMaximumSize(new Dimension(900, 30));
        reciepentMailField.setBorder(new EmptyBorder(20, 54, 0, 250));
        reciepentMailField.add(rEmail);
        reciepentMailField.add(Box.createRigidArea(new Dimension(40, 0)));
        reciepentMailField.add(rEmailField);

        // Subject
        subjectField = new JPanel();
        BoxLayout field2box = new BoxLayout(subjectField, BoxLayout.X_AXIS);
        subjectField.setLayout(field2box);
        subjectField.setBackground(null);
        eSubject = new JLabel("Email Subject: ");
        eSubject.setFont(new Font("Open Sans", Font.BOLD, 16));
        eSubjectField = new JTextField(10);
        eSubjectField.setMaximumSize(new Dimension(900, 20));
        subjectField.setBorder(new EmptyBorder(20, 55, 0, 250));
        subjectField.add(eSubject);
        subjectField.add(Box.createRigidArea(new Dimension(52, 0)));
        subjectField.add(eSubjectField);

        // Message Box
        messageBoxField = new JPanel();
        BoxLayout field3box = new BoxLayout(messageBoxField, BoxLayout.X_AXIS);
        messageBoxField.setLayout(field3box);
        messageBoxField.setBackground(null);
        rMessage = new JLabel("Message: ");
        rMessage.setFont(new Font("Open Sans", Font.BOLD, 16));
        rMessageField = new JTextArea();
        rMessageField.setLineWrap(true);
        rMessageField.setWrapStyleWord(true); // Wrap words to avoid cutting them

        JScrollPane scrollPane = new JScrollPane(rMessageField);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        rMessageField.setMaximumSize(new Dimension(1300, 23));

        messageBoxField.setBorder(new EmptyBorder(25, 59, 0, 250));
        rMessageField.setBorder(new LineBorder(Color.black, 1));
        messageBoxField.add(rMessage);
        messageBoxField.add(Box.createRigidArea(new Dimension(88, 0)));
        messageBoxField.add(scrollPane);

        getContentPane().add(messageBoxField, BorderLayout.CENTER);

        // Button panel
        buttonsPanel = new JPanel();
        BoxLayout field4box = new BoxLayout(buttonsPanel, BoxLayout.X_AXIS);
        buttonsPanel.setLayout(field4box);
        buttonsPanel.setBackground(null);

        // Attachment button
        attachment = new JButton();
        attachment.setMaximumSize(new Dimension(50, 50));
        // Upload file button
        ImageIcon uploadAttachment = new ImageIcon("images/upload.png");

        attachment.setIcon(uploadAttachment);
        attachment.setBackground(null);
        attachment.setBorder(null);
        attachment.setFocusable(false);

        attachment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // open fileopener
                JFileChooser jFile = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                int x = jFile.showOpenDialog(null);
                if (x == JFileChooser.APPROVE_OPTION) {
                    file = jFile.getSelectedFile().getAbsoluteFile();
                    attachmentPresent = true;
                    System.out.println("File Selected");
                }

            }
        });
        buttonsPanel.add(attachment);

        // Send Button
        sendButton = new JButton();
        sendButton.setText("SEND EMAIL");
        sendButton.setVisible(true);
        ImageIcon sendEmailIcon = new ImageIcon("images/sendemail.png");
        Image seIModified = sendEmailIcon.getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
        sendEmailIcon = new ImageIcon(seIModified);
        sendButton.setIcon(sendEmailIcon);
        sendButton.setHorizontalTextPosition(AbstractButton.TRAILING);
        sendButton.setFocusable(false);
        sendButton.setFont(new Font("Open Sans", Font.BOLD, 16));
        sendButton.setBackground(new Color(255, 182, 117));
        sendButton.setForeground(Color.BLACK);
        sendButton.setMaximumSize(new Dimension(150, 50));
        sendButton.addActionListener(this);
        buttonsPanel.add(Box.createRigidArea(new Dimension(25, 0)));
        buttonsPanel.add(sendButton);

        // Schedule Button
        scheduleButton = new JButton();
        scheduleButton.setText("SCHEDULE EMAIL");
        ImageIcon scheduleImageIcon = new ImageIcon("images/scheduleemail.png");
        Image sIIModified = scheduleImageIcon.getImage().getScaledInstance(46, 41, Image.SCALE_SMOOTH);
        scheduleImageIcon = new ImageIcon(sIIModified);
        scheduleButton.setIcon(scheduleImageIcon);
        scheduleButton.setHorizontalTextPosition(AbstractButton.TRAILING);
        scheduleButton.setFocusable(false);
        scheduleButton.setForeground(Color.white);
        scheduleButton.setBackground(Color.BLACK);
        scheduleButton.setFont(new Font("Open Sans", Font.BOLD, 16));
        scheduleButton.setMaximumSize(new Dimension(100, 50));
        buttonsPanel.add(Box.createRigidArea(new Dimension(25, 0)));
        scheduleButton.setVisible(true);
        buttonsPanel.setBorder(new EmptyBorder(30, 40, 30, 190));
        buttonsPanel.add(scheduleButton);

        buttonsPanel.add(Box.createRigidArea(new Dimension(45, 0)));

        emailSuccessMessage = new JButton();
        emailSuccessMessage.setText("Please wait, Average remaining time (less than 8s) ");
        emailSuccessMessage.setFocusable(false);
        emailSuccessMessage.setFont(new Font("Open Sans", Font.ITALIC, 13));
        emailSuccessMessage.setBackground(null);
        emailSuccessMessage.setForeground(Color.BLACK);
        emailSuccessMessage.setMaximumSize(new Dimension(350, 35));
        emailSuccessMessage.setVisible(false);
        buttonsPanel.add(emailSuccessMessage);
        attachmentPresent = false;

        // singleEmailPanel.add(uploadFile);
        singleEmailPanel.add(Box.createRigidArea(new Dimension(0, 0)));
        singleEmailPanel.add(reciepentMailField);
        singleEmailPanel.add(Box.createRigidArea(new Dimension(0, 8)));
        singleEmailPanel.add(subjectField);
        singleEmailPanel.add(Box.createRigidArea(new Dimension(0, 0)));
        singleEmailPanel.add(messageBoxField);
        singleEmailPanel.add(Box.createRigidArea(new Dimension(0, -20)));
        singleEmailPanel.add(buttonsPanel);
        singleEmailPanel.setVisible(true);
        return singleEmailPanel;
    }

    public homeScreen(String UserEmail) throws IOException {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setResizable(false);
        setTitle("E-REM V 1.0");
        setLayout(null);
        setLocationRelativeTo(null);
        // hS.setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(244, 246, 248));

        statsPanel = new JPanel();
        statsPanel.setBackground(new Color(244, 246, 248));
        BoxLayout h1L = new BoxLayout(statsPanel, BoxLayout.X_AXIS);
        statsPanel.setLayout(h1L);
        statsPanel.setBounds(300, 0, 1000, 140);
        // statsPanel.setBackground(Color.blue);

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
        homeSidebar.setBounds(0, 120, 300, 550);

        homeSidebarUpper = new JPanel();
        BoxLayout hsuL = new BoxLayout(homeSidebarUpper, BoxLayout.Y_AXIS);
        homeSidebarUpper.setBackground(Color.WHITE);
        homeSidebarUpper.setLayout(hsuL);
        homeSidebarUpper.setBorder(new LineBorder(new Color(255, 182, 117), 4));
        homeSidebarUpper.setBounds(0, 0, 300, 250);
        homeSidebarUpper.setAlignmentX(Component.LEFT_ALIGNMENT);

        dashboard_button = addNewButton(new JButton(), "Dashboard", "images/dashboard.png");
        composeMail_Button = addNewButton(new JButton(), "Compose Mail", "images/single email.png");
        bulkMail_Button = addNewButton(new JButton(), "Bulk Email", "images/bulk email.png");
        manageContact_Button = addNewButton(new JButton(), "Contacts", "images/contact manager.png");

        statsPanel.add(Box.createRigidArea(new Dimension(100, 0)));
        statsPanel.add(sent_Mails);
        statsPanel.add(Box.createRigidArea(new Dimension(50, 0)));
        statsPanel.add(contacts_Count);
        statsPanel.add(Box.createRigidArea(new Dimension(15, 0)));

        homeSidebarUpper.add(Box.createRigidArea(new Dimension(44, 25)));
        homeSidebarUpper.add(accountCredentials(UserEmail, "images/account icon tp.png"));

        card = new CardLayout();
        blankPanel = new JPanel(card);
        blankPanel.setBounds(300, 140, 1000, 550);
        blankPanel.add(dashboardPanel(), "Dashboard");
        blankPanel.add(singleEmailPanel(), "Single Email");

        homeSidebar.add(Box.createRigidArea(new Dimension(0, 50)));
        homeSidebar.add(dashboard_button);
        homeSidebar.add(Box.createRigidArea(new Dimension(0, 50)));
        homeSidebar.add(composeMail_Button);
        homeSidebar.add(Box.createRigidArea(new Dimension(0, 50)));
        homeSidebar.add(bulkMail_Button);
        homeSidebar.add(Box.createRigidArea(new Dimension(0, 50)));
        homeSidebar.add(manageContact_Button);
        homeSidebar.add(Box.createRigidArea(new Dimension(0, 75)));

        dashboard_button.addActionListener(this);
        composeMail_Button.addActionListener(this);
        bulkMail_Button.addActionListener(this);
        manageContact_Button.addActionListener(this);

        statsPanel.setVisible(true);

        homeSidebar.setVisible(true);
        homeSidebarUpper.setVisible(true);

        add(statsPanel);
        add(blankPanel);
        add(homeSidebar);
        add(homeSidebarUpper);

    }

    public String getB2val() {
        return b2val;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dashboard_button) {
            card.show(blankPanel, "Dashboard");
        }

        else if (e.getSource() == composeMail_Button) {
            card.show(blankPanel, "Single Email");
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
