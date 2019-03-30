package com.coffee.entity;

import java.io.Serializable;
import java.util.Date;

public class RedisUser implements Serializable {
  
	private static final long serialVersionUID = 1L;
	public RedisUser() {
    }
 

    private String name;
    private String code;
    private Date date;
    public RedisUser( String name, String code,Date date) {
        super();
        this.name = name;
        this.code = code;
        this.date = date;
    }
  
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

 
}

