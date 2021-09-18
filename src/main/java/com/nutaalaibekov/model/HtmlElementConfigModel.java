package com.nutaalaibekov.model;

import com.nutaalaibekov.enums.DataNodeType;
import com.nutaalaibekov.enums.HtmlElementPartType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HtmlElementConfigModel {
    private DataNodeType dataNodeType;
    private String dataPropertyname;
    private Boolean isUniqueIdentifier;

    private String elementSelector;
    private HtmlElementPartType elementPartType;
    private String elementPartId;
}
