package luggage;

import com.airport.luggage.routing.pojo.DirectedEdge;

import java.util.List;

public interface FindShortestRoute {
    public String findShortestPath(String entry, String dest, List<DirectedEdge> graphEdges);
}
