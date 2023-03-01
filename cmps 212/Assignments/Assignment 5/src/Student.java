 public class Student{
        private    String firstName;
        private   String  lastName;
        private   int studentId;
        private String s;
        private double grade;
        private String letterGrade;
        public Student(){}
        public Student( String firstName, String lastName, int id, String s, double grade, String letterGrade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.s=s;
            this.grade=grade;
            this.letterGrade=letterGrade;
        }
    /*public Student(String firstName, String lastName){
        this.lastName=lastName;
        this.firstName=firstName;

    }*/

        public String getFirstName (){return firstName;}
        public String getLastName (){return lastName;}
        public int  getStudentId (){return studentId;}
        public String getS(){return s;}
        public double getGrade(){return grade;}
        public String getLetterGrade(){return letterGrade;}

        public void setFirstName (String fname){firstName=fname;}
        public void setLastName (String lname){lastName=lname;}
        public void setStudentId (int id){studentId=id;}

       public String toString(){
            return lastName+" "+firstName+" "+s+" "+grade+" "+letterGrade;
        }}
