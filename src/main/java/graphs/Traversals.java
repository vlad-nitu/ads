package graphs;

import commons.Vertex;
import commons.VertexNumPair;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Traversals {
    /**
     * Breadth First Search algorithm
     *
     * @param u
     * @param search
     * @param known
     * @return
     */
    public static boolean BFS(Vertex u, Vertex search, Set<Vertex> known) {
        Queue<Vertex> q = new LinkedList<>();
        q.offer(u);
        known.add(u);
        if (u.equals(search)) return true; // 'a' and 'b' are the same vertex

        while (!q.isEmpty()) {
            Vertex new_u = q.poll();

            for (VertexNumPair v : new_u.getNeighbours())
                if (!known.contains(v)) {
                    known.add(v.getVertex());
                    q.offer(v.getVertex());
                    if (v.equals(search)) return true; // If we reached 'b' by starting from 'a'
                }
        }


        return false; //Otherwise, return false since we could not reach 'b' by starting from 'a'
    }

    /**
     * Depth First Search algorithm
     *
     * @param s
     * @param known
     */
    public static void DFS(Vertex s, Set<Vertex> known) {
        known.add(s);
        for (VertexNumPair next : s.getNeighbours())
            if (!known.contains(next.getVertex())) DFS(next.getVertex(), known);

        return;
    }
}
