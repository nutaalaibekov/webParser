package com.nutaalaibekov.service.impl;

import com.nutaalaibekov.dao.HtmlPageDao;
import com.nutaalaibekov.entity.HtmlPage;
import com.nutaalaibekov.service.HtmlPageService;

import java.util.List;

public class HtmlPageServiceImpl implements HtmlPageService {

    private final HtmlPageDao htmlPageDao;

    public HtmlPageServiceImpl(HtmlPageDao htmlPageDao) {
        this.htmlPageDao = htmlPageDao;
    }

    @Override
    public List<HtmlPage> getAllByWebSite(Integer webSiteId) {
        return htmlPageDao.getAllByWebSite(webSiteId);
    }
}
