package com.nutaalaibekov.service.impl;

import com.nutaalaibekov.dao.impl.HtmlNodesDaoImpl;
import com.nutaalaibekov.dao.impl.HtmlPageDaoImpl;
import com.nutaalaibekov.dao.impl.MinedDataDaoImpl;
import com.nutaalaibekov.dao.impl.WebSiteDaoImpl;
import com.nutaalaibekov.service.*;

import java.util.HashMap;
import java.util.Map;

public class WebParserContextImpl implements WebParserContext {

    private final Map<Class, Object> services = new HashMap<>();

    public WebParserContextImpl() {
        services.put(HtmlNodesService.class, new HtmlNodesServiceImpl(new HtmlNodesDaoImpl()));
        services.put(MinedDataService.class, new MinedDataServiceImpl(new MinedDataDaoImpl()));
        services.put(HtmlPageService.class, new HtmlPageServiceImpl(new HtmlPageDaoImpl()));
        services.put(WebSiteService.class, new WebSiteServiceImpl(new WebSiteDaoImpl()));
    }


    @Override
    public Object getService(Class clazz) {
        return services.get(clazz);
    }
}
