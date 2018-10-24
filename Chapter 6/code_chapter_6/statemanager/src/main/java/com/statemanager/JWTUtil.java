package com.statemanager;

import java.util.Calendar;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;


public class JWTUtil {
    // You will use a application secret stored in properties file or database. s
    String secret = "KeepSecretKeySameAccrossServers";
    
    /**
     * This method takes a user object and returns a token.
     * @param user
     * @return
     */
    public String createAccessJwtToken(User user) {
   	 
   	 Date date = new Date();

   	 Calendar c = Calendar.getInstance();
   	 c.setTime(date);
   	 c.add(Calendar.DATE, 1);
   	 // Setting expiration for 1 day
   	 Date expiration = c.getTime();
   	JWTCreator.Builder builder = com.auth0.jwt.JWT.create();
   	builder.withSubject(user.getName())
   			 .withKeyId(user.getId())
   			 .withIssuedAt(date)
   			 .withExpiresAt(expiration)
   			 .withClaim("canAccessSum", true);
   	String token =  builder.sign(Algorithm.HMAC256(secret));
   	 return token;
    }
    

    /**
     * This method takes a token and returns User Object.
     * @param token
     * @return
     */
	public User parseJwtToken(String token) {
		JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();
		    
		DecodedJWT  jwt =verifier.verify(token);
   		      
   	 Boolean sumAccess = jwt.getClaim("canAccessSum").asBoolean();
   	 
   	 User user = new User();
   	 user.setId(jwt.getId());
   	 user.setName(jwt.getSubject());
   	 user.setSumAccess(sumAccess);
   	 return user;
	}
}
