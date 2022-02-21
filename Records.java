import java.text.SimpleDateFormat;
import java.util.Date;

public class Records {
    /*
    * This class will contain the details of each and every transaction that takes place in the atm along with details such as date and time of transaction,transaction type etc.
    * */
    Records(int amount,String TransactionType){
    Date DOT = new Date();
    Date TOT = new Date();
    SimpleDateFormat SDF = new SimpleDateFormat("hh:mm:ss");
    SimpleDateFormat SDF1 = new SimpleDateFormat("dd-MM-yyyy");
    DateOfTransaction = SDF1.format(DOT);
    TimeOfTransaction = SDF.format(TOT);
    this.amount = amount;
    this.TransactionType = TransactionType;

    }
    private String DateOfTransaction;
    private String TimeOfTransaction;
    private int amount;
    private int AccountNumber;
    private String TransactionType;

    public String getDateOfTransaction() {
        return DateOfTransaction;
    }

    public String getTimeOfTransaction() {
        return TimeOfTransaction;
    }

    public int getAmount() {
        return amount;
    }

    public String getTransactionType() {
        return TransactionType;
    }
}
