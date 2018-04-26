package com.freight.ms.serviceImpl;

import com.freight.ms.common.exception.BusinessEnumException;
import com.freight.ms.common.exception.BusinessException;
import com.freight.ms.dao.GoodsMapper;
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

    public Goods findGoodsById(Integer id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    public String findGoods(Map<String, Object> paramMap){
        List<Goods> goodsList = goodsMapper.selectByParams(paramMap);
        return JsonUtil.getTableListJson(goodsMapper.getCount(),
                        new ExchangeWrapper(goodsList).wrap());
    }

    public void addGoods(Goods goods){
        try{
            goodsMapper.insertSelective(goods);
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.USER_ADD_FAIL);    //TODO:异常
        }
    }

    public void editGoods(Goods goods){
        try{
            goodsMapper.updateByPrimaryKeySelective(goods);
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.USER_EDIT_FAIL);   //TODO:异常
        }
    }

    public void deleteGoodss(List<Integer> list){
        try{
            for(Integer id:list){
                goodsMapper.deleteByPrimaryKey(id);
            }
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.USER_DELETE_FAIL);  //TODO:异常
        }
    }
}
