package com.freight.ms.service;

import com.freight.ms.model.Complaint;

import java.util.Map;

public interface ComplaintService {

    Complaint findComplaintById(Integer id);

    String findComplaints(Map<String, Object> paramMap);

    void handleComplaint(Integer id, String process, Integer adminId);

}
