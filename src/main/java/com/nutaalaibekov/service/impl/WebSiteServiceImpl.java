package com.nutaalaibekov.service.impl;

import com.nutaalaibekov.dao.WebSiteDao;
import com.nutaalaibekov.entity.WebSites;
import com.nutaalaibekov.service.WebSiteService;

import java.util.List;

public class WebSiteServiceImpl implements WebSiteService {

    private final WebSiteDao webSiteDao;

    public WebSiteServiceImpl(WebSiteDao webSiteDao) {
        this.webSiteDao = webSiteDao;
    }

    @Override
    public List<WebSites> getAllActive() {
        return webSiteDao.getAllActive();
    }
}
