import java.util.HashMap; // HashMap and Map are used to store and manage the account information
import java.util.Map;
import java.util.Scanner; // package used to read user inputs

//create customer class to represent all the customer details, can add any type of details
class Customer{
    private String name;
    private String orderType;
    private String dateOrdered;
    private String Status;
//Constructor for the "Customer" class that initializes the customer details with the values in the "account info"
    public Customer(String name, String orderType, String dateOrdered, String Status) {
        this.name = name;
        this.orderType = orderType;
        this.dateOrdered = dateOrdered;
        this.Status = Status;

    }
    //to string method which returns a string representation of hte customer object
    public String toString(){
        return "User name: " + name + " Order Type: " + orderType + " Date Ordered: " + dateOrdered + " Status: " + Status;
    }
}
//this is a class which privates all the information details in the account
class Account{
    private String accountNumber;
    private Customer customer;
//Constructor that Initializes the account details
    public Account(String accountNumber, Customer customer){
        this.accountNumber = accountNumber;
        this.customer = customer;

    }
    public String getAccountNumber(){  //method to return account number
        return accountNumber;
    }
    public Customer getCustomer(){      // returns "Customer" object
        return customer;
    }
}

//Defines a public class "Billing System" which contains the actual customer information
public class BillingSystem{
    private Map<String, Account> accountInfo;
//Constructor for "Billing System" that initializes account info
    public BillingSystem(){
        accountInfo = new HashMap<>();
        //example data
        accountInfo.put("123", new Account("123", new Customer("Sohan G", "Resume_order", "02/15/2005", "completed")));  // Correct
        accountInfo.put("1213", new Account("1213", new Customer("Kobe B", "Resume_order", "09/15/2020", "incomplete")));  // Correct
    }
//this is a method that displays the account information with multiple attempts
    public void displayAccountInfo(String accountNumber) {
        Scanner inputReader = new Scanner(System.in);
        boolean correctAccount = false;
        int attempts = 0;

        while (!correctAccount && attempts < 5) {
            if (accountInfo.containsKey(accountNumber)) {//if the number they entered exists in our data

                Account account = accountInfo.get(accountNumber);
                System.out.println("The customers Account Information is: " + account.getCustomer());
                correctAccount = true;

            } else {
                attempts++;
                if( attempts <5){
                //if the account does not exist then we need to display an error message
                System.out.println("The customers Account Information is incorrect");
                System.out.println("Please enter a valid account number, Attempts left: " + (5 - attempts));
                accountNumber = inputReader.nextLine();

            }   else{
                System.out.println("You have exceeded the maximum number of attempts");
            }

        }
    }
        inputReader.close();//close the scanner
    }
    // the psvm to create an instance of "billingSystem"
    public static void main(String[] args) {
        BillingSystem billingSystem = new BillingSystem();

        //Create a scanner to read the user input
        Scanner inputReader = new Scanner(System.in);

        //tell the user to input an account number
        System.out.println("Enter your billing account number: ");
        String accountNumber = inputReader.nextLine();

        billingSystem.displayAccountInfo(accountNumber);
        inputReader.close(); //close the scanner
    }

}


