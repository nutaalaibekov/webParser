package com.nutaalaibekov.model;

import com.nutaalaibekov.enums.TargetType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageParserConfig {
    private Long id;
    private String targetSelector;
    private TargetType targetType;
    private String targetId;
    private String fieldName;
    private Long parentId;
}
