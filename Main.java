import java.security.DomainLoadStoreParameter;
import java.util.*;

//Filing Imports
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.io.*;

// Swing GUI
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;
//import java.awt.Color;

// Date GUI
import java.util.Calendar;
import java.util.Date;

import com.sun.source.tree.BlockTree;
import org.jdatepicker.*;

import javax.mail.impl.*;



class Main {
    public static void main(String[] args) throws IOException {
        loginScreen login= new loginScreen();
        login.setVisible(true);


    }
}




























































        /* JFrame f1= new JFrame();
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setSize(1366, 768);
        f1.setResizable(false);
        f1.setTitle("E-REM V 1.0");
        f1.setLocationRelativeTo(null);
        f1.getContentPane().setBackground(new Color(233,242,246));

        JPanel pleft= new JPanel();
        BoxLayout box= new BoxLayout(pleft, BoxLayout.Y_AXIS);
        pleft.setLayout(box);
        pleft.setBackground(Color.white);
        pleft.setBounds(0, 0, 600, 768);


       // pleft.setBorder(new LineBorder(Color.ORANGE, 3));

        JPanel pright= new JPanel();
        pright.setLayout(null);
        pright.setBounds(100, 150, 819, 768);
        pright.setBackground(Color.ORANGE);

        // THE LOGIN FIELDS PANEL
       // JPanel loginFields= new JPanel();
       // BoxLayout boxLogin= new BoxLayout(loginFields, BoxLayout.Y_AXIS);
        //loginFields.setLayout(boxLogin);

        // gl.setVgap(1);

      // loginFields.setBounds(100, 100, loginFields.getWidth(), loginFields.getHeight());
        JLabel emailL= new JLabel("Enter Email: ");
        //   emailL.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextField enterEmail= new JTextField(2);
     //   enterEmail.setHorizontalAlignment(SwingConstants.LEFT);
        //enterEmail.setAlignmentX(Component.LEFT_ALIGNMENT);
        enterEmail.setMaximumSize(new Dimension(300, 40));
      //  enterEmail.setAlignmentX(Component.CENTER_ALIGNMENT);

        //enterEmail.setMaximumSize(new Dimension(700,100));

        JLabel passL= new JLabel("Enter Password: ");
        JTextField enterPass= new JTextField(2);
        enterPass.setMaximumSize(new Dimension(300, 40));
       // enterPass.setAlignmentX(Component.CENTER_ALIGNMENT);
       // enterPass.setMaximumSize(new Dimension(700,100));

        //enterEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
       // enterPass.setAlignmentX(Component.CENTER_ALIGNMENT);


      //  loginFields.add(Box.createVerticalGlue());


      //  loginFields.setBounds(-30, 200, 600, 300);
     //   loginFields.setAlignmentX(Component.CENTER_ALIGNMENT);



        ImageIcon logo= new ImageIcon("erem logo.png");
        Image logoModified= logo.getImage().getScaledInstance(105, 145, Image.SCALE_SMOOTH);
        logo= new ImageIcon(logoModified);
        JLabel logoL= new JLabel(logo);
        logoL.setAlignmentX(Component.CENTER_ALIGNMENT);
        //logoL.setBounds(-30, -10, 600, 300);
       // label.setHorizontalAlignment(JLabel.CENTER);
        //label.setBackground(new Color(000000));
        //label.setFont(new Font("Verdana", Font.PLAIN, 25));
      //  logo.setVisible(true);


        // The account icon section
        ImageIcon accIcon= new ImageIcon("account icon.png");
        Image aiOriginal= accIcon.getImage();
        Image aiModified= aiOriginal.getScaledInstance(48, 48, Image.SCALE_SMOOTH);
        accIcon= new ImageIcon(aiModified);

        JLabel accCredentials= new JLabel();
        accCredentials.setText("<html>digitalhamayun@gmail.com<br>Status: Active</html>");
        accCredentials.setIcon(accIcon);
      //  accCredentials.setHorizontalAlignment(JLabel.CENTER);




        // The log in button


        ImageIcon loginButtonImage= new ImageIcon("sign in button.png");
        Image lbiModified= loginButtonImage.getImage().getScaledInstance(255, 80, Image.SCALE_SMOOTH);
        JButton logIn= new JButton(new ImageIcon(lbiModified));
        logIn.setMaximumSize(new Dimension(245, 60));
        logIn.setAlignmentX(Component.CENTER_ALIGNMENT);

        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    homeScreen homeS= new homeScreen();
                    homeS.setVisible(true);
                    f1.dispose();
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
        f1.add(pleft);
        f1.add(pright);
        f1.setVisible(true);*/








     //   sendEmail sE= new sendEmail();




       // label.setIconTextGap(-40);
        //ImageIcon img1= new ImageIcon("");



        // Date Selector
        /*UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        f1.add(datePanel);*/

































        /*Student s1= new Student("Hamayun", "hamayun@gmail.com", "male", "bse-082", "third", 3.5, "Comsats University",  "Software Engineering");
        Student s2= new Student("Salman", "salman@gmail.com", "male", "bse-077", "third", 3.5, "Comsats University",  "Software Engineering");
        ArrayList<Student> arr= new ArrayList<>();
        File f= new File("Students.dat");

        addStudent(s1, f, arr);
        addStudent(s2, f, arr);
        displayStudents(f);
        searchStudent(f, "bse-082");
        deleteStudent(f, "bse-077");
        updateStudentEmail(f, "bse-077", "sm@gmail.com");
        updateStudentDepartment(f, "bse-077", "Computer Science");
        countProbStudents(f);
        displayDepartmentStudents(f, "Software Engineering");
        deleteDepartmentStudents(f, "Software Engineering");



    }

    public static void addStudent(Student s1, File f, ArrayList arr ) throws IOException {
        ObjectOutputStream output= new ObjectOutputStream(new FileOutputStream(f, true));
        output.writeObject(arr);
        output.close();

    }
    public static void displayStudents(File f) throws IOException, ClassNotFoundException {
        ObjectInputStream input= new ObjectInputStream(new FileInputStream(f));
        ArrayList<Student> std= (ArrayList) (input.readObject());
        // Reading the array:
        for (int i=0; i<std.size(); i++){
            System.out.println(std.get(i).toString());
        }
        input.close();
    }
    public static void searchStudent(File f, String regNo ) throws IOException, ClassNotFoundException {
        ObjectInputStream input= new ObjectInputStream(new FileInputStream(f));
        ArrayList<Student> stdSearch= (ArrayList) (input.readObject());
        for(int i=0; i<stdSearch.size(); i++){
            if(stdSearch.get(i).getRegNo() == regNo){
                System.out.println("Yes, the student is present ");
            }
            System.out.println("No, the student is not present");
        }
        input.close();
    }
    public static void deleteStudent(File f, String rNo) throws IOException, ClassNotFoundException {
        ObjectInputStream input= new ObjectInputStream(new FileInputStream(f));
        ArrayList<Student> stdDelete= (ArrayList) (input.readObject());
        for(int i=0; i< stdDelete.size(); i++){
            if (stdDelete.get(i).getRegNo()==rNo){
                stdDelete.remove(i);
                System.out.println("Student Deleted...");
            }
        }
        input.close();
        // To rewrite the file
        ObjectOutputStream output= new ObjectOutputStream(new FileOutputStream(f));
        output.writeObject(stdDelete);
        output.close();

    }

    public static void updateStudentEmail(File f, String regNo, String email) throws IOException, ClassNotFoundException {
        ObjectInputStream input= new ObjectInputStream(new FileInputStream(f));
        ArrayList<Student> uemail= (ArrayList) (input.readObject());
        for(int i=0; i<uemail.size(); i++) {
            if (uemail.get(i).getRegNo() == regNo) {
                uemail.get(i).setEmail(email);
                System.out.println("Email Updated...");
            }
        }
        input.close();
        ObjectOutputStream output= new ObjectOutputStream(new FileOutputStream(f));
        output.writeObject(uemail);
        output.close();
    }
    public static void updateStudentDepartment(File f, String regNo, String department) throws IOException, ClassNotFoundException {
        ObjectInputStream input= new ObjectInputStream(new FileInputStream(f));
        ArrayList<Student> udep= (ArrayList) (input.readObject());
        for(int i=0; i<udep.size(); i++) {
            if (udep.get(i).getRegNo() == regNo) {
                udep.get(i).setDepartment(department);
                System.out.println("Department Updated...");
            }
        }
        input.close();

        ObjectOutputStream output= new ObjectOutputStream(new FileOutputStream(f));
        output.writeObject(udep);
        output.close();
    }
    public static void countProbStudents(File f) throws IOException, ClassNotFoundException {
        int totalProbStudents= 0;
        ObjectInputStream input= new ObjectInputStream(new FileInputStream(f));
        ArrayList<Student> arr= (ArrayList) (input.readObject());
        for(int i=0; i<arr.size(); i++) {
            if (arr.get(i).getGpa() < 2.0) {
                totalProbStudents++;
            }
        }
        input.close();
    }

    public static void displayDepartmentStudents(File f, String dep) throws IOException, ClassNotFoundException {
        ObjectInputStream input= new ObjectInputStream(new FileInputStream(f));
        ArrayList<Student> arr= (ArrayList) (input.readObject());
        for(int i=0; i<arr.size(); i++) {
            if (arr.get(i).getDepartment() == dep) {
                System.out.println(arr.get(i).toString());
            }
        }
        input.close();
    }
    public static void deleteDepartmentStudents(File f, String dep) throws IOException, ClassNotFoundException {
        ObjectInputStream input= new ObjectInputStream(new FileInputStream(f));
        ArrayList<Student> arr= (ArrayList) (input.readObject());
        for(int i=0; i<arr.size(); i++) {
            if (arr.get(i).getDepartment() == dep) {
                arr.remove(i);
            }
        }
        input.close();

    }

}
*/

















