package com.yppcat.community.repository;

import com.yppcat.community.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News,Integer> {

    List<News> findAllByYearAndMonthAndDay(String year, String month, String day);
}
