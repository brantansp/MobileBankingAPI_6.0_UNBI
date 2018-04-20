package mBankingUtilityCenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandles;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.reporters.jq.Main;

import com.fss.boiMpay.HMACGeneration;
import com.fss.boiMpay.HMACKeyEncryption;


import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;
import java.util.Properties;
import java.io.*;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

public class HttpConnect extends ExtentManager {

	public static Properties prop=getProperty();
	protected static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	public static void main(String[] args){
		//String content = "{\"header\":{\"mobNo\":\"+918074581222\",\"mType\":\"req\",\"tType\":\"mid066\",\"bVer\":\"2.1\"},\"body\":{\"txnIdentifier\":\"cumulative\",\"pChk\":\"j1T+WIyITpKDSu5hUtjC1bcJaeEQir7RJ9/BRoQVLs96mJIduAzAHNpTsUQaaEPbq3DKN9p1oeawdW3Ry7MnTfFVqcSOUeF0SrQehOXNiuwqGnRjafjJ+HmOtvG/gSyLw5GeY7tt5xvTvGGpDDzxFWaX9SCwyeY3H7k9NyD8jA4=\",\"acc\":\"0000000000000000\",\"regFlag\":\"R\"},\"footer\":{}}";
		String content = "{\"header\":{\"mobNo\":\"+918754599508\",\"mType\":\"req\",\"tType\":\"mid025\",\"bVer\":\"2.1\"},\"body\":{\"search\":\"Hyderabad\",\"tpy\":\"all\",\"fromLat\":12.8356597,\"fromLon\":80.2228413},\"footer\":{}}";
			try {
				
				Post(content, "/boi-mobilepay-service-web/mbanking/boi/mob/6.0/en/location/search" );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public static String Post(String request, String resource) throws IOException
	{
		URL url = null;
		
		         String endpoint = "http://10.44.112.58:8079";
		      // String endpoint = "https://mobileprd.fssnet.co.in:5690";
		       //resource = "/boi-mobilepay-service-web/mbanking/boi/mob/6.0/en/location/search";
		       String plainKey =HMACKeyEncryption.plainKey();
		       url = new URL(endpoint+resource);
		       HttpURLConnection urlConn = null;	       
		       urlConn = (HttpURLConnection) url.openConnection();	       
		       urlConn.setDoInput (true);
		       urlConn.setDoOutput (true);
		 
		       urlConn.setRequestMethod("POST");
		       urlConn.setRequestProperty("Accept", "application/json, text/plain, */*");
		       urlConn.setRequestProperty("Accept-Encoding", "gzip, deflate");
		       urlConn.setRequestProperty("Accept-Language", "en-IN,en-US;q=0.9");
		       urlConn.setRequestProperty("authToken", "19ffd96b8c6681e2|Android|Moto G Play|||6.0.1|1.0.0.0");
		       urlConn.setRequestProperty("Connection", "keep-alive");
		       urlConn.setRequestProperty("Content-Length", "");
		       urlConn.setRequestProperty("Content-Type", "application/json");
		       urlConn.setRequestProperty("hmval", HMACGeneration.generateHMAC(request, plainKey));
		       urlConn.setRequestProperty("Host", "mobileprd.fssnet.co.in:5690");
		       urlConn.setRequestProperty("Origin", "file://");
		       urlConn.setRequestProperty("ralg", "3");
		       urlConn.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 6.0.1; Coolpad 3600I Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/64.0.3282.137 Mobile Safari/537.36");
		       urlConn.setRequestProperty("usrtk", HMACKeyEncryption.encryptedKey(plainKey));
		       urlConn.setRequestProperty("X-Requested-With", "com.fss.BOImPay");
		       /*	
		       234 > Host: mobileprd.fssnet.co.in:5690
		       234 > Origin: file://
		       234 > ralg: 3
		       234 > User-Agent: Mozilla/5.0 (Linux; Android 6.0.1; Coolpad 3600I Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/64.0.3282.137 Mobile Safari/537.36
		       234 > usrtk: SWnxNB0/PGjNtNQ6eNiCNK8H5agFoKlMUozzTDVuMa2yYkLkvWXh12ZdOYH9aRprJV4STT9b8F/e3VLzUh0Ei5ZQ5ZCWzVc3EZfghF6215bXjIr8GCTTn1pxjvavE8Ghrj4DaKBgTC9qhwqRV1jM3ErzXzCuzdzsxcJgbM0Qt/M=
		       234 > X-Requested-With: com.fss.BOImPay
		       */
		       urlConn.connect();
		         
		       DataOutputStream output = null;
		         
		       DataInputStream input = null;
		 
		       output = new DataOutputStream(urlConn.getOutputStream());
		 
		        String content = request;
		        System.out.println(content);
		        /* Send the request data.*/
		            output.writeBytes(content);

		        /* Get response data.*/
		        String Response = null;
		            input = new DataInputStream (urlConn.getInputStream());
		            while (null != ((response = input.readLine()))) {
		            	Response = response;
		            System.out.println("Httpconect : "+response); 
		      }
		            System.out.println("Httpconect : "+response); 
		            
	        return Response;
	    }

}
















