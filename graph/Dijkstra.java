package graph;

import java.util.Arrays;

public class Dijkstra {
    VisitedVertex vv;
    int matrix[][];

    public void dijkstra(char[] vertexs, int matrix[][], int index) {
        this.matrix = matrix;
        vv = new VisitedVertex(vertexs, 6);
        update(index);
        for (int i = 1; i < vertexs.length; i++) {
            index = nextVertex();
            update(index);

        }

    }

    public int nextVertex() {
        int min = 65535;
        int index = -1;
        for (int j = 0; j < vv.dis.length; j++) {
            if (vv.already_arr[j] == 0 && vv.dis[j] < min) {
                min = vv.dis[j];
                index = j;
            }
        }
        vv.already_arr[index] = 1;
        return index;
    }

    public void update(int index) {
        for (int i = 0; i < vv.already_arr.length; i++) {
            int len = vv.dis[index] + matrix[index][i];
            if (vv.already_arr[i] == 0 && len < vv.dis[i]) {
                vv.pre_visited[i] = index;
                vv.dis[i] = len;
            }
        }
    }

    static class VisitedVertex {
        int already_arr[];
        int pre_visited[];
        int dis[];

        public VisitedVertex(char[] vertexs, int index) {
            already_arr = new int[vertexs.length];
            pre_visited = new int[vertexs.length];
            dis = new int[vertexs.length];
            already_arr[index] = 1;
            Arrays.fill(dis, 65535);
            dis[index] = 0;
        }

    }

}
