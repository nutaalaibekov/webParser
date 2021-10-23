package com.nutaalaibekov.dao.impl;

import com.nutaalaibekov.dao.PageConfigDao;
import com.nutaalaibekov.enums.OutputDataType;
import com.nutaalaibekov.enums.NodePart;
import com.nutaalaibekov.entity.HtmlNodes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PageConfigDaoImpl extends BaseDao implements PageConfigDao {

    @Override
    public List<HtmlNodes> getByWebPageId(Integer webPageId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<HtmlNodes> parserConfigs = new ArrayList<>();
        try {
            connection = connect();
            statement = connection
                    .prepareStatement("select " +
                            " id," +
                            " data_node_type," +
                            " data_property_name," +
                            " is_data_id," +
                            " element_selector," +
                            " element_part," +
                            " element_part_key," +
                            " webpage_id " +
                            "from webpage_parse_config " +
                            "where webpage_id = ?");
            statement.setInt(1, webPageId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {

                parserConfigs.add(HtmlNodes.builder()
                        .id(resultSet.getLong("id"))
                        .type(OutputDataType.valueOf(resultSet.getString("data_node_type")) )
                        .outputKey(resultSet.getString("data_property_name"))
                        .isUnique(resultSet.getBoolean("is_data_id"))
                        .nodeSelector(resultSet.getString("element_selector"))
                        .nodePart(NodePart.valueOf(resultSet.getString("element_part")) )
                        .nodePartKey(resultSet.getString("element_part_key"))
                        .pageId(resultSet.getLong("webpage_id"))
                        .build());
            }
            return parserConfigs;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            properlyCloseResoures(connection, statement, resultSet);
        }
        return null;
    }
}
