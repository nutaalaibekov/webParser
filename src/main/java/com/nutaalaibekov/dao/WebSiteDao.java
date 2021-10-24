package com.nutaalaibekov.dao;

import com.nutaalaibekov.entity.WebSite;

import java.util.List;

public interface WebSiteDao {
    List<WebSite> getAllActive();
}
