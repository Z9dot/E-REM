import javax.mail.MessagingException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class sendSingleEmail extends JFrame implements ActionListener {
    /*public static void main(String[] args) throws IOException {
        sendSingleEmail sse = new sendSingleEmail("25", "8", "2022");
        Sidebar s = new Sidebar();
        sse.add(s.homeSidebar);
        sse.add(s.homeSidebarUpper);
        s.setVisible(true);
      //  sse.setVisible(true);
    }*/

   // private final JFrame sendSingleEmail;
    private JPanel emailStats;
    private JPanel singleForm;


    private JPanel uploadFile;
    private JPanel sidebar;
    private JPanel field1;
    private JPanel field2;
    private JPanel field3;
    private JPanel field4;
    private JPanel field5;
    private JButton sendButton;
    private JButton scheduleButton;
    private JButton emailSuccessMessage;

    private JButton txtButton;
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


    public sendSingleEmail(String d, String m, String y) throws IOException {
       // sendSingleEmail= new sendSingleEmail(null, null, null);
        setSize(1366, 768);
        setResizable(false);
        setTitle("E-REM V 1.0");
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(244, 246, 248));



        emailStats = new JPanel();
        emailStats.setBackground(Color.WHITE);
        BoxLayout h1L = new BoxLayout(emailStats, BoxLayout.X_AXIS);
        emailStats.setLayout(h1L);
        emailStats.setBounds(300, 0, 1100, 140);

        // ICON 1 OF BTN1
        ImageIcon btn1Image = new ImageIcon("email.png");
        Image btn1modified = btn1Image.getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
        btn1Image = new ImageIcon(btn1modified);

        //ICON 2 OF BTN 2
        ImageIcon btn2Image = new ImageIcon("failed.png");
        Image btn2modified = btn2Image.getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
        btn2Image = new ImageIcon(btn2modified);

        //Upload file button
        ImageIcon uploadAttachment = new ImageIcon("upload.png");
        //Image uploadAttachmentModified = uploadAttachment.getImage().getScaledInstance(500, 40, Image.SCALE_SMOOTH);
        //uploadAttachment = new ImageIcon(uploadAttachmentModified);

        ImageIcon sendEmailIcon = new ImageIcon("sendemail.png");
        Image seIModified = sendEmailIcon.getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
        sendEmailIcon = new ImageIcon(seIModified);

        ImageIcon scheduleImageIcon = new ImageIcon("scheduleemail.png");
        Image sIIModified = scheduleImageIcon.getImage().getScaledInstance(46, 41, Image.SCALE_SMOOTH);
        scheduleImageIcon = new ImageIcon(sIIModified);


        JButton b1 = new JButton();
        b1.setText("5");
        b1.setFont(new Font("Calibri", Font.BOLD, 35));
        b1.setFocusable(false);
        b1.setMaximumSize(new Dimension(280, 80));
        b1.setBackground(Color.WHITE);
        b1.setIcon(btn1Image);
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING);
        b1.setIconTextGap(180);
        b1.setBorder(new TitledBorder("SENT EMAILS"));

        JButton b2 = new JButton();
        b2.setText("10");
        b2.setFont(new Font("Calibri", Font.BOLD, 35));
        b2.setFocusable(false);
        b2.setMaximumSize(new Dimension(280, 80));
        b2.setBackground(Color.WHITE);
        b2.setIcon(btn2Image);
        // b1.setHorizontalAlignment(JButton.LEFT);
        b2.setVerticalTextPosition(AbstractButton.CENTER);
        b2.setHorizontalTextPosition(AbstractButton.LEADING);
        b2.setIconTextGap(180);
        b2.setBorder(new TitledBorder("FAILED EMAILS"));

        emailSuccessMessage = new JButton();
        emailSuccessMessage.setText("Please wait, Average remaining time (less than 8s) ");
        emailSuccessMessage.setFocusable(false);
        emailSuccessMessage.setFont(new Font("Open Sans", Font.ITALIC, 13));
        emailSuccessMessage.setBackground(null);
        emailSuccessMessage.setForeground(Color.BLACK);
        emailSuccessMessage.setMaximumSize(new Dimension(500, 35));
        emailSuccessMessage.setVisible(false);


        attachmentPresent=false;
        // Attachment button
        attachment = new JButton();
        attachment.setMaximumSize(new Dimension(64, 64));
        attachment.setIcon(uploadAttachment);
        attachment.setBackground(null);
        attachment.setBorder(null);
        attachment.setFocusable(false);
        attachment.setMaximumSize(new Dimension(64, 64));
        attachment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // open fileopener
                JFileChooser jFile= new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                int x= jFile.showOpenDialog(null);
                if (x ==JFileChooser.APPROVE_OPTION){
                    file= jFile.getSelectedFile().getAbsoluteFile();
                    attachmentPresent=true;
                }
                System.out.println("Kindly select the attachment file");

            }
        });
                // attachment.setIcon(uploadAttachment);


        singleForm = new JPanel();
        BoxLayout h2L = new BoxLayout(singleForm, BoxLayout.Y_AXIS);
        singleForm.setLayout(h2L);
        singleForm.setBounds(300, 160, 1366, 769);
        singleForm.setBackground(null);


        uploadFile = new JPanel();
        BoxLayout uploadBox = new BoxLayout(uploadFile, BoxLayout.X_AXIS);
        uploadFile.setLayout(uploadBox);
        uploadFile.setBackground(null);
        JButton uploadButton = new JButton();
        uploadButton.setBackground(null);
        // uploadFile.setBorder(BorderFactory.createEmptyBorder(0,0,0, 100));

        uploadFile.add(Box.createRigidArea(new Dimension(500, 0)));
        uploadFile.add(attachment);

        field1 = new JPanel();
        BoxLayout field1box = new BoxLayout(field1, BoxLayout.X_AXIS);
        field1.setLayout(field1box);
        field1.setBackground(null);
        rEmail = new JLabel();
        if (d!=null){
            rEmail.setText("Reminder Email: ");
        }
        else{
            rEmail.setText("Recipient Email: ");
        }

        rEmail.setFont(new Font("Open Sans", Font.BOLD, 16));
        rEmailField = new JTextField(10);
        rEmailField.setMaximumSize(new Dimension(350, 30));
        field1.setBorder(new EmptyBorder(20, 0, 0, 740));
        field1.add(rEmail);
        field1.add(Box.createRigidArea(new Dimension(40, 0)));
        field1.add(rEmailField);

        field2 = new JPanel();
        if (d!=null){
            rEmail.setText("Reminder Email: ");
        }
        else{
            rEmail.setText("Recipient Email: ");
        }
        BoxLayout field2box = new BoxLayout(field2, BoxLayout.X_AXIS);
        field2.setLayout(field2box);
        field2.setBackground(null);
        eSubject = new JLabel();
        if (d!=null){
            eSubject.setText("Reminder Info: ");
        }
        else{
            eSubject.setText("Email Subject: ");
        }
        eSubject.setFont(new Font("Open Sans", Font.BOLD, 16));
        eSubjectField = new JTextField(10);
        eSubjectField.setMaximumSize(new Dimension(900, 30));
        field2.setBorder(new EmptyBorder(20, 55, 0, 650));
        field2.add(eSubject);
        field2.add(Box.createRigidArea(new Dimension(52, 0)));
        field2.add(eSubjectField);

        field3 = new JPanel();
        BoxLayout field3box = new BoxLayout(field3, BoxLayout.X_AXIS);
        field3.setLayout(field3box);
        field3.setBackground(null);
        rMessage = new JLabel();
        if (d!=null){
            rMessage.setText("Reminder: ");
        }
        else{
            rMessage.setText("Message: ");
        }
        rMessage.setFont(new Font("Open Sans", Font.BOLD, 16));
        rMessageField = new JTextArea();
        rMessageField.setMaximumSize(new Dimension(1300, 233));
        field3.setBorder(new EmptyBorder(50, 60, 0, 540));
        field3.add(rMessage);
        field3.add(Box.createRigidArea(new Dimension(88, 0)));
        field3.add(rMessageField);

        field4 = new JPanel();
        BoxLayout field4box = new BoxLayout(field4, BoxLayout.X_AXIS);
        field4.setLayout(field4box);
        field4.setBackground(null);

        /*field5= new JPanel();
        BoxLayout field5box = new BoxLayout(field5, BoxLayout.X_AXIS);
        field4.setLayout(field5box);
        field4.setBackground(null);*/


            sendButton = new JButton();
            sendButton.setText("SEND EMAIL");
            sendButton.setVisible(true);
            sendButton.setIcon(sendEmailIcon);
            sendButton.setHorizontalTextPosition(AbstractButton.TRAILING);
            sendButton.setFocusable(false);
            sendButton.setFont(new Font("Open Sans", Font.BOLD, 16));
            sendButton.setBackground(new Color(255, 182, 117));
            sendButton.setForeground(Color.BLACK);
            sendButton.setMaximumSize(new Dimension(150, 50));
            sendButton.addActionListener(this);

        scheduleButton = new JButton();
        if (d!=null){

            scheduleButton.setText("SEND ON | "+d+"-"+m+"-"+y);
        }
        else{
            scheduleButton.setText("SCHEDULE EMAIL");
        }


        scheduleButton.setIcon(scheduleImageIcon);
        scheduleButton.setHorizontalTextPosition(AbstractButton.TRAILING);
        scheduleButton.setFocusable(false);
        scheduleButton.setForeground(Color.white);
        scheduleButton.setBackground(Color.BLACK);
        scheduleButton.setFont(new Font("Open Sans", Font.BOLD, 16));
        scheduleButton.setMaximumSize(new Dimension(150, 50));
        field4.add(Box.createRigidArea(new Dimension(50, 0)));
        scheduleButton.setVisible(true);
        field4.setBorder(new EmptyBorder(50, 60, 0, 540));
        if(d==null) {          // If date selected for reminder email purpose
            field4.add(sendButton);
        }
        field4.add(Box.createRigidArea(new Dimension(45, 0)));
        field4.add(emailSuccessMessage);
        sendButton.setVisible(true);

        scheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (d!=null) {
                    emailAutomation  scheduledFromCalendar;
                    try {
                        scheduledFromCalendar = new emailAutomation("single",attachmentPresent, true, rEmailField.getText(), null, eSubjectField.getText(), rMessageField.getText(), file, d, m, y);
                    } catch (MessagingException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    scheduledFromCalendar.setVisible(true);
                }
                else {

                    scheduleEmail schedule= new scheduleEmail("single", attachmentPresent, false, rEmailField.getText(), null, eSubjectField.getText(), rMessageField.getText(), file);
                    schedule.setVisible(true);
                }
            }
        });
        scheduleButton.setVisible(true);
        field4.add(scheduleButton);
        emailStats.add(Box.createRigidArea(new Dimension(220, 0)));
        emailStats.add(b1);
        emailStats.add(Box.createRigidArea(new Dimension(25, 0)));
        emailStats.add(b2);

        singleForm.add(uploadFile);
        singleForm.add(Box.createRigidArea(new Dimension(0, 0)));
        singleForm.add(field1);
        singleForm.add(Box.createRigidArea(new Dimension(0, 8)));
        singleForm.add(field2);
        singleForm.add(Box.createRigidArea(new Dimension(0, 0)));
        singleForm.add(field3);
        singleForm.add(Box.createRigidArea(new Dimension(0, -20)));
        singleForm.add(field4);
        //  singleForm.add(Box.createRigidArea(new Dimension(0, 7)));


        emailStats.setVisible(true);
        singleForm.setVisible(true);
        //  uploadFile.setVisible(true);


        add(emailStats);
        add(singleForm);
        //  add(uploadFile);
        Sidebar sb = null;
        try {
            sb = new Sidebar();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        add(sb.homeSidebar);
        add(sb.homeSidebarUpper);
        sb.setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == sendButton) {


            try {
                emailAutomation instantEmail= new emailAutomation("single",attachmentPresent, false, rEmailField.getText(), null, eSubjectField.getText(), rMessageField.getText(), file, null, null, null);
                instantEmail.setVisible(true);
            } catch (MessagingException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }


    }



}





