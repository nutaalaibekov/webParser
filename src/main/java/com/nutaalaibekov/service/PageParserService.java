package com.nutaalaibekov.service;

import com.nutaalaibekov.model.PageParserConfig;

import java.util.List;

public interface PageParserService {
    String parsePage(String url, List<PageParserConfig> configs);
}
