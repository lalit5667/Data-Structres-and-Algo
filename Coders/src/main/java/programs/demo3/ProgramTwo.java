package main.java.programs.demo3;

import java.util.LinkedHashMap;
import java.util.Map;

public class ProgramTwo {

    Map<Integer, Integer> map;
    int capacity;
    public ProgramTwo(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            int val = map.get(key);
            map.remove(key);
            map.put(key, val);
            return val;
        }
        return -1;
    }

    public void set(int key, int value) {
        map.put(key, value);
        if(map.size() > capacity ){
            Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) map.entrySet().toArray()[0];
            int firstKey = entry.getKey();
            map.remove(firstKey);
        }
    }


}


class check{
    public static void main(String args[]){
        ProgramTwo obj = new ProgramTwo(2);
//6 2 S 2 1 S 1 1 S 2 3 S 4 1 G 1 G 2
        obj.set(2, 1);
        obj.set(1, 1);
        obj.set(2, 3);
        obj.set(4, 1);
        System.out.println(obj.get(2));

        System.out.println(obj.get(1));
        obj.set(1, 5);
        obj.set(1, 2);
        System.out.println(obj.get(1));
        System.out.println(obj.get(2));

    }
}