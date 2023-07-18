//package Calander;
import java.util.Date;
public class myDate
{
    private Date setDate;
    private int date;
    private int day;
    private int month;
    private int year;
    private String dayString;
    private String monthString;

    public myDate(int date, int month, int year)
    {
        setMyDate(date, month, year);
        this.date=setDate.getDate();
        this.month=setDate.getMonth();
        this.year=setDate.getYear();
        this.day=setDate.getDay();
        dayString=getMyDay(this.day);
        monthString=getMyMonth(this.month);
    }

    public void setMyDate(int date, int month, int year)
    {
        setDate=new Date(year,month,date);
    }

    public int getMyDate()
    {
        return date;
    }

    public int getMyIntDay()
    {
        return day;
    }

    public int getMyMonth()
    {
        return month;
    }

    public int getMyYear()
    {
        if(year<1900)
        {
            year=year+1900;
        }
        return year;
    }

    public String getMyDay(int day)
    {
        String myDay[]={"Sun","Mon","Tue","Wed","Thur","Fri","Sat"};
        String myReturningDay="Sun";
        if(day==0)
        {
            myReturningDay=myDay[0];
        }
        else if(day==1)
        {
            myReturningDay=myDay[1];
        }
        else if(day==2)
        {
            myReturningDay=myDay[2];
        }
        else if(day==3)
        {
            myReturningDay=myDay[3];
        }
        else if(day==4)
        {
            myReturningDay=myDay[4];
        }
        else if(day==5)
        {
            myReturningDay=myDay[5];
        }
        else if(day==6)
        {
            myReturningDay=myDay[6];
        }
        return myReturningDay;
    }

    public String getMyMonth(int month)
    {
        String myMonth[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
        String myReturningMonth="January";
        if(month==0)
        {
            myReturningMonth=myMonth[0];
        }
        else if(month==1)
        {
            myReturningMonth=myMonth[1];
        }
        else if(month==2)
        {
            myReturningMonth=myMonth[2];
        }
        else if(month==3)
        {
            myReturningMonth=myMonth[3];
        }
        else if(month==4)
        {
            myReturningMonth=myMonth[4];
        }
        else if(month==5)
        {
            myReturningMonth=myMonth[5];
        }
        else if(month==6)
        {
            myReturningMonth=myMonth[6];
        }
        else if(month==7)
        {
            myReturningMonth=myMonth[7];
        }
        else if(month==8)
        {
            myReturningMonth=myMonth[8];
        }
        else if(month==9)
        {
            myReturningMonth=myMonth[9];
        }
        else if(month==10)
        {
            myReturningMonth=myMonth[10];
        }
        else if(month==11)
        {
            myReturningMonth=myMonth[11];
        }
        return myReturningMonth;
    }

    @Override
    public String toString()
    {
        return dayString+" "+date+" "+monthString+" "+getMyYear();
    }
}