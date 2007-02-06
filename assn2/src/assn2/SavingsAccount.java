/* Author:          McKelvy, James Markus
 * CLID:            jmm0468
 * Class:           CMPS360
 * Assignment:      assn2
 * Date Assigned:   Wednesday, 24 January 2007, 03:30 PM
 * Due Date:        Wednesday, 7 February 2007, 10:00 PM
 * Description:     Pretends to be a savings account that allows withdrawing, 
 *                  depositing, viewing of the account balance, and setting of 
 *                  the pin.
 */

package assn2;

/**
 * Pretends to be a savings account that allows withdrawing, depositing, viewing
 * of the account balance, and setting of the pin.
 * @author Mark
 */
public class SavingsAccount {
    
    /**
     *The account number of this account.
     */
    private String acctNumber;
    
    /**
     *The PIN of this account.
     */
    private String pin;
    
    /**
     *The balance of this account.
     */
    private double balance;
    
    /**
     *Sets balance to 0.0 and pin to the empty string.
     */
    {
        balance = 0.0;
        pin = "";
    }
    
    /** Creates a new instance of SavingsAccount with a unique account number. Balance is $0. */
    public SavingsAccount() {
        acctNumber = Integer.toString(this.hashCode());
    }
    
    /** Creates a new instance of SavingsAccount. Balance is $0. 
     *Account number is specified by the user.
     *@param acctNumber The account number of this account.
     */
    public SavingsAccount(String acctNumber) {
        this.acctNumber = acctNumber;
    }
    
    /**
     *Allows setting of a new pin code.
     *@param newPin The pin code to set, may be a number and/or letters.
     */
    public void setPin(String newPin){
        pin = newPin;
    }

    /**
     *Gets the balance of the account. 
     *The passed account number and pin number must be correct.
     *@param acctNumber The account to access.
     *@param pin The PIN to the account
     *@return The current balance.
     */
    public double getBalance(String acctNumber, String pin){
        if(this.acctNumber.equals(acctNumber) && this.pin.equals(pin))
            return balance;
        else return 0.0;
    }
    
    /**
     *Deposits a specified amount into the account.
     *The passed account number and pin number must be correct.
     *@param acctNumber The account to access.
     *@param pin The PIN to the account
     *@param amt The amount to deposit.
     */
    public boolean deposit(String acctNumber, String pin, double amt){
        if(this.acctNumber.equals(acctNumber) && this.pin.equals(pin) && amt > 0.0){
            balance += amt;
            return true;
        }
        else return false;
    }
    
    /**
     *Withdraws a specified amount from the account.
     *The passed account number and pin number must be correct.
     *@param acctNumber The account to access.
     *@param pin The PIN to the account
     *@param amt The amount to withdraw.
     *@return True if the withdraw was successful, false if it was not (amt may
     *be too much or not positive).
     */
    public boolean withdraw(String acctNumber, String pin, double amt){
        if(this.acctNumber.equals(acctNumber) && this.pin.equals(pin) && amt > 0.0 && amt <= balance){
            balance -= amt;
            return true;
        }
        else return false;
    }
}
