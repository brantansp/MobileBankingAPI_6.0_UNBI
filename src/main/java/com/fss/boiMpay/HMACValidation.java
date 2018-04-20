package com.fss.boiMpay;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;
import java.util.Formatter;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;


public class HMACValidation {
	
	private static final String receivedHMAC = "fc790133ba3d5fcf5988790a301edb068a9a2cb27a2c3330784d47f59b00e8d5";
	
	private static final String	hmacEncryptionKey	= "grUQJh79PKemelHIzR3mbLZFMX8jpjS/QAo9lnH0GDaZ7VOFuQQ2Y6mVixCQpzs6fuNZz3vc/DbYwDXb5Bog8FLLSN+VqYvK++b144sPx2GCsT/Oz90PFrRHqsxGFwA5mfFfKBFrzwf5tluYiUxX7g4tPFeUL/BdNmHGrqv8YyI=";
	
	
	private static final String rsaprivatekeypath = "src/com/fss/keyStore/id_rsa.pem";
	
    private static final String	RSA_PADDING_STANDARD		= "RSA/ECB/OAEPWithSHA1AndMGF1Padding";
	
	private static final String	RSA_KEY_FACTORY_INSTANCE	= "RSA";

	public static final String	PRIVATE_KEY_HEADER			= "-----BEGIN RSA PRIVATE KEY-----";
	
	public static final String	PRIVATE_KEY_FOOTER			= "-----END RSA PRIVATE KEY-----";

	private static final String	HMAC_SHA256_ALGORITHM	= "HmacSHA256";
	
	private static final String	privateKey	= "6D2EDFC83A5F4848EB3A2DE0CBE289FAF5585E5A518C3D02FC97944CAD700A08121B2DD7A0779E167B096FC25C4B9D54A88A800C641BA420E243D2D9F4D84976938DF1A12D568F2C0C64F864AE4C235B";
	
	private static final String	publicKey	= "A3C64FAC578EEC6D60D744D131D3CEF870048D877A525B847AE35E7304280F0C1B28C4C370B36D2353D62F847732A550DE4801C2EA15F0C9B14A4CC22151DBBE156C1109C99D773B19C51A1270D24367";
		
	private static final String	encryptedFlag	= "3";
	
	
	public static void main(String[] args) {/*

		
		try {
			String uploadFilePath = "D:/HMAC.txt";
			String uploadfile="";
			StringBuffer sb = new StringBuffer();
			//String hashedReq = "";
			String msg[] = null;
			
			File file=new File(uploadFilePath);
			System.out.println("File :: "+file);

			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			
			while ((uploadfile = reader.readLine()) != null)  {
				sb.append(uploadfile);
				sb.append("\r\n");
			}
			
			System.out.println("Request::"+sb.toString().trim());
			
			verifyHMACvalue(sb.toString().trim(),hmacEncryptionKey,encryptedFlag,receivedHMAC);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	*/
		System.out.println(getClearPin(privateKey, publicKey, encryptedFlag, "LJG4C5DMferXq8cDKp2/f7wxf5xntYMtapw7NJ4peqmI5JwTO9t6C3bkC8dhoGjBbPqa94to31DF/9tYwWQH2iK3KGiT/+8bNPkBkjIDHI51v6uUZvZZptPSavB4vXqZvZ/hzj1vrt5kCxFTVPMHnCYkRS/Ui1Ib93DY85yAj1Q="));
	
	}
	
public static boolean verifyHMACvalue(String message, String reqKey, String encryptedFlag, String hashedReq){
	boolean validHmac = false;
	try {

		validHmac = verifyHmacValue(message, reqKey, encryptedFlag,hashedReq);
	} catch (Exception ex) {
		System.out.println("Authorization Filter Exception Occured ::::"+ex);
	}
	return validHmac;
}

public static boolean verifyHmacValue(String message, String reqKey, String encryptedFlag, String hashedReq){
	boolean validHmac = false;
	try {
		
		String decryptReqKey = getClearPin(privateKey, publicKey, encryptedFlag, reqKey);
		String hashedData = calculateRFC2104HMAC(message, decryptReqKey);
		System.out.println("HMAC Generated :::"+hashedData);
		System.out.println("HMAC Received :::"+hashedReq);
		if (hashedData.equals(hashedReq)) {
			System.out.println("Hmac Verified Successfully");
			validHmac = true;
		} else {
			System.out.println("Hmac Verification Failed");
		}
	} catch (RuntimeException ex) {
		// LOGGER.error("(MPYERV2711) Verifying Hmac Exception Occured", ex);
		throw ex;
	} catch (Exception ex) {
		System.out.println("(MPYERV2711) Verifying Hmac Exception Occured:::"+ex);
	}
	return validHmac;
}

public static String calculateRFC2104HMAC(String data, String key) {

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
	return result;

}

private static String toHexString(byte[] bytes) {

	Formatter formatter = new Formatter();

	for (byte b : bytes) {
		formatter.format("%02x", b);
	}

	return formatter.toString();
}


public static String getClearPin(String privateKey, String publicKey, String encryptedFlag, String encryptedPin){
	
	String clearPin = "";
	try {
		/*if (encryptedFlag.equals("2")) {
			//publicKey = keyConfig.getRsaPublicKey();
			//privateKey = keyConfig.getRsaPrivateKey();
			clearPin = RSAKeyPairGenerator.decrypt(publicKey, privateKey, encryptedPin);
		}
		if (encryptedFlag.equals("1")) {
			//publicKey = keyConfig.getPublicKey();
			//privateKey = keyConfig.getPrivateKey();
			RSADecryptionNew rsa = new RSADecryptionNew(privateKey, publicKey, encryptedPin);
			clearPin = rsa.getDecryptedValue();
		}*/
		if(encryptedFlag.equals("3")) {
			clearPin = decrypt(encryptedPin, rsaprivatekeypath);
			System.out.println("Key ::"+clearPin);
		}
		/*if(encryptedFlag.equals("4")) {
			clearPin = RSAWapDecryptor.decrypt(encryptedPin, System.getProperty("conf.path")+"/wap_rsa.pem");
			System.out.println("Decrypted data :: {}"+clearPin);
		}*/
	}catch (Exception e) {
		System.out.println("RSA Key Pair Exception Occured "+e);
		
	}
	return clearPin;
}


public static String decrypt(String encryptedData, String keyFilePath) {
	try {
		byte[] decodedBytes = Base64.decodeBase64(encryptedData);
		byte[] plainData = blockDeCipher(decodedBytes, keyFilePath);
		return new String(plainData, "UTF-8");
	}
	catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}

private static byte[] blockDeCipher(byte[] bytes, String pemFileName) {
	try {
		Cipher decipher = Cipher.getInstance(RSA_PADDING_STANDARD);
		decipher.init(Cipher.DECRYPT_MODE, getPemPrivateKey(pemFileName));
		byte[] scrambled = new byte[0];
		byte[] toReturn = new byte[0];
		int length = 128;
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
		return trim(toReturn);
	}
	catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}

private static PrivateKey getPemPrivateKey(String filename) {
	
	File file = new File(filename);
	
	try {
		FileInputStream fileInputStream = new FileInputStream(file);
		DataInputStream dataInputInstream = new DataInputStream(fileInputStream);
		byte[] keyBytes = new byte[(int) file.length()];
		dataInputInstream.readFully(keyBytes);
		String privKeyPEM = new String(keyBytes);
		privKeyPEM = privKeyPEM.replace(PRIVATE_KEY_HEADER, "");
		privKeyPEM = privKeyPEM.replace(PRIVATE_KEY_FOOTER, "");
	
		byte[] decoded = Base64.decodeBase64(privKeyPEM);
					
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decoded);
		KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_FACTORY_INSTANCE);
		PrivateKey key = keyFactory.generatePrivate(spec);
		return key;
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

private static byte[] trim(byte[] original) {
	int length = original.length - 1;
	while (length >= 0 && original[length] == 0) {
		length--;
	}
	return Arrays.copyOf(original, length + 1);
}

}