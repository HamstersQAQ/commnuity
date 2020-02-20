package com.yppcat.community.repository;

import com.yppcat.community.entity.HomeType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeTypeRepository extends JpaRepository<HomeType, Integer> {

    List<HomeType> findByType(String type);
}
