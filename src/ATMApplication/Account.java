package ATMApplication;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    Scanner input=new Scanner(System.in);
    DecimalFormat moneyFormat=new DecimalFormat("'$'###,##0.00");
    int customerNumber;
    private int pinNumber;
    //Default balance will be 0.0
    double currentBalance=0.0,savingBalance=0.0;

    //Here i have to connect database for username and pin number
    public int setCustomerNumber(int customerNumber){
        this.customerNumber=customerNumber;
        return customerNumber;
    }
    public int getCustomerNumber(){
        return customerNumber;
    }
    public int setPinNUmber(int pinNumber){
        this.pinNumber=pinNumber;
        return pinNumber;
    }
    public int getPinNumber(){
        return pinNumber;
    }

    //Methods for Current Account
    public double getCurrentBalance(){
        return currentBalance;
    }
    public double calcCurrentWithdraw(double amount){
        currentBalance=currentBalance-amount;
        return currentBalance;
    }
    public double calcCurrentDeposit(double amount){
        currentBalance=currentBalance+amount;
        return currentBalance;
    }
    public void getCurrentWithdrawInput(){
        System.out.println("Current Account Balance: "+moneyFormat.format(currentBalance));
        System.out.println("Amount you want to withdraw from Current Account: ");
        double amount=input.nextDouble();

        if(currentBalance>=amount){
            calcCurrentWithdraw(amount);
            System.out.println("New current Account Balance: "+moneyFormat.format(currentBalance));
        }else{
            System.out.println("Balance are not sufficient to withdraw");
        }
    }
    public void getCurrentDepositInput(){
        System.out.println("Current Account Balance: "+moneyFormat.format(currentBalance));
        System.out.println("Amount you want deposit to Current Account: ");
        double amount=input.nextDouble();

        if((currentBalance+amount)>=0){
            calcCurrentDeposit(amount);
            System.out.println("New current Account Balance: "+moneyFormat.format(currentBalance));
        }else{
            System.out.println("Deposit Balance can not be negative");
        }
    }
    //Methods for Saving Account
    public double getSavingBalance(){
        return savingBalance;
    }
    public double calcSavingWithdraw(double amount){
        savingBalance=savingBalance-amount;
        return savingBalance;
    }
    public double calcSavingDeposit(double amount){
        savingBalance=savingBalance+amount;
        return savingBalance;
    }

    public void getSavingWithdrawInput(){
        System.out.println("Saving Account Balance: "+moneyFormat.format(savingBalance));
        System.out.println("Amount you want to withdraw from Saving Account: ");
        double amount=input.nextDouble();

        if(savingBalance>=amount){
            calcSavingWithdraw(amount);
            System.out.println("New Saving Account Balance: "+moneyFormat.format(savingBalance));
        }else{
            System.out.println("Balance are not sufficient to withdraw");
        }
    }
    public void getSavingDepositInput(){
        System.out.println("Saving Account Balance: "+moneyFormat.format(savingBalance));
        System.out.println("Amount you want deposit to Saving Account: ");
        double amount=input.nextDouble();

        if((savingBalance+amount)>=0){
            calcSavingDeposit(amount);
            System.out.println("New Saving Account Balance: "+moneyFormat.format(savingBalance));
        }else{
            System.out.println("Deposit Balance can not be negative");
        }
    }
}
