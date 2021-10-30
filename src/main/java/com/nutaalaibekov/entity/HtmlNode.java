package com.nutaalaibekov.entity;

import com.nutaalaibekov.enums.OutputDataType;
import com.nutaalaibekov.enums.NodePart;
import com.nutaalaibekov.model.NodeModel;
import com.nutaalaibekov.model.NodePartModel;
import com.nutaalaibekov.model.ParseInstructionModel;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class HtmlNode {
    private Long id;
    private OutputDataType type;
    private String outputKey;
    private Boolean isUnique;

    private String nodeSelector;
    private NodePart nodePart;
    private String nodePartKey;

    private Long pageId;


    public ParseInstructionModel toInstructionModel() {
        return ParseInstructionModel.builder()
                .outputType(this.getType())
                .outputKey(this.getOutputKey())
                .isUnique(this.getIsUnique())
                .inputData(this.toModel())
                .build();
    }

    public NodeModel toModel() {
        return NodeModel.builder()
                .selector(this.nodeSelector)
                .parts(getNodePartsFromEntity())
                .build();
    }

    private List<NodePartModel> getNodePartsFromEntity() {
        return new ArrayList<NodePartModel>() {{
            add(NodePartModel.builder()
                    .key(nodePartKey)
                    .type(nodePart)
                    .build());
        }};
    }

}
