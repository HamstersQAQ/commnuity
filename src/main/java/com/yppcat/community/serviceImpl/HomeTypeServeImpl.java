package com.yppcat.community.serviceImpl;

import com.yppcat.community.constant.ResultCode;
import com.yppcat.community.entity.HomeType;
import com.yppcat.community.repository.HomeTypeRepository;
import com.yppcat.community.result.Result;
import com.yppcat.community.result.ResultUtil;
import com.yppcat.community.service.HomeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class HomeTypeServeImpl implements HomeTypeService {

    @Autowired
    HomeTypeRepository homeTypeRepository;

    @Override
    @Transactional
    public Result addType(String type, String name, String linkAddress) {
        List<HomeType> homeTypes = homeTypeRepository.findByType(type);
        boolean isContain = false;
        for (HomeType homeType : homeTypes){
            if (name.equals(homeType.getName())){
                isContain = true;
                break;
            }
        }
        if (!isContain){
            HomeType homeType = new HomeType();
            homeType.setType(type);
            homeType.setName(name);
            homeType.setLinkAddress(linkAddress);
            return ResultUtil.success();
        }else {
            return ResultUtil.error(ResultCode.CODE_ERROR_DATA,"已存在");
        }
    }

    @Override
    public Result getTypes() {
        List<HomeType> homeTypes = homeTypeRepository.findAll();
        return ResultUtil.success(homeTypes);
    }
}
