package com.nutaalaibekov.dao.impl;

import com.nutaalaibekov.dao.PageConfigDao;
import com.nutaalaibekov.enums.DataNodeType;
import com.nutaalaibekov.enums.HtmlElementPartType;
import com.nutaalaibekov.model.PageTargetElementModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PageConfigDaoImpl extends BaseDao implements PageConfigDao {

    @Override
    public List<PageTargetElementModel> getByWebPageId(Integer webPageId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<PageTargetElementModel> parserConfigs = new ArrayList<>();
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

                parserConfigs.add(PageTargetElementModel.builder()
                        .id(resultSet.getLong("id"))
                        .dataNodeType(DataNodeType.valueOf(resultSet.getString("data_node_type")) )
                        .dataPropertyname(resultSet.getString("data_property_name"))
                        .isUniqueIdentifier(resultSet.getBoolean("is_data_id"))
                        .elementSelector(resultSet.getString("element_selector"))
                        .elementPartType(HtmlElementPartType.valueOf(resultSet.getString("element_part")) )
                        .elementPartId(resultSet.getString("element_part_key"))
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
