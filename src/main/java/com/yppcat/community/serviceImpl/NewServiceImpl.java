package com.yppcat.community.serviceImpl;

import com.yppcat.community.constant.ResultCode;
import com.yppcat.community.entity.News;
import com.yppcat.community.repository.NewsRepository;
import com.yppcat.community.result.Result;
import com.yppcat.community.result.ResultUtil;
import com.yppcat.community.service.NewService;
import org.springframework.stereotype.Service;

@Service
public class NewServiceImpl implements NewService {

    private final NewsRepository newsRepository;

    public NewServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public Result addNews(String year, String month, String day, String news) {
        if (news.isEmpty()) {
            return ResultUtil.error(ResultCode.CODE_ERROR_DATA, "数据为空");
        } else {
//            String[] newsList = news.split("\n\n");
//            for (int i = 1; i < newsList.length -1; i++) {
            News entity = new News();
            entity.setYear(year);
            entity.setMonth(month);
            entity.setDay(day);
            entity.setNewStr(news);

//            }
            return ResultUtil.success(newsRepository.save(entity));
        }

    }

    @Override
    public Result getNews(String year, String month, String day) {
        return ResultUtil.success(newsRepository.findAllByYearAndMonthAndDay(year, month, day));
    }
}
