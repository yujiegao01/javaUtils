package graph;

import java.util.Arrays;

import org.junit.Test;
import org.junit.rules.DisableOnDebug;

import graph.Kruskal.EdgeData;

public class GraphTest {

    @Test
    public void test3() {
        int N = 65535;
        char[] vertexs = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int[][] matrix = {
                { N, 5, 7, N, N, N, 2 },
                { 5, N, N, 9, N, N, 3 },
                { 7, N, N, N, 8, N, N },
                { N, 9, N, N, N, 4, N },
                { N, N, 8, N, N, 5, 4 },
                { N, N, N, 4, 5, N, 6 },
                { 2, 3, N, N, 4, 6, N }

        };
        Floyd floyd = new Floyd(vertexs, matrix);
        floyd.floyd();
        System.out.println("  " + Arrays.toString(vertexs));
        for (int i = 0; i < vertexs.length; i++) {
            System.out.println(vertexs[i] + " " + Arrays.toString(floyd.dis[i]));
        }
        System.out.println();
        System.out.println();
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.print(vertexs[floyd.pre[i][j]] + " ");

            }
            System.out.println();
        }

    }

    @Test
    public void test2() {
        int N = 65535;
        char[] vertexs = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int[][] matrix = {
                { N, 5, 7, N, N, N, 2 },
                { 5, N, N, 9, N, N, 3 },
                { 7, N, N, N, 8, N, N },
                { N, 9, N, N, N, 4, N },
                { N, N, 8, N, N, 5, 4 },
                { N, N, N, 4, 5, N, 6 },
                { 2, 3, N, N, 4, 6, N }

        };
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.dijkstra(vertexs, matrix, 6);
        System.out.println(Arrays.toString(dijkstra.vv.dis));

    }

    @Test
    public void test1() {
        int INF = Integer.MAX_VALUE;
        char vertexs[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int matrix[][] = {
                { 0, 12, INF, INF, INF, 16, 14 },
                { 12, 0, 10, INF, INF, 7, INF },
                { INF, 10, 0, 3, 5, 6, INF },
                { INF, INF, 3, 0, 4, INF, INF },
                { INF, INF, 5, 4, 0, 2, 8 },
                { 16, 7, 6, INF, 2, 0, 9 },
                { 14, INF, INF, INF, 8, 9, 0 }
        };
        Kruskal kruskal = new Kruskal();
        EdgeData[] mstTree = kruskal.kruskal(vertexs, matrix);
        for (int i = 0; i < mstTree.length; i++) {
            System.out.println(vertexs[mstTree[i].start] + "," + vertexs[mstTree[i].end] + " = " + mstTree[i].weight);

        }

    }

}
