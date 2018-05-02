package chapter11Sort;

/**
 * @author NicoleChen
 * @date 2018/4/8 14:18
 */
public class findElement {
    public static String findElement(int[][] matrix,int num){
        int row = 0;
        int col = matrix[0].length-1;
        while (row<matrix.length && col >=0){
            if(matrix[row][col] == num){
                String s = "row:"+row+" col:"+col;
                return s;
            }else if(matrix[row][col] > num){
                col--;
            }else{
                row++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[][] matrix = {{15,20,40,85},{20,35,80,95},{30,55,95,105},{40,80,100,120}};
        String s = findElement(matrix,55);
        System.out.println(s);
    }
}
