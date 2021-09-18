package com.nutaalaibekov.service;

import com.nutaalaibekov.model.PageModel;

import java.util.List;

public interface WebPageService {
    List<PageModel> getAllByWebSite(Integer webSiteId);;
}
