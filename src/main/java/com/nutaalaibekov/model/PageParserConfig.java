package com.nutaalaibekov.model;

import com.nutaalaibekov.enums.DataNodeType;
import com.nutaalaibekov.enums.HtmlElementPartType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PageParserConfig {
    private Long id;
    private DataNodeType dataNodeType;
    private String dataPropertyname;
    private Boolean isUniqueIdentifier;

    private String elementSelector;
    private HtmlElementPartType elementPartType;
    private String elementPartId;

    private Long pageId;
}
