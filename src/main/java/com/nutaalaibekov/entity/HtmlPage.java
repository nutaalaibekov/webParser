package com.nutaalaibekov.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HtmlPage {
    private Long id;
    private String url;
    private Long categoryId;
    private Long websiteId;
}
