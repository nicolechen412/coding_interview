package chapter1String;

/**
 * @author NicoleChen
 * @date 2018/3/11 12:36
 */
public class rotate {
    public static void rotate(int[][] matrix){


        int len = matrix.length;
        for(int layer = 0; layer<len/2; layer++){
            int first = layer;
            int last = len - 1 - layer;
            for(int i = layer; i<last; i++){
                int offset =  i - first;//注意偏移,除第一次循环外，每一层索引按从后往前旋转的层，要注意索引。
                //例如4*4，左向上的第二层时，last已经改变，直接使用last-i，位置错误。
                int top = matrix[first][i];
                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;


            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,1,1,1},{2,2,2,2},{3,3,3,3},
                {4,4,4,4}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            
            System.out.println();
        }
    }
}
