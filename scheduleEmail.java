import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;


public class scheduleEmail extends JFrame {


    private JPanel home1;
    private JButton semailButton;
    private JDatePanelImpl datePanel;

    private String sendDate;
    private String sendMonth;
    private String sendYear;


    public scheduleEmail(String source, boolean attachmentPresent, boolean schedule, String recipient, ArrayList emailList, String subject, String emailText , File file)  {
        setSize(400, 400);
        setResizable(false);
        setTitle("E-REM V 1.0");
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(244, 246, 248));


        home1 = new JPanel();
        BoxLayout h1Box = new BoxLayout(home1, BoxLayout.Y_AXIS);
        home1.setLayout(h1Box);

        // Date Selector
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        datePanel = new JDatePanelImpl(model, p);

        semailButton = new JButton("SCHEDULE");
        semailButton.setFocusable(false);
        semailButton.setFont(new Font("Open Sans", Font.BOLD, 16));
        semailButton.setBackground(Color.ORANGE);
        semailButton.setForeground(Color.WHITE);
        semailButton.setPreferredSize(new Dimension(20, 20));
        semailButton.setFont(new Font("Open Sans", Font.BOLD, 18));
        semailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String day= String.valueOf(datePanel.getModel().getDay());
                String month= String.valueOf(datePanel.getModel().getMonth());
                String year= String.valueOf(datePanel.getModel().getYear());
                try {
                    emailAutomation schedulethis= new emailAutomation(source,attachmentPresent, schedule, recipient, emailList, subject, emailText, file, day, month, year);
                    schedulethis.setVisible(true);
                    dispose();

                } catch (MessagingException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        datePanel.setVisible(true);
        semailButton.setVisible(true);
        add(datePanel, BorderLayout.NORTH);
        add(semailButton, BorderLayout.CENTER);



    }
}




