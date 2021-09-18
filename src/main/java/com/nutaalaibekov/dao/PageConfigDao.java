package com.nutaalaibekov.dao;

import com.nutaalaibekov.model.PageTargetElementModel;

import java.util.List;

public interface PageConfigDao {
    List<PageTargetElementModel> getByWebPageId(Integer webPageId);
}
