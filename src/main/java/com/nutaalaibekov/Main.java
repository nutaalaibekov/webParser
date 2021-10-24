package com.nutaalaibekov;

import com.nutaalaibekov.entity.HtmlPage;
import com.nutaalaibekov.entity.WebSite;
import com.nutaalaibekov.runnables.PageParseRunnable;
import com.nutaalaibekov.service.HtmlPageService;
import com.nutaalaibekov.service.WebParserContext;
import com.nutaalaibekov.service.WebSiteService;
import com.nutaalaibekov.service.impl.WebParserContextImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        WebParserContext context = new WebParserContextImpl();
        WebSiteService webSiteService = (WebSiteService) context.getService(WebSiteService.class);
        HtmlPageService htmlPageService = (HtmlPageService) context.getService(HtmlPageService.class);
        List<WebSite> webSites = webSiteService.getAllActive();
        for (WebSite webSite : webSites) {
            List<HtmlPage> pages = htmlPageService.getAllByWebSite(webSite.getId());
            for (HtmlPage page : pages) {
                PageParseRunnable pageParseRunnable = new PageParseRunnable(context, page);
                new Thread(pageParseRunnable).start();
            }
        }
    }
}
