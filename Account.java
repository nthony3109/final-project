import java.util.ArrayList;
import java.util.List;

public class Account {
        private long memberId;
        private double  Account_bal;
        private List<Transaction> transactions;

            //field constructor

        public Account(long memberId) {
            this.memberId = memberId;
            this.Account_bal = 0.0;
            this.transactions = new ArrayList<>();
        }
            //setters

        public void setMemberId( long id) {
            this.memberId = id;
        }
        public void setAccountBal(double acctBal) {
            this.Account_bal = acctBal;
        }
        //Getters
        public  long getMemberId(){
            return this.memberId;
        }
        public double getAccountBal() {
            return this.Account_bal;
        }
        public List<Transaction> getTransactions() {
            return this.transactions;
        }
        //adding and withdrawal method
        public void addFunds( Transaction trn) {
            transactions.add(trn);
            //System.out.println("in account class \n" + trn.getAmount());
            this.Account_bal += trn.getAmount();
        }
        public void withDrawFunds(Transaction trn) {
            transactions.add(trn);
            //System.out.println("this is in account class \n" +trn.getAmount());
          
                if (Account_bal >= trn.getAmount()) {
                    this.Account_bal -= trn.getAmount();
                }
                else {
                    System.out.println("the amount you entered exceeds account available balance");
                }
          
        }


        //return account fields
        @Override
        public String toString() {
            return (
                " member id: " + memberId  +"\n"
                + " Account bal: NGN" + Account_bal + "\n"
                + " transactions: " + transactions
            );
        }
}
