package chapter11Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * @author NicoleChen
 * @date 2018/4/4 9:52
 */
class AnagramComparator implements Comparator<String> {

    //方法一：使用排序算法并修改比较器
    public String sortChars(String s){
        char[] content  = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
    @Override
    public int compare(String o1, String o2) {
        return sortChars(o1).compareTo(sortChars(o2));
    }
    //方法二：使用散列表
    public void sort(String[] array){
        Hashtable<String,LinkedList<String>> hash = new Hashtable<>();
        for(String s: array){
            String key = sortChars(s);
            if(!hash.containsKey(key)){
                hash.put(key,new LinkedList<String>());
            }
            LinkedList<String> list = hash.get(key);
            list.push(s);
        }
        int index = 0;
        for(String s: hash.keySet()){
            LinkedList<String> list2 = hash.get(s);
            for(String ss: list2){
                array[index] = ss;
                index++;
            }
        }
    }
}

public class sortString{

    public static void main(String[] args) {
        String[] array = new String[]{"rtdf","dfrt","dcfa","drft","adfc"};
        //Arrays.sort(array,new AnagramComparator());
        AnagramComparator ac =new AnagramComparator();
        ac.sort(array);
        for(String s:array){
        System.out.println(s);
        }
    }
}
