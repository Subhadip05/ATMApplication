package ATMApplication;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class MainMenu extends Account{
    Scanner menuInput =new Scanner(System.in);
    DecimalFormat moneyFormat=new DecimalFormat("'$'###,##0.00");
    //<Integer,Integer> =<CustomerNumber,PinNumber>
    HashMap<Integer,Integer> data=new HashMap<>();
    public void getLogin() throws IOException{
            try{
                //Previously stored match customer number and Pin
                data.put(9876,99393);
                data.put(8948,38933);
                data.put(2934,23284);
                data.put(8982,64652);

                System.out.println("Welcome to MerPay ATM !");
                System.out.println("Enter your customer number");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter your ATM PIN number:");
                setPinNUmber(menuInput.nextInt());
            }catch(Exception e){
                System.out.println("\nInvalid ! Enter only numbers");
                System.out.println("Please Enter Your Right Customer Number or Pin Number");
            }
            //Checking valid Customer number ,Pin number
            int cn,pin;
            cn=getCustomerNumber();
            pin=getPinNumber();
            if(data.containsKey(cn) && data.get(cn)==pin){
                getAccountType();
            }else{
                System.out.println("\nWrong customer number or Pin number");
            }
    }

    public void getAccountType(){
        System.out.println("\nSelect the A/c type:");
        System.out.println("Press 1- Current Account");
        System.out.println("Press 2- Saving Account");
        System.out.println("Press 3- Exit");

        int selection=menuInput.nextInt();
        switch (selection){
            case 1:
                getCurrent();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("\nThank you for using MerPay");
                break;
            default:
                System.out.println("\nInvalid choice\nPlease ReEnter Your Choice:");
                getAccountType();
        }
    }

    public void getCurrent(){
        System.out.println("\nCurrent A/c");
        System.out.println("Press 1- View Balance");
        System.out.println("Press 2- Withdraw Money");
        System.out.println("Press 3- Deposit Money");
        System.out.println("Press 4- Exit");
        System.out.print("Enter Your Choice:");
        int selection=menuInput.nextInt();
        switch (selection){
            case 1:
                System.out.println("Current A/c balance: "+moneyFormat.format(getCurrentBalance()));
                getCurrent();
                break;
            case 2:
                getCurrentWithdrawInput();
                getCurrent();
                break;
            case 3:
                getCurrentDepositInput();
                getCurrent();
                break;
            case 4:
                System.out.println("\nThank you for using MerPay");
                break;
            default:
                System.out.println("\nInvalid choice\n");
                getCurrent();
        }
    }
    public void getSaving(){
        System.out.println("\nSaving A/c");
        System.out.println("Press 1- View Balance");
        System.out.println("Press 2- Withdraw Money");
        System.out.println("Press 3- Deposit Money");
        System.out.println("Press 4- Exit");
        System.out.print("Enter Your Choice:");
        int selection=menuInput.nextInt();

        switch (selection){
            case 1:
                System.out.println("Saving A/c balance: "+moneyFormat.format(getSavingBalance()));
                getSaving();
                break;
            case 2:
                getSavingWithdrawInput();
                getSaving();
                break;
            case 3:
                getSavingDepositInput();
                getSaving();
                break;
            case 4:
                System.out.println("\nThank you for using MerPay");
                break;
            default:
                System.out.println("\nInvalid choice\n");
                getSaving();
        }
    }

}
