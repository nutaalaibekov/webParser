package com.nutaalaibekov.service;

import com.nutaalaibekov.entity.HtmlPage;

import java.util.List;

public interface HtmlPageService {
    List<HtmlPage> getAllByWebSite(Long webSiteId);;
}
