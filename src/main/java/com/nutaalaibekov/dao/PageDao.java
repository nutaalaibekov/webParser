package com.nutaalaibekov.dao;

import com.nutaalaibekov.entity.HtmlPage;

import java.util.List;

public interface PageDao {
    List<HtmlPage> getAllByWebSite(Integer webSiteId);
}
