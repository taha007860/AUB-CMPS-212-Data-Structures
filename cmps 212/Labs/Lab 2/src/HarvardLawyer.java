public class HarvardLawyer extends Lawyer {
    public HarvardLawyer(){
        super();
        setBaseSalary((getBaseSalary()*120)/100.0);
        setBaseVacationDays(getBaseVacationDays()+3);
    }
}
