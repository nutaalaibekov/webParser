package com.nutaalaibekov.service.impl;

import com.nutaalaibekov.dao.PageDao;
import com.nutaalaibekov.entity.HtmlPage;
import com.nutaalaibekov.service.HtmlPageService;

import java.util.List;

public class HtmlPageServiceImpl implements HtmlPageService {

    private final PageDao pageDao;

    public HtmlPageServiceImpl(PageDao pageDao) {
        this.pageDao = pageDao;
    }

    @Override
    public List<HtmlPage> getAllByWebSite(Integer webSiteId) {
        return pageDao.getAllByWebSite(webSiteId);
    }
}
