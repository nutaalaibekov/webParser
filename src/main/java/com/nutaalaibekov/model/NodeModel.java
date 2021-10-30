package com.nutaalaibekov.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
public class NodeModel {
    private String selector;
    private List<NodePartModel> parts;
}
