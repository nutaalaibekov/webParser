package com.nutaalaibekov.service;

import com.nutaalaibekov.entity.MinedData;

import java.util.List;

public interface MinedDataService {
    void save(MinedData minedData);
    void saveAll(List<MinedData> minedDatas);
}
