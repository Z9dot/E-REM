 //package Calander;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.*;
public class Calander extends JFrame{
    public static void main(String[] args){
    Calander cl= new Calander(2, 2, 2023);
    cl.setVisible(true);
    }

    JFrame calander;
    JPanel main;
    JPanel firstRowPanel;
    Date defaultToday;
    myDate dateBreakDown;
    String monthYearName;
    JLabel monthNameLabel;
    Integer mArray[];
    Integer monthSelected;
    Integer yArray[];
    Integer yearSelected;
    JComboBox dropDownMonth;
    JComboBox dropDownYear;
    JButton show;
    JPanel secondRowPanel;
    String daysList[];
    JPanel[] daysNamePanels;
    JLabel[] daysNameLabels;
    myDate monthDate;
    String dayOfDate;
    JPanel thirdRowPanel;
    JPanel[] thirdRowPanels;
    JButton first[];
    JPanel fourthRowPanel;
    JPanel[] fourthRowPanels;
    JButton second[];
    JPanel fifthRowPanel;
    JPanel[] fifthRowPanels;
    JButton third[];
    JPanel sixthRowPanel;
    JPanel[] sixthRowPanels;
    JButton fourth[];
    JPanel seventhRowPanel;
    JPanel[] seventhRowPanels;
    JButton fifth[];
    JPanel eighthRowPanel;
    JPanel[] eighthRowPanels;
    JButton sixth[];

    public Calander(int date, int month, int year)
    {
        calander=new JFrame();
        calander.setSize(1366,768);
        calander.setResizable(false);
        calander.setLayout(null);
        mainPanelCreation(date,month,year);
        calander.add(main);
        calander.setVisible(true);
    }

    public void mainPanelCreation(int date, int month, int year)
    {
        main=new JPanel();
        main.setBounds(300,140,1066,628);
        main.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        main.setLayout(new GridLayout(9,1));
        firstRowPanel=new JPanel();
        SpringLayout firstRowPanelLayout=new SpringLayout();
        firstRowPanel.setLayout(firstRowPanelLayout);
        setMonthYear(date,month,year);
        dropBoxes();
        firstRowPanel.add(monthNameLabel);
        firstRowPanelLayout.putConstraint(SpringLayout.WEST,monthNameLabel,330,SpringLayout.WEST,firstRowPanel);
        firstRowPanelLayout.putConstraint(SpringLayout.NORTH,monthNameLabel,30,SpringLayout.NORTH,firstRowPanel);
        firstRowPanel.add(dropDownMonth);
        firstRowPanelLayout.putConstraint(SpringLayout.WEST,dropDownMonth,750,SpringLayout.WEST,firstRowPanel);
        firstRowPanelLayout.putConstraint(SpringLayout.NORTH,dropDownMonth,30,SpringLayout.NORTH,firstRowPanel);
        firstRowPanel.add(dropDownYear);
        firstRowPanelLayout.putConstraint(SpringLayout.WEST,dropDownYear,840,SpringLayout.WEST,firstRowPanel);
        firstRowPanelLayout.putConstraint(SpringLayout.NORTH,dropDownYear,30,SpringLayout.NORTH,firstRowPanel);
        firstRowPanel.add(show);
        firstRowPanelLayout.putConstraint(SpringLayout.WEST,show,950,SpringLayout.WEST,firstRowPanel);
        firstRowPanelLayout.putConstraint(SpringLayout.NORTH,show,30,SpringLayout.NORTH,firstRowPanel);
        secondRowPanel=new JPanel();
        secondRowPanel.setLayout(new GridLayout(1,8));
        daysListCreater();
        thirdRowPanel=new JPanel();
        thirdRowPanel.setLayout(new GridLayout(1,7));
        fourthRowPanel=new JPanel();
        fourthRowPanel.setLayout(new GridLayout(1,7));
        fifthRowPanel=new JPanel();
        fifthRowPanel.setLayout(new GridLayout(1,7));
        sixthRowPanel=new JPanel();
        sixthRowPanel.setLayout(new GridLayout(1,7));
        seventhRowPanel=new JPanel();
        seventhRowPanel.setLayout(new GridLayout(1,7));
        eighthRowPanel=new JPanel();
        eighthRowPanel.setLayout(new GridLayout(1,7));
        calanderDateFiller();
        main.add(firstRowPanel);
        main.add(secondRowPanel);
        main.add(thirdRowPanel);
        main.add(fourthRowPanel);
        main.add(fifthRowPanel);
        main.add(sixthRowPanel);
        main.add(seventhRowPanel);
        main.add(eighthRowPanel);
    }

    public void setMonthYear(int date, int month, int year)
    {
        defaultToday=new Date(year-1900,month-1,date);
        dateBreakDown=new myDate(defaultToday.getDate(),defaultToday.getMonth(),defaultToday.getYear());
        monthYearName=dateBreakDown.getMyMonth(defaultToday.getMonth())+" "+dateBreakDown.getMyYear();
        monthNameLabel=new JLabel(monthYearName);
        Font fontMonthName= new Font(monthYearName, Font.BOLD, 30);
        monthNameLabel.setFont(fontMonthName);
    }

    public void dropBoxes()
    {
        mArray= new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        dropDownMonth=new JComboBox(mArray);
        yArray= new Integer[]{2022,2023,2024,2025,2026,2027,2028,2029,2030,2031,2032};
        dropDownYear=new JComboBox(yArray);
        show=new JButton("Show");
        show.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                monthSelected=dropDownMonth.getSelectedIndex();
                yearSelected=dropDownYear.getSelectedIndex();
                calander.remove(main);
                mainPanelCreation(15,monthSelected+1,yearSelected);
                calander.add(main);
                dropDownMonth.setSelectedIndex(monthSelected);
                dropDownYear.setSelectedIndex(yearSelected);
                calander.setVisible(true);
            }
        });
    }

    public void daysListCreater()
    {
        daysList= new String[]{"Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat"};
        daysNamePanels=new JPanel[7];
        for (int i=0; i< daysNamePanels.length; i++)
        {
            daysNamePanels[i]=new JPanel();
        }
        daysNameLabels=new JLabel[7];
        for(int i=0; i< daysList.length; i++)
        {
            SpringLayout secondRowInnerPanelsLayout=new SpringLayout();
            daysNamePanels[i].setLayout(secondRowInnerPanelsLayout);
            daysNameLabels[i]=new JLabel(daysList[i]);
            Font fontDayName= new Font(daysList[i], Font.BOLD, 20);
            daysNameLabels[i].setFont(fontDayName);
            daysNamePanels[i].add(daysNameLabels[i]);
            secondRowInnerPanelsLayout.putConstraint(SpringLayout.WEST,daysNameLabels[i],57,SpringLayout.WEST,daysNamePanels[i]);
            secondRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH,daysNameLabels[i],30,SpringLayout.NORTH,daysNamePanels[i]);
            secondRowPanel.add(daysNamePanels[i]);
        }
    }

    public void calanderDateFiller() {
        String monthsList[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        if (dateBreakDown.getMyMonth(defaultToday.getMonth()) == monthsList[0] || dateBreakDown.getMyMonth(defaultToday.getMonth()) == monthsList[2] || dateBreakDown.getMyMonth(defaultToday.getMonth()) == monthsList[4] || dateBreakDown.getMyMonth(defaultToday.getMonth()) == monthsList[6] || dateBreakDown.getMyMonth(defaultToday.getMonth()) == monthsList[7] || dateBreakDown.getMyMonth(defaultToday.getMonth()) == monthsList[9] || dateBreakDown.getMyMonth(defaultToday.getMonth()) == monthsList[11])
        {
            int startDate=1;
            monthDate=new myDate(startDate,defaultToday.getMonth(),defaultToday.getYear());
            int intDayOfDate=monthDate.getMyIntDay();
            dayOfDate=monthDate.getMyDay(intDayOfDate);
            int count=intDayOfDate;
            first=new JButton[7];
            int prevMonthNumberOfDates=count-1;
            int thirtyOne=31;
            int thirty=30;
            int twentyNine=29;
            for(int a=prevMonthNumberOfDates; a>=0; a--)
            {
                String s=0+"";
                if(dateBreakDown.getMyMonth(defaultToday.getMonth()-1)==monthsList[0]||dateBreakDown.getMyMonth(defaultToday.getMonth()-1)==monthsList[2]||dateBreakDown.getMyMonth(defaultToday.getMonth()-1)==monthsList[4]||dateBreakDown.getMyMonth(defaultToday.getMonth()-1)==monthsList[6]||dateBreakDown.getMyMonth(defaultToday.getMonth()-1)==monthsList[7]||dateBreakDown.getMyMonth(defaultToday.getMonth()-1)==monthsList[9]||dateBreakDown.getMyMonth(defaultToday.getMonth()-1)==monthsList[11])
                {
                    s=(thirtyOne-(1*(prevMonthNumberOfDates-a)))+"";
                }
                if(dateBreakDown.getMyMonth(defaultToday.getMonth()-1)==monthsList[3]||dateBreakDown.getMyMonth(defaultToday.getMonth()-1)==monthsList[5]||dateBreakDown.getMyMonth(defaultToday.getMonth()-1)==monthsList[8]||dateBreakDown.getMyMonth(defaultToday.getMonth()-1)==monthsList[10])
                {
                    s=(thirty-(1*(prevMonthNumberOfDates-a)))+"";
                }
                if(dateBreakDown.getMyMonth(defaultToday.getMonth()-1)==monthsList[1])
                {
                    s=(twentyNine-(1*(prevMonthNumberOfDates-a)))+"";
                }
                first[a]=new JButton(s);
                first[a].setPreferredSize(new Dimension(142,65));
                first[a].addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                         sendSingleEmail sse= null;
                        try {
                            sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        sse.setVisible(true);
                    }
                });
            }
            int arrayCounter=1;
            for(int b=count; b<first.length; b++)
            {
                String s=(startDate)+"";
                first[b]=new JButton(s);
                first[b].setPreferredSize(new Dimension(142,65));
                first[b].addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                         sendSingleEmail sse= null;
                        try {
                            sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        sse.setVisible(true);
                    }
                });
                startDate=startDate+arrayCounter;
            }
            thirdRowPanels=new JPanel[7];
            for(int c=0; c<thirdRowPanels.length; c++)
            {
                thirdRowPanels[c]=new JPanel();
                SpringLayout thirdRowInnerPanelsLayout=new SpringLayout();
                thirdRowPanels[c].setLayout(thirdRowInnerPanelsLayout);
                thirdRowPanels[c].add(first[c]);
                thirdRowInnerPanelsLayout.putConstraint(SpringLayout.WEST,first[c],5,SpringLayout.WEST,thirdRowPanels[c]);
                thirdRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH,first[c],2,SpringLayout.NORTH,thirdRowPanels[c]);
                thirdRowPanel.add(thirdRowPanels[c]);
            }
            second=new JButton[7];
            for(int d=0; d<second.length; d++)
            {
                String s=(startDate)+"";
                second[d]=new JButton(s);
                second[d].setPreferredSize(new Dimension(142,65));
                second[d].addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                         sendSingleEmail sse= null;
                        try {
                            sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        sse.setVisible(true);
                    }
                });
                startDate=startDate+arrayCounter;
            }
            fourthRowPanels=new JPanel[7];
            for(int e=0; e<thirdRowPanels.length; e++)
            {
                fourthRowPanels[e]=new JPanel();
                SpringLayout fourthRowInnerPanelsLayout=new SpringLayout();
                fourthRowPanels[e].setLayout(fourthRowInnerPanelsLayout);
                fourthRowPanels[e].add(second[e]);
                fourthRowInnerPanelsLayout.putConstraint(SpringLayout.WEST,second[e],5,SpringLayout.WEST,fourthRowPanels[e]);
                fourthRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH,second[e],2,SpringLayout.NORTH,fourthRowPanels[e]);
                fourthRowPanel.add(fourthRowPanels[e]);
            }
            third=new JButton[7];
            for(int d=0; d<third.length; d++)
            {
                String s=(startDate)+"";
                third[d]=new JButton(s);
                third[d].setPreferredSize(new Dimension(142,65));
                third[d].addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                         sendSingleEmail sse= null;
                        try {
                            sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        sse.setVisible(true);
                    }
                });
                startDate=startDate+arrayCounter;
            }
            fifthRowPanels=new JPanel[7];
            for(int e=0; e<fifthRowPanels.length; e++)
            {
                fifthRowPanels[e]=new JPanel();
                SpringLayout fifthRowInnerPanelsLayout=new SpringLayout();
                fifthRowPanels[e].setLayout(fifthRowInnerPanelsLayout);
                fifthRowPanels[e].add(third[e]);
                fifthRowInnerPanelsLayout.putConstraint(SpringLayout.WEST,third[e],5,SpringLayout.WEST,fifthRowPanels[e]);
                fifthRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH,third[e],2,SpringLayout.NORTH,fifthRowPanels[e]);
                fifthRowPanel.add(fifthRowPanels[e]);
            }
            fourth=new JButton[7];
            for(int d=0; d<fourth.length; d++)
            {
                String s=(startDate)+"";
                fourth[d]=new JButton(s);
                fourth[d].setPreferredSize(new Dimension(142,65));
                fourth[d].addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                         sendSingleEmail sse= null;
                        try {
                            sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        sse.setVisible(true);
                    }
                });
                startDate=startDate+arrayCounter;
            }
            sixthRowPanels=new JPanel[7];
            for(int e=0; e<sixthRowPanels.length; e++)
            {
                sixthRowPanels[e]=new JPanel();
                SpringLayout sixthRowInnerPanelsLayout=new SpringLayout();
                sixthRowPanels[e].setLayout(sixthRowInnerPanelsLayout);
                sixthRowPanels[e].add(fourth[e]);
                sixthRowInnerPanelsLayout.putConstraint(SpringLayout.WEST,fourth[e],5,SpringLayout.WEST,sixthRowPanels[e]);
                sixthRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH,fourth[e],2,SpringLayout.NORTH,sixthRowPanels[e]);
                sixthRowPanel.add(sixthRowPanels[e]);
            }
            fifth=new JButton[7];
            for(int d=0; d<fifth.length; d++)
            {
                String s=(startDate)+"";
                fifth[d]=new JButton(s);
                fifth[d].setPreferredSize(new Dimension(142,65));
                fifth[d].addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                         sendSingleEmail sse= null;
                        try {
                            sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        sse.setVisible(true);
                    }
                });
                startDate=startDate+arrayCounter;
            }
            seventhRowPanels=new JPanel[7];
            for(int e=0; e<seventhRowPanels.length; e++)
            {
                seventhRowPanels[e]=new JPanel();
                SpringLayout seventhRowInnerPanelsLayout=new SpringLayout();
                seventhRowPanels[e].setLayout(seventhRowInnerPanelsLayout);
                seventhRowPanels[e].add(fifth[e]);
                seventhRowInnerPanelsLayout.putConstraint(SpringLayout.WEST,fifth[e],5,SpringLayout.WEST,seventhRowPanels[e]);
                seventhRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH,fifth[e],2,SpringLayout.NORTH,seventhRowPanels[e]);
                seventhRowPanel.add(seventhRowPanels[e]);
            }
            if(startDate==32)
            {
                startDate=1;
                sixth=new JButton[7];
                for(int d=0; d<sixth.length; d++)
                {
                    String s=(startDate)+"";
                    sixth[d]=new JButton(s);
                    sixth[d].setPreferredSize(new Dimension(142,65));
                    sixth[d].addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                            sendSingleEmail sse= null;
                            try {
                                sse = new sendSingleEmail(String.valueOf(31), String.valueOf(12),String.valueOf( 2022));
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                            sse.setVisible(true);
                        }
                    });
                    startDate=startDate+arrayCounter;
                }
                eighthRowPanels=new JPanel[7];
                for(int e=0; e<eighthRowPanels.length; e++)
                {
                    eighthRowPanels[e]=new JPanel();
                    SpringLayout eighthRowInnerPanelsLayout=new SpringLayout();
                    eighthRowPanels[e].setLayout(eighthRowInnerPanelsLayout);
                    eighthRowPanels[e].add(sixth[e]);
                    eighthRowInnerPanelsLayout.putConstraint(SpringLayout.WEST,sixth[e],5,SpringLayout.WEST,eighthRowPanels[e]);
                    eighthRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH,sixth[e],2,SpringLayout.NORTH,eighthRowPanels[e]);
                    eighthRowPanel.add(eighthRowPanels[e]);
                }
            }
            else if(startDate<32)
            {
                sixth = new JButton[7];
                int remainingDates = 32 - startDate;
                int remainingDatesLeft = remainingDates;
                while (remainingDatesLeft != 0)
                {
                    String s = (startDate) + "";
                    sixth[remainingDates - (1 * (remainingDatesLeft))] = new JButton(s);
                    sixth[remainingDates - (1 * (remainingDatesLeft))].setPreferredSize(new Dimension(142, 65));
                    sixth[(1 * (remainingDatesLeft))].addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                            sendSingleEmail sse= null;
                            try {
                               sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                         
                            sse.setVisible(true);
                            
                        }
                    });
                    startDate = startDate + arrayCounter;
                    remainingDatesLeft = remainingDatesLeft - 1;
                }
                startDate = 1;
                for (int d = remainingDates; d < sixth.length; d++)
                {
                    String s = (startDate) + "";
                    sixth[d] = new JButton(s);
                    sixth[d].setPreferredSize(new Dimension(142, 65));
                    sixth[d].addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                             sendSingleEmail sse= null;
                            try {
                               sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                         
                            sse.setVisible(true);
                        }
                    });
                    startDate = startDate + arrayCounter;
                }
                eighthRowPanels = new JPanel[7];
                for (int e = 0; e < eighthRowPanels.length; e++)
                {
                    eighthRowPanels[e] = new JPanel();
                    SpringLayout eighthRowInnerPanelsLayout = new SpringLayout();
                    eighthRowPanels[e].setLayout(eighthRowInnerPanelsLayout);
                    eighthRowPanels[e].add(sixth[e]);
                    eighthRowInnerPanelsLayout.putConstraint(SpringLayout.WEST, sixth[e], 5, SpringLayout.WEST, eighthRowPanels[e]);
                    eighthRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH, sixth[e], 2, SpringLayout.NORTH, eighthRowPanels[e]);
                    eighthRowPanel.add(eighthRowPanels[e]);
                }
            }
        }

        else if (dateBreakDown.getMyMonth(defaultToday.getMonth()) == monthsList[3] || dateBreakDown.getMyMonth(defaultToday.getMonth()) == monthsList[5] || dateBreakDown.getMyMonth(defaultToday.getMonth()) == monthsList[8] || dateBreakDown.getMyMonth(defaultToday.getMonth()) == monthsList[10])
        {
            int startDate = 1;
            monthDate = new myDate(startDate, defaultToday.getMonth(), defaultToday.getYear());
            int intDayOfDate = monthDate.getMyIntDay();
            dayOfDate = monthDate.getMyDay(intDayOfDate);
            int count = intDayOfDate;
            first = new JButton[7];
            int prevMonthNumberOfDates = count - 1;
            int thirtyOne = 31;
            for (int a = prevMonthNumberOfDates; a >= 0; a--)
            {
                String s =0+"";
                s = (thirtyOne - (1 * (prevMonthNumberOfDates - a))) + "";
                first[a] = new JButton(s);
                first[a].setPreferredSize(new Dimension(142, 65));
                first[a].addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                         sendSingleEmail sse= null;
                        try {
                            sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        sse.setVisible(true);
                    }
                });
            }
            int arrayCounter = 1;
            for (int b = count; b < first.length; b++)
            {
                String s = (startDate) + "";
                first[b] = new JButton(s);
                first[b].setPreferredSize(new Dimension(142, 65));
                first[b].addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                         sendSingleEmail sse= null;
                        try {
                            sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        sse.setVisible(true);
                    }
                });
                startDate = startDate + arrayCounter;
            }
            thirdRowPanels = new JPanel[7];
            for (int c = 0; c < thirdRowPanels.length; c++)
            {
                thirdRowPanels[c] = new JPanel();
                SpringLayout thirdRowInnerPanelsLayout = new SpringLayout();
                thirdRowPanels[c].setLayout(thirdRowInnerPanelsLayout);
                thirdRowPanels[c].add(first[c]);
                thirdRowInnerPanelsLayout.putConstraint(SpringLayout.WEST, first[c], 5, SpringLayout.WEST, thirdRowPanels[c]);
                thirdRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH, first[c], 2, SpringLayout.NORTH, thirdRowPanels[c]);
                thirdRowPanel.add(thirdRowPanels[c]);
            }
            second = new JButton[7];
            for (int d = 0; d < second.length; d++)
            {
                String s = (startDate) + "";
                second[d] = new JButton(s);
                second[d].setPreferredSize(new Dimension(142, 65));
                second[d].addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                         sendSingleEmail sse= null;
                        try {
                            sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        sse.setVisible(true);
                    }
                });
                startDate = startDate + arrayCounter;
            }
            fourthRowPanels = new JPanel[7];
            for (int e = 0; e < thirdRowPanels.length; e++)
            {
                fourthRowPanels[e] = new JPanel();
                SpringLayout fourthRowInnerPanelsLayout = new SpringLayout();
                fourthRowPanels[e].setLayout(fourthRowInnerPanelsLayout);
                fourthRowPanels[e].add(second[e]);
                fourthRowInnerPanelsLayout.putConstraint(SpringLayout.WEST, second[e], 5, SpringLayout.WEST, fourthRowPanels[e]);
                fourthRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH, second[e], 2, SpringLayout.NORTH, fourthRowPanels[e]);
                fourthRowPanel.add(fourthRowPanels[e]);
            }
            third = new JButton[7];
            for (int d = 0; d < third.length; d++)
            {
                String s = (startDate) + "";
                third[d] = new JButton(s);
                third[d].setPreferredSize(new Dimension(142, 65));
                third[d].addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                         sendSingleEmail sse= null;
                        try {
                            sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        sse.setVisible(true);
                    }
                });
                startDate = startDate + arrayCounter;
            }
            fifthRowPanels = new JPanel[7];
            for (int e = 0; e < fifthRowPanels.length; e++)
            {
                fifthRowPanels[e] = new JPanel();
                SpringLayout fifthRowInnerPanelsLayout = new SpringLayout();
                fifthRowPanels[e].setLayout(fifthRowInnerPanelsLayout);
                fifthRowPanels[e].add(third[e]);
                fifthRowInnerPanelsLayout.putConstraint(SpringLayout.WEST, third[e], 5, SpringLayout.WEST, fifthRowPanels[e]);
                fifthRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH, third[e], 2, SpringLayout.NORTH, fifthRowPanels[e]);
                fifthRowPanel.add(fifthRowPanels[e]);
            }
            fourth = new JButton[7];
            for (int d = 0; d < fourth.length; d++)
            {
                String s = (startDate) + "";
                fourth[d] = new JButton(s);
                fourth[d].setPreferredSize(new Dimension(142, 65));
                fourth[d].addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                         sendSingleEmail sse= null;
                        try {
                            sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        sse.setVisible(true);
                    }
                });
                startDate = startDate + arrayCounter;
            }
            sixthRowPanels = new JPanel[7];
            for (int e = 0; e < sixthRowPanels.length; e++)
            {
                sixthRowPanels[e] = new JPanel();
                SpringLayout sixthRowInnerPanelsLayout = new SpringLayout();
                sixthRowPanels[e].setLayout(sixthRowInnerPanelsLayout);
                sixthRowPanels[e].add(fourth[e]);
                sixthRowInnerPanelsLayout.putConstraint(SpringLayout.WEST, fourth[e], 5, SpringLayout.WEST, sixthRowPanels[e]);
                sixthRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH, fourth[e], 2, SpringLayout.NORTH, sixthRowPanels[e]);
                sixthRowPanel.add(sixthRowPanels[e]);
            }
            fifth = new JButton[7];
            for (int d = 0; d < fifth.length; d++)
            {
                String s = (startDate) + "";
                fifth[d] = new JButton(s);
                fifth[d].setPreferredSize(new Dimension(142, 65));
                fifth[d].addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                         sendSingleEmail sse= null;
                        try {
                            sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        sse.setVisible(true);
                    }
                });
                startDate = startDate + arrayCounter;
            }
            seventhRowPanels = new JPanel[7];
            for (int e = 0; e < seventhRowPanels.length; e++)
            {
                seventhRowPanels[e] = new JPanel();
                SpringLayout seventhRowInnerPanelsLayout = new SpringLayout();
                seventhRowPanels[e].setLayout(seventhRowInnerPanelsLayout);
                seventhRowPanels[e].add(fifth[e]);
                seventhRowInnerPanelsLayout.putConstraint(SpringLayout.WEST, fifth[e], 5, SpringLayout.WEST, seventhRowPanels[e]);
                seventhRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH, fifth[e], 2, SpringLayout.NORTH, seventhRowPanels[e]);
                seventhRowPanel.add(seventhRowPanels[e]);
            }
            if (startDate == 31)
            {
                startDate = 1;
                sixth = new JButton[7];
                for (int d = 0; d < sixth.length; d++)
                {
                    String s = (startDate) + "";
                    sixth[d] = new JButton(s);
                    sixth[d].setPreferredSize(new Dimension(142, 65));
                    sixth[d].addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                             sendSingleEmail sse= null;
                            try {
                               sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                         
                            sse.setVisible(true);
                        }
                    });
                    startDate = startDate + arrayCounter;
                }
                eighthRowPanels = new JPanel[7];
                for (int e = 0; e < eighthRowPanels.length; e++)
                {
                    eighthRowPanels[e] = new JPanel();
                    SpringLayout eighthRowInnerPanelsLayout = new SpringLayout();
                    eighthRowPanels[e].setLayout(eighthRowInnerPanelsLayout);
                    eighthRowPanels[e].add(sixth[e]);
                    eighthRowInnerPanelsLayout.putConstraint(SpringLayout.WEST, sixth[e], 5, SpringLayout.WEST, eighthRowPanels[e]);
                    eighthRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH, sixth[e], 2, SpringLayout.NORTH, eighthRowPanels[e]);
                    eighthRowPanel.add(eighthRowPanels[e]);
                }
            }
            else if (startDate < 31)
            {
                sixth = new JButton[7];
                int remainingDates = 31 - startDate;
                int remainingDatesLeft = remainingDates;
                while (remainingDatesLeft != 0)
                {
                    String s = (startDate) + "";
                    sixth[remainingDates - (1 * (remainingDatesLeft))] = new JButton(s);
                    sixth[remainingDates - (1 * (remainingDatesLeft))].setPreferredSize(new Dimension(142, 65));
                    sixth[(1 * (remainingDatesLeft))].addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                             sendSingleEmail sse= null;
                            try {
                               sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                         
                            sse.setVisible(true);
                        }
                    });
                    startDate = startDate + arrayCounter;
                    remainingDatesLeft = remainingDatesLeft - 1;
                }
                startDate = 1;
                for (int d = remainingDates; d < sixth.length; d++)
                {
                    String s = (startDate) + "";
                    sixth[d] = new JButton(s);
                    sixth[d].setPreferredSize(new Dimension(142, 65));
                    sixth[d].addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                             sendSingleEmail sse= null;
                            try {
                               sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                         
                            sse.setVisible(true);
                        }
                    });
                    startDate = startDate + arrayCounter;
                }
                eighthRowPanels = new JPanel[7];
                for (int e = 0; e < eighthRowPanels.length; e++)
                {
                    eighthRowPanels[e] = new JPanel();
                    SpringLayout eighthRowInnerPanelsLayout = new SpringLayout();
                    eighthRowPanels[e].setLayout(eighthRowInnerPanelsLayout);
                    eighthRowPanels[e].add(sixth[e]);
                    eighthRowInnerPanelsLayout.putConstraint(SpringLayout.WEST, sixth[e], 5, SpringLayout.WEST, eighthRowPanels[e]);
                    eighthRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH, sixth[e], 2, SpringLayout.NORTH, eighthRowPanels[e]);
                    eighthRowPanel.add(eighthRowPanels[e]);
                }
            }
        }

        else if (dateBreakDown.getMyMonth(defaultToday.getMonth()) == monthsList[1])
        {
            if (dateBreakDown.getMyYear()%4==0)
            {
                int startDate = 1;
                monthDate = new myDate(startDate, defaultToday.getMonth(), defaultToday.getYear());
                int intDayOfDate = monthDate.getMyIntDay();
                dayOfDate = monthDate.getMyDay(intDayOfDate);
                int count = intDayOfDate;
                first = new JButton[7];
                int prevMonthNumberOfDates = count - 1;
                int thirtyOne = 31;
                for (int a = prevMonthNumberOfDates; a >= 0; a--)
                {
                    String s = 0 + "";
                    s = (thirtyOne - (1 * (prevMonthNumberOfDates - a))) + "";
                    first[a] = new JButton(s);
                    first[a].setPreferredSize(new Dimension(142, 65));
                    first[a].addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                             sendSingleEmail sse= null;
                            try {
                               sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                         
                            sse.setVisible(true);
                        }
                    });
                }
                int arrayCounter = 1;
                for (int b = count; b < first.length; b++)
                {
                    String s = (startDate) + "";
                    first[b] = new JButton(s);
                    first[b].setPreferredSize(new Dimension(142, 65));
                    first[b].addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                             sendSingleEmail sse= null;
                            try {
                               sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                         
                            sse.setVisible(true);
                        }
                    });
                    startDate = startDate + arrayCounter;
                }
                thirdRowPanels = new JPanel[7];
                for (int c = 0; c < thirdRowPanels.length; c++)
                {
                    thirdRowPanels[c] = new JPanel();
                    SpringLayout thirdRowInnerPanelsLayout = new SpringLayout();
                    thirdRowPanels[c].setLayout(thirdRowInnerPanelsLayout);
                    thirdRowPanels[c].add(first[c]);
                    thirdRowInnerPanelsLayout.putConstraint(SpringLayout.WEST, first[c], 5, SpringLayout.WEST, thirdRowPanels[c]);
                    thirdRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH, first[c], 2, SpringLayout.NORTH, thirdRowPanels[c]);
                    thirdRowPanel.add(thirdRowPanels[c]);
                }
                second = new JButton[7];
                for (int d = 0; d < second.length; d++)
                {
                    String s = (startDate) + "";
                    second[d] = new JButton(s);
                    second[d].setPreferredSize(new Dimension(142, 65));
                    second[d].addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                             sendSingleEmail sse= null;
                            try {
                               sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                         
                            sse.setVisible(true);
                        }
                    });
                    startDate = startDate + arrayCounter;
                }
                fourthRowPanels = new JPanel[7];
                for (int e = 0; e < thirdRowPanels.length; e++)
                {
                    fourthRowPanels[e] = new JPanel();
                    SpringLayout fourthRowInnerPanelsLayout = new SpringLayout();
                    fourthRowPanels[e].setLayout(fourthRowInnerPanelsLayout);
                    fourthRowPanels[e].add(second[e]);
                    fourthRowInnerPanelsLayout.putConstraint(SpringLayout.WEST, second[e], 5, SpringLayout.WEST, fourthRowPanels[e]);
                    fourthRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH, second[e], 2, SpringLayout.NORTH, fourthRowPanels[e]);
                    fourthRowPanel.add(fourthRowPanels[e]);
                }
                third = new JButton[7];
                for (int d = 0; d < third.length; d++)
                {
                    String s = (startDate) + "";
                    third[d] = new JButton(s);
                    third[d].setPreferredSize(new Dimension(142, 65));
                    third[d].addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                             sendSingleEmail sse= null;
                            try {
                               sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                         
                            sse.setVisible(true);
                        }
                    });
                    startDate = startDate + arrayCounter;
                }
                fifthRowPanels = new JPanel[7];
                for (int e = 0; e < fifthRowPanels.length; e++)
                {
                    fifthRowPanels[e] = new JPanel();
                    SpringLayout fifthRowInnerPanelsLayout = new SpringLayout();
                    fifthRowPanels[e].setLayout(fifthRowInnerPanelsLayout);
                    fifthRowPanels[e].add(third[e]);
                    fifthRowInnerPanelsLayout.putConstraint(SpringLayout.WEST, third[e], 5, SpringLayout.WEST, fifthRowPanels[e]);
                    fifthRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH, third[e], 2, SpringLayout.NORTH, fifthRowPanels[e]);
                    fifthRowPanel.add(fifthRowPanels[e]);
                }
                fourth = new JButton[7];
                for (int d = 0; d < fourth.length; d++)
                {
                    String s = (startDate) + "";
                    fourth[d] = new JButton(s);
                    fourth[d].setPreferredSize(new Dimension(142, 65));
                    fourth[d].addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                             sendSingleEmail sse= null;
                            try {
                               sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                         
                            sse.setVisible(true);
                        }
                    });
                    startDate = startDate + arrayCounter;
                }
                sixthRowPanels = new JPanel[7];
                for (int e = 0; e < sixthRowPanels.length; e++)
                {
                    sixthRowPanels[e] = new JPanel();
                    SpringLayout sixthRowInnerPanelsLayout = new SpringLayout();
                    sixthRowPanels[e].setLayout(sixthRowInnerPanelsLayout);
                    sixthRowPanels[e].add(fourth[e]);
                    sixthRowInnerPanelsLayout.putConstraint(SpringLayout.WEST, fourth[e], 5, SpringLayout.WEST, sixthRowPanels[e]);
                    sixthRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH, fourth[e], 2, SpringLayout.NORTH, sixthRowPanels[e]);
                    sixthRowPanel.add(sixthRowPanels[e]);
                }
                fifth = new JButton[7];
                for (int d = 0; d < fifth.length; d++)
                {
                    String s = (startDate) + "";
                    fifth[d] = new JButton(s);
                    fifth[d].setPreferredSize(new Dimension(142, 65));
                    fifth[d].addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                             sendSingleEmail sse= null;
                            try {
                               sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                         
                            sse.setVisible(true);
                        }
                    });
                    startDate = startDate + arrayCounter;
                }
                seventhRowPanels = new JPanel[7];
                for (int e = 0; e < seventhRowPanels.length; e++)
                {
                    seventhRowPanels[e] = new JPanel();
                    SpringLayout seventhRowInnerPanelsLayout = new SpringLayout();
                    seventhRowPanels[e].setLayout(seventhRowInnerPanelsLayout);
                    seventhRowPanels[e].add(fifth[e]);
                    seventhRowInnerPanelsLayout.putConstraint(SpringLayout.WEST, fifth[e], 5, SpringLayout.WEST, seventhRowPanels[e]);
                    seventhRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH, fifth[e], 2, SpringLayout.NORTH, seventhRowPanels[e]);
                    seventhRowPanel.add(seventhRowPanels[e]);
                }
                if (startDate == 30)
                {
                    startDate = 1;
                    sixth = new JButton[7];
                    for (int d = 0; d < sixth.length; d++)
                    {
                        String s = (startDate) + "";
                        sixth[d] = new JButton(s);
                        sixth[d].setPreferredSize(new Dimension(142, 65));
                        sixth[d].addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e)
                            {
                                sendSingleEmail sse= null;
                                try {
                                    sse = new sendSingleEmail(String.valueOf(31), String.valueOf(12),String.valueOf( 2022));
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                                sse.setVisible(true);
                            }
                        });
                        startDate = startDate + arrayCounter;
                    }
                    eighthRowPanels = new JPanel[7];
                    for (int e = 0; e < eighthRowPanels.length; e++)
                    {
                        eighthRowPanels[e] = new JPanel();
                        SpringLayout eighthRowInnerPanelsLayout = new SpringLayout();
                        eighthRowPanels[e].setLayout(eighthRowInnerPanelsLayout);
                        eighthRowPanels[e].add(sixth[e]);
                        eighthRowInnerPanelsLayout.putConstraint(SpringLayout.WEST, sixth[e], 5, SpringLayout.WEST, eighthRowPanels[e]);
                        eighthRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH, sixth[e], 2, SpringLayout.NORTH, eighthRowPanels[e]);
                        eighthRowPanel.add(eighthRowPanels[e]);
                    }
                }
                else if (startDate < 30)
                {
                    sixth = new JButton[7];
                    int remainingDates = 30 - startDate;
                    int remainingDatesLeft = remainingDates;
                    while (remainingDatesLeft != 0)
                    {
                        String s = (startDate) + "";
                        sixth[remainingDates - (1 * (remainingDatesLeft))] = new JButton(s);
                        sixth[remainingDates - (1 * (remainingDatesLeft))].setPreferredSize(new Dimension(142, 65));
                        sixth[(1 * (remainingDatesLeft))].addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e)
                            {
                                 sendSingleEmail sse= null;
                                try {
                                    sse = new sendSingleEmail(String.valueOf(31), String.valueOf(12),String.valueOf( 2022));
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                                sse.setVisible(true);
                            }
                        });
                        startDate = startDate + arrayCounter;
                        remainingDatesLeft = remainingDatesLeft - 1;
                    }
                    startDate = 1;
                    for (int d = remainingDates; d < sixth.length; d++)
                    {
                        String s = (startDate) + "";
                        sixth[d] = new JButton(s);
                        sixth[d].setPreferredSize(new Dimension(142, 65));
                        sixth[d].addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e)
                            {
                                sendSingleEmail sse= null;
                                try {
                                    sse = new sendSingleEmail(String.valueOf(31), String.valueOf(12),String.valueOf( 2022));
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                                sse.setVisible(true);
                            }
                        });
                        startDate = startDate + arrayCounter;
                    }
                    eighthRowPanels = new JPanel[7];
                    for (int e = 0; e < eighthRowPanels.length; e++)
                    {
                        eighthRowPanels[e] = new JPanel();
                        SpringLayout eighthRowInnerPanelsLayout = new SpringLayout();
                        eighthRowPanels[e].setLayout(eighthRowInnerPanelsLayout);
                        eighthRowPanels[e].add(sixth[e]);
                        eighthRowInnerPanelsLayout.putConstraint(SpringLayout.WEST, sixth[e], 5, SpringLayout.WEST, eighthRowPanels[e]);
                        eighthRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH, sixth[e], 2, SpringLayout.NORTH, eighthRowPanels[e]);
                        eighthRowPanel.add(eighthRowPanels[e]);
                    }
                }
            }

            else
            {
                int startDate = 1;
                monthDate = new myDate(startDate, defaultToday.getMonth(), defaultToday.getYear());
                int intDayOfDate = monthDate.getMyIntDay();
                dayOfDate = monthDate.getMyDay(intDayOfDate);
                int count = intDayOfDate;
                first = new JButton[7];
                int prevMonthNumberOfDates = count - 1;
                int thirtyOne = 31;
                for (int a = prevMonthNumberOfDates; a >= 0; a--)
                {
                    String s = 0 + "";
                    s = (thirtyOne - (1 * (prevMonthNumberOfDates - a))) + "";
                    first[a] = new JButton(s);
                    first[a].setPreferredSize(new Dimension(142, 65));
                    first[a].addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                             sendSingleEmail sse= null;
                            try {
                               sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                         
                            sse.setVisible(true);
                        }
                    });
                }
                int arrayCounter = 1;
                for (int b = count; b < first.length; b++)
                {
                    String s = (startDate) + "";
                    first[b] = new JButton(s);
                    first[b].setPreferredSize(new Dimension(142, 65));
                    first[b].addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                             sendSingleEmail sse= null;
                            try {
                               sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                         
                            sse.setVisible(true);
                        }
                    });
                    startDate = startDate + arrayCounter;
                }
                thirdRowPanels = new JPanel[7];
                for (int c = 0; c < thirdRowPanels.length; c++)
                {
                    thirdRowPanels[c] = new JPanel();
                    SpringLayout thirdRowInnerPanelsLayout = new SpringLayout();
                    thirdRowPanels[c].setLayout(thirdRowInnerPanelsLayout);
                    thirdRowPanels[c].add(first[c]);
                    thirdRowInnerPanelsLayout.putConstraint(SpringLayout.WEST, first[c], 5, SpringLayout.WEST, thirdRowPanels[c]);
                    thirdRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH, first[c], 2, SpringLayout.NORTH, thirdRowPanels[c]);
                    thirdRowPanel.add(thirdRowPanels[c]);
                }
                second = new JButton[7];
                for (int d = 0; d < second.length; d++)
                {
                    String s = (startDate) + "";
                    second[d] = new JButton(s);
                    second[d].setPreferredSize(new Dimension(142, 65));
                    second[d].addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                             sendSingleEmail sse= null;
                            try {
                               sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                         
                            sse.setVisible(true);
                        }
                    });
                    startDate = startDate + arrayCounter;
                }
                fourthRowPanels = new JPanel[7];
                for (int e = 0; e < thirdRowPanels.length; e++)
                {
                    fourthRowPanels[e] = new JPanel();
                    SpringLayout fourthRowInnerPanelsLayout = new SpringLayout();
                    fourthRowPanels[e].setLayout(fourthRowInnerPanelsLayout);
                    fourthRowPanels[e].add(second[e]);
                    fourthRowInnerPanelsLayout.putConstraint(SpringLayout.WEST, second[e], 5, SpringLayout.WEST, fourthRowPanels[e]);
                    fourthRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH, second[e], 2, SpringLayout.NORTH, fourthRowPanels[e]);
                    fourthRowPanel.add(fourthRowPanels[e]);
                }
                third = new JButton[7];
                for (int d = 0; d < third.length; d++)
                {
                    String s = (startDate) + "";
                    third[d] = new JButton(s);
                    third[d].setPreferredSize(new Dimension(142, 65));
                    third[d].addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                             sendSingleEmail sse= null;
                            try {
                               sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                         
                            sse.setVisible(true);
                        }
                    });
                    startDate = startDate + arrayCounter;
                }
                fifthRowPanels = new JPanel[7];
                for (int e = 0; e < fifthRowPanels.length; e++)
                {
                    fifthRowPanels[e] = new JPanel();
                    SpringLayout fifthRowInnerPanelsLayout = new SpringLayout();
                    fifthRowPanels[e].setLayout(fifthRowInnerPanelsLayout);
                    fifthRowPanels[e].add(third[e]);
                    fifthRowInnerPanelsLayout.putConstraint(SpringLayout.WEST, third[e], 5, SpringLayout.WEST, fifthRowPanels[e]);
                    fifthRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH, third[e], 2, SpringLayout.NORTH, fifthRowPanels[e]);
                    fifthRowPanel.add(fifthRowPanels[e]);
                }
                fourth = new JButton[7];
                for (int d = 0; d < fourth.length; d++)
                {
                    String s = (startDate) + "";
                    fourth[d] = new JButton(s);
                    fourth[d].setPreferredSize(new Dimension(142, 65));
                    fourth[d].addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                             sendSingleEmail sse= null;
                            try {
                               sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                         
                            sse.setVisible(true);
                        }
                    });
                    startDate = startDate + arrayCounter;
                }
                sixthRowPanels = new JPanel[7];
                for (int e = 0; e < sixthRowPanels.length; e++)
                {
                    sixthRowPanels[e] = new JPanel();
                    SpringLayout sixthRowInnerPanelsLayout = new SpringLayout();
                    sixthRowPanels[e].setLayout(sixthRowInnerPanelsLayout);
                    sixthRowPanels[e].add(fourth[e]);
                    sixthRowInnerPanelsLayout.putConstraint(SpringLayout.WEST, fourth[e], 5, SpringLayout.WEST, sixthRowPanels[e]);
                    sixthRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH, fourth[e], 2, SpringLayout.NORTH, sixthRowPanels[e]);
                    sixthRowPanel.add(sixthRowPanels[e]);
                }
                fifth = new JButton[7];
                for (int d = 0; d < fifth.length; d++)
                {
                    String s = (startDate) + "";
                    fifth[d] = new JButton(s);
                    fifth[d].setPreferredSize(new Dimension(142, 65));
                    fifth[d].addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                             sendSingleEmail sse= null;
                            try {
                               sse= new sendSingleEmail(String.valueOf(31), String.valueOf(12), String.valueOf(2022));
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                         
                            sse.setVisible(true);
                        }
                    });
                    startDate = startDate + arrayCounter;
                }
                seventhRowPanels = new JPanel[7];
                for (int e = 0; e < seventhRowPanels.length; e++)
                {
                    seventhRowPanels[e] = new JPanel();
                    SpringLayout seventhRowInnerPanelsLayout = new SpringLayout();
                    seventhRowPanels[e].setLayout(seventhRowInnerPanelsLayout);
                    seventhRowPanels[e].add(fifth[e]);
                    seventhRowInnerPanelsLayout.putConstraint(SpringLayout.WEST, fifth[e], 5, SpringLayout.WEST, seventhRowPanels[e]);
                    seventhRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH, fifth[e], 2, SpringLayout.NORTH, seventhRowPanels[e]);
                    seventhRowPanel.add(seventhRowPanels[e]);
                }
                if (startDate == 29)
                {
                    startDate = 1;
                    sixth = new JButton[7];
                    for (int d = 0; d < sixth.length; d++)
                    {
                        String s = (startDate) + "";
                        sixth[d] = new JButton(s);
                        sixth[d].setPreferredSize(new Dimension(142, 65));
                        sixth[d].addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e)
                            {
                               sendSingleEmail sse= null;
                                try {
                                    sse = new sendSingleEmail(String.valueOf(31), String.valueOf(12),String.valueOf( 2022));
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                                sse.setVisible(true);
                            }
                        });
                        startDate = startDate + arrayCounter;
                    }
                    eighthRowPanels = new JPanel[7];
                    for (int e = 0; e < eighthRowPanels.length; e++)
                    {
                        eighthRowPanels[e] = new JPanel();
                        SpringLayout eighthRowInnerPanelsLayout = new SpringLayout();
                        eighthRowPanels[e].setLayout(eighthRowInnerPanelsLayout);
                        eighthRowPanels[e].add(sixth[e]);
                        eighthRowInnerPanelsLayout.putConstraint(SpringLayout.WEST, sixth[e], 5, SpringLayout.WEST, eighthRowPanels[e]);
                        eighthRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH, sixth[e], 2, SpringLayout.NORTH, eighthRowPanels[e]);
                        eighthRowPanel.add(eighthRowPanels[e]);
                    }
                }
                else if (startDate < 29)
                {
                    sixth = new JButton[7];
                    int remainingDates = 29 - startDate;
                    int remainingDatesLeft = remainingDates;
                    while (remainingDatesLeft != 0)
                    {
                        String s = (startDate) + "";
                        sixth[remainingDates - (1 * (remainingDatesLeft))] = new JButton(s);
                        sixth[remainingDates - (1 * (remainingDatesLeft))].setPreferredSize(new Dimension(142, 65));
                        sixth[(1 * (remainingDatesLeft))].addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e)
                            {
                               sendSingleEmail sse= null;
                                try {
                                    sse = new sendSingleEmail(String.valueOf(31), String.valueOf(12),String.valueOf( 2022));
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                                sse.setVisible(true);
                            }
                        });
                        startDate = startDate + arrayCounter;
                        remainingDatesLeft = remainingDatesLeft - 1;
                    }
                    startDate = 1;
                    for (int d = remainingDates; d < sixth.length; d++)
                    {
                        String s = (startDate) + "";
                        sixth[d] = new JButton(s);
                        sixth[d].setPreferredSize(new Dimension(142, 65));
                        sixth[d].addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e)
                            {
                               sendSingleEmail sse= null;
                                try {
                                    sse = new sendSingleEmail(String.valueOf(31), String.valueOf(12),String.valueOf( 2022));
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                                sse.setVisible(true);
                            }
                        });
                        startDate = startDate + arrayCounter;
                    }
                    eighthRowPanels = new JPanel[7];
                    for (int e = 0; e < eighthRowPanels.length; e++)
                    {
                        eighthRowPanels[e] = new JPanel();
                        SpringLayout eighthRowInnerPanelsLayout = new SpringLayout();
                        eighthRowPanels[e].setLayout(eighthRowInnerPanelsLayout);
                        eighthRowPanels[e].add(sixth[e]);
                        eighthRowInnerPanelsLayout.putConstraint(SpringLayout.WEST, sixth[e], 5, SpringLayout.WEST, eighthRowPanels[e]);
                        eighthRowInnerPanelsLayout.putConstraint(SpringLayout.NORTH, sixth[e], 2, SpringLayout.NORTH, eighthRowPanels[e]);
                        eighthRowPanel.add(eighthRowPanels[e]);
                    }
                }
            }
        }
    }
}




























