import java.util.*;
public class EmployeeAccounts {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        Employee[] e=new Employee[3];
            int id=scan.nextInt();
            double balance=scan.nextInt();
            double annualInterestRate=scan.nextDouble();
            Account a=new Account(id,balance,annualInterestRate);
            Employee e1=new Employee(a,null,null);
            e[0]=e1;
            System.out.println(e[0]);
            double overdraftLimit= scan.nextDouble();
           int idC=scan.nextInt();
        double balanceC=scan.nextInt();
        double annualInterestRateC=scan.nextDouble();
        CheckingAccount b=new CheckingAccount(id,balance,annualInterestRate,overdraftLimit);
            Employee e2=new Employee(a, null,b);
            e[1]=e2;
            System.out.println(e[1]);
        int idS=scan.nextInt();
        double balanceS=scan.nextInt();
        double annualInterestRateS=scan.nextDouble();
        int creditCardNumber=scan.nextInt();
        SavingsAccount c=new SavingsAccount(id, balance, annualInterestRate,creditCardNumber);
            Employee e3=new Employee(a,c, null);
            e[2]=e3;
            System.out.println(e[2]);}}


