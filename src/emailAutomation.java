import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;

import java.lang.Thread;
import java.io.IOException;

import java.util.*;
import java.util.Timer;
import java.util.Calendar;

public class emailAutomation extends JFrame {
    public static void main(String[] args) throws IOException {
        File f= new File("contacts.png");
        ArrayList emailsList= new ArrayList();
        emailsList.add("growiconic@gmail.com");
        emailsList.add("digitalhumayun@gmail.com");

        emailAutomation email;
        try {
            // Parameters for this master constructor
            // String source, boolean attachment, boolean schedule, String recipient, ArrayList emailList, String subject, String emailText , File file, String day, String month, String year
            email = new emailAutomation("bulk", true, false, null, emailsList, "Welcome To Java Bulk Attached", "JAVA is an OOP oriented language - Wonderful approach", f, null, null,  null);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


    }
    private JPanel home1;
    private JButton btn;
    private JButton btn2;
    ArrayList<String> rEmails;

    public void simpleEmails(String recipient, String subject, String emailText){
        loginScreen login= new loginScreen();


        final String email= "digitalhamayun@gmail.com"; //login.getUseremail
        final String password= "mzzxcrkeccesptuj"; //login.getUserpass
        final String host= "smtp.gmail.com";
        final String port= "587";

        Properties properties= new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        Session session= Session.getDefaultInstance(properties,
                new Authenticator(){
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email, password);
                    }
                });
        MimeMessage msg = new MimeMessage(session);
        try {

            msg.setFrom(new InternetAddress("digitalhamayun@gmail.com"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            msg.setSubject(subject);
            msg.setText(emailText);
            Transport.send(msg);


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    public void attachmentEmails(String recipient, String subject, String emailText, File file) throws IOException {

        final String email= "digitalhamayun@gmail.com";
        final String password= "mzzxcrkeccesptuj";
        final String host= "smtp.gmail.com";
        final String port= "587";

        Properties properties= new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        Session session= Session.getDefaultInstance(properties,
                new Authenticator(){
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email, password);
                    }
                });
        MimeMessage msg = new MimeMessage(session);
        try {

            msg.setFrom(new InternetAddress("digitalhamayun@gmail.com"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            msg.setSubject(subject);

            MimeBodyPart content= new MimeBodyPart();
            content.setText(emailText);
            MimeBodyPart eAttachment= new MimeBodyPart();
            eAttachment.attachFile(file);
            MimeMultipart multiEmail= new MimeMultipart();
            multiEmail.addBodyPart(content);
            multiEmail.addBodyPart(eAttachment);
            msg.setContent(multiEmail);
            Transport.send(msg);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    public void simpleBulkEmail(ArrayList emailList, String subject, String emailText ) throws MessagingException {
        final String email= "digitalhamayun@gmail.com";
        final String password= "mzzxcrkeccesptuj";
        final String host= "smtp.gmail.com";
        final String port= "587";

        Properties properties= new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        Session session= Session.getDefaultInstance(properties,
                new Authenticator(){
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email, password);
                    }
                });
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("digitalhamayun@gmail.com"));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress("growiconic@gmail.com"));
        msg.setSubject(subject);
        rEmails = emailList;

        msg.setText(emailText);
        for (String emails : rEmails) {
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(emails));
            Transport.send(msg);
        }

    }
    public void attachmentBulkEmail(ArrayList emailList, String subject, String emailText , File file) throws MessagingException, IOException {
        final String email = "digitalhamayun@gmail.com";
        final String password = "mzzxcrkeccesptuj";
        final String host = "smtp.gmail.com";
        final String port = "587";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        Session session = Session.getDefaultInstance(properties,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email, password);
                    }
                });
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("digitalhamayun@gmail.com"));
        msg.setSubject(subject);
        rEmails = emailList;

        MimeBodyPart content = new MimeBodyPart();
        content.setText(emailText);
        MimeBodyPart eAttachment = new MimeBodyPart();
        eAttachment.attachFile(file);
        MimeMultipart multiEmail = new MimeMultipart();
        multiEmail.addBodyPart(content);
        multiEmail.addBodyPart(eAttachment);
        msg.setContent(multiEmail);
        for (String emails : rEmails) {
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(emails));
            Transport.send(msg);

        }
    }


    public emailAutomation(String source, boolean attachment, boolean schedule, String recipient, ArrayList emailList, String subject, String emailText , File file, String day, String month, String year) throws MessagingException, IOException {
        setSize(400, 400);
        setResizable(false);
        setTitle("E-REM V 1.0");
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(244, 246, 248));

        boolean isScheduled= false;

        home1 = new JPanel();
        BoxLayout h1Box = new BoxLayout(home1, BoxLayout.Y_AXIS);
        home1.setLayout(h1Box);
        home1.setBackground(null);


        ImageIcon emailIcon= new ImageIcon("emailmarketing.png");
        Image eModified= emailIcon.getImage().getScaledInstance(250, 200, Image.SCALE_SMOOTH);
        emailIcon= new ImageIcon(eModified);


        JButton emailIconBtn= new JButton();
        emailIconBtn.setIcon(emailIcon);
        emailIconBtn.setBackground(null);
        emailIconBtn.setFocusable(false);
        emailIconBtn.setBorder(null);
        emailIconBtn.setMaximumSize(new Dimension(250, 250));

        btn = new JButton();
        btn.setText("SENT SUCCESSFULLY");
        btn.setFocusable(false);
        btn.setFont(new Font("Open Sans", Font.BOLD, 15));
        btn.setBackground(null);
        btn.setForeground(Color.BLACK);
        btn.setMaximumSize(new Dimension(270 , 35));


        if (source.equalsIgnoreCase("single")) {

            if (attachment == false && schedule==false) {
                simpleEmails(recipient, subject, emailText);
            }
            else if(attachment==true && schedule==false){
                attachmentEmails(recipient, subject, emailText, file);

            }
            else if (schedule == true && attachment== false){
                isScheduled= true;
               Timer t= new Timer();

               TimerTask task= new TimerTask() {
                   @Override
                   public void run() {
                       simpleEmails(recipient, subject, emailText);
                   }
               };
                Calendar fetchDate= Calendar.getInstance();
                fetchDate.set(Calendar.YEAR, Integer.parseInt(year));
                fetchDate.set(Calendar.MONTH, Integer.parseInt(month));
                fetchDate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
                fetchDate.set(Calendar.HOUR_OF_DAY, 6);
                fetchDate.set(Calendar.MINUTE, 0);
                fetchDate.set(Calendar.SECOND, 0);

                 t.schedule(task, fetchDate.getTime());
            }
            else if(schedule==true && attachment==true){
                isScheduled= true;
                Timer t= new Timer();

                TimerTask task= new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            attachmentEmails(recipient, subject, emailText, file);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                };
                Calendar fetchDate= Calendar.getInstance();
                fetchDate.set(Calendar.YEAR, Integer.parseInt(year));
                fetchDate.set(Calendar.MONTH, Integer.parseInt(month));
                fetchDate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
                fetchDate.set(Calendar.HOUR_OF_DAY, 6);
                fetchDate.set(Calendar.MINUTE, 0);
                fetchDate.set(Calendar.SECOND, 0);

                t.schedule(task, fetchDate.getTime());

            }

        }

        if (source.equalsIgnoreCase("bulk")) {

            if (attachment == false && schedule==false) {
                simpleBulkEmail(emailList, subject, emailText);

                }

            else if(attachment==true && schedule==false){
                attachmentBulkEmail(emailList, subject, emailText, file);

            }
            else if(attachment==false && schedule==true){
                isScheduled= true;
                Timer t2= new Timer();


                TimerTask task2= new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            simpleBulkEmail(emailList, subject, emailText);
                        } catch (MessagingException e) {
                            throw new RuntimeException(e);
                        }
                    }

                };
                Calendar fetchDate= Calendar.getInstance();
                fetchDate.set(Calendar.YEAR, Integer.parseInt(year));
                fetchDate.set(Calendar.MONTH, Integer.parseInt(month));
                fetchDate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
                fetchDate.set(Calendar.HOUR_OF_DAY, 6);
                fetchDate.set(Calendar.MINUTE, 0);
                fetchDate.set(Calendar.SECOND, 0);

                t2.schedule(task2, fetchDate.getTime());

            }
            else if(attachment==true && schedule==true){
                isScheduled= true;
                Timer t3= new Timer();

                TimerTask task3= new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            attachmentBulkEmail(emailList, subject, emailText, file);
                        } catch (MessagingException | IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                };
                Calendar fetchDate= Calendar.getInstance();
                fetchDate.set(Calendar.YEAR, Integer.parseInt(year));
                fetchDate.set(Calendar.MONTH, Integer.parseInt(month));
                fetchDate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
                fetchDate.set(Calendar.HOUR_OF_DAY, 6);
                fetchDate.set(Calendar.MINUTE, 0);
                fetchDate.set(Calendar.SECOND, 0);
                t3.schedule(task3, fetchDate.getTime());
            }

        }



        home1.add(Box.createRigidArea(new Dimension(105, 0)));
        home1.add(emailIconBtn);
        if (isScheduled==true){
            btn.setText("SCHEDULED SUCCESSFULLY");
        }
        home1.add(btn);
        home1.setVisible(true);
        add(home1);
    }
}
