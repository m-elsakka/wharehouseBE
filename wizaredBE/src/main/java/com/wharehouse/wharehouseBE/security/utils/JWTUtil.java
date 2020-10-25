/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.security.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wharehouse.wharehouseBE.model.ConstantStrings;
import com.wharehouse.wharehouseBE.model.pojos.JwtResponse;
import com.wharehouse.wharehouseBE.model.pojos.UserValidPojo;
import com.wharehouse.wharehouseBE.utils.DateUtilities;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.util.Date;
import java.util.List;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.codec.binary.Base64;


public class JWTUtil {

      static SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
    public static final String DEFAULT_KEY = "YnZjeGJ2Y3hidmNJTG92ZVNlY3VyaXR5ZmFld29pamV3ZXdxcmV3";
    public static final String MOBILE_INFO = "AGENT_INFO";
    public static final String MOBILE_RES_HEADER_KEY = "mobile_login_key";
    static Base64 base64Url = new Base64(true);
    static Gson gson = new GsonBuilder().create();

    public static List getRoles(String jwtString, String secretKeyString) {
        Claims claims = Jwts.parser().setSigningKey(secretKeyString).parseClaimsJws(jwtString).getBody();
        return claims.get("roles", List.class);
    }

    public static String generateToken(String userName, Object[] roles) {
        String jwtToken = "";
        JwtBuilder jwtBuilder = Jwts.builder().setSubject(userName)
                .claim("roles", roles)
                .claim("creationDate", new Date())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, ConstantStrings.SIGNING_KEY)
                .setExpiration(DateUtilities.addDays(new Date(), 30));
        jwtToken = jwtBuilder.compact();
        return jwtToken;
    }

//    public static String encodeJWT(Object data, byte[] apiKeySecretBytes) {
////        byte[] apiKeySecretBytes = secretKeyString.getBytes();
//        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
//        String jwtString = Jwts.builder()
//                .claim("data", data)
//                .signWith(signatureAlgorithm, signingKey)
//                .setIssuedAt(new Date())
//                .setExpiration(DateUtilities.addDays(new Date(), 1))
//                .compact();
//        return jwtString;
//    }

//    public static String decodeJWT(String jwtString, byte[] secretKeyByte) {
//        return decodeJWT(jwtString, secretKeyByte, "data");
//    }
//
//    public static String decodeJWT(String jwtString, byte[] secretKeyByte, String claimName) {
//        Key signingKey = new SecretKeySpec(secretKeyByte, signatureAlgorithm.getJcaName());
//        String string = Jwts.parser()
//                .setSigningKey(signingKey)
//                .parseClaimsJws(jwtString)
//                .getBody()
//                .get(claimName, String.class);
//        return string;
//    }
    
    
    public static String getUsernameFromToken(Claims claims) {
        String userName = claims.getSubject();
        return userName;
    }

    public static String getUsernameFromToken(String jwtString, String secretKeyString) {
        Claims claims = Jwts.parser().setSigningKey(secretKeyString).parseClaimsJws(jwtString).getBody();
        return JWTUtil.getUsernameFromToken(claims);

    }
    
    public static String getBranchNo(String jwtString,String secretKeyString){
        Claims claims = Jwts.parser().setSigningKey(secretKeyString).parseClaimsJws(jwtString).getBody();
        return claims.get("branchno",String.class);
    }
    
    public static Long getAccountId(String jwtString,String secretKeyString){
        Claims claims = Jwts.parser().setSigningKey(secretKeyString).parseClaimsJws(jwtString).getBody();
        return  claims.get("accountId", Long.class);
    }

    public static byte[] getJwtKey(HttpServletRequest request){
        return DEFAULT_KEY.getBytes();
    }
    
    public static String encodeJWT(Object data, byte[] apiKeySecretBytes) {
//        byte[] apiKeySecretBytes = secretKeyString.getBytes();
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        String jwtString = Jwts.builder()
                .claim("data", data)
                .signWith(signatureAlgorithm, signingKey)
                .setIssuedAt(new Date())
                .setExpiration(DateUtilities.addDays(new Date(), 1))
                .compact();
        return jwtString;
    }
    
    public static String decodeJWT(String jwtString, byte[] secretKeyByte) {
        return decodeJWT(jwtString, secretKeyByte, "data");
    }
    
    public static String decodeJWT(String jwtString, byte[] secretKeyByte, String claimName) {
        Key signingKey = new SecretKeySpec(secretKeyByte, signatureAlgorithm.getJcaName());
        String string = Jwts.parser()
                .setSigningKey(signingKey)
                .parseClaimsJws(jwtString)
                .getBody()
                .get(claimName, String.class);
        return string;
    }
    
    public static boolean checkifMobileService(HttpServletRequest hsr) {
        return hsr.getRequestURI().contains(ConstantStrings.SUB_MOBILE_URL);
    }
    
    
    public static UserValidPojo getDataToAccess(String result,String key){
        String[] split_response = result.split("\\.");
        String responseBody = split_response[1];
        String body = new String(base64Url.decode(responseBody));
        JwtResponse jwtObj = gson.fromJson(body, JwtResponse.class); // deserializes json into target2
        return jwtObj.getData();
    }
}
