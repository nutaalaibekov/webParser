package com.nutaalaibekov.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WebSiteModel {
    private Long id;
    private String uri;
    private String url;
    private String description;
}
