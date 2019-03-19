package com.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coffee.entity.Picture;
import com.coffee.service.PictureService;

@Controller
public class PictureController {
	@Autowired
	private PictureService pictureService;
	@RequestMapping("/addPicturee")
	@ResponseBody
	public Picture addPicturee()
	{
		Picture picture = new Picture();
		picture.setPictureName("xiaoxiao");
		picture.setPicturePath("/xx");
		picture.setSplit("1");
		return	pictureService.savePicture(picture);
		 
	}
}
