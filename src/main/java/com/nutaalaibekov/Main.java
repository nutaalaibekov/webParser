package com.nutaalaibekov;

import com.nutaalaibekov.enums.DataNodeType;
import com.nutaalaibekov.enums.HtmlElementPartType;
import com.nutaalaibekov.model.PageParserConfig;
import com.nutaalaibekov.service.PageParserService;
import com.nutaalaibekov.service.impl.PageParserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "https://bishkek.headhunter.kg/vacancies/programmist";
        List<PageParserConfig> configs = new ArrayList<>();
        configs.add(PageParserConfig.builder()
                .id(1l)
                .dataNodeType(DataNodeType.CHILD)
                .dataPropertyname("salary")
                .elementSelector(".vacancy-serp .vacancy-serp-item .vacancy-serp-item__info .resume-search-item__name .bloko-link")
                .elementPartType(HtmlElementPartType.INNER_TEXT)
                .elementPartId(null)
                .pageId(1l)
                .build());
        configs.add(PageParserConfig.builder()
                .id(2l)
                .dataNodeType(DataNodeType.CHILD)
                .dataPropertyname("title")
                .elementSelector(".vacancy-serp .vacancy-serp-item .vacancy-serp-item__sidebar bloko-header-section-3.bloko-header-section-3_lite")
                .elementPartType(HtmlElementPartType.INNER_TEXT)
                .elementPartId(null)
                .pageId(2l)
                .build());
        PageParserService parserService = new PageParserServiceImpl();

        String jsonData = parserService.parsePage(url, configs);
        System.out.println(jsonData);

    }
}
