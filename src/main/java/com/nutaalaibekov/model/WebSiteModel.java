package com.nutaalaibekov.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WebSiteModel {
    private Long id;
    private String url;
    private String description;
    private boolean isActive;
}
