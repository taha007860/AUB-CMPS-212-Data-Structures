public class TestTimeSpan {
    public static void main(String[] args){
        TimeSpan t1 = new TimeSpan(3, 45);
        System.out.println(t1 + " is " + t1.getTotalHours() + " hours");
        t1.add(2, 30);
        System.out.println(t1 + " is " + t1.getTotalHours() + " hours");
        TimeSpan t2 = new TimeSpan(0, 55);
        t1.add(t2);
        System.out.println(t1 + " is " + t1.getTotalHours() + " hours");
    }
}
