import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String transactionType;
    private long memberId;
    private double amount;
    private long transactionId;
    private String transactionDateTime;
    
    private static long incr =0;
    public Transaction (String transac, long id, double amount) {
        this.transactionType = transac;
        this.memberId = id;
        this.amount  = amount;
        this.transactionId = incr ++;

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(" dd-MM-yyyy  HH-mm-ss");
        this.transactionDateTime = dateTime.format(dateFormat);
    
    }
    public  void  setTransactionType( String tr_Type) {
        this.transactionType= tr_Type;
    }
    public void setMemberId( long id) {
        this.memberId =id;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    //getters
    public  String  getTransactionType() {
        return  this.transactionType;
    }
    public Double getAmount() {
        return this.amount;
    }
    public long getMemberId() {
        return this.memberId;
    }
    public long getTransactionId(){
        return this.transactionId;
    }
    public String getTransactionDateTime() {
        return this.transactionDateTime;
    }
     //to String
     @Override
     public String toString() {
        return (
            " Transaction id: " + transactionId + " \n"
            + " date and time: " + transactionDateTime + " \n"
            + " member id: " + memberId + " \n"
            + " Transaction type: " + transactionType + " \n"
            + " Amount: NGN" + amount
            
        );
     }
}
