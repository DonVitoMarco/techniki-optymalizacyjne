package pl.marek;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {

    private List<Edge> edges = new ArrayList<>();

    public void addEdge(int start, int end, int weight) {
        edges.add(new Edge(start, end, weight));
        edges.add(new Edge(end, start, weight));
    }

    public Set<Integer> getVertices() {
        Set<Integer> vertices = new HashSet<>();
        for (Edge e : edges) {
            vertices.add(e.getStart());
            vertices.add(e.getEnd());
        }
        return vertices;
    }

    public Set<Integer> getNeighbours(int vertex) {
        Set<Integer> neighbours = new HashSet<>();
        for (Edge e : edges) {
            if (e.getStart() == vertex) {
                neighbours.add(e.getEnd());
            } else if (e.getEnd() == vertex) {
                neighbours.add(e.getStart());
            }
        }
        return neighbours;
    }

    public int getWeight(int source, int target) {
        for (Edge e : edges) {
            if (e.getStart() == source && e.getEnd() == target) {
                return e.getWeight();
            }
        }
        return 0;
    }
}
