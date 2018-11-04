/**
 * 在有序的二维数组中查找某个数
 * @author William Mou
 * @date 2018/11/4 21:46
 */
public class FindInPartiallySortedMatrix {
    public static boolean Find(int[][] matrix,int number){
        boolean found = false;
        if (matrix != null && matrix.length != 0){
            int rows = matrix.length; //行数
            int columns = matrix[0].length; //列数
            int row = 0; //当前行
            int column = columns - 1;
            while(row < rows && column >= 0){
                if (matrix[row][column] == number){
                    found = true;
                    break;
                }else if (matrix[row][column] > number){
                    -- column;
                }else {
                    ++ row;
                }
            }
        }
        return  found;
    }
    public static void main(String[] args){
        int[][] matrix = { { 1, 2, 8, 9},{ 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
        System.out.println(Find(matrix,7));
    }
}
