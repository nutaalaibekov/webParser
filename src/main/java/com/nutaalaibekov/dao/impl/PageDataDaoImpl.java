package com.nutaalaibekov.dao.impl;

import com.nutaalaibekov.dao.PageDataDao;
import com.nutaalaibekov.model.PageDataModel;
import com.nutaalaibekov.util.DateUtil;

import java.sql.*;

public class PageDataDaoImpl extends BaseDao implements PageDataDao {

    @Override
    public PageDataModel save(PageDataModel pageDataModel) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            pageDataModel.setCreatedDate(new java.util.Date());
            connection = connect();
            statement = connection
                    .prepareStatement("insert into WEBPAGE_DATA(json_data, data_id, created_date, webpage_id) \n" +
                            "                  values(?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, pageDataModel.getData());
            statement.setString(2, pageDataModel.getDataUniqueId());
            statement.setDate(3, DateUtil.toSqlDate(pageDataModel.getCreatedDate()) );
            statement.setLong(4, pageDataModel.getPageId());

            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                pageDataModel.setId(resultSet.getLong(1));
            }
            return pageDataModel;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            properlyCloseResoures(connection, statement, resultSet);
        }
        return null;
    }
}
