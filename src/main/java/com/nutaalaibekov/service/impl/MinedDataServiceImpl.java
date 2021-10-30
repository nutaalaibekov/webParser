package com.nutaalaibekov.service.impl;

import com.nutaalaibekov.dao.MinedDataDao;
import com.nutaalaibekov.entity.MinedData;
import com.nutaalaibekov.service.MinedDataService;

import java.util.List;

public class MinedDataServiceImpl implements MinedDataService {

    private final MinedDataDao minedDataDao;

    public MinedDataServiceImpl(MinedDataDao minedDataDao) {
        this.minedDataDao = minedDataDao;
    }

    @Override
    public void save(MinedData minedData) {
        minedDataDao.save(minedData);
    }

    @Override
    public void saveAll(List<MinedData> minedDatas) {
        for(MinedData minedData : minedDatas) {
            save(minedData);
        }
    }
}
