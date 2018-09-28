package newCoder;

/**
 * @author NicoleChen
 * @date 2018/5/14 21:36
 */
public class Code_04_Matrix {
    public static class ZigZagPrint{
        public void printing(int[][] matrix){
            int br = matrix.length-1;
            int bc = matrix[0].length-1;
            int row = 0;
            int column = 0;
            boolean flag = true;
            while(row <= br && column <= bc){
                System.out.print(matrix[row][column] + " ");
                if(flag == true){//up
                    if(row == 0 && column < bc){
                        column++;
                        flag = false;
                    }else if(column == bc){
                        row++;
                        flag = false;
                    }
                    else{
                        row--;column++;
                    }


                }else if(flag == false){//down
                    if(column == 0 && row < br){
                        row++;
                        flag = true;
                    }else if(row == br){
                        column++;
                        flag = true;
                    }else{
                        column--;row++;
                    }

                }
            }

        }
    }
    public static class RotateMatrix{
        public void printing(int[][] matrix){

            int a =  0;
            int b = matrix.length-1;
            int tmp;

            while(a < b){
                int m = a;
                int n = b;
                /*while(m < b && n > a){
                tmp = matrix[a][m];
                matrix[a][m] = matrix[n][a];
                matrix[n][a] = matrix[b][n];
                matrix[b][n] = matrix[m][b];
                matrix[m][b] = tmp;
                m++;
                n--;
                }*/
                for(int i = 0; i<b-a; i++){
                    tmp = matrix[a][m+i];
                    matrix[a][m+i] = matrix[n-i][a];
                    matrix[n-i][a] = matrix[b][n-i];
                    matrix[b][n-i] = matrix[m+i][b];
                    matrix[m+i][b] = tmp;
                }
                a++;b--;

            }
            for(int i = 0; i<matrix.length; i++){
                for(int j = 0; j<matrix.length; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
    public static class ClockwisePrinting{
        public void printing(int[][] matrix){
            int ac = 0;
            int ar = 0;
            int br = matrix.length-1;
            int bc = matrix[0].length-1;
            //System.out.println("br"+br);
            //System.out.println("bc"+bc);

            while (ac <= bc && ar <= br) {
                printEdge(matrix,ac++,ar++,bc--,br--);
            }
            System.out.println();

        }

        private void printEdge(int[][] matrix, int ac, int ar, int bc, int br) {
            if (ac == bc) {
                for (int i = ar; i <= br; i++) {
                    System.out.print(matrix[i][ac] + " ");
                }
            }else if (ar == br) {
                for (int i = ac; i <= bc; i++) {
                    System.out.print(matrix[ar][i] + " ");
                }
            }else{
                int curR = ar;
                int curC = ac;
                while(curC < bc){
                    System.out.print(matrix[curR][curC++] + " ");
                }
                while(curR < br){
                    System.out.print(matrix[curR++][curC] + " ");
                }
                while(curC > ac){
                    System.out.print(matrix[curR][curC--] + " ");
                }
                while(curR > ar){
                    System.out.print(matrix[curR--][curC] + " ");
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        //int[][] matrix = {{1,2,3,4}};
        //int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        //int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        ClockwisePrinting cp = new ClockwisePrinting();
        cp.printing(matrix);
        RotateMatrix rm = new RotateMatrix();
        rm.printing(matrix);
        ZigZagPrint zz = new ZigZagPrint();
        zz.printing(matrix);
    }
}
