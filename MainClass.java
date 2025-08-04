import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MemberServices service = new MemberServices();
        AccountService acctService = new AccountService();
       // Members member = new Members(0, null, null, null);
        int opt;
        // choice of operations
        do {
        System.out.println("what do you want to do,enter option in digit");
        System.out.println("1. Add new member");
        System.out.println("2. view members");
        System.out.println("3. login");
        System.out.println("4. total amount contributed");
      
        opt =  scan.nextInt();
       if (opt  == 1) {
        service.addMember();
        
       }
       else if (opt == 2) {
         service.getMembers();
       }
       
       //verify user for other operations
       else if(opt  == 3) {
            System.out.println("enter user id");
          //scan.nextLong();
            long id = scan.nextLong();
            long memberid = service.getMemberId(id);
            if (memberid == id) {
              int choice;
              System.out.println("1.contribute");
              System.out.println("2. withdrawal");
              System.out.println("3. check balance");
              System.out.println("4. get statement");
              System.out.println("5. update name");

              
              //scan.next();
              choice = scan.nextInt();

              // to make contribtion;
              if (choice == 1) {
                double amount;
                System.out.println("enter amount");
               // scan.nextDouble();
                amount = scan.nextDouble();
                Members currentMember = service.findMemberById(memberid);
                acctService.contributeReq(currentMember, amount);
                
              }
              // to make withdrawal
              if (choice == 2) {
                double amount;
                System.out.println("enter amount to withdraw");
               // scan.nextDouble();
                amount = scan.nextDouble();

                System.out.println("enter pin");
                long pin = scan.nextLong();

                Members currentMember = service.findMemberById(memberid);
                acctService.withDrawalReq(currentMember, amount,pin);
              }

              // a member account balance 
              if (choice == 3) {
               Members currentMember = service.findMemberById(memberid);
               double bal = acctService.checkBal(currentMember);
               System.out.println(
                   "the balance for id: " + currentMember + " \n"
                   +bal
               );
              }

              if(choice == 4) {
                Members member = service.findMemberById(memberid);
                acctService.getMemberStatements(member);
              }
              //to  update name
              if (choice==5) {
                Members currMember = service.findMemberById(memberid);
                service.updateName(currMember, scan);
              }
           

            }
            }

                 else if (opt == 4) {
                service.getTotalContributions();  
              
            }
       
       else{
        System.out.println("wrong input");
        scan.close();
        return;
       }
    } 
    while(opt != 0);

    scan.close();
            }
}