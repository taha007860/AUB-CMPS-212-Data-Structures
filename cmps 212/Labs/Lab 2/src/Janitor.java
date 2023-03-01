public class Janitor extends Employee{
    public Janitor(){
        super();
        setBaseHours(getBaseHours()+40);
        setBaseSalary(getBaseSalary()-10000);
        setBaseVacationDays(getBaseVacationDays()/2);
    }
    public void clean(){
        System.out.println("Workin' for the man");
    }
}
