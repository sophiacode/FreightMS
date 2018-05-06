package com.freight.ms.service;

import com.freight.ms.model.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {

    Goods findGoodsById(Integer id);

    String findGoods(Map<String, Object> paramMap);

    void addGoods(Goods goods);

    void editGoods(Goods goods);

    void deleteGoodss(List<Integer> list);

    String getExchangeRecord(Integer goodsId);
}
