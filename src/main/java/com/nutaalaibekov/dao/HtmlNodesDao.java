package com.nutaalaibekov.dao;

import com.nutaalaibekov.entity.HtmlNodes;

import java.util.List;

public interface HtmlNodesDao {
    List<HtmlNodes> getByWebPageId(Integer webPageId);
}
