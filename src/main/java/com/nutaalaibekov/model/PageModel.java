package com.nutaalaibekov.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageModel {
    private Long id;
    private String uri;
    private String urls;
    private Long categoryId;
    private Long websiteId;
}
