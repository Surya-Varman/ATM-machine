import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ATM extends BankServer {  //-->Inheritance<-- // This is the implementation of inheritance
    /*
    * This class is used to implement features such as deposit into the atm, withdraw funds from the atm,transfer funds etc.
    *
    *
    * */
    Scanner scanner = new Scanner(System.in);
    public int Limit=2000000;
    public int ATM_Balance=Limit;
    public void setMaxLimit(int n) {
        this.Limit = n;
    }
    public void UpdateBalance(){   //  -->Polymorphism<-- // This function will set the balance of the atm to the maximum value
        ATM_Balance = Limit;
    }
    public void UpdateBalance(int n){   // -->Polymorphism<-- // This function will update the atm balance by the required amount
        ATM_Balance=ATM_Balance+n;
    }
    public boolean CheckAtmBalance(int n){
        if(n>ATM_Balance){
            return false;
        }
        else
            return true;
    }
    public void BalanceEnquiry(int AccNumber){
//        System.out.println("Enter the account number");
//        int AccNumber = scanner.nextInt();
        if(CustomerList.containsKey(AccNumber)){
            System.out.println("Enter your ATM pin ");
            int PIN = scanner.nextInt();
            if (CustomerList.get(AccNumber).checkATMPIN(PIN)) {
                System.out.println("Your current account balance is " + (CustomerList.get(AccNumber)).getBalance());
            }
            else{
                System.out.println("Entered ATM PIN is incorrect ");
                CustomerList.get(AccNumber).IncreaseLockedCount();
            }
        }
        else
            System.out.println("Your account does not exists");
    }
    public void PINCHANGE(){
        System.out.println("Enter your account number");
        int AccNumber = scanner.nextInt();
        if(CustomerList.containsKey(AccNumber)){
            System.out.println("Enter your new atm pin: ");
            int PIN= scanner.nextInt();
            (CustomerList.get(AccNumber)).setATMPIN(PIN);
        }
        else{
            System.out.println("Your account does not exists.");
        }
    }
    public void Withdrawal(int AccNumber)
    {
        if(CustomerList.containsKey(AccNumber))
        {
            System.out.println("Enter your ATM pin ");
            int PIN = scanner.nextInt();
            if (CustomerList.get(AccNumber).checkATMPIN(PIN)) {
                System.out.println("Enter the amount that you would want to withdraw: ");
                int amt = scanner.nextInt();
                int curr_bal = CustomerList.get(AccNumber).getBalance();
                if (amt > curr_bal) {
                    System.out.println("There is no sufficient funds");
                } else {
                    if(ATM_Balance<amt){
                        System.out.println("Sorry there is no sufficient funds in the ATM machine.");
                    }
                    else{
                    CustomerList.get(AccNumber).ChangeBalance((-1) * amt);
                    Records r =new Records(amt,"Debited");
                    RecordsMap.get(AccNumber).addRecords(r);}
                }
            } else {
                System.out.println("Entered ATM PIN is incorrect ");
                CustomerList.get(AccNumber).IncreaseLockedCount();
            }
        }
        else
            System.out.println("Your account does not exists");
    }


    public void FundTransfer(int AccNumber){
        if(CustomerList.containsKey(AccNumber))
        {
            System.out.println("Enter your ATM pin ");
            int PIN = scanner.nextInt();
            if (CustomerList.get(AccNumber).checkATMPIN(PIN)) {
                System.out.println("Enter the beneficiary account number: ");
                int beneAccNumber = scanner.nextInt();
                if (CustomerList.containsKey(beneAccNumber)) {
                    System.out.println("Enter the amount that you would want to transfer:");
                    int amt = scanner.nextInt();
                    int curr_bal = CustomerList.get(AccNumber).getBalance();
                    if (amt > curr_bal) {
                        System.out.println("There is no sufficient funds");
                    } else {
                        CustomerList.get(AccNumber).ChangeBalance((-1) * amt);
                        CustomerList.get(beneAccNumber).ChangeBalance(amt);
                        Records r =new Records(amt,"Debited");
                        RecordsMap.get(AccNumber).addRecords(r);
                        Records r1 =new Records(amt,"Credited");
                        RecordsMap.get(beneAccNumber).addRecords(r1);
                    }

                } else
                    System.out.println("The entered beneficiary account number does not exists");
            }
            else{
                System.out.println("Entered ATM PIN is incorrect ");
                CustomerList.get(AccNumber).IncreaseLockedCount();
            }
        }
        else
            System.out.println("Your account does not exists");
    }
    public void DepositFunds(int AccNumber){
        if(CustomerList.containsKey(AccNumber)){
            System.out.println("Enter your ATM pin ");
            int PIN = scanner.nextInt();
            if (CustomerList.get(AccNumber).checkATMPIN(PIN)){
                System.out.println("Enter the amount that you want to deposit ");
                int amt = scanner.nextInt();
                CustomerList.get(AccNumber).ChangeBalance(amt);
                Records r =new Records(amt,"Credited");
                RecordsMap.get(AccNumber).addRecords(r);
            }
            else
            {
                System.out.println("Entered ATM PIN is incorrect ");
                CustomerList.get(AccNumber).IncreaseLockedCount();
            }
        }
        else
            System.out.println("Your account does not exists");
    }
    public void PrintReceipt(int AccNumber){
        if(CustomerList.containsKey(AccNumber)) {
            System.out.println("Enter your ATM pin ");
            int PIN = scanner.nextInt();
            if (CustomerList.get(AccNumber).checkATMPIN(PIN)) {
                Date temp1= new Date();
                SimpleDateFormat temp = new SimpleDateFormat("dd-MM-yyyy");
                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println("                            ATM RECEIPT          ");

                System.out.println("                    "+temp1);
                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println("Your current account balance is " + (CustomerList.get(AccNumber)).getBalance());
                System.out.println("Your transactions are as follows ");
                int n = RecordsMap.get(AccNumber).size();
                for(int i=0;i<n;i++){
                    System.out.println("Transaction "+(i+1)+" : Date: "+RecordsMap.get(AccNumber).CollectionOfRecords.get(i).getDateOfTransaction()+" Time: "+RecordsMap.get(AccNumber).CollectionOfRecords.get(i).getTimeOfTransaction()+" Amount: "+RecordsMap.get(AccNumber).CollectionOfRecords.get(i).getAmount()+" Transaction Type: "+RecordsMap.get(AccNumber).CollectionOfRecords.get(i).getTransactionType());
                }
                System.out.println("-----------------------------------------------------------------------------------------");


            } else {
                System.out.println("Entered ATM PIN is incorrect ");
                CustomerList.get(AccNumber).IncreaseLockedCount();
            }
        }
        else
            System.out.println("Your account does not exists");
    }


}
