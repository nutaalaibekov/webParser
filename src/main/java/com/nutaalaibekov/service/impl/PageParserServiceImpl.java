package com.nutaalaibekov.service.impl;

import com.google.gson.Gson;
import com.nutaalaibekov.enums.DataType;
import com.nutaalaibekov.enums.TargetType;
import com.nutaalaibekov.model.PageParserConfig;
import com.nutaalaibekov.service.PageParserService;
import com.nutaalaibekov.util.HttpUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageParserServiceImpl implements PageParserService {
    private final Gson GSON = new Gson();

    @Override
    public String parsePage(String url, List<PageParserConfig> configs) {
        String html = HttpUtil.get(url);
        Document doc = Jsoup.parse(html);
        Map<PageParserConfig, String> pageData = new HashMap<>();
        for(PageParserConfig config : configs) {
            if (config.getDataType() == DataType.CHILD) {
                pageData.put(config, getDataFromDocument(doc, config));
            } else {
                pageData.put(config, null);
            }
        }

        return formJsonData(pageData);
    }

    private String getDataFromDocument(Document doc, PageParserConfig config) {

        String resultData = null;
        Elements elements = doc.select(config.getTargetTagSelector());

        if (config.getTargetType() == TargetType.ATTRIBUTE) {
            resultData = elements.attr(config.getTargetId());
        } else if (config.getTargetType() == TargetType.INNER_TEXT) {
            resultData = elements.text();
        } else {
            resultData = "UNKNOWN_TYPE";
        }

        return resultData;
    }

    private String formJsonData(Map<PageParserConfig, String> pageData) {
        // TODO: finish him !
        return GSON.toJson(pageData);
    }


}
