public class Employee {
    private int baseHours;
    private double baseSalary;
    private int baseVacationDays;
    private String baseVacationForm;
    public Employee(){
        baseSalary=40000;
        baseHours = 40;
        baseVacationDays=10;
        baseVacationForm="black";
    }
    public int getBaseHours(){
        return baseHours;
    }
    public double getBaseSalary(){
        return baseSalary;
    }
    public int getBaseVacationDays(){
        return baseVacationDays;
    }
    public String getBaseVacationForm(){
        return baseVacationForm;
    }
    public void setBaseHours(int bH){
        baseHours=bH;
    }
    public void setBaseSalary(double bS){
        baseSalary=bS;
    }
    public void setBaseVacationDays(int bVD){
        baseVacationDays=bVD;
    }
    public void setBaseVacationForm(String bVF){
        baseVacationForm=bVF;
    }
}
