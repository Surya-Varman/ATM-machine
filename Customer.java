public class Customer {
    /*
    * This class will contain all the details of the customer.
    * */
    private String name;
    private int AccountNumber;
    private String CardNumber;
    private int ATMPIN;
    private String PhoneNumber;
    private int Balance;
    private boolean isLocked;
    private int LockedCount;

    public int getLockedCount() {
        return LockedCount;
    }

    public void setLockedCount(int lockedCount) {
        LockedCount = lockedCount;
    }

    public Customer(String name, String cardNumber, int accountNumber, String phoneNumber, int ATMPIN ) {
        this.name = name;
        AccountNumber = accountNumber;
        CardNumber = cardNumber;
        this.ATMPIN = ATMPIN;
        PhoneNumber = phoneNumber;
        this.Balance =0;
        this.isLocked = false;
        this.LockedCount=0;
    }

    public void ChangeBalance(int amount) {
        Balance = amount+Balance;
    }

    public void setATMPIN(int ATMPIN) {
        this.ATMPIN = ATMPIN;
    }

    public int getBalance() {
        return Balance;
    }

    public boolean checkATMPIN(int ATMPIN) {
        if(this.ATMPIN == ATMPIN)
            return true;
        else
            return false;
    }

    public String getName() {
        return name;
    }

    public int getAccountNumber() {
        return AccountNumber;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public int getATMPIN() {
        return ATMPIN;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public void IncreaseLockedCount(){
        this.LockedCount++;
    }

}
