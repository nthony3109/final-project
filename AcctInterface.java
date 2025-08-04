public interface AcctInterface {
    public double checkBal( Members member);
    public void contributeReq(Members member, double amount);
     public  void withDrawalReq( Members member, double amount , long pin );
}
