import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.color.ICC_ColorSpace;

import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class sendBulkEmail extends JFrame implements ActionListener {
    // public static void main(String[] args) throws IOException {
    // sendBulkEmail sbe = new sendBulkEmail();
    // Sidebar s = new Sidebar();
    // sbe.add(s.homeSidebar);
    // sbe.add(s.homeSidebarUpper);
    // s.setVisible(true);
    // sbe.setVisible(true);
    // }

    private JPanel bulkEmailPanel;
    private JPanel reciepentsMailField;
    private JLabel rEmail;
    private JTextField rEmailField;
    private Container subjectField;
    private Container eSubject;
    private JPanel messageBoxField;
    private JLabel rMessage;
    private JPanel buttonsPanel;
    private JButton emailSuccessMessage;
    private JButton sendButton;
    private JButton scheduleButton;
    private JTextField eSubjectField;
    private JTextArea rMessageField;
    private JButton attachment;
    private JButton addReciepentButton;
    private ImageIcon addIcon;
    private ImageIcon fAdd;

    public JPanel bulkEmailPanel() {
        bulkEmailPanel = new JPanel();
        BoxLayout h2L = new BoxLayout(bulkEmailPanel, BoxLayout.Y_AXIS);
        bulkEmailPanel.setLayout(h2L);
        bulkEmailPanel.setBounds(300, 140, 1000, 550);

        // reciepent mail
        reciepentsMailField = new JPanel();
        BoxLayout reciepentMailbox = new BoxLayout(reciepentsMailField, BoxLayout.X_AXIS);
        reciepentsMailField.setLayout(reciepentMailbox);
        reciepentsMailField.setBackground(null);
        rEmail = new JLabel("Recipient Email: ");
        rEmail.setFont(new Font("Open Sans", Font.BOLD, 16));
        rEmailField = new JTextField(20);
        rEmailField.setMaximumSize(new Dimension(800, 25));
        reciepentsMailField.setBorder(new EmptyBorder(20, 54, 0, 250));
        addReciepentButton = new JButton();
        addIcon = new ImageIcon("Images/add email.png");
        Image add = addIcon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        fAdd = new ImageIcon(add);
        addReciepentButton.setIcon(fAdd);
        addReciepentButton.setFocusable(false);
        addReciepentButton.setPreferredSize(new Dimension(10, 8));
        reciepentsMailField.add(rEmail);
        reciepentsMailField.add(Box.createRigidArea(new Dimension(40, 0)));
        reciepentsMailField.add(rEmailField);
        reciepentsMailField.add(addReciepentButton);

        // Subject
        subjectField = new JPanel();
        BoxLayout field2box = new BoxLayout(subjectField, BoxLayout.X_AXIS);
        subjectField.setLayout(field2box);
        subjectField.setBackground(null);
        eSubject = new JLabel("Email Subject: ");
        eSubject.setFont(new Font("Open Sans", Font.BOLD, 16));
        eSubjectField = new JTextField(10);
        eSubjectField.setMaximumSize(new Dimension(900, 20));
        ((JComponent) subjectField).setBorder(new EmptyBorder(20, 55, 0, 250));
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

        // bulkEmailPanel.add(uploadFile);
        bulkEmailPanel.add(Box.createRigidArea(new Dimension(0, 0)));
        bulkEmailPanel.add(reciepentsMailField);
        bulkEmailPanel.add(Box.createRigidArea(new Dimension(0, 8)));
        bulkEmailPanel.add(subjectField);
        bulkEmailPanel.add(Box.createRigidArea(new Dimension(0, 0)));
        bulkEmailPanel.add(messageBoxField);
        bulkEmailPanel.add(Box.createRigidArea(new Dimension(0, -20)));
        bulkEmailPanel.add(buttonsPanel);
        bulkEmailPanel.setVisible(true);
        return bulkEmailPanel;
    }

    private JPanel emailStats;
    private JPanel singleForm;
    private File fileEmails;
    private File FileOfEmails;

    private File file;
    private boolean attachmentPresent;

    private JPanel uploadFile;
    private JPanel sidebar;
    private JPanel field1;
    private JPanel field2;
    private JPanel field3;
    private JPanel field4;

    private ArrayList bulkEmails;

    public sendBulkEmail() throws IOException {
        // setSize(1366, 768);
        // setResizable(false);
        // setTitle("E-REM V 1.0");
        // setLayout(null);
        // setLocationRelativeTo(null);
        // getContentPane().setBackground(new Color(244, 246, 248));

        // Sidebar s = null;
        // try {
        // s = new Sidebar();
        // } catch (IOException ex) {
        // throw new RuntimeException(ex);
        // }
        // add(s.homeSidebar);
        // add(s.homeSidebarUpper);
        // s.setVisible(true);

        // emailStats = new JPanel();
        // emailStats.setBackground(Color.WHITE);
        // BoxLayout h1L = new BoxLayout(emailStats, BoxLayout.X_AXIS);
        // emailStats.setLayout(h1L);
        // emailStats.setBounds(300, 0, 1100, 140);

        // // ICON 1 OF BTN1
        // ImageIcon btn1Image = new ImageIcon("email.png");
        // Image btn1modified = btn1Image.getImage().getScaledInstance(48, 48,
        // Image.SCALE_SMOOTH);
        // btn1Image = new ImageIcon(btn1modified);

        // // ICON 2 OF BTN 2
        // ImageIcon btn2Image = new ImageIcon("failed.png");
        // Image btn2modified = btn2Image.getImage().getScaledInstance(48, 48,
        // Image.SCALE_SMOOTH);
        // btn2Image = new ImageIcon(btn2modified);

        // // Upload file button
        // ImageIcon uploadAttachment = new ImageIcon("upload.png");
        // // Image uploadAttachmentModified =
        // // uploadAttachment.getImage().getScaledInstance(500, 40,
        // Image.SCALE_SMOOTH);
        // // uploadAttachment = new ImageIcon(uploadAttachmentModified);

        // ImageIcon sendEmailIcon = new ImageIcon("sendemail.png");
        // Image seIModified = sendEmailIcon.getImage().getScaledInstance(48, 48,
        // Image.SCALE_SMOOTH);
        // sendEmailIcon = new ImageIcon(seIModified);

        // ImageIcon scheduleImageIcon = new ImageIcon("scheduleemail.png");
        // Image sIIModified = scheduleImageIcon.getImage().getScaledInstance(46, 41,
        // Image.SCALE_SMOOTH);
        // scheduleImageIcon = new ImageIcon(sIIModified);

        // JButton b1 = new JButton();
        // b1.setText("5");
        // b1.setFont(new Font("Calibri", Font.BOLD, 35));
        // b1.setFocusable(false);
        // b1.setMaximumSize(new Dimension(280, 80));
        // b1.setBackground(Color.WHITE);
        // b1.setIcon(btn1Image);
        // b1.setVerticalTextPosition(AbstractButton.CENTER);
        // b1.setHorizontalTextPosition(AbstractButton.LEADING);
        // b1.setIconTextGap(180);
        // b1.setBorder(new TitledBorder("SENT EMAILS"));

        // JButton b2 = new JButton();
        // b2.setText("10");
        // b2.setFont(new Font("Calibri", Font.BOLD, 35));
        // b2.setFocusable(false);
        // b2.setMaximumSize(new Dimension(280, 80));
        // b2.setBackground(Color.WHITE);
        // b2.setIcon(btn2Image);
        // // b1.setHorizontalAlignment(JButton.LEFT);
        // b2.setVerticalTextPosition(AbstractButton.CENTER);
        // b2.setHorizontalTextPosition(AbstractButton.LEADING);
        // b2.setIconTextGap(180);
        // b2.setBorder(new TitledBorder("FAILED EMAILS"));

        // // Attachment button
        // attachment = new JButton();
        // attachment.setMaximumSize(new Dimension(64, 64));
        // attachment.setIcon(uploadAttachment);
        // attachment.setBackground(null);
        // attachment.setBorder(null);
        // attachment.setFocusable(false);
        // attachment.setMaximumSize(new Dimension(64, 64));
        // attachment.addActionListener(this);

        // // Import txt file button
        // txtButton = new JButton("IMPORT EMAILS");
        // txtButton.setIcon(sendEmailIcon);
        // txtButton.setHorizontalTextPosition(AbstractButton.TRAILING);
        // txtButton.setFocusable(false);
        // txtButton.setFont(new Font("Open Sans", Font.BOLD, 16));
        // txtButton.setBackground(new Color(255, 182, 117));
        // txtButton.setForeground(Color.BLACK);
        // txtButton.setMaximumSize(new Dimension(250, 40));
        // txtButton.addActionListener(this);

        // singleForm = new JPanel();
        // BoxLayout h2L = new BoxLayout(singleForm, BoxLayout.Y_AXIS);
        // singleForm.setLayout(h2L);
        // singleForm.setBounds(300, 160, 1366, 769);
        // singleForm.setBackground(null);

        // uploadFile = new JPanel();
        // BoxLayout uploadBox = new BoxLayout(uploadFile, BoxLayout.X_AXIS);
        // uploadFile.setLayout(uploadBox);
        // uploadFile.setBackground(null);
        // JButton uploadButton = new JButton();
        // uploadButton.setBackground(null);

        // uploadFile.add(Box.createRigidArea(new Dimension(500, 0)));
        // uploadFile.add(attachment);

        // field1 = new JPanel();
        // BoxLayout field1box = new BoxLayout(field1, BoxLayout.X_AXIS);
        // field1.setLayout(field1box);
        // field1.setBackground(null);
        // JLabel rEmail = new JLabel("Recipient Emails: ");
        // rEmail.setFont(new Font("Open Sans", Font.BOLD, 16));
        // field1.setBorder(new EmptyBorder(20, 0, 0, 842));
        // field1.add(rEmail);
        // field1.add(Box.createRigidArea(new Dimension(40, 0)));
        // field1.add(txtButton);

        // field2 = new JPanel();
        // BoxLayout field2box = new BoxLayout(field2, BoxLayout.X_AXIS);
        // field2.setLayout(field2box);
        // field2.setBackground(null);
        // JLabel eSubject = new JLabel("Email Subject: ");
        // eSubject.setFont(new Font("Open Sans", Font.BOLD, 16));
        // eSubjectField = new JTextField(10);
        // eSubjectField.setMaximumSize(new Dimension(900, 30));
        // field2.setBorder(new EmptyBorder(20, 55, 0, 650));
        // field2.add(eSubject);
        // field2.add(Box.createRigidArea(new Dimension(52, 0)));
        // field2.add(eSubjectField);

        // field3 = new JPanel();
        // BoxLayout field3box = new BoxLayout(field3, BoxLayout.X_AXIS);
        // field3.setLayout(field3box);
        // field3.setBackground(null);
        // JLabel rMessage = new JLabel("Message: ");
        // rMessage.setFont(new Font("Open Sans", Font.BOLD, 16));
        // rMessageField = new JTextArea();
        // // rMessageField.setBackground(Color.lightGray);
        // rMessageField.setBorder(new LineBorder(Color.lightGray, 1));
        // rMessageField.setMaximumSize(new Dimension(1300, 233));
        // field3.setBorder(new EmptyBorder(50, 60, 0, 540));
        // field3.add(rMessage);
        // field3.add(Box.createRigidArea(new Dimension(88, 0)));
        // field3.add(rMessageField);

        // field4 = new JPanel();
        // BoxLayout field4box = new BoxLayout(field4, BoxLayout.X_AXIS);
        // field4.setLayout(field4box);
        // field4.setBackground(null);

        // sendButton = new JButton("SEND EMAIL");
        // sendButton.setIcon(sendEmailIcon);
        // sendButton.setHorizontalTextPosition(AbstractButton.TRAILING);
        // sendButton.setFocusable(false);
        // sendButton.setFont(new Font("Open Sans", Font.BOLD, 16));
        // sendButton.setBackground(new Color(255, 182, 117));
        // sendButton.setForeground(Color.BLACK);
        // sendButton.setMaximumSize(new Dimension(150, 50));
        // sendButton.addActionListener(this);

        // scheduleButton = new JButton("SCHEDULE EMAIL");
        // scheduleButton.setIcon(scheduleImageIcon);
        // scheduleButton.setHorizontalTextPosition(AbstractButton.TRAILING);
        // scheduleButton.setFocusable(false);
        // scheduleButton.setForeground(Color.white);
        // scheduleButton.setBackground(Color.BLACK);
        // scheduleButton.setFont(new Font("Open Sans", Font.BOLD, 16));
        // scheduleButton.setMaximumSize(new Dimension(150, 50));
        // scheduleButton.addActionListener(this);
        // field4.setBorder(new EmptyBorder(50, 60, 0, 540));

        // field4.add(sendButton);
        // field4.add(Box.createRigidArea(new Dimension(50, 0)));
        // field4.add(scheduleButton);

        // emailStats.add(Box.createRigidArea(new Dimension(220, 0)));
        // emailStats.add(b1);
        // emailStats.add(Box.createRigidArea(new Dimension(25, 0)));
        // emailStats.add(b2);

        // singleForm.add(uploadFile);
        // singleForm.add(Box.createRigidArea(new Dimension(0, 0)));
        // singleForm.add(field1);
        // singleForm.add(Box.createRigidArea(new Dimension(0, 8)));
        // singleForm.add(field2);
        // singleForm.add(Box.createRigidArea(new Dimension(0, 0)));
        // singleForm.add(field3);
        // singleForm.add(Box.createRigidArea(new Dimension(0, -20)));
        // singleForm.add(field4);
        // // singleForm.add(Box.createRigidArea(new Dimension(0, 7)));

        // emailStats.setVisible(true);
        // singleForm.setVisible(true);
        // // uploadFile.setVisible(true);

        // add(emailStats);
        // add(singleForm);
        // // add(uploadFile);

        // }

        // @Override
        // public void actionPerformed(ActionEvent e) {
        // if (e.getSource() == txtButton) {
        // bulkEmails = new ArrayList();
        // // open fileopener
        // JFileChooser jFile2 = new
        // JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        // int x = jFile2.showOpenDialog(this);
        // if (x == JFileChooser.APPROVE_OPTION) {
        // fileEmails = jFile2.getSelectedFile().getAbsoluteFile();
        // FileOfEmails = fileEmails;
        // txtButton.setText(FileOfEmails.getName());

        // } else {
        // System.out.println("Kindly select the attachment file");
        // }
        // try {
        // Scanner sc = new Scanner(FileOfEmails);
        // while (sc.hasNext()) {
        // String getEmail = sc.nextLine();
        // bulkEmails.add(getEmail);
        // }
        // } catch (FileNotFoundException ex) {
        // throw new RuntimeException(ex);
        // }

        // }
        // if (e.getSource() == attachment) {

        // // open fileopener
        // JFileChooser jFile = new
        // JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        // int x = jFile.showOpenDialog(this);
        // if (x == JFileChooser.APPROVE_OPTION) {
        // file = jFile.getSelectedFile().getAbsoluteFile();
        // attachmentPresent = true;
        // }
        // System.out.println("Kindly select the attachment file");

        // }
        // if (e.getSource() == sendButton) {
        // // String source, boolean attachment, boolean schedule, String recipient,
        // // ArrayList emailList, String subject, String emailText , File file, String
        // // day, String month, String year
        // // emailSuccessMessage.setVisible(true);

        // if (e.getSource() == scheduleButton) {
        // scheduleEmail schedule = new scheduleEmail("bulk", attachmentPresent, true,
        // rMessageField.getText(),
        // bulkEmails, eSubjectField.getText(), rMessageField.getText(), file);
        // schedule.setVisible(true);

        // }
        // }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
