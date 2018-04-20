package com.fss.boiMpay;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Random;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

/**
 * 
 * @author brantansp
 *
 */

public class HMACKeyEncryption {
	
	private static final String timeinmilliseconds = "9991518442019023";
	private static final String rsapublickeypath = System.getProperty("user.dir")+"\\src\\main\\java\\com\\fss\\keyStore\\id_rsapublic.pem";
	private static final String	RSA_PADDING_STANDARD		= "RSA/ECB/OAEPWithSHA1AndMGF1Padding";
	private static final String	RSA_KEY_FACTORY_INSTANCE	= "RSA";
	public static final String	PUBLIC_KEY_HEADER			= "-----BEGIN PUBLIC KEY-----";
	public static final String	PUBLIC_KEY_FOOTER			= "-----END PUBLIC KEY-----";
	
	public String encrypt(String decryptedData, String keyFilePath) {
		try {
			byte[] encodedBytes = decryptedData.getBytes();
			byte[] encryptedData = blockDeCipher(encodedBytes, keyFilePath);
			String finalEncryptedData = Base64.encodeBase64String(encryptedData);
			return finalEncryptedData;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private PublicKey getPemPublicKey(String filename) {
		
		File file = new File(filename);
		
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			DataInputStream dataInputInstream = new DataInputStream(fileInputStream);
			byte[] keyBytes = new byte[(int) file.length()];
			dataInputInstream.readFully(keyBytes);
			String pubKeyPEM = new String(keyBytes);
			pubKeyPEM = pubKeyPEM.replace(PUBLIC_KEY_HEADER, "");
			pubKeyPEM = pubKeyPEM.replace(PUBLIC_KEY_FOOTER, "");
			//System.out.println("pubKeyPEM::"+pubKeyPEM);
			byte[] decoded = Base64.decodeBase64(pubKeyPEM);			
			
			X509EncodedKeySpec spec = new X509EncodedKeySpec(decoded);
			KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_FACTORY_INSTANCE);
			PublicKey publicKey = keyFactory.generatePublic(spec);
			
			//System.out.println("publicKey::"+publicKey);
			return publicKey;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private byte[] blockDeCipher(byte[] bytes, String pemFileName) {
		try {
			Cipher decipher = Cipher.getInstance(RSA_PADDING_STANDARD);
			decipher.init(Cipher.ENCRYPT_MODE, getPemPublicKey(pemFileName));
			byte[] scrambled = new byte[0];
			byte[] toReturn = new byte[0];
			int length = 24;
			byte[] buffer = new byte[length];
			for (int counter = 0; counter < bytes.length; counter++) {
				if ((counter > 0) && (counter % length == 0)) {
					scrambled = decipher.doFinal(buffer);
					toReturn = append(toReturn, scrambled);
					int newlength = length;
					if (counter + length > bytes.length) {
						newlength = bytes.length - counter;
					}
					buffer = new byte[newlength];
				}
				buffer[counter % length] = bytes[counter];
			}
			scrambled = decipher.doFinal(buffer);
			
			toReturn = append(toReturn, scrambled);
			return toReturn;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static byte[] append(byte[] prefix, byte[] suffix) {
		byte[] toReturn = new byte[prefix.length + suffix.length];
		for (int counter = 0; counter < prefix.length; counter++) {
			toReturn[counter] = prefix[counter];
		}
		for (int counter = 0; counter < suffix.length; counter++) {
			toReturn[counter + prefix.length] = suffix[counter];
		}
		return toReturn;
	}

	public static String encryptedKey(String plainKey)
	{
		System.out.println("plainKey : "+plainKey);
	    java.security.Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
       	String finalEncryptedData = new HMACKeyEncryption().encrypt(plainKey , rsapublickeypath);
       	System.out.println("finalEncryptedData : "+finalEncryptedData.replaceAll("(\\r\\n)", ""));
		return finalEncryptedData.replaceAll("(\\r\\n)", "");
	}
	
	public static String plainKey()
	{
	    Random random = new Random();
		int x = random.nextInt(9000) + 100;
	    long millis = System.currentTimeMillis();
	    String timesmillis= String.valueOf(millis);
	    System.out.println("Plain key : "+timesmillis+x+"");
		return timesmillis+x+"";
	}
	
	public static void main(String[] args) {}

	
	
	
	
	
	
	
	
	
	
	
	
}
