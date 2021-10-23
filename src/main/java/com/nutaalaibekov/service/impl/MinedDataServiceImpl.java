package com.nutaalaibekov.service.impl;

import com.nutaalaibekov.dao.MinedDataDao;
import com.nutaalaibekov.entity.MinedData;
import com.nutaalaibekov.service.MinedDataService;

public class MinedDataServiceImpl implements MinedDataService {

    private final MinedDataDao minedDataDao;

    public MinedDataServiceImpl(MinedDataDao minedDataDao) {
        this.minedDataDao = minedDataDao;
    }

    @Override
    public void save(MinedData minedData) {

    }
}
