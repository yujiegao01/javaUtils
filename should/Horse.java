package should;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Horse {
    List<BZ> bz = new ArrayList<BZ>();
    int size = 8;
    int[][] matrix = new int[size][size];

    int count = 1;

    public void horse(int x, int y) {
        matrix[x][y] = 1;
        int[][] b = getB(x, y);
        horseA(x, y, 2, b);
        bz.add(new BZ(x, y, 1));
        for (int i = 0; i < size; i++) {
            System.out.println((i) + "    " + Arrays.toString(matrix[i]));

        }

    }

    public boolean horseA(int x, int y, int countNum, int[][] bzNum) {
        if (bzNum.length == 0) {

            if (count == size * size) {
                return true;
            } else {
                return false;
            }
        }

        int[][][] allBz = getAllBz(bzNum);

        for (int i = 0; i < bzNum.length; i++) {

            count++;
            matrix[bzNum[i][0]][bzNum[i][1]] = 1;
            boolean aa = horseA(bzNum[i][0], bzNum[i][1], countNum + 1, allBz[i]);

            if (aa) {
                bz.add(new BZ(bzNum[i][0], bzNum[i][1], countNum));
                return true;
            } else {
                matrix[bzNum[i][0]][bzNum[i][1]] = 0;

                count--;
            }

        }
        return false;
    }

    public int[][][] getAllBz(int[][] bzNum) {

        int[][][] allBz = new int[bzNum.length][][];
        allBz[0] = getB(bzNum[0][0], bzNum[0][1]);
        for (int i = 1; i < bzNum.length; i++) {
            int[][] sbz = getB(bzNum[i][0], bzNum[i][1]);
            allBz[i] = sbz;

            int[][] insertVal = sbz;
            int insertIndex = i;

            int[] insertVal2 = bzNum[i];

            while (insertIndex - 1 >= 0 && sbz.length < allBz[insertIndex - 1].length) {
                allBz[insertIndex] = allBz[insertIndex - 1];
                bzNum[insertIndex] = bzNum[insertIndex - 1];
                insertIndex--;
            }

            allBz[insertIndex] = insertVal;
            bzNum[insertIndex] = insertVal2;

        }

        return allBz;
    }

    public int[][] getB(int x, int y) {

        int x1 = -1, y1 = -1;
        int b[][] = new int[8][2];
        int xx[] = { 2, -2, 1, -1 };
        int yy[] = { 1, -1, 2, -2 };
        int ii = 0;
        for (int i = 0; i < 4; i++) {
            if (x + xx[i] >= 0 && (x + xx[i]) < size) {
                x1 = x + xx[i];

            } else {
                x1 = -1;
            }
            int j = 0;

            for (j = (i >= 2 ? 2 : 0); j < (i >= 2 ? 4 : 2); j++) {
                if (y + yy[j] >= 0 && y + yy[j] < size) {
                    y1 = y + yy[j];
                } else {
                    y1 = -1;
                }

                if (x1 != -1 && y1 != -1 && matrix[x1][y1] == 0) {
                    b[ii][0] = x1;
                    b[ii++][1] = y1;
                }

            }
        }

        int bb[][] = new int[ii][2];

        for (int i = 0; i < ii; i++) {
            bb[i][0] = b[i][0];
            bb[i][1] = b[i][1];
        }

        return bb;
    }

    class BZ {
        int x;
        int y;
        int count;

        public BZ(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;

        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return "x= " + x + " y= " + y + " 步数= " + count;
        }
    }

}
