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
public class PageTargetElementModel {
    private Long id;
    private DataNodeType dataNodeType;
    private String dataPropertyname;
    private Boolean isUniqueIdentifier;

    private String elementSelector;
    private HtmlElementPartType elementPartType;
    private String elementPartId;

    private Long pageId;

    public HtmlElementConfigModel toHtmlParserConfig() {
        return HtmlElementConfigModel.builder()
                .dataNodeType(dataNodeType)
                .dataPropertyname(dataPropertyname)
                .isUniqueIdentifier(isUniqueIdentifier)
                .elementSelector(elementSelector)
                .elementPartType(elementPartType)
                .elementPartId(elementPartId)
                .build();
    }
}
