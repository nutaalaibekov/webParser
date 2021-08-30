package com.nutaalaibekov.service;

import com.nutaalaibekov.model.PageDataModel;
import com.nutaalaibekov.model.PageParserConfig;

import java.util.List;

public interface PageParserService {
    List<String> parsePage(String url, List<PageParserConfig> configs);
}
