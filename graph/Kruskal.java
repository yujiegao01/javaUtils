package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {

    public EdgeData[] kruskal(char[] vertexs, int[][] matrix) {
        Graph graph = new Graph(vertexs, matrix);
        EdgeData[] edgeDataArr = getAllEdgeDataAndSort(matrix);
        EdgeData[] mstTree = new EdgeData[vertexs.length - 1];
        int ends[] = new int[graph.edgeNum];
        int index = 0;
        for (int i = 0; i < edgeDataArr.length; i++) {
            int p1 = edgeDataArr[i].start;
            int p2 = edgeDataArr[i].end;
            int p1End = getEnd(ends, p1);
            int p2End = getEnd(ends, p2);
            if (p1End != p2End) {
                ends[p1End] = p2End;
                mstTree[index++] = edgeDataArr[i];
            }

        }
        return mstTree;
    }

    public int getEnd(int ends[], int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;

    }

    public EdgeData[] getAllEdgeDataAndSort(int[][] matrix) {
        List<EdgeData> list = new ArrayList<EdgeData>();
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                if (matrix[i][j] < Integer.MAX_VALUE) {
                    list.add(new EdgeData(i, j, matrix[i][j]));
                }

            }

        }
        Collections.sort(list);
        EdgeData[] edgeDataArr = new EdgeData[list.size()];
        return list.toArray(edgeDataArr);

    }

    class EdgeData implements Comparable<EdgeData> {
        int start;
        int end;
        int weight;

        public EdgeData(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(EdgeData o) {

            return this.weight - o.weight;
        }

    }

    class Graph {
        int edgeNum;
        char vertexs[];
        int matrix[][];

        public Graph(char vertexs[], int matrix[][]) {
            this.vertexs = vertexs;
            this.matrix = matrix;
            for (int i = 0; i < vertexs.length; i++) {
                for (int j = i + 1; j < vertexs.length; j++) {
                    if (matrix[i][j] < Integer.MAX_VALUE) {
                        this.edgeNum++;
                    }

                }

            }

        }
    }

}
