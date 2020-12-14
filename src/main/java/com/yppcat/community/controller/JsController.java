package com.yppcat.community.controller;

import com.yppcat.community.result.Result;
import com.yppcat.community.service.HomeTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsController {


    private final HomeTypeService homeTypeService;

    public JsController(HomeTypeService homeTypeService) {
        this.homeTypeService = homeTypeService;
    }


    @PostMapping(value = "/jiaoshou/add")
    public Result addType(@RequestParam("type")String type,
                          @RequestParam("name")String name,
                          @RequestParam("linkAddress")String linkAddress){
        return homeTypeService.addType(type,name,linkAddress);
    }

    @GetMapping(value = "jiaoshou/types")
    public Result getTypes(){
        return homeTypeService.getTypes();
    }

}
