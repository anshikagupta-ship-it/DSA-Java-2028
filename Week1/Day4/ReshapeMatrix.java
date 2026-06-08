package Week1.Day4;
import java.util.Arrays;

public class ReshapeMatrix {


    public static int[][] matrixReshape(int[][] mat, int r, int c) {

        int rows = mat.length;
        int cols = mat.length;

        if (rows * cols != r * c) {
            return mat;
        }

        int[][] result = new int[r][c];

        int row = 0;
        int col = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                result[row][col] = mat[i][j];

                col++;

                if (col == c) {
                    col = 0;
                    row++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] mat = {
                {1, 2},
                {3, 4}
        };

        int[][] result = matrixReshape(mat, 1, 4);

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}