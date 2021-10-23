package com.nutaalaibekov.dao;

import com.nutaalaibekov.entity.HtmlPage;

import java.util.List;

public interface HtmlPageDao {
    List<HtmlPage> getAllByWebSite(Integer webSiteId);
}
