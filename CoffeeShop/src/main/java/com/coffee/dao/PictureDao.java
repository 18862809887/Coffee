package com.coffee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.entity.Picture;

public interface PictureDao extends JpaRepository<Picture,Integer> {

}
