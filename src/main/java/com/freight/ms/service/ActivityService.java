package com.freight.ms.service;

import com.freight.ms.model.Activity;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ActivityService {

    Activity findActivityById(Integer id);

    String findActivitys(Map<String, Object> paramMap);

    void addActivity(Activity activity);

    void editActivity(Activity activity);

    void deleteActivitys(List<Integer> list);
}
