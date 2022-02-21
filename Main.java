import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    /*
    * This is the main class and it will combine all the features of the other class and show it to the user.
    * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isrunning = true;
        Register register = new Register();
        ATM atm = new ATM();
        register.CustomerList = atm.CustomerList;
        Date CurrentDate = new Date();
        SimpleDateFormat CurrentDateFormatted = new SimpleDateFormat("hh:mm:ss");
        if(CurrentDateFormatted.format(CurrentDate).equals("06:00:00"))
        {
            atm.UpdateBalance(); //this will reset the account balance to the maximum capacity every morning 6 o'clock
        }
        while (isrunning) {
            System.out.println("Choose amongst the following operations");
            System.out.println("1.Register a new account");
            System.out.println("2.Pin change");
            System.out.println("3.Withdrawal");
            System.out.println("4.Fund Transfer");
            System.out.println("5.Balance Enquiry");
            System.out.println("6.Deposit Funds");
            System.out.println("7.Print Receipt");
            System.out.println("8.Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            int AccNumber=0;
            if(choice!=1 && choice!=8) {  //this if condition exists because if the user wants to register then the account number should not be asked
                System.out.println("Enter your account number");
                AccNumber = scanner.nextInt();
                try {
                    if (atm.CustomerList.get(AccNumber).getLockedCount() == 3)
                        System.out.println("Your account is locked");
                    else {
                        switch (choice) {
                            case 2:
                                if (atm.CustomerList.containsKey(AccNumber)) {
                                    System.out.println("Enter your ATM pin ");
                                    int PIN = scanner.nextInt();
                                    if (atm.CustomerList.get(AccNumber).checkATMPIN(PIN)) {
                                        System.out.println("Enter your new atm pin ");
                                        int newPIN = scanner.nextInt();
                                        atm.CustomerList.get(AccNumber).setATMPIN(newPIN);
                                    } else {
                                        System.out.println("Entered ATM PIN is incorrect ");
                                        atm.CustomerList.get(AccNumber).IncreaseLockedCount();
                                    }
                                } else {
                                    System.out.println("The entered account does not exists ");
                                }
                                break;
                            case 3:
                                atm.Withdrawal(AccNumber);
                                break;
                            case 4:
                                atm.FundTransfer(AccNumber);
                                break;
                            case 5:
                                atm.BalanceEnquiry(AccNumber);
                                break;
                            case 6:
                                atm.DepositFunds(AccNumber);
                                break;
                            case 7:
                                atm.PrintReceipt(AccNumber);
                                break;
                        }


                    }
                } catch (NullPointerException e) {  //we will get a Null Pointer exception when we don't have any element in the arraylist
                    System.out.println("Your account number does not exists");
                }
            }
            else if(choice==1){
                register.RegisterCustomer(scanner);
                System.out.println("Your account has been generated successfully");
            }
            else
                isrunning=false; //this will exit the while loop
        }
    }
}

