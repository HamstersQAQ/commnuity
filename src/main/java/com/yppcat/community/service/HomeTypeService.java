package com.yppcat.community.service;

import com.yppcat.community.result.Result;
import org.springframework.stereotype.Component;

@Component
public interface HomeTypeService {

    Result addType(String type,String name,String linkAddress);

    Result getTypes();
}
