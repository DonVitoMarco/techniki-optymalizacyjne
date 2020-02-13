package pl.marek;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Zadanie05 {

    public static void main(String[] args) {
        List<String> data;
        if (args.length == 0)  {
            System.out.println("Please provide a file path");
            System.exit(1);
        }
        data = readDataFromFile(args[0]);

        List<Pair<Graph, Integer>> graphs = parse(data);

        for (Pair<Graph, Integer> p : graphs) {
            System.out.printf("%d%n", new ShortestPaths(p.getLeft(), p.getRight()).numberOfShortestPaths(1, 2));
        }
    }

    public static List<Pair<Graph, Integer>> parse(List<String> args) {
        List<Pair<Graph, Integer>> graphs = new ArrayList<>();

        int index = 0;

        while (index < args.size()) {
            int vertices = Integer.parseInt(args.get(index).split(" ")[0]);
            if (vertices == 0) {
                break;
            }
            int edges = Integer.parseInt(args.get(index).split(" ")[1]);

            index++;

            Graph g = new Graph();
            for (int i = index; i < index + edges; i++) {
                String[] arg = args.get(i).split(" ");
                int start = Integer.parseInt(arg[0].trim());
                int end = Integer.parseInt(arg[1].trim());
                int cost = Integer.parseInt(arg[2].trim());

                g.addEdge(start, end, cost);
            }
            graphs.add(new Pair<>(g, vertices));

            index += edges;
        }

        return graphs;
    }

    public static List<String> readDataFromFile(String filePath) {
        List<String> data = new ArrayList<>();
        BufferedReader reader = null;
        String line;
        try {
            File in = new File(filePath);
            reader = new BufferedReader(new FileReader(in));
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }
}
