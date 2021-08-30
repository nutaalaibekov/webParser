package com.nutaalaibekov.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageDataModel {
    private Long id;
    private String data;
    private String dataUniqueId;
    private Date createdDate;
    private Long pageId;
}
