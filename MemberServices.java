import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberServices {
     List<Members> membersArr = new ArrayList<>();
     private  static long idSerial = 3412;
        
         Scanner scan =new Scanner(System.in);

    public void addMember() {
          idSerial ++;
         System.out.println("enter first name");
           String fName = scan.nextLine();

         System.out.println("enter other Names");
           String otherNames = scan.nextLine();

         System.out.println(" create withdraw pin");
          long pin = scan.nextLong();

           LocalDateTime dateTime = LocalDateTime.now();

           DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy  HH:mm:ss");
           String createdDateTime = dateTime.format(dateFormat);

         Members member =  new Members(idSerial,fName,otherNames,pin,createdDateTime);
         boolean added = membersArr.add(member);

         if (added) {
            System.out.println("member created");
            //System.out.println(member);
            for (Members m: membersArr) {
            System.out.println(member);
            }
         }
         else {
            System.out.println("error was not created");
         }
    }

  
    //finding member by Id 
    public Members findMemberById(long id) {
    for (Members m : membersArr) {
        if (m.getId() == id) {
            return m;
        }
    }
    return null;
}
    // to edit member names

  public void updateName(Members member, Scanner sc) {
    System.out.println("1. Update First Name");
    System.out.println("2. Update Other Names");
  
    System.out.print("Select option: ");
    int option = sc.nextInt();
    sc.nextLine();

    switch (option) {
        case 1:
            System.out.print("Enter new First Name: ");
            member.setFname(sc.nextLine());
            System.out.println("First name updated.");
            break;
        case 2:
            System.out.print("Enter new Other Names: ");
            member.setOtherNames(sc.nextLine());
            System.out.println("Other names updated.");
            break;
        default:
            System.out.println("Invalid option.");
    }
}

// total contribution

public void getTotalContributions() {
  double totalAmount = 0.0;
   for (Members m : membersArr) {
      totalAmount += m.getAccount().getAccountBal();
   }
   System.out.println("Total contributed amount: NGN" + totalAmount);
}
  

  //to  get member Id

     public long getMemberId( long id) {
            long memberId;
            for(Members m : membersArr) {
                memberId = m.getId();
            }
          return id;
         }

    public void getMembers() {
       if (membersArr.isEmpty()) {
         System.out.println("no member in the list");
       }
       else {
         for (Members member: membersArr) {
            System.out.println(member);
        }
       }
    }
}
