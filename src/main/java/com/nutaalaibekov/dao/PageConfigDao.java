package com.nutaalaibekov.dao;

import com.nutaalaibekov.entity.HtmlNodes;

import java.util.List;

public interface PageConfigDao {
    List<HtmlNodes> getByWebPageId(Integer webPageId);
}
