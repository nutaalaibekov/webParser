package com.nutaalaibekov.service.impl;

import com.google.gson.Gson;
import com.nutaalaibekov.enums.DataNodeType;
import com.nutaalaibekov.enums.HtmlElementPartType;
import com.nutaalaibekov.model.HtmlElementConfigModel;
import com.nutaalaibekov.model.PageDataModel;
import com.nutaalaibekov.model.PageModel;
import com.nutaalaibekov.model.PageTargetElementModel;
import com.nutaalaibekov.service.HtmlParserService;
import com.nutaalaibekov.util.HttpUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;
import java.util.stream.Collectors;

public class HtmlParserServiceImpl implements HtmlParserService {
    private final Gson GSON = new Gson();
    private final String url;
    private final String html;
    private final Document doc;

    public HtmlParserServiceImpl(String url) {
        this.url = url;
        this.html = HttpUtil.get(url);
        this.doc = Jsoup.parse(html);
    }

    @Override
    public String findData(HtmlElementConfigModel configModel) {
        return null;
    }

    private List<PageDataModel> parsePage(String url, List<PageTargetElementModel> configs) {

        PageTargetElementModel rootConfig = configs.stream()
                                            .filter(x -> x.getDataNodeType() == DataNodeType.ROOT)
                                            .findFirst()
                                            .orElseThrow(IllegalArgumentException::new);

        List<PageTargetElementModel> childConfigs = configs.stream()
                                                    .filter(x -> x.getDataNodeType() != DataNodeType.ROOT)
                                                    .collect(Collectors.toList());

        List<PageDataModel> result = new LinkedList<>();
        Elements elements = doc.select(rootConfig.getElementSelector());
        for(Element element : elements) {
            PageDataModel pageDataModel = getDataFromRoot(element, childConfigs);
            result.add(pageDataModel);
        }

        return result;
    }

    private PageDataModel getDataFromRoot(Element rootElement, List<PageTargetElementModel> childConfigs) {
        Map<String, String> map = new HashMap<>();
        String dataUniqueId = null;

        for(PageTargetElementModel childConfig : childConfigs) {
            String value = getDataFromElement(rootElement, childConfig);
            map.put(childConfig.getDataPropertyname(), value);
            if (childConfig.getIsUniqueIdentifier()) {
                dataUniqueId = value;
            }
        }

        return PageDataModel.builder()
                .data(GSON.toJson(map))
                .dataUniqueId(dataUniqueId)
                .createdDate(new Date())
                .pageId(childConfigs.get(0).getPageId())
                .build();
    }

    private String getDataFromElement(Element rootElement, PageTargetElementModel childConfig) {
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
