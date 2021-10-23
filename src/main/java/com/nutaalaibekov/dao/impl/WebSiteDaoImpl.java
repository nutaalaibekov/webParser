package com.nutaalaibekov.dao.impl;

import com.nutaalaibekov.dao.WebSiteDao;
import com.nutaalaibekov.entity.WebSites;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WebSiteDaoImpl extends BaseDao implements WebSiteDao {

    @Override
    public List<WebSites> getAllActive() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<WebSites> webSites = new ArrayList<>();
        try {
            connection = connect();
            statement = connection
                    .prepareStatement("select " +
                            " id," +
                            " url," +
                            " description," +
                            " is_active" +
                            " from webpage" +
                            " where is_active = true");
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                webSites.add(WebSites.builder()
                        .id(resultSet.getLong("id"))
                        .url(resultSet.getString("url"))
                        .description(resultSet.getString("description"))
                        .isActive(resultSet.getBoolean("is_active"))
                        .build());
            }
            return webSites;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            properlyCloseResoures(connection, statement, resultSet);
        }
        return null;
    }
}
