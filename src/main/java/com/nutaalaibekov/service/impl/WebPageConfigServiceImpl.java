package com.nutaalaibekov.service.impl;

import com.nutaalaibekov.dao.PageConfigDao;
import com.nutaalaibekov.model.PageTargetElementModel;
import com.nutaalaibekov.service.WebPageConfigService;

import java.util.List;

public class WebPageConfigServiceImpl implements WebPageConfigService {

    private final PageConfigDao pageConfigDao;

    public WebPageConfigServiceImpl(PageConfigDao pageConfigDao) {
        this.pageConfigDao = pageConfigDao;
    }

    @Override
    public List<PageTargetElementModel> getByWebPageId(Integer webPageId) {
        return null;
    }
}
