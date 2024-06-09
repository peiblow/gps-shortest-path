package com.veoow.gpsDijk.entity;

import lombok.*;

import java.util.List;
import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Node {
    private Long id;
    private Double lat;
    private Double lng;
    private String label;

    public Node(Double lat, Double lng, String label) {
        this.id = new Random().nextLong();
        this.lat = lat;
        this.lng = lng;
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
