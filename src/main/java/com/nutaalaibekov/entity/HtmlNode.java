package com.nutaalaibekov.entity;

import com.nutaalaibekov.enums.OutputDataType;
import com.nutaalaibekov.enums.NodePart;
import lombok.*;

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

}
