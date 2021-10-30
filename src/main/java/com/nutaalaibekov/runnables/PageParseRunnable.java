package com.nutaalaibekov.runnables;

import com.nutaalaibekov.entity.HtmlNode;
import com.nutaalaibekov.entity.HtmlPage;
import com.nutaalaibekov.entity.MinedData;
import com.nutaalaibekov.enums.OutputDataType;
import com.nutaalaibekov.model.ParseInstructionModel;
import com.nutaalaibekov.service.HtmlNodesService;
import com.nutaalaibekov.service.HtmlParserService;
import com.nutaalaibekov.service.MinedDataService;
import com.nutaalaibekov.service.WebParserContext;
import com.nutaalaibekov.service.impl.HtmlParserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class PageParseRunnable implements Runnable {

    private HtmlParserService htmlParserService;
    private final HtmlNodesService htmlNodesService;
    private final MinedDataService minedDataService;

    private final HtmlPage page;

    public PageParseRunnable(WebParserContext context, HtmlPage page) {
        this.htmlNodesService = (HtmlNodesService) context.getService(HtmlNodesService.class);
        this.minedDataService = (MinedDataService) context.getService(MinedDataService.class);
        this.page = page;
        htmlParserService = new HtmlParserServiceImpl(page.getUrl());
    }

    @Override
    public void run() {
        List<HtmlNode> htmlNodes = htmlNodesService.getNodesByPageId(page.getId());

        List<ParseInstructionModel> parseInstructionModels = getInstructionsFromEntities(htmlNodes);

        setRootNode(parseInstructionModels);

        List<MinedData> minedDatas = getDataByInstructions(parseInstructionModels);

        minedDataService.saveAll(minedDatas);
    }

    public void setRootNode(List<ParseInstructionModel> parseInstructionModels) {
        ParseInstructionModel rootNode = getRoot(parseInstructionModels);
        if (rootNode != null) {
            htmlParserService.changeRoot(rootNode);
        }
    }

    public List<MinedData> getDataByInstructions(List<ParseInstructionModel> parseInstructionModels) {
        List<MinedData> minedDatas = new ArrayList<>();
        for(ParseInstructionModel node : parseInstructionModels) {
            String minedData = htmlParserService.getData(node);
            minedDatas.add(MinedData.builder()
                    .pageId(page.getId())
                    .data(minedData)
                    .isUnique(node.getIsUnique())
                    .build());
        }

        return minedDatas;
    }

    private List<ParseInstructionModel> getInstructionsFromEntities(List<HtmlNode> entites) {
        List<ParseInstructionModel> parseInstructionModels = new ArrayList<>();
        for(HtmlNode node : entites) {
            parseInstructionModels.add(node.toInstructionModel());
        }
        return parseInstructionModels;
    }

    private ParseInstructionModel getRoot(List<ParseInstructionModel> nodeModels) {
        for(ParseInstructionModel nodeModel : nodeModels) {
            if (nodeModel.getOutputType() == OutputDataType.ROOT) {
                return nodeModel;
            }
        }
        return null;
    }
}
