package com.veoow.gpsDijk.entity;

import lombok.*;

import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Edge {
    private Long id;
    private Node source;
    private Node target;
    private Double distance;

    public Edge(Node src, Node trg, Double distance) {
        this.id = new Random().nextLong();
        this.source = src;
        this.target = trg;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return source.getLabel() + " -> " + target.getLabel();
    }
}
