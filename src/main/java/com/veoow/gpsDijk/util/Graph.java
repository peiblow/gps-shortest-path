package com.veoow.gpsDijk.util;

import com.veoow.gpsDijk.entity.Edge;
import com.veoow.gpsDijk.entity.Node;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Graph {
    private Map<Long, Node> nodesMap;
    private Map<Long, List<Edge>> edgesList;

    public Graph() {
        this.nodesMap = new HashMap<>();
        this.edgesList = new HashMap<>();
    }

    public Node addNode(Double lat, Double lng, String label) {
        Node newNode = new Node(lat, lng, label);
        this.nodesMap.putIfAbsent(newNode.getId(), newNode);
        this.edgesList.put(newNode.getId(), new ArrayList<>());

        return newNode;
    }

    public void addEdge(Node src, Node trgt, double distance) {
        Edge newEdge = new Edge(src, trgt, distance);
        Edge oppositeNewEdge = new Edge(trgt, src, distance);

        edgesList.get(src.getId()).add(newEdge);
        edgesList.get(trgt.getId()).add(oppositeNewEdge);
    }
}
