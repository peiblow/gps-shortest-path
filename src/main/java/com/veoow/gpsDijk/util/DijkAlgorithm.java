package com.veoow.gpsDijk.util;

import com.veoow.gpsDijk.entity.Edge;
import com.veoow.gpsDijk.entity.Node;

import java.util.*;

public class DijkAlgorithm {
    private Graph graph;

    public DijkAlgorithm(Graph graph) {
        this.graph = graph;
    }

    public void minShortestPath(Node source, Node target) {
        Map<Long, Double> distances = new HashMap<>();
        Map<Long, Long> previous = new HashMap<>();

        for (Long node : graph.getNodesMap().keySet()) {
            distances.put(node, Double.MAX_VALUE);
            previous.put(node, null);
        }

        distances.put(source.getId(), 0.0);

        PriorityQueue<Map.Entry<Long, Double>> pq = new PriorityQueue<>(Comparator.comparingDouble(Map.Entry::getValue));
        pq.add(new AbstractMap.SimpleEntry<>(source.getId(), 0.0));

        while (!pq.isEmpty()) {
            Map.Entry<Long, Double> entry = pq.poll();

            long currentNodeId = entry.getKey();
            double currentDistance = entry.getValue();

            if (currentNodeId == target.getId()) {
                break;
            }

            for (Edge edge : graph.getEdgesList().getOrDefault(currentNodeId, Collections.emptyList())) {
                long neighborId = edge.getTarget().getId();
                double newDist = currentDistance + edge.getDistance();
                if (newDist < distances.get(neighborId)) {
                    distances.put(neighborId, newDist);
                    previous.put(neighborId, currentNodeId);
                    pq.add(new AbstractMap.SimpleEntry<>(neighborId, newDist));
                }
            }
        }

        printPath(previous, source.getId(), target.getId());
        System.out.println("Shortest distance from " + source.getLabel() + " to " + target.getLabel() + ": " + distances.get(target.getId()));
    }

    private void printPath(Map<Long, Long> previous, long startId, long endId) {
        List<String> path = new ArrayList<>();

        for (Long at = endId; at != null; at = previous.get(at)) {
            path.add(graph.getNodesMap().get(at).getLabel());
        }
        Collections.reverse(path);
        System.out.println("Path: " + path);
    }
}
