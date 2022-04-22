package graphs;

import commons.AdaptablePQ;
import commons.Graph;
import commons.Vertex;
import commons.VertexNumPair;

public class Dijkstra {
    /**
     * Returns the length of the shortest path between vertex a and b in graph g.
     * @param g Graph to consider.
     * @param a Vertex to start from.
     * @param b Vertex to go to.
     * @return The length of the shortest path between a and b, or -1 if no such path exists.
     */
    public static int shortestPath(Graph g, Vertex a, Vertex b) {

        int N = g.getAllVertices().size();
        int[] D = new int[N];
        boolean[] known = new boolean[N] ;

        AdaptablePQ pq = new AdaptablePQ() ;
        pq.insertOrReplace(a, 0) ;

        for (int i = 0 ;  i < N ; ++i)
        {if (i != a.getId())
            D[i] = Integer.MAX_VALUE;
        else D[i] = 0;}


        if (a == b) return 0 ;

        while (!pq.isEmpty()) {
            VertexNumPair u_aux = pq.removeMin() ;
            Vertex u = u_aux.getVertex() ;
            int u_id = u.getId() ;
            known[u_id] = true;

            for (VertexNumPair v_aux: g.getNeighbours(u)){
                Vertex v = v_aux.getVertex();
                int wgt = v_aux.getNum() ;
                int v_id = v.getId() ;
                if (!known[v_id] && D[u_id] + wgt < D[v_id]) {
                    D[v_id] = D[u_id] + wgt;
                    pq.insertOrReplace(v, D[v_id]) ;
                }
            }

        }

        if (D[b.getId()] == Integer.MAX_VALUE)
            return -1;
        else return D[b.getId()] ;
    }
}
