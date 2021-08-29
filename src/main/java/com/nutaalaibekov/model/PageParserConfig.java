package com.nutaalaibekov.model;

import com.nutaalaibekov.enums.DataType;
import com.nutaalaibekov.enums.TargetType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PageParserConfig {
    private Long id;
    private DataType dataType;
    private String targetTagSelector;
    private TargetType targetType;
    private String targetId;
    private String fieldName;
    private Long parentId;
    private Long pageId;
}
