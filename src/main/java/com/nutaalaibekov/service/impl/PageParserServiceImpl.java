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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PageParserServiceImpl implements PageParserService {
    private final Gson GSON = new Gson();

    @Override
    public List<String> parsePage(String url, List<PageParserConfig> configs) {
        String html = HttpUtil.get(url);
        Document doc = Jsoup.parse(html);

        PageParserConfig rootConfig = configs.stream()
                                            .filter(x -> x.getDataNodeType() == DataNodeType.ROOT)
                                            .findFirst()
                                            .orElseThrow(IllegalArgumentException::new);

        List<PageParserConfig> childConfigs = configs.stream()
                                                    .filter(x -> x.getDataNodeType() != DataNodeType.ROOT)
                                                    .collect(Collectors.toList());

        List<String> result = new LinkedList<>();
        Elements elements = doc.select(rootConfig.getElementSelector());
        for(Element element : elements) {
            result.add(getDataFromRoot(element, childConfigs));
        }

        return result;
    }

    private String getDataFromRoot(Element rootElement, List<PageParserConfig> childConfigs) {
        Map<String, String> map = new HashMap<>();
        for(PageParserConfig childConfig : childConfigs) {
            map.put(childConfig.getDataPropertyname(), getDataFromElement(rootElement, childConfig));
        }
        return GSON.toJson(map);
    }

    private String getDataFromElement(Element rootElement, PageParserConfig childConfig) {
        List<String> elementValues = new LinkedList<>();

        Elements elements = rootElement.select(childConfig.getElementSelector());
        for(Element element : elements) {
            if (childConfig.getElementPartType() == HtmlElementPartType.ATTRIBUTE) {
                elementValues.add(element.attr(childConfig.getElementPartId()));
            } else if (childConfig.getElementPartType() == HtmlElementPartType.INNER_TEXT) {
                elementValues.add(element.text());
            }
        }

        return String.join(",", elementValues);
    }


}
