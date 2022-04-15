package graph;

import java.util.Arrays;

public class Floyd {
    int[][] dis;
    int[][] pre;
    char[] vertexs;

    public Floyd(char[] vertexs, int[][] matrix) {
        this.vertexs = vertexs;
        this.dis = matrix;
        this.pre = new int[vertexs.length][vertexs.length];
        for (int i = 0; i < vertexs.length; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    public void floyd() {
        for (int k = 0; k < vertexs.length; k++) {
            for (int i = 0; i < vertexs.length; i++) {
                for (int j = 0; j < vertexs.length; j++) {
                    int len = dis[i][k] + dis[k][j];
                    if (len < dis[i][j]) {
                        dis[i][j] = len;
                        dis[j][i] = len;
                        pre[i][j] = pre[k][j];
                        pre[j][i] = pre[k][j];
                    }

                }

            }
        }

    }
}
