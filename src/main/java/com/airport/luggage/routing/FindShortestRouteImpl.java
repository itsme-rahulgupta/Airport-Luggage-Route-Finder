package com.airport.luggage.routing;

import com.airport.luggage.routing.pojo.DirectedEdge;
import com.airport.luggage.routing.pojo.RouteGraphMap;
import com.airport.luggage.routing.pojo.Vertex;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FindShortestRouteImpl implements FindShortestRoute {

    private final static String SINGLE_WHITE_SPACE=" ";

    Map<String, RouteGraphMap> visitedMap=new ConcurrentHashMap<String, RouteGraphMap>(); // Visited map with the sourceName as the key

    @Override
    public String findShortestPath(String entryGate, String destGate, List<DirectedEdge> edges) {
        RouteGraphMap routeGraphMap;
        if(visitedMap.containsKey(entryGate)){
            routeGraphMap = visitedMap.get(entryGate);
        }else {
            routeGraphMap = new RouteGraphMap(edges);
            routeGraphMap.dijkstra(entryGate);
            visitedMap.put(entryGate, routeGraphMap);
        }

        List<Vertex> shortestPath= routeGraphMap.getShortestPath(destGate);
        return generatePathLine(shortestPath);
    }

    private String generatePathLine(List<Vertex> path){
        StringBuffer line = new StringBuffer();

        for(Vertex vertex:path){
            line.append(vertex.getName()).append(SINGLE_WHITE_SPACE);
        }
        line.append(": ").append(path.get(path.size()-1).getTime());
        return line.toString();
    }

}
