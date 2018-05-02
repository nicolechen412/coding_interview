package chapter11Sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author NicoleChen
 * @date 2018/4/9 11:07
 */
public class longestIncreasingSubsequence {


    public static void main(String[] args) {
        HtWt h1 = new HtWt(1,3);
        HtWt h2 = new HtWt(2,5);
        HtWt h3 = new HtWt(1,6);
        HtWt h4 = new HtWt(3,7);
        HtWt h5 = new HtWt(2,8);
        ArrayList<HtWt> htWts = new ArrayList<>();
        htWts.add(h1);
        htWts.add(h2);
        htWts.add(h3);
        htWts.add(h4);
        htWts.add(h5);
        ArrayList<HtWt> arrayList = getIncreasingSequence(htWts);
        for(HtWt a:arrayList){
            System.out.println(a.getHt()+" "+a.getWt());
        }

    }

    public static ArrayList<HtWt> getIncreasingSequence(ArrayList<HtWt> array){
        Collections.sort(array);
        return longestIncreasingSubsequence(array);
    }
    public static ArrayList<HtWt> longestIncreasingSubsequence(ArrayList<HtWt> array) {
        ArrayList<HtWt>[] solutions = new ArrayList[array.size()];
        longestIncreasingSubsequence(array,solutions,0);
        ArrayList<HtWt> best_sequence = new ArrayList<>();
        for(int i = 0; i<array.size(); i++){
            best_sequence = seqWithMaxSequence(best_sequence,solutions[i]);
        }
        return best_sequence;
    }

    public static void longestIncreasingSubsequence(ArrayList<HtWt> array, ArrayList<HtWt>[] solutions, int current_index) {
        ArrayList<HtWt> best_sequence = null;
        HtWt current_element = array.get(current_index);
        for(int i = 0; i<current_index; i++){
            if(array.get(i).isBefore(current_element)){
                best_sequence = seqWithMaxSequence(best_sequence,solutions[i]);
            }
        }
        ArrayList<HtWt> new_solution = new ArrayList<>();
        if(best_sequence != null){
            new_solution.addAll(best_sequence);
        }

        new_solution.add(current_element);
        solutions[current_index] = new_solution;
        longestIncreasingSubsequence(array,solutions,current_index+1);
    }

    public static ArrayList<HtWt> seqWithMaxSequence(ArrayList<HtWt> seq1, ArrayList<HtWt> seq2){
        if(seq1 == null) return seq2;
        if(seq2 == null) return seq1;
        if(seq1.size()>seq2.size()){
            return seq1;
        }else {
            return seq2;
        }
    }
}
class HtWt implements Comparable{
    private int Ht;
    private int Wt;

    public HtWt(int ht, int wt) {
        Ht = ht;
        Wt = wt;
    }

    public int getHt() {
        return Ht;
    }

    public void setHt(int ht) {
        Ht = ht;
    }

    public int getWt() {
        return Wt;
    }

    public void setWt(int wt) {
        Wt = wt;
    }

    @Override
    public int compareTo(Object o) {
        HtWt second = (HtWt) o;
        if(this.Ht != second.Ht){
            return ((Integer)this.Ht).compareTo(second.Ht);
        }else{
            return ((Integer)this.Wt).compareTo(second.Wt);
        }
    }

    public boolean isBefore(HtWt other){
        if(this.Ht<other.Ht && this.Wt<other.Wt) return true;
        else return false;
    }
}
