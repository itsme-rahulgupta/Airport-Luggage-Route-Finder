package luggage;

public class FindShortestRouteFactory {

    public static FindShortestRoute createDijkstraAlgorithm(){
        return new FindShortestRouteImpl();
    }
}
