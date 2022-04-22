package graphs;

import commons.Road;
import commons.UnionFind;

import java.util.*;

public class Kruskal {

    /**
     * @param village Adjacency map representing the village.
     * @param coatiHouses The IDs of the coati houses that should be connected.
     * @return The roads on which the traps should be dismantled.
     */
    public static Set<Road> regroupTheCoatis(List<Map<Integer, Integer>> village, Set<Integer> coatiHouses) {
        Set<Road> res = new HashSet<>() ;
        int N = village.size() ;
        int M = coatiHouses.size() ;
        UnionFind uf = new UnionFind(N) ;
        if (village == null || coatiHouses == null) return null;
        if (village.size() == 0) return res;
        if (coatiHouses.size() == 0) return res;

        List<Road> roads = new ArrayList<>() ;
        for (int u_id = 0 ; u_id < N ; ++u_id)
            if (coatiHouses.contains(u_id))
            {

                Map<Integer,Integer> map = village.get(u_id) ;
                if (map != null)
                    for (int v_id = 0 ; v_id < N ; ++v_id)
                        if (coatiHouses.contains(v_id) && map.get(v_id) != null) // exists a path (u,v)
                        {


                            int wgt = map.get(v_id) ;
                            Road road = new Road(u_id, v_id, wgt) ;
                            //Check whether road is contained in res already. since the graph is undirected
                            boolean isContained = false;
                            for (Road search_road: roads)
                                if (search_road.equals(road)) isContained = true ;

                            if (!isContained)
                                roads.add(road) ;
                        }
            }

        sortByWeight(roads) ; // Increasing sort by roads

        int curr_pos = 0 ;
        while (res.size() < M - 1 && curr_pos < roads.size()) {
            Road road = roads.get(curr_pos) ;
            curr_pos ++ ;

            int from = road.getFrom() ;
            int to = road.getTo() ;
            if (uf.union(from, to))
                res.add(road) ;
            //else will ignore this edge

        }

        if (res.size() == M - 1)
            return res;
        else return null;



    }

    public static void sortByWeight(List<Road> roads) {
        for (int i = 0 ; i < roads.size() - 1 ; ++i)
            for (int j = i + 1; j < roads.size() ; ++j)
                if (roads.get(i).getTraps() > roads.get(j).getTraps())
                {
                    Road road = roads.get(i) ;
                    roads.set(i, roads.get(j)) ;
                    roads.set(j, road) ;
                }
    }
}



