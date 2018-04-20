package com.fss.boiMpay;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Formatter;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;


public class HMACGeneration {
	
	private static final String	hmacKey	= "9991518442019023";

	private static final String	HMAC_SHA256_ALGORITHM	= "HmacSHA256";
	
	private static final String	encryptedFlag	= "3";
	
	
	
	public static void main(String[] args) {
			String content = "{\"header\":{\"mobNo\":\"+918825877640\",\"mType\":\"req\",\"tType\":\"mid025\",\"bVer\":\"2.1\"},\"body\":{\"search\":\"Hyderabad\",\"tpy\":\"all\",\"fromLat\":12.8356597,\"fromLon\":80.2228413},\"footer\":{}}";
			System.out.println("Request::"+content);
			verifyHMACvalue(content.trim(), hmacKey);	
	}
	
	public static String generateHMAC(String message, String reqKey)
	{
		return calculateRFC2104HMAC(message, reqKey);
	}
	
public static boolean verifyHMACvalue(String message, String reqKey){
	boolean validHmac = false;
	try {

		validHmac = verifyHmacValue(message, reqKey);
	} catch (Exception ex) {
		System.out.println("Authorization Filter Exception Occured ::::"+ex);
	}
	return validHmac;
}

public static boolean verifyHmacValue(String message, String reqKey){
	boolean validHmac = false;
	try {
		
		String hashedData = calculateRFC2104HMAC(message, reqKey);
		System.out.println("Server Hmac Value :::"+hashedData);
		/*System.out.println("Request hmac Value :::"+hashedReq);
		if (hashedData.equals(hashedReq)) {
			System.out.println("Hmac Verified Successfully");
			validHmac = true;
		} else {
			System.out.println("Hmac Not Verified");
		}*/
	} catch (RuntimeException ex) {
		// LOGGER.error("(MPYERV2711) Verifying Hmac Exception Occured", ex);
		throw ex;
	} catch (Exception ex) {
		System.out.println("(MPYERV2711) Verifying Hmac Exception Occured:::"+ex);
	}
	return validHmac;
}

public static String calculateRFC2104HMAC(String data, String key) {

	System.out.println("key in calculateRFC2104HMAC : "+key);
	SecretKeySpec signingKey;
	String result = "";
	try {
		signingKey = new SecretKeySpec(key.getBytes("ISO-8859-1"), HMAC_SHA256_ALGORITHM);
		Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
		mac.init(signingKey);
		result = toHexString(mac.doFinal(data.getBytes("ISO-8859-1")));
	} catch (Exception e) {
		System.out.println("Exception::"+e);
	}
	System.out.println("calculateRFC2104HMAC : "+result);
	return result;

}

private static String toHexString(byte[] bytes) {

	Formatter formatter = new Formatter();

	for (byte b : bytes) {
		formatter.format("%02x", b);
	}

	return formatter.toString();
}




}