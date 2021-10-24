package com.nutaalaibekov.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WebSite {
    private Long id;
    private String url;
    private String description;
    private boolean isActive;
}
