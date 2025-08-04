public class Members {
    private long memberId;
    private String fName;
    private String otherNames;
    private long withdrawalPin;
    private String dateTime;
    private Account account;



    // field constructor
    public Members(long memberId, String fName, String otherNames,long pin ,String createdDateTime) {
        this.fName = fName;

        this.otherNames = otherNames;
        this.memberId =  memberId;
        this.withdrawalPin = pin;
        this.dateTime = createdDateTime;
        this.account = new Account(memberId);
    }
    public void setFname(String f) {
        this.fName = f; System.out.println("enter id");
    }
    public void setOtherNames(String o) {
        this.otherNames = o;
    }
    public void setId(int idSerial) {
        this.memberId = idSerial;
    }
    public String getFname() {
        return this.fName;
    }
    public String getOtherNames() {
        return this.otherNames;
    }
    public void setwithdrawalPin( long pin) {
        this.withdrawalPin = pin;
    }
    public Long getWithdrawalPin() {
        return this.withdrawalPin;
    }
    public long  getId() {
        return this.memberId;
    }
    public String getCreatedDate() {
        return this.dateTime;
    }
    public Account getAccount() {
        return this.account;
    }

    @Override
    public String toString() {
        return ( "id: " + memberId + '\n'
         + "first name: " + fName + "\n"
         + "  other names: " + otherNames + "\n"
         + "  createdDate: " + dateTime );
    }
}
