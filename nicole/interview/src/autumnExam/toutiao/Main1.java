package autumnExam.toutiao;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author NicoleChen
 * @date 2018/8/25 9:58
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int team = Integer.parseInt(sc.next());
        boolean[][] flag1 = new boolean[team][2];
        boolean[] flag;
        int time = 0;

        while(team-- != 0){
            int count = Integer.parseInt(sc.next().trim());

            LinkedList<String>[] lists = new LinkedList[count];
            for (int i = 0; i < count; i++) {

                lists[i] = new LinkedList<>();
                for (String s :sc.next().split("")) {
                    lists[i].add(s);
                }
            }

            String first = lists[0].getFirst();
            int index2 = 0;
            for (int i = 0; i < lists[1].size(); i++) {
                if(lists[1].get(i).equals(first)){
                    index2 = i;
                    break;
                }
            }
            flag  = new boolean[2];
            flag[0] = true;
            for (int i = 0; i < lists[0].size(); i++) {
                String tmp1 = lists[0].get(1);

                String tmp2 ;
                tmp2 = lists[1].get(index2+1 > lists[1].size()-1 ? 0 : index2+1);
                if(!tmp2.equals(tmp1)){
                    tmp2 = lists[1].get(index2-1 < 0 ? lists[1].size()-1 : index2-1);
                    if(!tmp2.equals(tmp1)) {

                        flag1[time++][1] = false;
                        break;
                    }else{
                        flag[0] = false;
                    }
                }else{
                    flag[0] = true;
                }
            }

            check(lists, flag, index2);

            if(flag[1]){
                if(time < flag1.length)
                    flag1[time++][1] = true;
            }else{
                if(time < flag1.length)
                    flag1[time++][1] = false;
            }


        }
        for (int i = 0; i < flag1.length; i++) {

            if(flag1[i][1]){
                System.out.println("Yeah");
            }else{
                System.out.println("Sad");
            }
        }

    }

    private static void check(LinkedList<String>[] lists, boolean[] flag, int index2) {
        if(flag[0]){
            for (int i = 0; i < lists[0].size()-1; i++) {
                String tmp1 = lists[0].get(i+1);
                index2 = index2+1 > lists[1].size()-1 ? 0 : index2+1;
                String tmp2 = lists[1].get(index2);
                if(!tmp1.equals(tmp2)){
                    flag[1] = false;
                    return;
                }
            }
            flag[1] = true;

        }else{
            for (int i = 0; i < lists[0].size()-1; i++) {
                String tmp1 = lists[0].get(i+1);
                index2 = index2-1 < 0 ?lists[1].size()-1 : index2-1;
                String tmp2 = lists[1].get(index2);
                if(!tmp1.equals(tmp2)){
                    flag[1] = false;
                    return;
                }
            }
            flag[1] = true;
        }
    }


}
