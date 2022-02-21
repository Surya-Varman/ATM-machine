import java.util.ArrayList;

public class RecordCollection {
    /*
    * This class will contain the list of all transactions for a given customer and used to print the mini statement of the customer.
    * */
    ArrayList<Records> CollectionOfRecords;
    RecordCollection() {
        CollectionOfRecords = new ArrayList<>();
    }
    public void addRecords(Records r){
        CollectionOfRecords.add(r);
    }
    public int size(){
        return CollectionOfRecords.size();
    }
}
