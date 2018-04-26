package com.freight.ms.service;

import com.freight.ms.model.Driver;

import java.util.List;
import java.util.Map;

public interface DriverService {

    Driver findDriverById(Integer id);

    Driver findDriverByName(String name);

    String findDrivers(Map<String, Object> paramMap);

    void changeStatus(List<Integer> list);
}
