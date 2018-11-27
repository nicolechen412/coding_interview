package Leetcode;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2018/10/26 下午4:11
 * desc  :
 */



import java.util.*;

public class ReverseInteger {
    public static void main(String[] args) {
        //reverse(153423006469);
        //
        //System.out.println(isPalindrome(10));
        //
        // System.out.println(romanToInt("III"));

        //String[] strs = new String[]{"flower","flow","flight"};
        //String[] strs = new String[]{"dog","racecar","car"};
        //System.out.println(longestCommonPrefix(strs));

        //System.out.println(isValid("("));

        //int[] nums = new int[]{1,1,2,2,3,3,3,5,5,7,7,7,8};
        //System.out.println(removeDuplicates(nums));

        //int[] nums = new int[]{4,2,0,2,2,1,4,4,1,4,3,2};
        //System.out.println(removeElement(nums,4));

        System.out.println(strStr("hello","ll"));

    }
    public static long reverse(int x){      //反转数字
        //System.out.println(Integer.MAX_VALUE/2);
        //System.out.println(Integer.MIN_VALUE/2);
        //System.out.println((int)Math.pow(2,31)-1);
        //System.out.println((int)Math.pow(-2,31));
        if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE){
            return  0;
        }
        int y = Math.abs(x);
        //System.out.println(y);
        long res = 0;
        while(y >= 10){
            res += y % 10;
            res = res * 10;
            y = y / 10;

        }
        if(y != 0) res += y;

        if(x < 0) res = -res;
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
            res =  0;
        }
        System.out.println(res);
        return res;
    }

    public static boolean isPalindrome(int x){     //判断回文数字
        if(x < 0) return false;
        char[] arr = Integer.toString(x).toCharArray();
        for (int i = 0; i <= arr.length/2 ; i++) {
            if(arr[i] != arr[arr.length-1-i]){
                return false;
            }
        }
        
        return true;

    }

    public static int romanToInt(String str){
        char[] chars = str.toCharArray();
        HashMap<Character,Integer> hash = new HashMap<>();
        hash.put('I',1);
        hash.put('V',5);
        hash.put('X',10);
        hash.put('L',50);
        hash.put('C',100);
        hash.put('D',500);
        hash.put('M',1000);

        int res = hash.get(chars[chars.length-1]);
        for (int i = chars.length-2; i >= 0; i--) {


                if(hash.get(chars[i]) < hash.get(chars[i+1])){
                    res -=  hash.get(chars[i]);

                }else{
                    res +=   hash.get(chars[i]);
                }

        }


        return res;
    }

    public static String longestCommonPrefix(String[] strs){

        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
       /* StringBuffer sb = new StringBuffer();
        LinkedList<String> list = new LinkedList<>();
        list.addAll(Arrays.asList(strs));

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return o1.length()-o2.length();
            }
        });
        //Collections.reverse(list);
        if(list.isEmpty()) return "";
        String first = (String) list.getFirst();
        boolean flag = false;
        for (int i = 0; i < first.length(); i++) {
            System.out.println(first.length());
            System.out.println(first);
            for (int j = 0; j < strs.length; j++) {
                if(first.charAt(i) != strs[j].charAt(i)){
                    return sb.toString();
                }
            }
            sb.append(first.charAt(i));
        }
        return sb.toString();*/
    }

    public static boolean isValid(String s){
        Stack<Character> stack = new Stack();
        boolean res ;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '(' || arr[i] == '[' || arr[i] == '{'){
                stack.push(arr[i]);
                continue;
            }
            if(!stack.empty()){
                if((arr[i] == ')' && stack.pop() != '(') ||
                        (arr[i] == ']' && stack.pop() != '[') ||
                        (arr[i] == '}' && stack.pop() != '{')){
                   return false;
                }
            }else{

                    return false;

            }
        }
        return stack.empty();
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
  }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);

        if(l1 == null && l2 == null) return null;
        if(l1 == null ) return l2;
        if(l2 == null ) return l1;
        ListNode node = head ;

        ListNode pre;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                node.next = l1;
                node = node.next;
                l1 = l1.next;
            }else {
                node.next = l2;
                node = node.next;
                l2 = l2.next;
            }
        }
        if(l1 != null) node.next = l1;
        if(l2 != null) node.next = l2;
        return head.next;
  }

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;


        int p = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[p]){

                nums[++p] = nums[i];

            }
        }

        return p+1;
    }

    public static int removeElement(int[] nums, int val) {

        /*int point = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == val && nums[point] != val){
                //point = i;
                continue;
            }else {
                if ( nums[i] != val) {
                    nums[point++] = nums[i];
                    count++;
                }


            }
        }*/
        int point = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[point++] = nums[i];
            }
        }
        for (int i = 0; i <nums.length ; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        //return count;
        return point;

    }

    public static int strStr(String haystack, String needle) {
        if(haystack.contains(needle)){
            return haystack.indexOf(needle);
        }else{
            return -1;
        }
    }

}
