package com.nutaalaibekov.service.impl;

import com.nutaalaibekov.enums.NodePart;
import com.nutaalaibekov.model.NodeModel;
import com.nutaalaibekov.model.NodePartModel;
import com.nutaalaibekov.model.OutputDataModel;
import com.nutaalaibekov.service.HtmlParserService;
import com.nutaalaibekov.util.HttpUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HtmlParserServiceImpl implements HtmlParserService {
    private final String url;
    private final String html;
    private final Element document;
    private Element root;

    public HtmlParserServiceImpl(String url) {
        this.url = url;
        this.html = HttpUtil.get(url);
        this.root = Jsoup.parse(html);
        this.document = root.clone();
    }

    @Override
    public String getData(OutputDataModel outputDataInfo) {
        NodeModel targetNodeInfo = outputDataInfo.getTargetNode();
        Elements nodes = getNodes(this.root, targetNodeInfo.getSelector());
        List<String> nodesInfo = getNodesInfo(nodes, targetNodeInfo.getParts());
        return nodesInfo.toString();
    }

    @Override
    public void changeRoot(OutputDataModel outputDataInfo) {
        NodeModel targetNodeInfo = outputDataInfo.getTargetNode();
        Elements nodes = this.document.select(targetNodeInfo.getSelector());
        this.root = nodes.first();
    }

    private Elements getNodes(Element root, String cssSelector) {
        return root.select(cssSelector);
    }

    private List<String> getNodesInfo(Elements nodes, List<NodePartModel> nodeParts) {
        List<String> outputValues = new LinkedList<>();
        for(Element node : nodes) {
            List<String> partsValue = getNodePartsValues(node, nodeParts);
            outputValues.add(partsValue.toString());
        }
        return outputValues;
    }

    private List<String> getNodePartsValues(Element node, List<NodePartModel> nodeParts) {
        List<String> nodePartsValues = new ArrayList<>();
        for(NodePartModel nodePartInfo : nodeParts) {
            String partValue = getNodePart(node, nodePartInfo);
            nodePartsValues.add(partValue);
        }
        return nodePartsValues;
    }

    private String getNodePart(Element node, NodePartModel nodePart) {
        if (nodePart.getType() == NodePart.ATTRIBUTE) {
            return node.attr(nodePart.getKey());
        } else if (nodePart.getType() == NodePart.INNER_TEXT) {
            return node.text();
        }
        return null;
    }
}
