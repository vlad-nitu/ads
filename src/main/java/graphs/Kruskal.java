package graphs;


import commons.Edge;
import commons.UnionFind;

import java.util.*;

public class Kruskal {

    /**
     * Builds a Minimum Spanning Tree (MST) using
     * Kruskal's Algorithm (as learned in class).
     * Nodes are numbered from 0 to n - 1.
     *
     * @param n     the amount of nodes in the graph
     * @param edges the edges that comprise the graph
     * @return the list of edges that should be included in the MST
     */
    public static List<Edge> buildMST(int n, List<Edge> edges) {
        List<Edge> MST = new ArrayList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (Edge edge : edges) pq.add(edge);

        UnionFind data = new UnionFind(n);

        while (MST.size() < n - 1) {
            Edge edge = pq.poll();
            int from = edge.getFrom();
            int to = edge.getTo();
            if (data.union(from, to)) // from and to belong to different sets -> union
                MST.add(edge);
        }

        return MST;
    }
}



