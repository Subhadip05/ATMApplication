package ATMApplication;
import java.io.IOException;
public class ATM extends MainMenu{
    public static void main(String[] args) throws IOException{
        MainMenu mainMenu=new MainMenu();
         mainMenu.getLogin(); //Login method from MainMenu Class
        //all the first you have to run ATM class before MainMenu and Account
    }
}
