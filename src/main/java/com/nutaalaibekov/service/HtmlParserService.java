package com.nutaalaibekov.service;

import com.nutaalaibekov.model.HtmlElementConfigModel;
import org.jsoup.nodes.Element;

public interface HtmlParserService {
    String findData(HtmlElementConfigModel configModel);

    String findDataWithRoot(Element root, HtmlElementConfigModel configModel);

    Element findElement(HtmlElementConfigModel configModel);
}
