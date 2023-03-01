public class Lawyer extends Employee{
    public Lawyer(){
        super();
        setBaseVacationForm("pink");
        setBaseVacationDays(getBaseVacationDays()+5);
    }
    public void sue(){
        System.out.println("I'll see you in court!");
    }
}
