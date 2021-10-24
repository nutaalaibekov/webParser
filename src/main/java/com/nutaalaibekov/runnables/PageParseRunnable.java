package com.nutaalaibekov.runnables;

import com.nutaalaibekov.entity.HtmlNode;
import com.nutaalaibekov.entity.HtmlPage;
import com.nutaalaibekov.entity.MinedData;
import com.nutaalaibekov.enums.OutputDataType;
import com.nutaalaibekov.model.NodeModel;
import com.nutaalaibekov.model.NodePartModel;
import com.nutaalaibekov.model.OutputDataModel;
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
        List<MinedData> resultData = new ArrayList<>();
        List<HtmlNode> htmlNodes = htmlNodesService.getByPageId(page.getId());
        List<OutputDataModel> outputDataModels = getFromHtmlNodes(htmlNodes);
        OutputDataModel rootNode = getRoot(outputDataModels);

        if (rootNode != null) {
            htmlParserService.changeRoot(rootNode);
        }

        for(OutputDataModel node : outputDataModels) {
            String minedData = htmlParserService.getData(node);
//            resultData.add();
            minedDataService.save(MinedData.builder()
                    .pageId(page.getId())
                    .data(minedData)
                    .isUnique(node.getIsUnique())
                    .build());
        }


    }

    private List<OutputDataModel> getFromHtmlNodes(List<HtmlNode> nodes) {
        List<OutputDataModel> outputDataModels = new ArrayList<>();
        for(HtmlNode node : nodes) {
            outputDataModels.add(getOutputDataModelFromEntity(node));
        }
        return outputDataModels;
    }

    private OutputDataModel getOutputDataModelFromEntity(HtmlNode node) {
        OutputDataModel outputDataModel = new OutputDataModel();
        outputDataModel.setOutputKey(node.getOutputKey());
        outputDataModel.setOutputType(node.getType());
        outputDataModel.setIsUnique(node.getIsUnique());
        outputDataModel.setTargetNode(getNodeModelFromEntity(node));

        return outputDataModel;
    }

    private NodeModel getNodeModelFromEntity(HtmlNode node) {
        NodeModel targetNode = new NodeModel();
        targetNode.setSelector(node.getNodeSelector());
        targetNode.setParts(getNodePartsFromEntity(node));
        return targetNode;
    }

    private List<NodePartModel> getNodePartsFromEntity(HtmlNode node) {
        List<NodePartModel> parts = new ArrayList<>();
        NodePartModel part = new NodePartModel();
        part.setKey(node.getNodePartKey());
        part.setType(node.getNodePart());
        parts.add(part);

        return parts;
    }

    private OutputDataModel getRoot(List<OutputDataModel> nodeModels) {
        for(OutputDataModel nodeModel : nodeModels) {
            if (nodeModel.getOutputType() == OutputDataType.ROOT) {
                return nodeModel;
            }
        }
        return null;
    }
}
