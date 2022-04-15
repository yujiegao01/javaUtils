package graph;

public class Prim {
    public static void prim(Graph graph, int v) {
        int h1 = -1, h2 = -1;
        int minWeight = 10000;
        int visited[] = new int[graph.verxs];
        visited[v] = 1;

        for (int k = 1; k < graph.verxs; k++) {
            for (int i = 0; i < graph.verxs; i++) {
                for (int j = 0; j < graph.verxs; j++) {
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }

            }
            System.out.println(graph.data[h1] + "," + graph.data[h2] + "," + minWeight);
            visited[h2] = 1;
            minWeight = 1000;

        }

    }

    static class Graph {
        int verxs;
        int data[];
        int weight[][];

        public Graph(int data[], int weight[][]) {
            this.verxs = data.length;
            this.data = data;
            this.weight = weight;

        }
    }

}
