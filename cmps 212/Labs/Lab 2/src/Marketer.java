public class Marketer extends Employee {
    public Marketer(){
        super();
        setBaseSalary(getBaseSalary() + 10000);
    }
    public void advertise(){
        System.out.println("Act now, while supplies last!");
    }}
