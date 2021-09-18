package com.nutaalaibekov.service;

import com.nutaalaibekov.model.PageTargetElementModel;

import java.util.List;

public interface WebPageConfigService {
    List<PageTargetElementModel> getByWebPageId(Integer webPageId);
}
