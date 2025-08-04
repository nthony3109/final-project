import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountService implements AcctInterface {
   //ccount account = new Account(0);
        private List<Transaction> transaction = new ArrayList<>();
        //Scanner scan = new Scanner(System.in);
    
      
        // to make contribution
        @Override
        public void contributeReq(Members member, double amount) {
            if (amount < 1000) {
                System.out.println(" minimum contribution amount is NGN1000");
            }
            Transaction transac = new Transaction("contribution", member.getId(), amount);
            transaction.add(transac);
            member.getAccount().addFunds(transac);
            System.out.println("posted successfully");
             System.out.println("Amount :NGN" + amount);
            
        }

        // to make withdrawal
       






        @Override
        public  void withDrawalReq( Members member, double amount , long pin ) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
         LocalDate today= LocalDate.now();
         String date = member.getCreatedDate().split(" ")[0];
         LocalDate reqDate = LocalDate.parse(date, formatter);

         if (reqDate.plusDays(30).isAfter(today)) {
               System.out.println("withdrawal starts 30 days after registration");
               return;
         }
         //  System.out.println(reqDate);
          if (amount < 10) {
                System.out.println("enter reasonable amount"); 
                return;
            }
    
            long withdrawalPin = member.getWithdrawalPin();
            if (withdrawalPin == pin) {
              Transaction transac = new Transaction("withdrawal", member.getId(), amount);
            transaction.add(transac);
            member.getAccount().withDrawFunds(transac);
            
            System.out.println(" withdrawal successful");
             System.out.println("Amount :NGN" + amount);
            }

            else{
              System.out.println("invalid withdrawal pin");
            }
         
            
        }

        // to check a member balance

        @Override
       public double checkBal(Members member) {
         if (member == null || member.getAccount() == null) {
            System.out.println("Member or account not found.");
        return 0.0;
    }
    return member.getAccount().getAccountBal();
}

// print member statements

public void getMemberStatements(Members member) {
    Account account = member.getAccount();
      System.out.println("member id: " + member.getId() + "\n"
        + " Name: " + member.getFname() + " " + member.getOtherNames() + "\n"
             + " Account balance: " + account.getAccountBal() + "\n"
      );
      System.out.println("Transactions: " );
      for(Transaction transac : account.getTransactions()) {
        System.out.println(transac);
      }

}

}
