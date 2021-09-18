package com.nutaalaibekov.service.impl;

import com.nutaalaibekov.dao.PageDao;
import com.nutaalaibekov.model.PageModel;
import com.nutaalaibekov.service.WebPageService;

import java.util.List;

public class WebPageServiceImpl implements WebPageService {

    private final PageDao pageDao;

    public WebPageServiceImpl(PageDao pageDao) {
        this.pageDao = pageDao;
    }

    @Override
    public List<PageModel> getAllByWebSite(Integer webSiteId) {
        return pageDao.getAllByWebSite(webSiteId);
    }
}
