import java.util.*;

class Bank {
    int accno;
    private String name;
    private int age;
    private String fathername;
    private String city;
    private String state;
    private long deposit;
    private long balance;
 //default constructor
  Bank()
  {
      accno=0;
      name="";
      age=0;
      fathername="";  
      city="";
      state="";
      deposit=0;
  }

  Scanner KB=new Scanner(System.in);
  
  //method to open an account
  void openAccount(int a)
  { 
      accno=a;
      System.out.println("Enter Name");
      name=KB.next();
      System.out.println("Enter age");
      age=KB.nextInt();
      System.out.println("Enter Father name");
      fathername=KB.next();
      System.out.println("Enter city");
      city=KB.next();
      System.out.println("Enter state");
      state=KB.next();
      System.out.println("Enter deposit: ");
      deposit=KB.nextLong();
      System.out.println("\n");
      System.out.println("YOUR ACCOUNT SUCCESSFULLY CREATED");
      System.out.println("YOUR ACCOUNT NUMBER IS \n"+accno);
      System.out.println("\n");
  }

  //method to display account details
  void showAccount()
  { 
      System.out.println("account num="+accno);
      System.out.println("name="+name);
      System.out.println("age="+age);
      System.out.println("father name="+fathername);
      System.out.println("city="+city);
      System.out.println("state="+state);
      System.out.println("balance="+deposit);
      System.out.println("\n");
    }

  //method to deposit money
  void deposit()
  {
       long amt;
       System.out.println("Enter Amount U Want to Deposit : ");
       amt=KB.nextLong();
       balance=deposit+amt;
       System.out.println("your balance is:"+balance);
       System.out.println("SUCCESSFULLY DEPOSITED\n");
  }

  //method to withdraw money
  void withdrawal()
  {
       long amt;
       System.out.println("Enter Amount U Want to withdraw : ");
       amt=KB.nextLong();
       if(balance>=amt)
       { 
            balance=balance-amt;
            System.out.println("your balance is:"+balance);
            System.out.println("SUCCESSFULL WITHDRAWAL\n");
       }
       else
       {
         System.out.println("Less Balance..Transaction Failed..\n");
       }
  }

  //method to search an account number
  boolean search(int acn)
  { 
    if(accno==acn)
    { 
      showAccount();
      return(true);
    }
    return(false);
  }
}
//class exbank is extending the class bank(inheritance concept)
public class ExBank extends Bank{
 
  public static void main(String arg[])
    {
      int n;
      System.out.println("\t\t\t\t\t\t\t~!!!\tBANK IN HAND\t!!!~\n");
      System.out.println("\t\t\t\t\t\t~!!!\tkadubesanahalli branch,Marathahalli\t!!!~\n");
      //try block exception handling
      try (Scanner KB = new Scanner(System.in)) {
      //create initial accounts
       System.out.print("How Many Customer U Want to Input : ");
       n=KB.nextInt();
       ExBank  C[]=new ExBank[15];
       for(int i=0;i<n;i++)
       {   
          C[i]=new ExBank();
          int a=100+i;
          C[i].openAccount(a);
       }
      
      //run loop until menu 6 is not pressed
      int ch;
      do
      {
        System.out.println("Main Menu\n1.create new account\n2.Search By Account\n3.Deposit\n4.Withdrawal\n5.display all the accounts\n6.Exit\n");
        System.out.println("Ur Choice :");
        ch=KB.nextInt();
        switch(ch)
        { 
         case 1:
            for(int i=n;i<n+1;i++)
            {
              C[i]=new ExBank();
              int a=100+i;
              C[i].openAccount(a);
            }
            n=n+1;
            break;                             
            
         case 2:
            System.out.print("Enter Account No U Want to Search...: ");
            int acn=KB.nextInt();
            boolean found=false;
            for(int i=0;i<n;i++)
            {  
              found=C[i].search(acn);
              if(found)
              {
                break;
              }
            }
            if(!found)
            {
              System.out.println("Search Failed..Account Not Exist..\n");
            }
            break;

         case 3:
            System.out.print("Enter Account No : ");
            acn=KB.nextInt();
            found=false;
            for(int i=0;i<n;i++)
            {  
              found=C[i].search(acn);
              if(found)
              {
                C[i].deposit();
                break;
              }
            }
            if(!found)
            {
              System.out.println("Search Failed..Account Not Exist..\n");
            }
            break;

         case 4:
            System.out.print("Enter Account No : ");
            acn=KB.nextInt();
            found=false;
            for(int i=0;i<n;i++)
            {  
              found=C[i].search(acn);
              if(found)
              {
                C[i].withdrawal();
                break;
              }
            }
            if(!found)
            {
              System.out.println("Search Failed..Account Not Exist..\n");
            }
            break;

         case 5:
            
            for(int i=0;i<n;i++)
            {
              C[i].showAccount();
            }
            break;
            
         case 6:                      
             System.out.println("\t\t\t**THANK YOU**");
             break;
        }
      }
      while(ch!=6);
      //catch block handling exception
    }catch(Exception e) {
      System.out.println("Error occured.Run again");
    }
  }

}
