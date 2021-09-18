package com.nutaalaibekov.dao;

import com.nutaalaibekov.model.WebSiteModel;

import java.util.List;

public interface WebSiteDao {
    List<WebSiteModel> getAllActive();
}
