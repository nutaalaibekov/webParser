package com.nutaalaibekov.model;

import com.nutaalaibekov.enums.NodePart;
import lombok.Data;

@Data
public class NodePartModel {
    private NodePart type;
    private String key;
}
