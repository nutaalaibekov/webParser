package com.nutaalaibekov.dao;

import com.nutaalaibekov.model.PageModel;

import java.util.List;

public interface PageDao {
    List<PageModel> getAllByWebSite(Integer webSiteId);
}
