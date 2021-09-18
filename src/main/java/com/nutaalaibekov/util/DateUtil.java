package com.nutaalaibekov.util;

import java.sql.Date;

public class DateUtil {
    private DateUtil(){}

    public static Date toSqlDate(java.util.Date fromDate) {
        return fromDate != null ? new java.sql.Date(fromDate.getTime()) : null;
    }
}
