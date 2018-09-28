package chapter7Prob;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author NicoleChen
 * @date 2018/5/2 9:46
 */
public class getKthMagicNumber {
    public static long getKthMagicNumber(long k){
        long start1 = System.nanoTime();
        if(k < 0) return 0;
        long val = 0;
        LinkedList<Long> list = new LinkedList<>();
        addProducts(list,1);
        for(long i = 0; i<k; i++){
            val = removeMin(list);
            addProducts(list,val);
        }
        /*int val = 0;
        LinkedList<Integer> list3 = new LinkedList<>();
        LinkedList<Integer> list5 = new LinkedList<>();
        LinkedList<Integer> list7 = new LinkedList<>();
        list3.add(1);
        for(int i = 0; i <= k; i++){
            int v3 = list3.size()>0 ? list3.peek() : Integer.MAX_VALUE;
            int v5 = list5.size()>0 ? list5.peek() : Integer.MAX_VALUE;
            int v7 = list7.size()>0 ? list7.peek() : Integer.MAX_VALUE;
            val = Math.min(v3,Math.min(v5,v7));
            if(val == v3){
                list3.remove();
                list3.add(3 * val);
                list5.add(5 * val);
            }else if(val == v5){
                list5.remove();
                list5.add(5 * val);
            }else if(val == v7){
                list7.remove();
            }
            list7.add(7 * val);
        }
*/
        long end1 = System.nanoTime();
        System.out.println("Time1 ：" + (end1-start1));
        return val;
    }
    public static long getKthMagicNumber2(long k){
        long start2 = System.nanoTime();
        if(k < 0) return 0;
        long val = 0;
        LinkedList<Long> list3 = new LinkedList<>();
        LinkedList<Long> list5 = new LinkedList<>();
        LinkedList<Long> list7 = new LinkedList<>();
        list3.add((long)1);
        for(long i=0; i<=k; i++){
            long v3 = list3.size()>0 ? list3.peek() : Integer.MAX_VALUE;
            long v5 = list5.size()>0 ? list5.peek() : Integer.MAX_VALUE;
            long v7 = list7.size()>0 ? list7.peek() : Integer.MAX_VALUE;
            val = Math.min(v3,Math.min(v5,v7));
            if(val == v3){
                list3.remove();
                list3.add(3 * val);
                list5.add(5 * val);
            }else if(val == v5){
                list5.remove();
                list5.add(5 * val);
            }else if(val == v7){
                list7.remove();
            }
            list7.add(7 * val);
        }

        long end2 = System.nanoTime();
        System.out.println("Time2 ：" + (end2 - start2));
        return val;
    }
    private static long removeMin(LinkedList<Long> list) {
        long min = list.peek();
        for(Long i : list){
            if(i < min) min = i;
        }
        /*while (list.contains(min)){
            list.remove(min);
        }*/
        Iterator iter = list.iterator();
        while(iter.hasNext()){
            long str = (long) iter.next();
            if(str == min)
                iter.remove();
        }
        return min;
    }

    private static void addProducts(LinkedList<Long> list, long i) {
        list.add(i*3);
        list.add(i*5);
        list.add(i*7);
    }

    public static void main(String[] args) {
        System.out.println(getKthMagicNumber(2000));
        System.out.println(getKthMagicNumber2(2000));
    }
}
