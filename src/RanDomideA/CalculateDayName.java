package RanDomideA;
import java.util.Scanner;
public class CalculateDayName {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //Key-value Method
        int yr=0;
        int date=0;
        String month="";
        try{
            System.out.println("Enter the year:[Like 1947]");
            yr = sc.nextInt();
            System.out.println("Enter the date :[15]");
            date=sc.nextInt();
            System.out.println("Enter the month name:[August]");
            month=sc.next().toUpperCase();
        }catch (Exception e){
            System.out.println("Please Enter valid Input.");
        }

        int fDgt = yr/100; //first 2 digit
        int lDgt=yr%100;  //last 2 digit
        int yrCode=0;
        //Finding year code
        int temp=fDgt%4;
        if(temp==3){
            yrCode=0;
        } else if (temp==0) {
            yrCode=6;
        } else if (temp==1) {
            yrCode=4;
        }else if(temp==2){
            yrCode=2;
        }
        int leapYr=lDgt/4;
        //Finding month code
        int mCode=0;
        switch (month){
            case "JANUARY" :
                mCode=1;
                break;
            case "FEBRUARY" :
                mCode=4;
                break;
            case "MARCH" :
                mCode=4;
                break;
            case "APRIL" :
                mCode=0;
                break;
            case "MAY" :
                mCode=2;
                break;
            case "JUNE" :
                mCode=5;
                break;
            case "JULY" :
                mCode=0;
                break;
            case "AUGUST" :
                mCode=3;
                break;
            case "SEPTEMBER" :
                mCode=6;
                break;
            case "OCTOBER" :
                mCode=1;
                break;
            case "NOVEMBER" :
                mCode=4;
                break;
            default: //december
                mCode=6;
                break;
        }

        int oddDay=(yrCode+lDgt+leapYr+date+mCode)%7;
        String day="";
        switch (oddDay){
            case 1:
                day="Sunday";
                break;
            case 2:
                day="Monday";
                break;
            case 3:
                day="Tuesday";
                break;
            case 4:
                day="Wednesday";
                break;
            case 5:
                day="Thursday";
                break;
            case 6:
                day="Friday";
                break;
            default:
                day="Saturday";
        }
        System.out.println(yr+" "+date+" "+month.toLowerCase()+" dayName: "+day);
    }
}
