package com.nutaalaibekov.service;

import com.nutaalaibekov.entity.HtmlNode;

import java.util.List;

public interface HtmlNodesService {
    List<HtmlNode> getByPageId(Long pageId);
}
