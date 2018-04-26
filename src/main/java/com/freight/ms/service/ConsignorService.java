package com.freight.ms.service;

import com.freight.ms.model.Consignor;

import java.util.List;
import java.util.Map;

public interface ConsignorService {

    Consignor findConsignorById(Integer id);

    Consignor findConsignorByName(String name);

    String findConsignors(Map<String, Object> paramMap);

    void changeStatus(List<Integer> list);
}
