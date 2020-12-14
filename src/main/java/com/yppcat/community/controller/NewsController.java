package com.yppcat.community.controller;

import com.yppcat.community.result.Result;
import com.yppcat.community.service.NewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {
    private final NewService newService;

    public NewsController(NewService newService) {
        this.newService = newService;
    }

    @GetMapping(value = "/news/add")
    public Result addNews(@RequestParam("year") String year,
                          @RequestParam("month") String month,
                          @RequestParam("day") String day,
                          @RequestParam("news") String news) {
        return newService.addNews(year, month, day, news);
    }

    @GetMapping(value = "/news/get")
    public Result getNews(@RequestParam("year") String year,
                          @RequestParam("month") String month,
                          @RequestParam("day") String day) {
        return newService.getNews(year, month, day);
    }
}
