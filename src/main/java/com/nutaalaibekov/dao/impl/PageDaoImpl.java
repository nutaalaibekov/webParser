package com.nutaalaibekov.dao.impl;

import com.nutaalaibekov.dao.PageDao;
import com.nutaalaibekov.entity.HtmlPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PageDaoImpl extends BaseDao implements PageDao {

    @Override
    public List<HtmlPage> getAllByWebSite(Integer webSiteId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<HtmlPage> htmlPages = new ArrayList<>();
        try {
            connection = connect();
            statement = connection
                    .prepareStatement("select " +
                            " id," +
                            " url," +
                            " category_id," +
                            " website_id" +
                            " from webpage" +
                            " where website_id = ?");
            statement.setInt(1, webSiteId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                htmlPages.add(HtmlPage.builder()
                        .id(resultSet.getLong("id"))
                        .url(resultSet.getString("url"))
                        .categoryId(resultSet.getLong("category_id"))
                        .websiteId(resultSet.getLong("website_id"))
                        .build());
            }
            return htmlPages;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            properlyCloseResoures(connection, statement, resultSet);
        }
        return null;
    }
}
