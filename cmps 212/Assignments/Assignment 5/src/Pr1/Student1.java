package Pr1;

import java.util.*;
    public class Student1 {
        private String firstName;
        private String lastName;
        public Student1(){}
        public Student1(String firstName, String lastName) {
            this.firstName=firstName;
            this.lastName=lastName;
        }
        public String getFirstName (){return firstName;}
        public String getLastName (){return lastName;}
        public void setFirstName (String firstName){this.firstName=firstName;}
        public void setLastName (String lastName){this.lastName=lastName;}
        public String toString(){ return firstName + " " + lastName;}
    }
