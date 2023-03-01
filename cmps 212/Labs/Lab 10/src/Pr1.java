 import java.util.*;
    public class Pr1{
        public static void main(String[] args){
            List<String> list = new ArrayList<>(Arrays.asList("hi", "how", "is", "He", "Marty!", "this", "think", "feel", "fun", "morning?", "fine.", "?huh?", "HOW", "I"));
            System.out.println(commonFirstLetters(list)); //it works, returns [h, i, m]
        }
        public static Set<String> commonFirstLetters(List<String> list) { //runs in o(n)
            Set<Character> letters = new HashSet<Character>(); //first data structure
            Set<String> res = new HashSet<String>(); //second data structure
            for (String s : list) {
                char temp = Character.toLowerCase(s.charAt(0));
                if (letters.contains(temp)) {
                    res.add("" + temp);
                }
                letters.add(temp);
            }
            return res;
        }
    }
