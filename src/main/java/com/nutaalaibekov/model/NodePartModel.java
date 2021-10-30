package com.nutaalaibekov.model;

import com.nutaalaibekov.enums.NodePart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NodePartModel {
    private NodePart type;
    private String key;
}
