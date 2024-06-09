package com.veoow.gpsDijk;

import com.veoow.gpsDijk.entity.Node;
import com.veoow.gpsDijk.util.DijkAlgorithm;
import com.veoow.gpsDijk.util.Graph;

public class GpsDijk {
    public static void main(String[] args) {
        Graph grapho = new Graph();
        DijkAlgorithm dijk = new DijkAlgorithm(grapho);

        Node city1 = grapho.addNode(40.712776, -74.005974, "city1");
        Node city2 = grapho.addNode(40.712217, -74.004879, "city2");
        Node city3 = grapho.addNode(40.711659, -74.003785, "city3");
        Node city4 = grapho.addNode(40.710589, -74.005131, "city4");
        Node city5 = grapho.addNode(40.710025, -74.003621, "city5");

        grapho.addEdge(city1, city2, 100);
        grapho.addEdge(city1, city3, 200);
        grapho.addEdge(city2, city3, 150);
        grapho.addEdge(city2, city4, 250);
        grapho.addEdge(city3, city5, 300);
        grapho.addEdge(city4, city5, 100);

        dijk.minShortestPath(city3, city1);
    }
}
