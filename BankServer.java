import java.util.HashMap;

public class BankServer {
    /*
    This is the Bank Server Class.
    This class will store all the records of the customers and their list of transactions as like in the real life scenario.
    * */
    HashMap<Integer,Customer> CustomerList = new HashMap<>(); //This hashmap will store the lists of customer objects as value and their account number as keys
     static HashMap<Integer,RecordCollection> RecordsMap = new HashMap<>(); //This hashmap will store account number as key and the object of records as value
}
