package com.nutaalaibekov.runnables;

import com.nutaalaibekov.entity.HtmlNodes;
import com.nutaalaibekov.entity.HtmlPage;
import com.nutaalaibekov.entity.MinedData;
import com.nutaalaibekov.model.OutputDataModel;
import com.nutaalaibekov.service.HtmlNodesService;
import com.nutaalaibekov.service.HtmlParserService;
import com.nutaalaibekov.service.MinedDataService;
import com.nutaalaibekov.service.impl.HtmlParserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class PageParseRunnable implements Runnable {

    private HtmlParserService htmlParserService;
    private final HtmlNodesService htmlNodesService;
    private final MinedDataService minedDataService;

    private final HtmlPage page;

    public PageParseRunnable(HtmlNodesService htmlNodesService, MinedDataService minedDataService, HtmlPage page) {
        this.htmlNodesService = htmlNodesService;
        this.minedDataService = minedDataService;
        this.page = page;

        init();

    }

    public void init() {
        htmlParserService = new HtmlParserServiceImpl(page.getUrl());
    }

    @Override
    public void run() {
        List<MinedData> resultData = new ArrayList<>();
        List<HtmlNodes> htmlNodes = htmlNodesService.getByPageId(page.getId());
        List<OutputDataModel> outputDataModels = getNodeModels(htmlNodes);
        OutputDataModel rootNode = getRoot(outputDataModels);

        if (rootNode != null) {
            htmlParserService.changeRoot(rootNode);
        }

        for(OutputDataModel node : outputDataModels) {
            String minedData = htmlParserService.getData(node);
            resultData.add(MinedData.builder()
                    .pageId(page.getId())
                    .data(minedData)
                    .isUnique(node.getIsUnique())
                    .build());
        }

    }

    private List<OutputDataModel> getNodeModels(List<HtmlNodes> nodes) {

        return null;
    }

    private OutputDataModel getRoot(List<OutputDataModel> nodeModels) {

        return null;
    }
}
