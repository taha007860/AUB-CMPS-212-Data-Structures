import java.util.*;
public class TestCheckingSavings {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        ArrayList<Account> a=new ArrayList<Account>();
        for(int i=0;i<=3;i++){
            boolean press1=scan.nextBoolean();
            boolean press2=!press1;
        int id=scan.nextInt();
        double balance=scan.nextDouble();
        double annualInterestRate=scan.nextDouble();
        double overdraftLimit=scan.nextDouble();
        int creditCardNumber= scan.nextInt();
        if(press1){a.add(new CheckingAccount(id,balance,annualInterestRate,overdraftLimit));}
        else if(press2){a.add(new SavingsAccount(id,balance,annualInterestRate,creditCardNumber));}
        double amount=scan.nextDouble();
        a.get(i).deposit(amount);
        System.out.println(a.get(i).getBalance());
        double amount1=scan.nextDouble();
        a.get(i).withdraw(amount1);
        System.out.println(a.get(i).getBalance());
        System.out.print("For a ");
        if(press1){System.out.println("Checking account: \n");}
        else{System.out.println("Savings account: \n");}
        System.out.print("This is a ");
        if(press1){System.out.println("Checking account");}
        else{System.out.println("Savings account");}
        System.out.println("Account ID: "+a.get(i).getId());
        System.out.println("Date Created: "+a.get(i).getCalender());
        System.out.println("Current Balance: "+a.get(i).getBalance());
        System.out.println("Annual Interest Rate: "+a.get(i).getAnnualInterestRate());
        System.out.println("Monthly Interest Amount: "+a.get(i).getMonthlyInterestAmount());
        if(press1) {CheckingAccount c=(CheckingAccount)(a.get(i));
            System.out.println("Overdraft Limit: "+c.getOverdraftLimit());}
        else{SavingsAccount s=(SavingsAccount) (a.get(i));
            System.out.println("Credit Card Number: "+s.getCreditCardNumber());
            System.out.println("Card Expiry Date: "+s.getExpiryDate());
            System.out.println("Credit Balance: "+s.getCreditBalance());}






    }
        }

    }
