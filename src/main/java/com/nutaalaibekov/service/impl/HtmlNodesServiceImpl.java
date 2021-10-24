package com.nutaalaibekov.service.impl;

import com.nutaalaibekov.dao.HtmlNodesDao;
import com.nutaalaibekov.entity.HtmlNode;
import com.nutaalaibekov.service.HtmlNodesService;

import java.util.List;

public class HtmlNodesServiceImpl implements HtmlNodesService {

    private final HtmlNodesDao htmlNodesDao;

    public HtmlNodesServiceImpl(HtmlNodesDao htmlNodesDao) {
        this.htmlNodesDao = htmlNodesDao;
    }

    @Override
    public List<HtmlNode> getByPageId(Long pageId) {
        return htmlNodesDao.getByWebPageId(pageId);
    }
}
