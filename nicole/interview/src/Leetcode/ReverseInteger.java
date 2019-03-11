package Leetcode;/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2018/10/26 下午4:11
 * desc  :
 */



import java.math.BigInteger;

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

        //System.out.println(strStr("hello","ll"));

        //int[] nums = new int[]{1,3,5,6};
        //int target = 0;
        //System.out.println(searchInsert(nums, target));

        //System.out.println(countAndSay(5));

        //int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        //int[] nums = new int[]{-2,-1};
        //System.out.println(maxSubArray(nums));

        //String s = "cfjv nvjfdbvfj nkvjfd njjvdflib";
        //System.out.println(lengthOfLastWord(s));

        //int[] a = new int[]{1,3,9,9};
        //int[] b = plusOne(a);
        //for (int i = 0; i < b.length; i++) {
        //    System.out.print(b[i]+ " ");
        //}

        //String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        //String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        //String a = "101";
        //String b = "11";
        //System.out.println(addBinary(a,b));
        //"10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
       // "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"

        int x = 9;
        System.out.println(mySqrt(x));
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

    public static int romanToInt(String str){     //罗马数字转数字
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

    public static String longestCommonPrefix(String[] strs){      //最长公共前缀

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

    public static boolean isValid(String s){    //有效括号公式
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
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){  //合并两个有序链表
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

    public static int removeDuplicates(int[] nums) {    //移除重复的数字，不增加新的空间
        if(nums.length == 0) return 0;


        int p = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[p]){

                nums[++p] = nums[i];

            }
        }

        return p+1;
    }

    public static int removeElement(int[] nums, int val) {    //移除指定的数字，不增加新的空间

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

    public static int strStr(String haystack, String needle) {  //返回needle字符在haystack的索引位置，不存在返回-1，空返回0
        if(haystack.contains(needle)){
            return haystack.indexOf(needle);
        }else{
            return -1;
        }
    }

    public static int searchInsert(int[] nums, int target){   //返回target在有序数组中的位置，没有则返回应该在的位置

        //int pos = 0;
        for (int i = 0; i < nums.length; i++) {

            if(target == nums[i]){
                return i;
            }
            if(target < nums[i]){
                return i;

            }
        }
        return nums.length;

    }

    public static String countAndSay(int n){    //1由1个1组成为11，11由2个1组成为21，21由1个2和1个1组成为1211，以此类推
        int count = 0;
        char num = '1';
        StringBuffer sb = new StringBuffer();

        sb.append(num);
        StringBuffer sb2 = new StringBuffer();


        for (int i = 0; i < n-1; i++) {
            num = sb.charAt(0);
            for (int j = 0; j < sb.length(); j++) {
                if(sb.charAt(j) != num){
                    if(count != 0){
                        sb2.append(count);
                        sb2.append(num);
                    }
                    num = sb.charAt(j);
                    count = 1;
                }else{
                    count++;
                }
                if(sb.length()-1 == j){
                    sb2.append(count);
                    sb2.append(num);
                    break;
                }
            }

           // System.out.println("sb:" + sb2);
            sb = sb2;
            sb2 = new StringBuffer();
            count = 0;
        }
        return sb.toString();
    }

    //其他方法
    /*public String countAndSay(int n) {
        if (n < 1) return "";
        String temp = "1";
        for (int i = 1; i < n; i++) {
            temp = countAndSay(temp);
        }
        return temp;
    }

    private String countAndSay(String s) {
        if (s.equals("")) return "";
        char[] c = s.toCharArray();
        int cur = 1, i = 1;
        StringBuilder sb = new StringBuilder();
        for (; i < c.length; i++) {
            if (c[i - 1] == c[i]) cur++;
            else {
                sb.append(cur).append(c[i - 1] - '0');
                cur = 1;
            }
        }
        sb.append(cur).append(c[i - 1] - '0');
        return sb.toString();
    }*/

    public static int maxSubArray(int[] nums){

       /* int length = nums.length;
        int sum;
        int max = nums[0];
        //if(nums.length == 1) max = nums[0];
        for (int i = 1; i < length; i++) {
            max = max > nums[i] ? max : nums[i];
        }
        for (int i = 0; i < length ; i++) {
            sum = nums[i];
            for (int j = i + 1; j < length; j++) {
                sum += nums[j];
                max = max > sum ? max : sum;
            }

        }*/

       //DP
       int length = nums.length;
       int maxCur = nums[0];
       int maxEnd = nums[0];
        for (int i = 1; i < length; i++) {
            maxCur = Math.max(maxCur + nums[i], nums[i]);
            maxEnd = Math.max(maxCur, maxEnd);
        }

        return maxEnd;
    }



    public static int lengthOfLastWord(String s) {

        String ss = s.trim();
        if(ss.equals("")) return 0;
        int cur = ss.lastIndexOf(" ");
        return ss.length() - 1 - cur;
    }

    public static int[] plusOne(int[] digits) {

       /* int length = digits.length;
        int[] newDigits = new int[length+1];

        *//*for (int i = 0; i < length +1; i++) {
            System.out.println(newDigits[i]);
        }*//*
        if(digits[length - 1] != 9){
            digits[length - 1]++;
            return digits;
        }
        while(digits[length - 1] == 9){
            length--;
            if(length == 0) {
                newDigits[0] = 1;
                break;
            }
        }
        //if(length != 0) newDigits[length-1]++;
        if(length != 0){
            for (int i = 0; i < length; i++) {
                newDigits[i+1] = digits[i];
            }
            newDigits[length] = ++digits[length-1];
        }

        if(newDigits[0] != 0) {
            return newDigits;
        }else{
            int[] digits2 = new int[newDigits.length-1];
            for (int i = 0; i < digits2.length-1; i++) {
                digits2[i] = newDigits[i+1];
            }
            return digits2;
        }*/
       int length = digits.length;
        for (int i = length-1; i >= 0 ; i--) {
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newDigits = new int[length + 1];
        newDigits[0] = 1;

        return newDigits;

    }

    public static String addBinary(String a, String b) {

        /*BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);

        //long y = Long.parseLong(b,2);
        //System.out.println("a : " + x + " b : " + y);
        //return a;
        //BigInteger sum = x.add(y);
         return x.add(y).toString(2);*/

        StringBuilder sb = new StringBuilder();

        int i = a.length()-1;
        int j = b.length()-1;
        int sum;
        int cur = 0;
        while(i >= 0 || j >= 0){
            sum = cur;
            //System.out.println(a.indexOf(i));
            if(i >= 0 )
                sum += a.charAt(i--) - '0';
            if(j >= 0)
                sum += b.charAt(j--) - '0';
            cur = sum / 2;
            sb.append(sum % 2);
        }
        if(cur != 0) sb.append(1);

        return sb.reverse().toString();
    }

    public static int mySqrt(int x) {
        //System.out.println((int) Math.sqrt(x));
        //return (int)Math.sqrt(x);


        int start = 1; int end = x / 2;
        int mid = 0;
        if(x == 1) return 1;
        while(start < end){
            mid  = (start + end) / 2 ;
            if(mid + 1 > x / (mid + 1) && mid <= x / mid){
                return mid;
            }else if(mid > x / mid){
                end = mid;
            }else{
                start = mid;
            }
        }
        return mid;
    }
}


