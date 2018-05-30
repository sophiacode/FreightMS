package com.freight.ms.serviceImpl;

import com.freight.ms.common.exception.BusinessEnumException;
import com.freight.ms.common.exception.BusinessException;
import com.freight.ms.dao.ConsignorMapper;
import com.freight.ms.dao.DriverMapper;
import com.freight.ms.dao.ExchangeMapper;
import com.freight.ms.dao.GoodsMapper;
import com.freight.ms.model.Exchange;
import com.freight.ms.model.Goods;
import com.freight.ms.service.GoodsService;
import com.freight.ms.util.JsonUtil;
import com.freight.ms.wrapper.ExchangeWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private ExchangeMapper exchangeMapper;

    @Autowired
    private ConsignorMapper consignorMapper;

    @Autowired
    private DriverMapper driverMapper;

    public Goods findGoodsById(Integer id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    public String findGoods(Map<String, Object> paramMap){
        List<Goods> goodsList = goodsMapper.selectByParams(paramMap);
        return JsonUtil.getTableListJson(goodsMapper.getCount(paramMap),
                new ExchangeWrapper(goodsList).wrap());
    }

    public void addGoods(Goods goods){
        try{
            goodsMapper.insertSelective(goods);
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.GOODS_ADD_FAIL);
        }
    }

    public void editGoods(Goods goods){
        try{
            goodsMapper.updateByPrimaryKeySelective(goods);
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.GOODS_EDIT_FAIL);
        }
    }

    public void deleteGoodss(List<Integer> list){
        try{
            for(Integer id:list){
                goodsMapper.deleteByPrimaryKey(id);
            }
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.GOODS_DELETE_FAIL);
        }
    }

    public String getExchangeRecord(Integer goodsId) {
        List<Exchange> list = exchangeMapper.selectByGoodsId(goodsId);

        for(Exchange e:list){
            if(e.getUserId() != null){
                if(e.getUserType() == 1){
                    e.setUser(driverMapper.selectByPrimaryKey(e.getUserId()).getName());
                }else if(e.getUserType() == 2){
                    e.setUser(consignorMapper.selectByPrimaryKey(e.getUserId()).getName());
                }
            }
        }

        return JsonUtil.getTableListJson(list.size(), list);
    }
}
