public class TimeSpan {
    int hours;
    int minutes;
    public TimeSpan(int h, int m){
        hours=h;
        minutes=m;
    } public void add(int hours, int minutes){
        this.hours += hours;
        this.minutes += minutes;
        if(this.minutes > 59){
            this.minutes -= 60;
            this.hours += 1;
        }}
    public void add(TimeSpan timespan){
        this.add(timespan.hours, timespan.minutes);
    }public double getTotalHours(){
         return hours+minutes/60.0;
    }
    public String toString(){
        return this.hours+"h"+this.minutes+"m";
    }
}
