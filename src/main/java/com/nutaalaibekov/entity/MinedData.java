package com.nutaalaibekov.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MinedData {
    private Long id;
    private String data;
    private Boolean isUnique;
    private Date createdDate;
    private Long pageId;
}
