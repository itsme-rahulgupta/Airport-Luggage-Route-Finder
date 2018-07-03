package com.airport.luggage.routing;

public class FindShortestRouteFactory {

    public static FindShortestRoute createDijkstraAlgorithm(){
        return new FindShortestRouteImpl();
    }
}
