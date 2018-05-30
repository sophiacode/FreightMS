package com.freight.ms.serviceImpl;

import com.freight.ms.common.constant.ComplaintEnum;
import com.freight.ms.common.exception.BusinessEnumException;
import com.freight.ms.common.exception.BusinessException;
import com.freight.ms.dao.ComplaintMapper;
import com.freight.ms.dao.OrderMapper;
import com.freight.ms.dao.UserMapper;
import com.freight.ms.model.Complaint;
import com.freight.ms.model.Order;
import com.freight.ms.model.User;
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

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;


    public Complaint findComplaintById(Integer id) {
        return complaintMapper.selectByPrimaryKey(id);
    }

    public String findComplaints(Map<String, Object> paramMap){
        List<Complaint> complaintList = complaintMapper.selectByParams(paramMap);

        for(Complaint complaint : complaintList){
            Order order = orderMapper.selectByPrimaryKey(complaint.getOrderId());
            if(order != null){
                complaint.setOrderNo(order.getOrderNo());
            }

            if(complaint.getAdminId() != null){
                User user = userMapper.selectByPrimaryKey(complaint.getAdminId());
                if(user != null){
                    complaint.setAdminName(user.getName());
                }
            }
        }

        return JsonUtil.getTableListJson(complaintMapper.getCount(paramMap),
                        new ComplaintWrapper(complaintList).wrap());
    }

    public void handleComplaint(Integer id, String process, Integer adminId){
        Complaint complaint = complaintMapper.selectByPrimaryKey(id);
        if(complaint == null){
            throw new BusinessException(BusinessEnumException.REQUEST_NULL);
        }

        complaint.setProcess(process);
        complaint.setAdminId(adminId);
        complaint.setStatus(ComplaintEnum.COMPLAINT_STATUS_HANDLED.getCode());

        try{
            complaintMapper.updateByPrimaryKeySelective(complaint);
        }catch (Exception e){
            throw new BusinessException(BusinessEnumException.COMPLAINT_HANDLE_FAIL);
        }
    }
}
