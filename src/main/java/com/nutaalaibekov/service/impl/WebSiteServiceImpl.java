package com.nutaalaibekov.service.impl;

import com.nutaalaibekov.dao.WebSiteDao;
import com.nutaalaibekov.model.WebSiteModel;
import com.nutaalaibekov.service.WebSiteService;

import java.util.List;

public class WebSiteServiceImpl implements WebSiteService {

    private final WebSiteDao webSiteDao;

    public WebSiteServiceImpl(WebSiteDao webSiteDao) {
        this.webSiteDao = webSiteDao;
    }

    @Override
    public List<WebSiteModel> getAllActive() {
        return webSiteDao.getAllActive();
    }
}
