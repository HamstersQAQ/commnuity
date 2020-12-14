package com.yppcat.community.service;

import com.yppcat.community.result.Result;
import org.springframework.stereotype.Component;

@Component
public interface NewService {

    Result addNews(String year,String month,String day,String news);

    Result getNews(String year,String month,String day);
}
