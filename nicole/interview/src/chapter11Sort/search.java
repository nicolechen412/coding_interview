package chapter11Sort;

/**
 * @author NicoleChen
 * @date 2018/4/4 14:31
 * 字符串的旋转：将字符串前面的若干个字符移动到字符串的尾部
 */
public class search {
    public static int search(int[] a, int left, int right, int x){
        int mid = (left+right)/2;
        if(x == a[mid])
            return mid;
        if(left>right)
            return -1;
        if(a[left]<a[mid]){
            if(x>=a[left] && x<= a[mid]){
                return search(a,left,mid-1,x);
            }else{
                return search(a,mid+1,right,x);
            }
        }else if(a[mid]<a[right]){
            if(x>=a[mid] && x<=a[right]){
                return search(a,mid+1,right,x);
            }else{
                return search(a,left,mid-1,x);
            }
        }else if(a[mid] == a[left]){
            if(a[right] != a[mid]){
                return search(a,mid+1,right,x);
            }else{
                int result = search(a,left,mid-1,x);
                if(result == -1){
                    return search(a,mid+1,right,x);
                }else {
                    return result;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] a = new int[]{10,15,20,0,5};
        int[] b = new int[]{50,5,20,30,40};
        System.out.println(search(b,0,b.length-1,5));
    }
}
