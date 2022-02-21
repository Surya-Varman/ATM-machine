import java.util.Scanner;

public class Register extends BankServer {
    /*
    * This class is used to register new customers into the Bank server.
    *
    * */
    public int gen_account_number(){
     int AccountNumber = (int)((Math.random()*(100000))+100000);
     if(CustomerList.containsKey(String.valueOf(AccountNumber))){
         AccountNumber=gen_account_number();
     }
     return AccountNumber;
    }

    public void RegisterCustomer(Scanner scanner){
        System.out.println("Enter your Name: ");
        String Name = scanner.nextLine();
        System.out.println("Enter your Card Number");
        String CardNumber = scanner.nextLine();
        System.out.println("Enter your Phone number: ");
        String PhoneNumber = scanner.nextLine();
        int AccountNumber = gen_account_number();
        System.out.println("Enter your 4 digit ATM pin number: ");
        int AtmPin = scanner.nextInt();
        Customer customer = new Customer(Name,CardNumber,AccountNumber,PhoneNumber,AtmPin);
       // CustomerListObjects.add(customer);
        CustomerList.put(AccountNumber,customer);
        scanner.nextLine();
        System.out.println("your account number is "+AccountNumber);
        RecordCollection recordscollection = new RecordCollection();
        RecordsMap.put(AccountNumber,recordscollection);
    }

}
