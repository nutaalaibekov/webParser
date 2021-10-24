package com.nutaalaibekov.dao;

import com.nutaalaibekov.entity.HtmlNode;

import java.util.List;

public interface HtmlNodesDao {
    List<HtmlNode> getByWebPageId(Long webPageId);
}
