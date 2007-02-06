/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      assn2
 * Date Assigned:   Wednesday, 24 January 2007, 03:30 PM
 * Due Date:        Wednesday, 7 February 2007, 10:00 PM
 * Description:     Pretends to be a small bank, allows viewing of account 
 *                  balance, depositing, and withdrawing.
 */

package assn2;

import javax.swing.*;
import java.util.*;

/**
 * Pretends to be a small bank, allows viewing of account balance, depositing,
 * and withdrawing.
 * @author Mark
 */
public class SmallBank {
    
    /**
     *An array of bank savings accounts.
     */
    private SavingsAccount[] savingsAccount;
    
    /**
     *How many accounts are we keeping track of.
     */
    private int numberOfAccounts;
    
    /**
     *Keeps track of the accounts we have (by number).
     */
    private Hashtable hashtable;
    
    /**
     * preinitialize the number of accounts
     */
    {
        numberOfAccounts = 10;
    }
    
    /**
     *Startup SmallBank.
     */
    public static void main(String[] args){
        new SmallBank();
    }
    
    /** Creates a new instance of SmallBank, show the user a menu until they want
     * to quit
     */
    public SmallBank() {
        savingsAccount = new SavingsAccount[numberOfAccounts];
        hashtable = new Hashtable();
        String choice;
        String tmp_acct;
        String tmp_pin;
        Integer tmp_var;
        
        initializeAccounts();
        choice = prompt(getMenu());
        
        // loop until user opts to quit
        while(!choice.equals("0")){
            if(choice.equals("1") || choice.equals("2") || choice.equals("3")){
                tmp_acct = prompt("Please enter your account number");
                tmp_var = (Integer)hashtable.get(tmp_acct);
                if(tmp_var != null){
                    tmp_pin = prompt("Please enter your pin number");
                    
                    // get account balnace
                    if(choice.equals("1")){
                        showMessage("Account balance: $" + savingsAccount[tmp_var.intValue()].getBalance(tmp_acct, tmp_pin));
                    }
                    // deposit into account
                    else if(choice.equals("2")){
                        double amt = Double.parseDouble(prompt("Amount to deposit"));
                        if(savingsAccount[tmp_var.intValue()].deposit(tmp_acct, tmp_pin, amt)){
                            showMessage("Deposit successful.");
                        }
                        else showMessage("Deposit failure.");
                    }
                    // withdraw from account
                    else if(choice.equals("3")){
                        double amt = Double.parseDouble(prompt("Amount to withdraw"));
                        if(savingsAccount[tmp_var.intValue()].withdraw(tmp_acct, tmp_pin, amt)){
                            showMessage("Withdraw successful.");
                        }
                        else showMessage("Withdraw failure.");
                    }
                }
                else{
                    showMessage("Account doesn't exist");
                }
            }
            else{
                showMessage("Incorrect choice");
            }
            choice = prompt(getMenu());
        }
    }
    
    /**
     *Initializes the bank accounts starting at acct # 100000 and pin # 1000,
     *incremented by 1 each time.
     */
    private void initializeAccounts(){
        long accts = 100000;
        int pins = 1000;
        
        for(int i = 0; i < numberOfAccounts; i++){
            hashtable.put(Long.toString(accts), i);
            savingsAccount[i] = new SavingsAccount(Long.toString(accts++));
            savingsAccount[i].setPin(Integer.toString(pins++));
        }
    }
    
    /**
     *Central place to put menu options.
     *@return The string containing the menu.
     */
    private String getMenu(){
        String tmp="";
        
        tmp+="Welcome to SmallBank(c)!\n\n";
        
        tmp+="1 - Check account balance.\n";
        tmp+="2 - Deposit into account.\n";
        tmp+="3 - Withdraw from account.\n";
        tmp+="0 - Exit.\n";
        
        tmp+="\nPlease enter the number of your choice:";
        
        return tmp;
    }
    
    /**
     *Shows a dialog to the user with a message.
     *@return The response the user gives.
     */
    private String prompt(String msg){
        return JOptionPane.showInputDialog(null, msg);
    }
    
    /**
     *Shows a message to the user via dialog.
     */
    private void showMessage(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
}
