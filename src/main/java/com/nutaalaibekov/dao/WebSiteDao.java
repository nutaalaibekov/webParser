package com.nutaalaibekov.dao;

import com.nutaalaibekov.entity.WebSites;

import java.util.List;

public interface WebSiteDao {
    List<WebSites> getAllActive();
}
