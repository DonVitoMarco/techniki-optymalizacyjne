package pl.marek;

import java.util.Arrays;
import java.util.Set;

public class ShortestPaths {

    private Graph graph;
    private int vertices;

    public ShortestPaths(Graph graph, int vertices) {
        this.graph = graph;
        this.vertices = vertices;
    }

    public int numberOfShortestPaths(int source, int target) {
        int[] distances = new int[vertices + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        int[] routes = new int[vertices + 1];
        Arrays.fill(routes, 0);

        distances[source] = 0;
        routes[source] = 1;

        Set<Integer> graphVertices = graph.getVertices();

        while (graphVertices.size() != 0) {
            int current = findIndexMinValue(distances, graphVertices);
            graphVertices.remove(current);

            if (distances[current] == Integer.MAX_VALUE) {
                break;
            }

            Set<Integer> neighbours = graph.getNeighbours(current);

            for (Integer n : neighbours) {
                int route = distances[current] + graph.getWeight(current, n);
                if (route < distances[n]) {
                    distances[n] = route;
                    routes[n] = routes[current];
                } else if (route == distances[n]) {
                    routes[n] += routes[current];
                }
            }
        }

        return routes[target];
    }

    private int findIndexMinValue(int[] distances, Set<Integer> graphVertices) {
        int minVal = Integer.MAX_VALUE;
        int index = -1;
        for (Integer v : graphVertices) {
            if (distances[v] < minVal) {
                minVal = distances[v];
                index = v;
            }
        }
        return index;
    }
}
