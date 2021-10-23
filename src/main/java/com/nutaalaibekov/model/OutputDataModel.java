package com.nutaalaibekov.model;

import com.nutaalaibekov.enums.OutputDataType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OutputDataModel {
    private OutputDataType outputType;
    private String outputKey;
    private Boolean isUnique;

    private NodeModel targetNode;
}
