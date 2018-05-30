package com.freight.ms.service;

import com.freight.ms.model.Report;

public interface ReportService {
    Report getReport(String startTime, String endTime);
}
