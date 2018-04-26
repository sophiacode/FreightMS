package com.freight.ms.serviceImpl;

import com.freight.ms.dao.ComplaintMapper;
import com.freight.ms.model.Complaint;
import com.freight.ms.service.ComplaintService;
import com.freight.ms.util.JsonUtil;
import com.freight.ms.wrapper.ComplaintWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ComplaintServiceImpl implements ComplaintService{
    @Autowired
    private ComplaintMapper complaintMapper;

    public Complaint findComplaintById(Integer id) {
        return complaintMapper.selectByPrimaryKey(id);
    }

    public String findComplaints(Map<String, Object> paramMap){
        List<Complaint> complaintList = complaintMapper.selectByParams(paramMap);
        return JsonUtil.getTableListJson(complaintMapper.getCount(),
                        new ComplaintWrapper(complaintList).wrap());
    }

}
