public class TestAccount {
    public static void main(String[] args){
        Account account=new Account(1122,20000,4);
        account.withdraw(2500);
        account.deposit(3000);
        System.out.println(account.getBalance());
        System.out.println(account.getMonthlyInterestRate());
        System.out.println(account.getCalender());
    }
}
