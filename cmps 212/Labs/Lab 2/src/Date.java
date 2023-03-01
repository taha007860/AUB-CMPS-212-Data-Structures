public class Date {
    private int day;
    private int month;
    private int year;
    public int getDay(){
        return day;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
    public void setDay(int d){
        day=d;
    }
    public void setMonth(int m){
        month=m;
    }
    public void setYear(int y){
        year=y;
    }
    public String toString(){
        return day+"/"+month+"/"+year;
    }
}
