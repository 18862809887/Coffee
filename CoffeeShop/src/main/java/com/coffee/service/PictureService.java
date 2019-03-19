package com.coffee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.dao.PictureDao;
import com.coffee.entity.Picture;
@Service
public class PictureService {
	@Autowired
	private PictureDao pictureDao;
	
	public Picture savePicture(Picture picture)
	{
		return pictureDao.save(picture);
	}
}
