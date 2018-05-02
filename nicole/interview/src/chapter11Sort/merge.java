package chapter11Sort;

/**
 * @author NicoleChen
 * @date 2018/4/3 8:54
 *
 */
public class merge {
    public static void merge(int[] A,int[] B,int lengthA, int lengthB){
        int indexA = lengthA-1;
        int indexB = lengthB-1;
        int length = lengthA+lengthB-1;
        while (indexA>=0 && indexB>=0){
            if(A[indexA]>B[indexB]){
                A[length] = A[indexA];
                indexA--;
            }else{
                A[length] = B[indexB];
                indexB--;
            }
            length--;
        }
        while (indexB>=0){
            A[length] = B[indexB];
            indexB--;
            length--;
        }
    }

    public static void main(String[] args) {
        int[] A = new int[100];
        A[0] = 3;
        A[1] = 6;
        A[2] = 9;
        A[3] = 13;
        A[4] = 15;
        A[5] = 16;
        int[] B = new int[]{0,1,2,4,7,9,14,17,22,25,27};
        merge(A,B,6,11);
        for(int x: A){
            System.out.println(x);
        }
    }
}
