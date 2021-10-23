package com.nutaalaibekov.service.impl;

import com.nutaalaibekov.dao.PageConfigDao;
import com.nutaalaibekov.entity.HtmlNodes;
import com.nutaalaibekov.service.HtmlNodesService;

import java.util.List;

public class HtmlNodesServiceImpl implements HtmlNodesService {

    private final PageConfigDao pageConfigDao;

    public HtmlNodesServiceImpl(PageConfigDao pageConfigDao) {
        this.pageConfigDao = pageConfigDao;
    }

    @Override
    public List<HtmlNodes> getByPageId(Long pageId) {
        return null;
    }
}
