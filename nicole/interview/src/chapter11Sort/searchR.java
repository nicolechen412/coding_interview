package chapter11Sort;

/**
 * @author NicoleChen
 * @date 2018/4/8 8:53
 */
public class searchR {
    public static int searchR(String[] strings,String str,int first,int end){
        int mid = (first+end)/2;
        if(first>end) return -1;
        if(strings[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;
            while (true) {
                if (left < first && right > end) {
                    return -1;
                } else if (right <= end && !strings[right].isEmpty()) {
                    mid = right;
                    break;
                } else if (left >= first && !strings[left].isEmpty()) {
                    mid = left;
                    break;
                }
                left--;
                right++;
            }
        }
        if (str.equals(strings[mid])) {
            return mid;
        } else if (strings[mid].compareTo(str) < 0) {
            return searchR(strings, str, mid + 1, end);
        } else {
            return searchR(strings, str, first, mid - 1);
        }

    }
    public static int search(String[] strings,String str){
        return searchR(strings,str,0,strings.length);
    }
    public static void main(String[] args) {
        String[] strings = new String[]{"absdfg","acfg","","bgrf","","","bhujki","","gfhyt","zggt"};
        String str = "bgrf";
        System.out.println(search(strings,str));
    }
}
