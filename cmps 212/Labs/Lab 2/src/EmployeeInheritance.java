public class EmployeeInheritance {
    public static void main(String[] args){
        Marketer m=new Marketer();
        System.out.println(m.getBaseSalary());
        //Janitor can't advertise.
        //Harvard Lawyer can sue.
        HarvardLawyer hL=new HarvardLawyer();
        System.out.println(hL.getBaseHours());
        System.out.println(hL.getBaseSalary());
        System.out.println(hL.getBaseVacationDays());
        System.out.println(hL.getBaseVacationForm());
        hL.sue();
        Lawyer l=new Lawyer();
        System.out.println(l.getBaseHours());
        System.out.println(l.getBaseSalary());
        System.out.println(l.getBaseVacationDays());
        System.out.println(l.getBaseVacationForm());
        l.sue();
        Janitor j=new Janitor();
        System.out.println(j.getBaseHours());
        System.out.println(j.getBaseSalary());
        System.out.println(j.getBaseVacationDays());
        System.out.println(j.getBaseVacationForm());
        j.clean();
        Marketer m1=new Marketer();
        System.out.println(m1.getBaseHours());
        System.out.println(m1.getBaseSalary());
        System.out.println(m1.getBaseVacationDays());
        System.out.println(m1.getBaseVacationForm());
        m1.advertise();
    }
}
