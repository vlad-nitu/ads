package AoC_2021.Day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Day14 {
    public static String template;
    public static Map<String, Character> insertions = new HashMap<>();
    public static Map<String, Long> keys = new HashMap<>();
    public static Map<Character,Long> buckets = new HashMap<>();


    public static void day14() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/vladnitu/Desktop/TUDelft/Q2/ADS/ads-things/src/main/java/AoC_2021/Day14/in.in"));
        template = scanner.nextLine();
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner parse = new Scanner(line).useDelimiter(" -> ") ;
            String string = parse.next() ;
            String charact = parse.next() ;
            insertions.put(string,charact.charAt(0));
            keys.put(string, 0L);
        }
        constructKeys();

        for (int i = 0; i < 40; i++){
            step();
        }
        System.out.println(getResult());
    }

    private static void constructKeys(){
        for (int i = 0; i < template.length() - 1; i++) {
            String key = template.substring(i,i+2);
            if (insertions.containsKey(key)){
                long old = (keys.containsKey(key))?keys.get(key):0;
                keys.put(key,old+1);
            }
            char curr = template.charAt(i+1);
            addValueToBucket(curr,1);
        }

        char curr = template.charAt(0);
        addValueToBucket(curr,1);
    }

    private static void step() {
        Map<String, Long> newKeys = new HashMap<>();
        Iterator it = keys.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry<String,Long> entry = (Map.Entry<String,Long>)it.next();
            String key = entry.getKey();
            Long value = entry.getValue();
            if (value > 0){
                char toAdd = insertions.get(key);
                addValueToBucket(toAdd,value);
                String newKey1 = Character.toString(key.charAt(0)) + toAdd;
                String newKey2 = Character.toString(toAdd) + key.charAt(1);
                long old1 = (newKeys.containsKey(newKey1))?newKeys.get(newKey1):0;
                long old2 = (newKeys.containsKey(newKey2))?newKeys.get(newKey2):0;
                newKeys.put(newKey1,old1+value);
                newKeys.put(newKey2,old2+value);
            }
        }

        keys = newKeys;

    }
    private static void addValueToBucket(char key,long val){
        long old = (buckets.containsKey(key))?buckets.get(key):0;
        buckets.put(key,old+val);
    }

    private static long getResult(){
        long min = Long.MAX_VALUE;
        long max = -1;
        for (Long value : buckets.values()) {
            max = Math.max(value, max) ;
            min = Math.min(value, min) ;
        }
        return max - min;

    }
}
