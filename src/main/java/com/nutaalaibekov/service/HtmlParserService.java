package com.nutaalaibekov.service;

import com.nutaalaibekov.model.ParseInstructionModel;

public interface HtmlParserService {

    String getData(ParseInstructionModel configModel);

    void changeRoot(ParseInstructionModel outputDataInfo);

}
