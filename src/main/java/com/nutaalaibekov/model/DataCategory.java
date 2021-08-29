package com.nutaalaibekov.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataCategory {
    private Long id;
    private String name;
    private String description;
    private Long parentId;
}
