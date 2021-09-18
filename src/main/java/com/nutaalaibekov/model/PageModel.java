package com.nutaalaibekov.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageModel {
    private Long id;
    private String url;
    private Long categoryId;
    private Long websiteId;
}
