package com.nutaalaibekov;

import com.nutaalaibekov.entity.HtmlPage;
import com.nutaalaibekov.runnables.PageParseRunnable;
import com.nutaalaibekov.service.HtmlNodesService;
import com.nutaalaibekov.service.HtmlPageService;
import com.nutaalaibekov.service.MinedDataService;
import com.nutaalaibekov.service.impl.HtmlNodesServiceImpl;
import com.nutaalaibekov.service.impl.HtmlPageServiceImpl;
import com.nutaalaibekov.service.impl.MinedDataServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        HtmlNodesService htmlNodesService = new HtmlNodesServiceImpl();
        MinedDataService minedDataService = new MinedDataServiceImpl();
        HtmlPageService htmlPageService = new HtmlPageServiceImpl();

        List<HtmlPage> pages = htmlPageService.getAllByWebSite(1);

        PageParseRunnable pageParseRunnable = new PageParseRunnable(htmlNodesService, minedDataService, pages.get(0));

        Thread newThread = new Thread(pageParseRunnable);
        newThread.start();
    }
}
