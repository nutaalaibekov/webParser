package com.nutaalaibekov.service.impl;

import com.google.gson.Gson;
import com.nutaalaibekov.enums.DataNodeType;
import com.nutaalaibekov.enums.HtmlElementPartType;
import com.nutaalaibekov.model.PageParserConfig;
import com.nutaalaibekov.service.PageParserService;
import com.nutaalaibekov.util.HttpUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
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
            if (config.getDataNodeType() == DataNodeType.CHILD) {
                pageData.put(config, getDataFromDocument(doc, config));
            } else {
                pageData.put(config, null);
            }
        }

        return formJsonData(pageData);
    }

    private String getDataFromDocument(Document doc, PageParserConfig config) {

        String resultData = null;
        Element element = doc.select(config.getElementSelector()).first();

        if (config.getElementPartType() == HtmlElementPartType.ATTRIBUTE) {
            resultData = element.attr(config.getElementPartId());
        } else if (config.getElementPartType() == HtmlElementPartType.INNER_TEXT) {
            resultData = element.text();
        } else {
            resultData = "UNKNOWN_TYPE";
        }

        return resultData;
    }

    private String formJsonData(Map<PageParserConfig, String> pageData) {
        Map<String, Object> resultData = new HashMap<>();

        for(Map.Entry<PageParserConfig, String> entry : pageData.entrySet()) {
            fillProperty(resultData, entry.getKey(), entry.getValue());
        }

        return GSON.toJson(resultData);
    }

    private Map<String, Object> fillProperty(Map<String, Object> resultData, PageParserConfig config, String value) {
        String[] propertyKeys = config.getDataPropertyname().split("\\.");
        Map<String, Object> currentMap = resultData;
        for(int i = 0; i < propertyKeys.length; i++) {
            if (propertyKeys.length - 1 == i && config.getDataNodeType() == DataNodeType.CHILD) {
                currentMap.put(propertyKeys[i], value);
                break;
            }

            Map<String, Object> newMap = new HashMap<>();
            currentMap.put(propertyKeys[i], newMap);
            currentMap = newMap;
        }
        return resultData;
    }


}
