import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;
class Reuters
{
    public static Map<String, Map<String,Integer>> mapD = new HashMap<String, Map<String,Integer>>();
    public static Map<String, Map<String,Integer>> mapC = new HashMap<String, Map<String,Integer>>();
    public Map<String, Integer> mergeSumOfMaps(Map<String, Integer>... maps)
    {
        final Map<String, Integer> resultMap = new HashMap<>();
        for (final Map<String, Integer> map : maps) {
            for (final String key : map.keySet())
            {
                final int value;
                if (resultMap.containsKey(key)) {
                    final int existingValue = resultMap.get(key);
                    value = map.get(key) + existingValue;
                }
                else {
                    value = map.get(key);
                }
                resultMap.put(key, value);
            }
        }
        return resultMap;
    }

    public static void read(String directory) throws FileNotFoundException
    {
        File dir = new File("Lab11/reuters");
        File[] files = dir.listFiles();

        for (File file :files)
        {
            Map<String,Integer> one = new HashMap<>();
            Map<String,Integer> two = mapC.get("earn");
            if(file.isFile())
            {
                try (Scanner scan = new Scanner(file)) {
                    while(scan.hasNext())
                    {
                        String word = scan.next();
                        if(!one.containsKey(word))
                        {
                            one.put(word, 1);
                        }
                        else
                        {
                            one.replace(word,one.get(word)+1);
                        }
                    }
                }
            }
            mapD.put(file.getName(),one);
            if(file.getName().endsWith("earn"))
            {
                if(!mapC.containsKey("earn"))
                {
                    mapC.put("earn", one);
                }
                else
                {
                    Map<String, Integer> result = (new Reuters()).mergeSumOfMaps(one, two);
                    mapC.put("earn",result);
                }
            }
        }
    }




    public static boolean containsD(String term, String document)
    {
        if(mapD.containsKey(document))
        {
            if(mapD.get(document).containsKey(term))
            {
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }

    public static boolean containsC(String term, String category)
    {
        if(mapC.containsKey(category))
        {
            if(mapC.get(category).containsKey(term))
            {
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }

    public static int countD(String term, String document)
    {
        if(mapD.containsKey(document))
        {
            if(mapD.get(document).containsKey(term))
            {
                return mapD.get(document).get(term);
            }
            else
            {
                return 0;
            }
        }
        else
            return 0;
    }

    public static int countC(String term, String category)
    {
        if(mapC.containsKey(category))
        {
            if(mapC.get(category).containsKey(term))
            {
                return mapC.get(category).get(term);
            }
            else
            {
                return 0;
            }
        }
        else
            return 0;
    }

    public static String maxD(String document)
    {
        Map<String,Integer> one = new HashMap<>();
        for(Entry<String,Integer> entry:mapD.get(document).entrySet())
        {
            one.put(entry.getKey(), entry.getValue());
        }
        Collection<Integer> c = one.values();
        Iterator<Integer> i =c.iterator();
        int max = i.next();
        while(i.hasNext())
        {
            int temp = i.next();
            if(temp>max)
            {
                max = temp;
            }
        }
        for(Entry<String,Integer> entry:one.entrySet())
        {
            if(entry.getValue()==max)
            {
                return entry.getKey();
            }
        }
        return null;

    }

    public static String maxC(String category)
    {
        Map<String,Integer> one = new HashMap<>();
        for(Entry<String,Integer> entry:mapC.get(category).entrySet())
        {
            one.put(entry.getKey(), entry.getValue());
        }
        Collection<Integer> c = one.values();
        Iterator<Integer> i =c.iterator();
        int max = i.next();
        while(i.hasNext())
        {
            int temp = i.next();
            if(temp>max)
            {
                max = temp;
            }
        }
        for(Entry<String,Integer> entry:one.entrySet())
        {
            if(entry.getValue()==max)
            {
                return entry.getKey();
            }
        }
        return null;

    }

    public static double similarity(String doc1, String doc2)
    {
        Map<String,Integer> m1 = mapD.get(doc1);

        Map<String,Integer> m2 = mapD.get(doc2);

        double total = m1.size()+m2.size();

        double similar = 0;

        for(Entry<String,Integer> en: m2.entrySet())
        {
            if(m1.containsKey(en.getKey()))
            {
                similar++;
            }
        }
        return similar/total;
    }
    public static Set<Character> commonFirstLetters(List<String> l)
    {
        Map<Character,Integer> mapX = new HashMap<Character,Integer>();
        for(String str:l)
        {
            if(!mapX.containsKey(str.toLowerCase().charAt(0)))
            {
                mapX.put(str.toLowerCase().charAt(0), 1);
            }
            else
            {
                int temp = mapX.get(str.toLowerCase().charAt(0));
                mapX.replace(str.toLowerCase().charAt(0),temp+1 );
            }
        }
        Set<Character> se = new TreeSet<Character>();
        for(Map.Entry<Character,Integer> en:mapX.entrySet())
        {
            if(en.getValue()>1)
            {
                se.add(en.getKey());
            }
        }
        System.out.println(mapX);
        return se;
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        read("reuters");
        System.out.println(containsD("billion","21373.txt.earn")); // True
        System.out.println(containsC("billion","earn")); 		   // True
        System.out.println(countD("billion","21373.txt.earn"));    // 2
        System.out.println(countC("billion","earn"));              // 311
        System.out.println(maxD("21373.txt.earn"));                // mln
        System.out.println(maxC("earn"));                          // vs
        System.out.println(similarity("21502.txt.crude","21541.txt.crude")); // 0.10658307210031348

    }
}

