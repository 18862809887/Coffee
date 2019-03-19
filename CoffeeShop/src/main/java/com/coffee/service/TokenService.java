package com.coffee.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.coffee.entity.Userinfo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@ConfigurationProperties(prefix = "jwt")
@Component
public class TokenService {
	 private Logger logger = LoggerFactory.getLogger(getClass());

	    private String secret;
	    private long expire;
	    private String header;
	
	public String getToken(Userinfo user){
		String token="";
		token = JWT.create().withAudience(user.getUserName()).sign(Algorithm.HMAC256(user.getPassword()));
		
		return token;
	}
	
	public String generateToken(Userinfo users ){
		Date nowDate = new java.util.Date();
		Date expirDate = new Date(nowDate.getTime()+expire*1000);
		return Jwts.builder()
				.setSubject(users.getUserId()+"")
				.setIssuedAt(nowDate)
				.setExpiration(expirDate)
				.signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, secret)
				.compact();
	}
    public Claims getClaimByToken(String token)
    {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            logger.debug("validate is token error ", e);
            return null;
        }
    }
    
    /**
     * token是否过期
     * @return  true：过期
     */
    public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }
	

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

}
