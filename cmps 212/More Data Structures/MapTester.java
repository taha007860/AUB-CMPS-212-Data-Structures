import java.util.*;

public class MapTester {
    public static void main(String[] args) {
        Map<String, String> phonebook = 
                new UnsortedTableMap1<String, String>();
        phonebook.put("Stuart Reges", "1-206-685-9138");
        phonebook.put("Marty Stepp", "1-253-692-4540");
        phonebook.put("Jenny", "867-5309");
        System.out.println(phonebook);
        
        
        
        Map<String, Integer> ssnMap = new UnsortedTableMap1<String, Integer>();
        ssnMap.put("Stuart Reges", 439876305);
        ssnMap.put("Marty Stepp", 504386382);
        ssnMap.put("Jenny", 867530912);
        
        System.out.println(ssnMap);

        Iterable<String> nameSet = ssnMap.keySet();
        for (String name : nameSet) {
            System.out.println("Name: " + name);
        }
        
        Iterable<Integer> ssnValues = ssnMap.values();
        for (int ssn : ssnValues) {
            System.out.println("SSN: " + ssn);
        }

        for (String name : ssnMap.keySet()) {
            int ssn = ssnMap.get(name);
            System.out.println(name + "'s SSN is " + ssn);
        }
    }
}