package org.problemsolving.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    Map<String, List<String>> graph = new HashMap<>();

    public boolean addVertex(String vertex) {
        if (graph.get(vertex) == null) {
            graph.put(vertex, new ArrayList<>());
            return true;
        }
        return false;

    }

    public boolean addEdegs(String ver1, String ver2) {
        if (graph.get(ver1) != null && graph.get(ver2) != null) {
            graph.get(ver1).add(ver2);
            graph.get(ver2).add(ver1);
            return true;
        }
        return false;
    }

    public boolean removeEdges(String ver1, String ver2) {
        if (graph.get(ver1) != null && graph.get(ver2) != null) {
            graph.get(ver1).remove(ver2);
            graph.get(ver2).remove(ver1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String ver) {
        if (graph.get(ver) != null)
        {
            for (String otherVer : graph.get(ver)) {
                graph.get(otherVer).remove(ver);
            }
            graph.remove(ver);
            return true;
        }
        return false;
    }


    public void printGraph() {
        graph.entrySet().stream().forEach(e ->
        {
            System.out.println(e.getKey() + ":" +
                    String.valueOf(e.getValue()));
        });
    }
}
