package com.nutaalaibekov.service;

import com.nutaalaibekov.entity.HtmlNodes;

import java.util.List;

public interface HtmlNodesService {
    List<HtmlNodes> getByPageId(Long pageId);
}
