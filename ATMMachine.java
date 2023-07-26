import java.util.*; 
import java.text.SimpleDateFormat;
public class ATMMachine {
    public static void main(String args[]) {
     ATM obj = new ATM();
      obj.checkPin();
    }
}
class ATM {
   static Scanner sc = new Scanner(System.in);
    private float balance;
    private String userID = "abcd1234";
    private int PIN = 973302;
    static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();
    String str;
    ArrayList<String> list = new ArrayList<>();
    void checkPin() {
        System.out.println("PLEASE ENTER YOUR PIN :");
        int enteredPin = sc.nextInt();
        if(enteredPin == PIN) {
            menu();
        }else {
            System.out.println("ENTERED PIN IS NOT CORRECT");
                checkPin();
        }
    }
    void menu() {
        System.out.println("PLEASE ENTER YOUR CHOICE");
      System.out.println("1. Transaction History");
      System.out.println("2. Withdraw");
      System.out.println("3. Deposit");
      System.out.println("4. Transfer");
      System.out.println("5. Exit");
      int choice = sc.nextInt();
      if(choice == 1){
        transHis(list);
      }else if(choice == 2){
        withdraw();
      }else if(choice == 3) {
        deposit();
      }else if(choice == 4){
        transfer();
      }else if(choice == 5) {
        System.out.println("Thankyou for using our ATM.");
        sc.close();
        System.exit(0);
      }else {
        System.out.println("PLEASE ENTER A VALID CHOICE");
      }
    }

    void deposit() {
        System.out.println("PLEASE ENTER THE AMOUNT YOU WANT TO DEPOSIT");
        float amt = sc.nextFloat();
        balance = balance + amt ;
        System.out.println("Money deposited successfully. Your Bank Balance is Rs " + balance);
        str = "Credit Rs " + amt + " on " + formatter.format(date);
       history(str);
        menu();
    }

    void withdraw() {
        System.out.println("Enter the amount you want to withdraw");
        float amt = sc.nextFloat();
        if(amt > balance){
            System.out.println("Invalid amount entered. Your Bank Balance is Rs " + balance);
        }else{
            balance = balance - amt;
            System.out.println("Money withdrawl successfully. Your Bank Balance is Rs " + balance);
        }
        str = "Debit Rs " + amt + " on " + formatter.format(date);
       history(str);
        menu();
    }

    void transfer() {
        System.out.println("Please enter the userID of the person you want to transfer money");
        String ID = sc.next();
        System.out.println("Enter the amount to tranfer");
        int n = sc.nextInt();
        if(n > balance){
            System.out.println("Invalid amount entered. Your Bank Balance is Rs " + balance);
        }else{
            balance = balance - n;
            System.out.println("Rs " + n + " is successfully transferred to userID " + ID + ". Your Bank Balance is Rs " + balance);
        }
         str = "Transferred to userID " + ID + " Rs "+ n + " on "+ formatter.format(date);
       history(str);
        menu();
    }

    void history(String str){
      list.add(str);
      
    }

    void transHis(ArrayList<String> list) {
      if(list.size() == 0){
        System.out.println("No Transactions are made in this session");
        menu();
      }
      System.out.println("Your Transactions are as follows:");
       for(int i=0 ; i < list.size() ; i++) {
        System.out.println(list.get(i));
       }
       System.out.println("Current Bank Balance is : " + balance);
       
       menu();
    }
}