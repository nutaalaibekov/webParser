package com.nutaalaibekov.model;

import lombok.Data;

import java.util.List;

@Data
public class NodeModel {
    private String selector;
    private List<NodePartModel> parts;
}
