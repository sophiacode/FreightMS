package com.freight.ms.serviceImpl;

import com.freight.ms.common.constant.ConsignorEnum;
import com.freight.ms.common.exception.BusinessEnumException;
import com.freight.ms.common.exception.BusinessException;
import com.freight.ms.dao.ConsignorMapper;
import com.freight.ms.model.Consignor;
import com.freight.ms.service.ConsignorService;
import com.freight.ms.util.JsonUtil;
import com.freight.ms.wrapper.ConsignorWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ConsignorServiceImpl implements ConsignorService{
    @Autowired
    private ConsignorMapper consignorMapper;


    public Consignor findConsignorById(Integer id) {
        return consignorMapper.selectByPrimaryKey(id);
    }

    public Consignor findConsignorByName(String name) {
        return consignorMapper.selectByName(name);
    }

    public String findConsignors(Map<String, Object> paramMap){
        List<Consignor> consignorList = consignorMapper.selectByParams(paramMap);
        return JsonUtil.getTableListJson(consignorMapper.getCount(),
                new ConsignorWrapper(consignorList).wrap());
    }

    public void changeStatus(List<Integer> list){
        List<Consignor> consignors = new ArrayList<>();

        for(Integer id:list){
            Consignor consignor = consignorMapper.selectByPrimaryKey(id);

            if(consignor.getStatus() == ConsignorEnum.CONSIGNOR_STATUS_OK.getCode()){
                consignor.setStatus(ConsignorEnum.CONSIGNOR_STATUS_FREEZE.getCode());
            }else{
                consignor.setStatus(ConsignorEnum.CONSIGNOR_STATUS_OK.getCode());
            }
            consignors.add(consignor);
        }

        try{
            for(Consignor consignor:consignors){
                consignorMapper.updateByPrimaryKeySelective(consignor);
            }
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.CONSIGNOR_CHANGE_STATUS_FAIL);
        }
    }
}
