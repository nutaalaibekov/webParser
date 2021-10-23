package com.nutaalaibekov.service;

import com.nutaalaibekov.model.OutputDataModel;

public interface HtmlParserService {

    String getData(OutputDataModel configModel);

    void changeRoot(OutputDataModel outputDataInfo);

}
