package com.nutaalaibekov.dao.impl;

import com.nutaalaibekov.dao.MinedDataDao;
import com.nutaalaibekov.entity.MinedData;
import com.nutaalaibekov.util.DateUtil;

import java.sql.*;

public class MinedDataDaoImpl extends BaseDao implements MinedDataDao {

    @Override
    public MinedData save(MinedData minedData) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            minedData.setCreatedDate(new java.util.Date());
            connection = connect();
            statement = connection
                    .prepareStatement("insert into parse_execution_result(json_data, data_id, created_date, webpage_id) \n" +
                            "                  values(?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, minedData.getData());
            statement.setBoolean(2, minedData.getIsUnique());
            statement.setDate(3, DateUtil.toSqlDate(minedData.getCreatedDate()) );
            statement.setLong(4, minedData.getPageId());

            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                minedData.setId(resultSet.getLong(1));
            }
            return minedData;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            properlyCloseResoures(connection, statement, resultSet);
        }
        return null;
    }
}
