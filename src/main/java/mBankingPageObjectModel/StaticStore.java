package mBankingPageObjectModel;

import java.util.Properties;

import mBankingUtilityCenter.ExtentManager;
import mBankingUtilityCenter.RandomNumGenerator;

public class StaticStore{
	
	static StringBuilder sb = new StringBuilder() ;
	static Properties prop = ExtentManager.getProperty();
	
	public static void main(String[] args) 
	{
		System.out.println(IMPSP2P());
		
	}
	
	public static String SilentSMS(){
		
		StringBuilder sb=new StringBuilder();
		sb.append("{");
			 sb.append("\"header\":{");
			    sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\"," );//if field1 is “1”  By Default value is “0000000000” ,if field1 is “2” mobNO
			    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
			   sb.append("\"tType\":\"mid013\",");
			    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
			  sb.append("},");
			 sb.append("\"body\":{");
			    sb.append("\"field1\":\""+prop.getProperty("field1")+"\","); // 1 - 1st leg. Normal Silent SMS for fetching mobile number, 2 - 2nd leg. Registered Customer. Update device ID based on mobile number 
			    sb.append("\"field2\":\""+prop.getProperty("field2")+"\","); //VMN
			    sb.append("\"field3\":\""+prop.getProperty("field3")+"\""); // \"BMBUAT  ACTIVATE\" + DEVICEID +"BOI\" +25 DIGIT RANDOAM ID+ SIM SERIAL NUMBER [Maximum of 60 characters]
			  sb.append("},");
			 sb.append("\"footer\":{}");
			sb.append("}");
		return sb.toString();
		
	}
	
	public static String CheckUserIDAvailability()
	{
			StringBuilder sb=new StringBuilder();
			sb.append("{");
				  sb.append("\"header\":{");
				   sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
				    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
				    sb.append("\"tType\":\"mid198\",");
				    sb.append("\"bVer\": \""+prop.getProperty("bVer")+"\"");
				  sb.append("},");
				  sb.append("\"body\":{");
				   sb.append("\"usrId\":\""+prop.getProperty("usrId")+"\"");	
				  sb.append("},");
				  sb.append("\"footer\":{}");
				sb.append("}");
			return sb.toString();
	}
	
	public static String CardNumberValidation()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
			  sb.append("\"header\":{");
			  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
			    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
			    sb.append("\"tType\":\"mid040\",");
			    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
			  sb.append("},");
			  sb.append("\"body\":{");
				sb.append("\"field4\":\""+prop.getProperty("field4")+"\","); //encryptedCardNumber
				sb.append("\"field5\":\""+prop.getProperty("field5")+"\","); //encryptedAtTransaction Password
				sb.append("\"field6\":\""+prop.getProperty("field6")+"\""); //cardExpiryDate   	
			   sb.append("},");
			  sb.append("\"footer\":{}");
			sb.append("}");
		return sb.toString();
	}
	
	public static String GenerateOTP()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid001\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		  sb.append("},");
		  sb.append("\"body\":{},");
		  sb.append("\"footer\":{}");
			sb.append("}");
		return sb.toString();
	}
	
	public static String VerifyOTP()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid002\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		  sb.append("},");
		  sb.append("\"body\":{");
		  sb.append("\"eOtp\":\""+prop.getProperty("eOtp")+"\"");
		  sb.append("},");
		  sb.append("\"footer\":{}");
			sb.append("}");
		return sb.toString();
	}
	
	
	public static String FTUserRegistration()
	{
		StringBuilder sb=new StringBuilder();
			sb.append("{");
			  sb.append("\"header\":{");
			  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
			    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
			    sb.append("\"tType\":\"mid167\",");
			    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
			  sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"field1\":\""+prop.getProperty("field1")+"\",");
			  sb.append("\"field2\":\""+prop.getProperty("field2")+"\",");
			  sb.append("\"field3\":\""+prop.getProperty("field3")+"\",");
			  sb.append("\"field4\":\""+prop.getProperty("field4")+"\",");
			  sb.append("\"field5\":\""+prop.getProperty("field5")+"\",");
			  sb.append("\"field6\":\""+prop.getProperty("field6")+"\",");
			  sb.append("\"field7\":\""+prop.getProperty("field7")+"\",");
			  sb.append("\"field8\":\""+prop.getProperty("field8")+"\",");
			  sb.append("\"field9\":\""+prop.getProperty("field9")+"\",");
			  sb.append("\"field10\":\""+prop.getProperty("field10")+"\",");
			  sb.append("},");
			  sb.append("\"footer\":{}");
				sb.append("}");
		return sb.toString();
	}
	
	public static String CustomerIDFetch()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid030\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		  sb.append("},");
		  sb.append("\"body\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\"");
		  sb.append("},");
		  sb.append("\"footer\":{}");
			sb.append("}");
		
		return sb.toString();
	}
	
	public static String ViewOnlyUserRegistration()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid167\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		  sb.append("},");
		  sb.append("\"body\":{");
		  sb.append("\"field1\":\""+prop.getProperty("field1")+"\",");
		  sb.append("\"field2\":\""+prop.getProperty("field2")+"\",");
		  sb.append("\"field3\":\""+prop.getProperty("field3")+"\",");
		  sb.append("\"field4\":\""+prop.getProperty("field4")+"\",");
		  sb.append("\"field5\":\""+prop.getProperty("field5")+"\",");
		  sb.append("\"field6\":\""+prop.getProperty("field6")+"\",");
		  sb.append("\"field7\":\""+prop.getProperty("field7")+"\",");
		  sb.append("\"field8\":\""+prop.getProperty("field8")+"\",");
		  sb.append("\"field9\":\""+prop.getProperty("field9")+"\",");
		  sb.append("\"field10\":\""+prop.getProperty("field10")+"\",");
			sb.append("\"cityCode\":\""+prop.getProperty("cityCode")+"\",");
            sb.append("\"countryCode\":\""+prop.getProperty("countryCode")+"\",");
            sb.append("\"custAddr\":\""+prop.getProperty("custAddr")+"\",");
            sb.append("\"pinCode\":\""+prop.getProperty("pinCode")+"\",");
            sb.append("\"stateCode\":\""+prop.getProperty("stateCode")+"\",");
            sb.append("\"custName\":\""+prop.getProperty("custName")+"\",");
		  sb.append("},");
		  sb.append("\"footer\":{}");
			sb.append("}");
		
		return sb.toString();
	}
	
	public static String LoginParameterDownload()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid039\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		  sb.append("},");
		  sb.append("\"body\":{");
		  sb.append("\"gcmId\":\""+prop.getProperty("gcmId")+"\"");
		  sb.append("},");
		  sb.append("\"footer\":{}");
			sb.append("}");
		return sb.toString();
	}

	public static String LoginCustomerInfo()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid040\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		  sb.append("},");
		  sb.append("\"body\":{},");
		  sb.append("\"footer\":{}");
			sb.append("}");
			return sb.toString();
	}
	
	
	public static String MyAccountCumulativeofBalance()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"tType\":\"mid066\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\"");
		  sb.append("},");
		  sb.append("\"body\":{");
		  sb.append("\"accNo\":\""+prop.getProperty("accNo")+"\",");
		  sb.append("\"txnIdentifier\":\""+prop.getProperty("txnIdentifier")+"\",");
		  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
		  sb.append("\"regFlag\":\""+prop.getProperty("regFlag")+"\",");
		  sb.append("\"accType\":\""+prop.getProperty("accType")+"\"");
		  sb.append("},");
		  sb.append("\"footer\":{}");
			sb.append("}");
		
		return sb.toString();
	}
	
	public static String MyAccountBalanceagainsteachaccountbasedonmobilenumber()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"tType\":\"mid066\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\"");
		  sb.append("},");
		  sb.append("\"body\":{");
		  sb.append("\"accNo\":\""+prop.getProperty("accNo")+"\",");
		  sb.append("\"txnIdentifier\":\""+prop.getProperty("txnIdentifier")+"\",");
		  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
		  sb.append("\"regFlag\":\""+prop.getProperty("regFlag")+"\",");
		  sb.append("\"accType\":\""+prop.getProperty("accType")+"\"");
		  sb.append("},");
		  sb.append("\"footer\":{}");
			sb.append("}");
		
		return sb.toString();
	}

	public static String MiniStatement()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid012\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		  sb.append("},");
		  sb.append("\"body\":{");
		  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
		  sb.append("\"accType\":\""+prop.getProperty("accType")+"\",");
		  sb.append("\"accNo\":\""+prop.getProperty("accNo")+"\"");
		  sb.append("},");
		  sb.append("\"footer\":{}");
			sb.append("}");
		
		return sb.toString();
	}
	
	public static String ValidateTransactionPassword()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid004\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		  sb.append("},");
		  sb.append("\"body\":{");
		  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
		  sb.append("\"ePn\":\""+prop.getProperty("ePn")+"\"");
		  sb.append("},");
		  sb.append("\"footer\":{}");
	      sb.append("}");
	      
		  return sb.toString();
	}
	
	public static String MobiletoAccount()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid020\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\",");
		    sb.append("\"acc\":\""+prop.getProperty("acc")+"\"");
		  sb.append("},");
		  sb.append("\"body\":{");
		  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
		  sb.append("\"ePn\":\""+prop.getProperty("ePn")+"\",");
		  sb.append("\"typ\":\""+prop.getProperty("typ")+"\",");
		  sb.append("\"benAcc\":\""+prop.getProperty("benAcc")+"\",");
		  sb.append("\"amt\":\""+prop.getProperty("amt")+"\",");
		  sb.append("\"rms\":\""+prop.getProperty("rms")+"\",");
		  sb.append("\"eOpt\":\""+prop.getProperty("eOpt")+"\"");
		  sb.append("},");
		  sb.append("\"footer\":{}");
	      sb.append("}");
	      
	      return sb.toString();
	}
	
	public static String VerifyUser()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid010\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\",");
		    sb.append("\"acc\":\""+prop.getProperty("acc")+"\"");
		  sb.append("},");
		  sb.append("\"body\":{");
		  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
		  sb.append("\"ePn\":\""+prop.getProperty("ePn")+"\",");
		  sb.append("\"accNo\":\""+prop.getProperty("accNo")+"\"");
		  sb.append("},");
		  sb.append("\"footer\":{}");
	      sb.append("}");
		 return sb.toString();
	}
	
	
	public static String CheckTransactionStatus()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid061\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		  sb.append("},");
		  sb.append("\"body\":{");
		  sb.append("\"orgtxnId\":\""+prop.getProperty("orgtxnId")+"\"");
		  sb.append("},");
		  sb.append("\"footer\":{}");
	      sb.append("}");
		return sb.toString();
	}
	
	public static String SelfAccountQuickFT(){
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid064\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\",");
		    sb.append("\"acc\":\""+prop.getProperty("acc")+"\"");
		  sb.append("},");
		  sb.append("\"body\":{");
		  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
		  sb.append("\"ePn\":\""+prop.getProperty("ePn")+"\",");
		  sb.append("\"typ\":\""+prop.getProperty("typ")+"\",");
		  sb.append("\"benAcc\":\""+prop.getProperty("benAcc")+"\",");
		  sb.append("\"eOpt\":\""+prop.getProperty("eOpt")+"\"");
		  sb.append("},");
		  sb.append("\"footer\":{}");
	      sb.append("}");
		return sb.toString();
	}
	
	public static String NEFT()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\"8778602561\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid021\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\",");
		    sb.append("\"acc\":\""+prop.getProperty("acc")+"\"");
		  sb.append("},");
		  sb.append("\"body\":{");
		  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
		  sb.append("\"ePn\":\""+prop.getProperty("ePn")+"\",");
		  sb.append("\"typ\":\""+prop.getProperty("typ")+"\",");
		  sb.append("\"benAcc\":\""+prop.getProperty("benAcc")+"\",");
		  sb.append("\"benName\":\""+prop.getProperty("benName")+"\",");
		  sb.append("\"benIfc\":\""+prop.getProperty("benIfc")+"\",");
		  sb.append("\"amt\":\""+prop.getProperty("amt")+"\",");
		  sb.append("\"rms\":\""+prop.getProperty("rms")+"\",");
		  sb.append("\"eOpt\":\""+prop.getProperty("eOpt")+"\",");
		  sb.append("\"feeAmt\":\""+prop.getProperty("feeAmt")+"\",");
		  sb.append("\"totAmt\":\""+prop.getProperty("totAmt")+"\",");
		  sb.append("\"taxAmt\":\""+prop.getProperty("taxAmt")+"\",");
		  sb.append("\"neftFlag\":\""+prop.getProperty("neftFlag")+"\"");
		  sb.append("},");
		  sb.append("\"footer\":{}");
	      sb.append("}");
		return sb.toString();
	}
	
	public static String BankSearchbasedonIFSC()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid060\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		  sb.append("},");
		  sb.append("\"body\":{");
		  sb.append("\"ifsc\":\""+prop.getProperty("benIfc")+"\"");
		  sb.append("},");
		  sb.append("\"footer\":{}");
	      sb.append("}");
		return sb.toString();
	}
	
	public static String BankNameSearch()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid060\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		  sb.append("},");
		  sb.append("\"body\":{}");
		  sb.append("\"footer\":{}");
			sb.append("}");
		return sb.toString();
	}
	
	public static String IFSCSearch()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid060\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		  sb.append("},");
		  sb.append("\"body\":{");
		  sb.append("\"brnch\":\""+prop.getProperty("brnch")+"\",");
		  sb.append("\"state\":\""+prop.getProperty("state")+"\",");
		  sb.append("\"bnkName\":\""+prop.getProperty("bnkName")+"\"");
		  sb.append("},");
		  sb.append("\"footer\":{}");
	      sb.append("}");
		
		return sb.toString();
	}
	
	
	public static String RTGS()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid095\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\",");
		    sb.append("\"acc\":\""+prop.getProperty("acc")+"\"");
		  sb.append("},");
		  sb.append("\"body\":{");
		  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
		  sb.append("\"ePn\":\""+prop.getProperty("ePn")+"\",");
		  sb.append("\"typ\":\""+prop.getProperty("typ")+"\",");
		  sb.append("\"benAcc\":\""+prop.getProperty("benAcc")+"\",");
		  sb.append("\"benName\":\""+prop.getProperty("benName")+"\",");
		  sb.append("\"benIfc\":\""+prop.getProperty("benIfc")+"\",");
		  sb.append("\"amt\":\""+prop.getProperty("amt")+"\",");
		  sb.append("\"rms\":\""+prop.getProperty("rms")+"\",");
		  sb.append("\"eOpt\":\""+prop.getProperty("eOpt")+"\",");
		  sb.append("\"feeAmt\":\""+prop.getProperty("feeAmt")+"\",");
		  sb.append("\"totAmt\":\""+prop.getProperty("totAmt")+"\",");
		  sb.append("\"taxAmt\":\""+prop.getProperty("taxAmt")+"\",");
		  sb.append("\"neftFlag\":\""+prop.getProperty("neftFlag")+"\"");
		  sb.append("},");
		  sb.append("\"footer\":{}");
	      sb.append("}");
		
		return sb.toString();
	}
	
	public static String ChangeTransactionPassword()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"acc\":\""+prop.getProperty("acc")+"\",");
		    sb.append("\"tType\":\"mid004\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		  sb.append("},");
		  sb.append("\"body\":{");
		  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
		  sb.append("\"eOp\":\""+prop.getProperty("eOp")+"\",");
		  sb.append("\"eNp\":\""+prop.getProperty("eNp")+"\"");
		  sb.append("},");
		  sb.append("\"footer\":{}");
	      sb.append("}");
	
		return sb.toString();
	}
	
	public static String GenerateMMID()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid015\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\",");
		    sb.append("\"acc\":\""+prop.getProperty("acc")+"\"");
		  sb.append("},");
		  sb.append("\"body\":{");
		  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\"");
		  sb.append("},");
		  sb.append("\"footer\":{}");
	      sb.append("}");
	
		return sb.toString();
	}
	
	public static String ADDFavourite()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid031\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		  sb.append("},");
		  sb.append("\"body\":{");
		  sb.append("\"remAcc\":\""+prop.getProperty("remAcc")+"\",");
		  sb.append("\"benNickName\":\""+prop.getProperty("benNickName")+"\",");
		  sb.append("\"amt\":\""+prop.getProperty("amt")+"\",");
		  sb.append("\"rms\":\""+prop.getProperty("rms")+"\",");
		  sb.append("\"txnTyp\":\""+prop.getProperty("txnTyp")+"\",");
		  sb.append("\"favtType\":\""+prop.getProperty("favtType")+"\",");
		  sb.append("\"reserved1\":\""+prop.getProperty("reserved1")+"\",");
		  sb.append("\"reserved2\":\""+prop.getProperty("reserved2")+"\",");
		  sb.append("\"reserved3\":\""+prop.getProperty("reserved3")+"\",");
		  sb.append("\"reserved4\":\""+prop.getProperty("reserved4")+"\",");
		  sb.append("\"reserved5\":\""+prop.getProperty("reserved5")+"\",");
		  sb.append("\"reserved6\":\""+prop.getProperty("reserved6")+"\"");
		  sb.append("},");
		  sb.append("\"footer\":{}");
	      sb.append("}");
		  return sb.toString();
	}
	
	public static String DeleteFavourite()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid032\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		  sb.append("},");
		  sb.append("\"body\":{");
		  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
		  sb.append("\"ePn\":\""+prop.getProperty("ePn")+"\",");
		  sb.append("\"benName\":\""+prop.getProperty("benName")+"\"");
		  sb.append("},");
		  sb.append("\"footer\":{}");
	      sb.append("}");
		return sb.toString();
	}
	
	public static String IMPSP2A()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		 sb.append("\"footer\":{},");
		  sb.append("\"header\":{");
		  sb.append("\"bankId\":\""+prop.getProperty("bankId")+"\",");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		  sb.append("\"outwardTxnId\":\""+prop.getProperty("outwardTxnId")+"\",");
		  sb.append("\"tType\":\"mid037\",");
		  sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\",");
		  sb.append("\"mType\":\""+prop.getProperty("mType")+"\"");
		  sb.append("},");
		  sb.append("\"body\":{");
		  sb.append("\"remitterDetails\":{");
		  sb.append("\"remName\":\""+prop.getProperty("remName")+"\",");
		  sb.append("\"remUserId\":\""+prop.getProperty("remUserId")+"\",");
		  sb.append("\"remCustId\":\""+prop.getProperty("remCustId")+"\",");
		  sb.append("\"remMob\":\""+prop.getProperty("remMob")+"\",");
		  sb.append("\"txnFee\":\""+prop.getProperty("txnFee")+"\",");
		  sb.append("\"remAcc\":\""+prop.getProperty("remAcc")+"\"},");
		  sb.append("\"beneDetails\":{");
		  sb.append("\"beneAc\":\""+prop.getProperty("beneAc")+"\",");
		  sb.append("\"beneIFSC\":\""+prop.getProperty("beneIFSC")+"\",");
		  sb.append("\"tranAmt\":\""+prop.getProperty("tranAmt")+"\",");
		  sb.append("\"remarks\":\""+prop.getProperty("remarks")+"\"}");
		  sb.append("}");
	      sb.append("}");
		return sb.toString();
	}
	
	public static String IMPSP2P()
	{
		
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"footer\":{},");
		  sb.append("\"header\":{");
		  sb.append("\"bankId\":\""+prop.getProperty("bankId")+"\",");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		  sb.append("\"outwardTxnId\":\""+prop.getProperty("outwardTxnId")+"\",");
		    sb.append("\"tType\":\"mid036\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		  sb.append("},");
		  sb.append("\"body\":{");
		  sb.append("\"remitterDetails\":{");
		  sb.append("\"remName\":\""+prop.getProperty("remName")+"\",");
		  sb.append("\"remUserId\":\""+prop.getProperty("remUserId")+"\",");
		  sb.append("\"remCustId\":\""+prop.getProperty("remCustId")+"\",");
		  sb.append("\"remMob\":\""+prop.getProperty("remMob")+"\",");
		  sb.append("\"txnFee\":\""+prop.getProperty("txnFee")+"\",");
		  sb.append("\"remAcc\":\""+prop.getProperty("remAcc")+"\"},");
		  sb.append("\"beneDetails\":{");
		  sb.append("\"beneMMID\":\""+prop.getProperty("beneMMID")+"\",");
		  sb.append("\"tranAmt\":\""+prop.getProperty("tranAmt")+"\",");
		  sb.append("\"remarks\":\""+prop.getProperty("remarks")+"\",");
		  sb.append("\"benMob\":\""+prop.getProperty("benMob")+"\"}");
		  sb.append("}");
	      sb.append("}");
		return sb.toString();
	}
	
	public static String IMPSP2U(){
		
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		sb.append("\"footer\":{},");
		  sb.append("\"header\":{");
		    sb.append("\"bankId\":\""+prop.getProperty("bankId")+"\",");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"outwardTxnId\":\""+prop.getProperty("outwardTxnId")+"\",");
		    sb.append("\"tType\":\"mid043\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\"");
		  sb.append("},");
		  sb.append("\"body\":{");
		  sb.append("\"remitterDetails\":{");
		  sb.append("\"remName\":\""+prop.getProperty("remName")+"\",");
		  sb.append("\"remUserId\":\""+prop.getProperty("remUserId")+"\",");
		  sb.append("\"remCustId\":\""+prop.getProperty("remCustId")+"\",");
		  sb.append("\"remMob\":\""+prop.getProperty("remMob")+"\",");
		  sb.append("\"txnFee\":\""+prop.getProperty("txnFee")+"\",");
		  sb.append("\"remAcc\":\""+prop.getProperty("remAcc")+"\"},");
		  sb.append("\"beneDetails\":{");
		  sb.append("\"beneAadhaar\":\""+prop.getProperty("beneAadhaar")+"\",");
		  sb.append("\"tranAmt\":\""+prop.getProperty("tranAmt")+"\",");
		  sb.append("\"remarks\":\""+prop.getProperty("remarks")+"\"}");
		  sb.append("}");
	      sb.append("}");
		return sb.toString();
		
	}
	
	public static String ConfirmationLeg()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid030\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"txnTyp\":\""+prop.getProperty("txnTyp")+"\",");
			  sb.append("\"amt\":\""+prop.getProperty("amt")+"\",");
			  sb.append("\"benAcc\":\""+prop.getProperty("benAcc")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
			return sb.toString();	  
	}
	
	public static String Transactionhistorybasedonpiechart()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid051\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"txnType\":\""+prop.getProperty("txnType")+"\",");
			  sb.append("\"period\":\""+prop.getProperty("period")+"\",");
			  sb.append("\"accType\":\""+prop.getProperty("accType")+"\",");
			  sb.append("\"accNo\":\""+prop.getProperty("accNo")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
			return sb.toString();
	}
	
	public static String LoanAccountfetch()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid066\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"accType\":\""+prop.getProperty("accType")+"\",");
			  sb.append("\"txnIdentifier\":\""+prop.getProperty("txnIdentifier")+"\",");
			  sb.append("\"accNo\":\""+prop.getProperty("accNo")+"\",");
			  sb.append("\"regFlag\":\""+prop.getProperty("regFlag")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
			return sb.toString();
	}
	
	public static String LoanStatement()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid150\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"accType\":\""+prop.getProperty("accType")+"\",");
			  sb.append("\"txnIdentifier\":\""+prop.getProperty("txnIdentifier")+"\",");
			  sb.append("\"accNo\":\""+prop.getProperty("accNo")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
			return sb.toString();
	}
	
	public static String LoanCertificate()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid166\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"accType\":\""+prop.getProperty("accType")+"\",");
			  sb.append("\"txnIdentifier\":\""+prop.getProperty("txnIdentifier")+"\",");
			  sb.append("\"accNo\":\""+prop.getProperty("accNo")+"\",");
			  sb.append("\"regFlag\":\""+prop.getProperty("regFlag")+"\",");
			  sb.append("\"startYear\":\""+prop.getProperty("startYear")+"\",");
			  sb.append("\"endYear\":\""+prop.getProperty("endYear")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
			return sb.toString();
		
	}
	
	public static String mPassbookviadateselection()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid304\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\",");
		    sb.append("\"acc\":\""+prop.getProperty("acc")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
			  sb.append("\"ePn\":\""+prop.getProperty("ePn")+"\",");
			  sb.append("\"fDate\":\""+prop.getProperty("fDate")+"\",");
			  sb.append("\"tDate\":\""+prop.getProperty("tDate")+"\",");
			  sb.append("\"noOfTxns\":\""+prop.getProperty("noOfTxns")+"\",");
			  sb.append("\"noOfDays\":\""+prop.getProperty("noOfDays")+"\",");
			  sb.append("\"lastTxnId\":\""+prop.getProperty("lastTxnId")+"\",");
			  sb.append("\"lastTxnDate\":\""+prop.getProperty("lastTxnDate")+"\",");
			  sb.append("\"lastTxnDateTime\":\""+prop.getProperty("lastTxnDateTime")+"\",");
			  sb.append("\"lastTxnAmount\":\""+prop.getProperty("lastTxnAmount")+"\",");
			  sb.append("\"lastPartTranSrlNumber\":\""+prop.getProperty("lastPartTranSrlNumber")+"\",");
			  sb.append("\"fromAmt\":\""+prop.getProperty("fromAmt")+"\",");
			  sb.append("\"toAmt\":\""+prop.getProperty("toAmt")+"\",");
			  sb.append("\"viewAs\":\""+prop.getProperty("viewAs")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
			return sb.toString();
	}
	
	public static String mPassbookviaNumberofTxns()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid304\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\",");
		    sb.append("\"acc\":\""+prop.getProperty("acc")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
			  sb.append("\"ePn\":\""+prop.getProperty("ePn")+"\",");
			  sb.append("\"fDate\":\""+prop.getProperty("fDate")+"\",");
			  sb.append("\"tDate\":\""+prop.getProperty("tDate")+"\",");
			  sb.append("\"noOfTxns\":\""+prop.getProperty("noOfTxns")+"\",");
			  sb.append("\"noOfDays\":\""+prop.getProperty("noOfDays")+"\",");
			  sb.append("\"lastTxnId\":\""+prop.getProperty("lastTxnId")+"\",");
			  sb.append("\"lastTxnDate\":\""+prop.getProperty("lastTxnDate")+"\",");
			  sb.append("\"partTranSrlNumber\":\""+prop.getProperty("partTranSrlNumber")+"\",");
			  sb.append("\"fromAmt\":\""+prop.getProperty("fromAmt")+"\",");
			  sb.append("\"toAmt\":\""+prop.getProperty("toAmt")+"\",");
			  sb.append("\"viewAs\":\""+prop.getProperty("viewAs")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
			return sb.toString();
	}
	
	public static String mPassbookviaNumberofdays()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid304\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\",");
		    sb.append("\"acc\":\""+prop.getProperty("acc")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
			  sb.append("\"ePn\":\""+prop.getProperty("ePn")+"\",");
			  sb.append("\"fDate\":\""+prop.getProperty("fDate")+"\",");
			  sb.append("\"tDate\":\""+prop.getProperty("tDate")+"\",");
			  sb.append("\"noOfTxns\":\""+prop.getProperty("noOfTxns")+"\",");
			  sb.append("\"noOfDays\":\""+prop.getProperty("noOfDays")+"\",");
			  sb.append("\"lastTxnId\":\""+prop.getProperty("lastTxnId")+"\",");
			  sb.append("\"lastTxnDate\":\""+prop.getProperty("lastTxnDate")+"\",");
			  sb.append("\"fromAmt\":\""+prop.getProperty("fromAmt")+"\",");
			  sb.append("\"toAmt\":\""+prop.getProperty("toAmt")+"\",");
			  sb.append("\"viewAs\":\""+prop.getProperty("viewAs")+"\",");
			  sb.append("\"lastTxnDateTime\":\""+prop.getProperty("lastTxnDateTime")+"\",");
			  sb.append("\"lastTxnAmount\":\""+prop.getProperty("lastTxnAmount")+"\",");
			  sb.append("\"lastPartTranSrlNumber\":\""+prop.getProperty("lastPartTranSrlNumber")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
			return sb.toString();
	}
	
	public static String mPassbookEmail()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid065\",");
		    sb.append("\"servName\":\""+prop.getProperty("servName")+"\"");
			sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"to\":\"["+prop.getProperty("to")+"]\",");
			  sb.append("\"templateVal\":\"{"+prop.getProperty("templateVal")+"}\",");
			  sb.append("\"uniqueRefNo\":\""+prop.getProperty("uniqueRefNo")+"\",");
			  sb.append("\"attachment\":[");
			  sb.append("{\"attchmtPath\":\""+prop.getProperty("attchmtPath")+"\"}");
			  sb.append("]},");
			  sb.append("\"footer\":{");
			  sb.append("\"txnId\":\""+prop.getProperty("txnId")+"\",");
			  sb.append("\"dateTime\":\""+prop.getProperty("dateTime")+"\",");
			  sb.append("\"rspTime\":\""+prop.getProperty("rspTime")+"\"");
			  sb.append("}}");
				return sb.toString();
	}
	
	public static String mPassbookpdf()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid302\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\",");
		    sb.append("\"acc\":\""+prop.getProperty("acc")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
			  sb.append("\"ePn\":\""+prop.getProperty("ePn")+"\",");
			  sb.append("\"fDate\":\""+prop.getProperty("fDate")+"\",");
			  sb.append("\"tDate\":\""+prop.getProperty("tDate")+"\",");
			  sb.append("\"noOfTxns\":\""+prop.getProperty("noOfTxns")+"\",");
			  sb.append("\"noOfDays\":\""+prop.getProperty("noOfDays")+"\",");
			  sb.append("\"lastTxnId\":\""+prop.getProperty("lastTxnId")+"\",");
			  sb.append("\"lastTxnDate\":\""+prop.getProperty("lastTxnDate")+"\",");
			  sb.append("\"fromAmt\":\""+prop.getProperty("fromAmt")+"\",");
			  sb.append("\"toAmt\":\""+prop.getProperty("toAmt")+"\",");
			  sb.append("\"viewAs\":\""+prop.getProperty("viewAs")+"\",");
			  sb.append("\"lastTxnDateTime\":\""+prop.getProperty("lastTxnDateTime")+"\",");
			  sb.append("\"lastTxnAmount\":\""+prop.getProperty("lastTxnAmount")+"\",");
			  sb.append("\"lastPartTranSrlNumber\":\""+prop.getProperty("lastPartTranSrlNumber")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
			return sb.toString();
	}
	
	public static String ServiceandCategoryDownload()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"acc\":\""+prop.getProperty("acc")+"\",");
		    sb.append("\"tType\":\"mid500\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
			  sb.append("\"ePn\":\""+prop.getProperty("ePn")+"\",");
			  sb.append("\"billPayService\":{}");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
			 		return sb.toString();
	}
	
	public static String BillerDownload()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"acc\":\""+prop.getProperty("acc")+"\",");
		    sb.append("\"tType\":\"mid501\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
			  sb.append("\"ePn\":\""+prop.getProperty("ePn")+"\",");
			  sb.append("\"billPayService\":{}");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
			 		return sb.toString();
	}
	
	public static String BillFetch()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"acc\":\""+prop.getProperty("acc")+"\",");
		    sb.append("\"tType\":\"mid504\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
			  sb.append("\"ePn\":\""+prop.getProperty("ePn")+"\",");
			  sb.append("\"billPayService\":{");
			  sb.append("\"billerId\":\""+prop.getProperty("billerId")+"\",");
			  sb.append("\"billerRefName\":\""+prop.getProperty("billerRefName")+"\",");
			  sb.append("\"noOfReferenceValue\":\""+prop.getProperty("noOfReferenceValue")+"\",");
			  sb.append("\"referenceValueDetails\":[{");
			  sb.append("\"referenceValue\":\""+prop.getProperty("referenceValue")+"\",");
			  sb.append("}],");
			  sb.append("\"noOfReferenceLabel\":\""+prop.getProperty("noOfReferenceLabel")+"\",");
			  sb.append("\"referenceLabelDetails\":[{");
			  sb.append("\"referenceLabel\":\""+prop.getProperty("referenceLabel")+"\"");
			  sb.append("}]");
			  sb.append("}},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
			 		return sb.toString();
			  
	}
	
	public static String BillerRegistration()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"acc\":\""+prop.getProperty("acc")+"\",");
		    sb.append("\"tType\":\"mid502\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
			  sb.append("\"ePn\":\""+prop.getProperty("ePn")+"\",");
			  sb.append("\"billerDetails\":{");
			  sb.append("\"billerId\":\""+prop.getProperty("billerId")+"\",");
			  sb.append("\"billerRefName\":\""+prop.getProperty("billerRefName")+"\",");
			  sb.append("\"billGenerationDate\":\""+prop.getProperty("billGenerationDate")+"\",");
			  sb.append("\"noOfReferenceValue\":\""+prop.getProperty("noOfReferenceValue")+"\",");
			  sb.append("\"referenceValueDetails\":[{");
			  sb.append("\"referenceValue\":\""+prop.getProperty("referenceValue")+"\"");
			  sb.append("}]}},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
			 		return sb.toString();
	}
	
	public static String BillPaymentConfirmation()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"acc\":\""+prop.getProperty("acc")+"\",");
		    sb.append("\"tType\":\"mid506\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
			  sb.append("\"ePn\":\""+prop.getProperty("ePn")+"\",");
			  sb.append("\"paymentDetails\":{");
			  sb.append("\"paymentId\":\""+prop.getProperty("paymentId")+"\",");
			  sb.append("\"amount\":\""+prop.getProperty("amount")+"\",");
			  sb.append("\"billerNumber\":\""+prop.getProperty("billerNumber")+"\",");
			  sb.append("\"customerId\":\""+prop.getProperty("customerId")+"\",");
			  sb.append("\"remark\":\""+prop.getProperty("rms")+"\",");
			  sb.append("\"custPaymentMode\":\""+prop.getProperty("custPaymentMode")+"\",");
			  sb.append("\"paymentType\":\""+prop.getProperty("paymentType")+"\",");
			  sb.append("\"billerId\":\""+prop.getProperty("billerId")+"\",");
			  sb.append("\"noOfReferenceValue\":\""+prop.getProperty("noOfReferenceValue")+"\",");
			  sb.append("\"refVal\":[{");
			  sb.append("\"referenceValue\":\""+prop.getProperty("referenceValue")+"\"");
			  sb.append("}],");
			  sb.append("\"noOfReferenceLabel\":\""+prop.getProperty("noOfReferenceLabel")+"\",");
			  sb.append("\"refLabel\":[{");
			  sb.append("\"referenceLabel\":\""+prop.getProperty("referenceLabel")+"\"");
			  sb.append("}],");
			  sb.append("\"billerRefName\":\""+prop.getProperty("billerRefName")+"\"");
			  sb.append("}},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
			 		return sb.toString();
	}
	
	public static String BillPayment()
	{

		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"acc\":\""+prop.getProperty("acc")+"\",");
		    sb.append("\"tType\":\"mid506\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
			  sb.append("\"ePn\":\""+prop.getProperty("ePn")+"\",");
			  sb.append("\"paymentDetails\":{");
			  sb.append("\"paymentId\":\""+prop.getProperty("paymentId")+"\",");
			  sb.append("\"amount\":\""+prop.getProperty("amount")+"\",");
			  sb.append("\"billerNumber\":\""+prop.getProperty("billerNumber")+"\",");
			  sb.append("\"customerId\":\""+prop.getProperty("customerId")+"\",");
			  sb.append("\"remark\":\""+prop.getProperty("remark")+"\",");
			  sb.append("\"custPaymentMode\":\""+prop.getProperty("custPaymentMode")+"\",");
			  sb.append("\"paymentType\":\""+prop.getProperty("paymentType")+"\",");
			  sb.append("\"billerId\":\""+prop.getProperty("billerId")+"\",");
			  sb.append("\"totAmt\":\""+prop.getProperty("totAmt")+"\",");
			  sb.append("\"feeAmt\":\""+prop.getProperty("feeAmt")+"\",");
			  sb.append("\"taxAmt\":\""+prop.getProperty("taxAmt")+"\",");
			  sb.append("\"waiverAmt\":\""+prop.getProperty("waiverAmt")+"\",");
			  sb.append("\"noOfReferenceValue\":\""+prop.getProperty("noOfReferenceValue")+"\",");
			  sb.append("\"refVal\":[{");
			  sb.append("\"referenceValue\":\""+prop.getProperty("referenceValue")+"\"");
			  sb.append("}],");
			  sb.append("\"noOfReferenceLabel\":\""+prop.getProperty("noOfReferenceLabel")+"\",");
			  sb.append("\"refLabel\":[{");
			  sb.append("\"referenceLabel\":\""+prop.getProperty("referenceLabel")+"\"");
			  sb.append("}],");
			  sb.append("\"billerRefName\":\""+prop.getProperty("billerRefName")+"\"");
			  sb.append("}},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
			 		return sb.toString();
	}
	
	
	public static String FetchRegisteredBiller(){
		

		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"acc\":\""+prop.getProperty("acc")+"\",");
		    sb.append("\"tType\":\"mid503\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
			  sb.append("\"ePn\":\""+prop.getProperty("ePn")+"\",");
			  sb.append("\"billPayService\":{}");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
			 		return sb.toString();
		
	}
	
	public static String BillerDeletion(){
		
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"acc\":\""+prop.getProperty("acc")+"\",");
		    sb.append("\"tType\":\"mid515\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
			  sb.append("\"ePn\":\""+prop.getProperty("ePn")+"\",");
			  sb.append("\"billerDelDetails\":{");
			  sb.append("\"billerId\":\""+prop.getProperty("billerId")+"\",");
			  sb.append("\"noOfReferenceValue\":\""+prop.getProperty("noOfReferenceValue")+"\",");
			  sb.append("\"referenceValueDetails\":[{");
			  sb.append("\"referenceValue\":\""+prop.getProperty("referenceValue")+"\"");
			  sb.append("}],");
			  sb.append("\"noOfReferenceLabel\":\""+prop.getProperty("noOfReferenceLabel")+"\",");
			  sb.append("\"referenceLabelDetails\":[{");
			  sb.append("\"referenceLabel\":\""+prop.getProperty("referenceLabel")+"\"");
			  sb.append("}]}},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
		  	return sb.toString();
	}
	
	public static String BillPaymentTxnHistory()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"acc\":\""+prop.getProperty("acc")+"\",");
		    sb.append("\"tType\":\"mid516\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
			  sb.append("\"ePn\":\""+prop.getProperty("ePn")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
			 		return sb.toString();
		
	}
	
	public static String DeviceIDUpdate()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid023\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"field2\":\""+prop.getProperty("field2")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
			 		return sb.toString();
	}
	
	public static String TermDepositAccountFetch()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid066\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"accType\":\""+prop.getProperty("accType")+"\",");
			  sb.append("\"txnIdentifier\":\""+prop.getProperty("txnIdentifier")+"\",");
			  sb.append("\"accNo\":\"456374558854\",");
			  sb.append("\"regFlag\":\""+prop.getProperty("regFlag")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
			 		return sb.toString();
	}
	
	public static String TermDepositAccountClosure()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid113\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\",");
		    sb.append("\"acc\":\""+prop.getProperty("acc")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
			  sb.append("\"ePn\":\""+prop.getProperty("ePn")+"\",");
			  sb.append("\"fdDetails\":{");
			  sb.append("\"debitAccount\":\""+prop.getProperty("debitAccount")+"\","); 
			  sb.append("\"creditAccount\":\""+prop.getProperty("creditAccount")+"\","); 
			  sb.append("\"schemeType\":\""+prop.getProperty("schemeType")+"\","); 
			  sb.append("}},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
		      return sb.toString();
	}
	
	public static String TermDepositAccountOpening()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid106\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\",");
		    sb.append("\"acc\":\""+prop.getProperty("acc")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
			  sb.append("\"ePn\":\""+prop.getProperty("ePn")+"\",");
			  sb.append("\"fdDetails\":{");
			  sb.append("\"debitAccount\":\""+prop.getProperty("debitAccount")+"\","); 
			  sb.append("\"creditAccount\":\""+prop.getProperty("creditAccount")+"\","); 
			  sb.append("\"schemeType\":\""+prop.getProperty("schemeType")+"\",");
			  sb.append("\"depositAmt\":\""+prop.getProperty("depositAmt")+"\",");
			  sb.append("\"periodMonth\":\""+prop.getProperty("periodMonth")+"\",");
			  sb.append("\"periodDays\":\""+prop.getProperty("periodDays")+"\",");
			  sb.append("\"autoRenewalFlag\":\""+prop.getProperty("autoRenewalFlag")+"\",");
			  sb.append("\"renewalMonth\":\""+prop.getProperty("renewalMonth")+"\",");
			  sb.append("\"renewalDays\":\""+prop.getProperty("renewalDays")+"\",");
			  sb.append("\"nomineeFlag\":\""+prop.getProperty("nomineeFlag")+"\"},");
			  sb.append("\"nomineeDetails\":{");
			  sb.append("\"nomineeDOB\":\""+prop.getProperty("nomineeDOB")+"\",");
			  sb.append("\"nomineeName\":\""+prop.getProperty("nomineeName")+"\",");
			  sb.append("\"nomineeRelation\":\""+prop.getProperty("nomineeRelation")+"\",");
			  sb.append("\"nomineeAddress1\":\""+prop.getProperty("nomineeAddress1")+"\",");
			  sb.append("\"nomineeAddress2\":\""+prop.getProperty("nomineeAddress2")+"\",");
			  sb.append("\"nomineePincode\":\""+prop.getProperty("nomineePincode")+"\",");
			  sb.append("\"nomineeStatecode\":\""+prop.getProperty("nomineeStatecode")+"\",");
			  sb.append("\"nomineeCitycode\":\""+prop.getProperty("nomineeCitycode")+"\",");
			  sb.append("\"nomineeCountrycode\":\""+prop.getProperty("nomineeCountrycode")+"\"},");
			  sb.append("\"guardianDetails\":{");
			  sb.append("\"guardianName\":\""+prop.getProperty("guardianName")+"\",");
			  sb.append("\"guardianCode\":\""+prop.getProperty("guardianCode")+"\",");
			  sb.append("\"guardianAddress1\":\""+prop.getProperty("guardianAddress1")+"\",");
			  sb.append("\"guardianAddress2\":\""+prop.getProperty("guardianAddress2")+"\",");
			  sb.append("\"guardianStatecode\":\""+prop.getProperty("guardianStatecode")+"\",");
			  sb.append("\"guardianCitycode\":\""+prop.getProperty("guardianCitycode")+"\",");
			  sb.append("\"guardianCountrycode\":\""+prop.getProperty("guardianCountrycode")+"\",");
			  sb.append("\"guardianPincode\":\""+prop.getProperty("guardianPincode")+"\"},");
			  sb.append("\"eOtp\":\""+prop.getProperty("eOtp")+"\""); 
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
		      return sb.toString();
	}
	
	public static String TermDepositInterestRate()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid141\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
			  sb.append("\"fdScheme\":\""+prop.getProperty("fdScheme")+"\",");
			  sb.append("\"fdAmount\":\""+prop.getProperty("fdAmount")+"\",");
			  sb.append("\"durationMonth\":\""+prop.getProperty("durationMonth")+"\",");
			  sb.append("\"durationDays\":\""+prop.getProperty("durationDays")+"\",");
			  sb.append("\"fdInterestCatergory\":\""+prop.getProperty("fdInterestCatergory")+"\",");
			  sb.append("\"fdPayoutType\":\""+prop.getProperty("fdPayoutType")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
		      return sb.toString();
	}
	
	public static String Deregistration()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid089\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
		      return sb.toString();
	}
	
	public static String RequestforCreditCard() 
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid071\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"name\":\""+prop.getProperty("name")+"\",");
			  sb.append("\"email\":\""+prop.getProperty("email")+"\",");
			  sb.append("\"panCardNo\":\""+prop.getProperty("panCardNo")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
		      return sb.toString();
			  
	}
	
	public static String RequestforLoan()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\"+918778602561\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid070\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"name\":\""+prop.getProperty("name")+"\",");
			  sb.append("\"email\":\""+prop.getProperty("email")+"\",");
			  sb.append("\"loanType\":\""+prop.getProperty("loanType")+"\",");
			  sb.append("\"address\":\""+prop.getProperty("address")+"\",");
			  sb.append("\"amount\":\""+prop.getProperty("amount")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
		      return sb.toString();
	}
	
	public static String StopChequeFetchUnusedChequeList()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid018\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\",");
		    sb.append("\"acc\":\""+prop.getProperty("acc")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"chqStatus\":\""+prop.getProperty("chqStatus")+"\",");
			  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
			  sb.append("\"ePn\":\""+prop.getProperty("ePn")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
		      return sb.toString();
			  
	}
	
	public static String StopCheque()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid017\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\",");
		    sb.append("\"acc\":\""+prop.getProperty("acc")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
			  sb.append("\"ePn\":\""+prop.getProperty("ePn")+"\",");
			  sb.append("\"ChqNo\":\""+prop.getProperty("ChqNo")+"\",");
			  sb.append("\"rem\":\""+prop.getProperty("rms")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
		      return sb.toString();
	}
	
	public static String ChequeStatusBasedonDate()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid018\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\",");
		    sb.append("\"acc\":\""+prop.getProperty("acc")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"chqStatus\":\""+prop.getProperty("chqStatus")+"\",");
			  sb.append("\"chequeDate\":\""+prop.getProperty("chequeDate")+"\",");
			  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
			  sb.append("\"ePn\":\""+prop.getProperty("ePn")+"\",");
			  sb.append("\"chqStatTyp\":\""+prop.getProperty("chqStatTyp")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
		      return sb.toString();
	}
	
	public static String ChequeStatus()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid018\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\",");
		    sb.append("\"acc\":\""+prop.getProperty("acc")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"ChqNo\":\""+prop.getProperty("ChqNo")+"\",");
			  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
			  sb.append("\"ePn\":\""+prop.getProperty("ePn")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
		      return sb.toString();
	}
	
	public static String FeedBack()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid027\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"rating\":\""+prop.getProperty("rating")+"\",");
			  sb.append("\"message\":\""+prop.getProperty("message")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
		      return sb.toString();
	}
	
	public static String FetchTransactionLimit()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid099\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"txnType\":\""+prop.getProperty("txnType")+"\",");
			  sb.append("\"grpFlg\":\""+prop.getProperty("grpFlg")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
		      return sb.toString();
	}
	
	public static String UpdateTransactionLimit()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid100\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"txnType\":\""+prop.getProperty("txnType")+"\",");
			  sb.append("\"grpFlg\":\""+prop.getProperty("grpFlg")+"\",");
			  sb.append("\"custMaxAmountPerTxn\":\""+prop.getProperty("custMaxAmountPerTxn")+"\",");
			  sb.append("\"custPerDayLimit\":\""+prop.getProperty("custPerDayLimit")+"\",");
			  sb.append("\"custPerWeekLimit\":\""+prop.getProperty("custPerWeekLimit")+"\",");
			  sb.append("\"custPerMonthLimit\":\""+prop.getProperty("custPerMonthLimit")+"\",");
			  sb.append("\"txnTypeDesc\":\""+prop.getProperty("txnTypeDesc")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
		      return sb.toString();
	}
	
	public static String ComplaintViewStatus()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid901\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"fromDate\":\""+prop.getProperty("fromDate")+"\",");
			  sb.append("\"toDate\":\""+prop.getProperty("toDate")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
		      return sb.toString();

	}
	
	public static String ComplaintFetchTransactionTypeandReason()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid902\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
		      return sb.toString();
	}
	
	
	public static String ComplaintFetchTransactionDetails()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid903\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"fromDate\":\""+prop.getProperty("fromDate")+"\",");
			  sb.append("\"toDate\":\""+prop.getProperty("toDate")+"\",");
			  sb.append("\"txnId\":\""+prop.getProperty("txnId")+"\",");
			  sb.append("\"txnType\":\""+prop.getProperty("txnType")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
		      return sb.toString();
	}
	
	public static String ComplaintFetchBBPSSubType()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid904\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
		      return sb.toString();
	}
	
	
	public static String RequestforChequeBook()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid906\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\",");
			  sb.append("\"ePn\":\""+prop.getProperty("ePn")+"\",");
			  sb.append("\"acc\":\""+prop.getProperty("accNo")+"\",");
			  sb.append("\"noOfLeaves\":\""+prop.getProperty("noOfLeaves")+"\",");
			  sb.append("\"name\":\""+prop.getProperty("name")+"\",");
			  sb.append("\"txnIdentifier\":\""+prop.getProperty("txnIdentifier")+"\",");
			  sb.append("\"eOtp\":\""+prop.getProperty("eOtp")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
		      return sb.toString();
	}
	
	public static String LocatorFetchATMBranchListbasedonNearBy()
	{

		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid025\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"tpy\":\""+prop.getProperty("tpy")+"\",");
			  sb.append("\"fromLat\":\""+prop.getProperty("fromLat")+"\",");
			  sb.append("\"fromLon\":\""+prop.getProperty("fromLon")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
		      return sb.toString();
	}
	
	public static String LocatorFetchATMBranchListbasedonsearch()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid025\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"search\":\""+prop.getProperty("search")+"\",");
			  sb.append("\"tpy\":\""+prop.getProperty("tpy")+"\",");
			  sb.append("\"fromLat\":\""+prop.getProperty("fromLat")+"\",");
			  sb.append("\"fromLon\":\""+prop.getProperty("fromLon")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
		      return sb.toString();
	}
	
	
	public static String LocatorFetchATMBranchListbasedonStateCity()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid025\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"search\":\""+prop.getProperty("state")+"\",");
			  sb.append("\"tpy\":\""+prop.getProperty("tpy")+"\",");
			  sb.append("\"fromLat\":"+prop.getProperty("fromLat")+",");
			  sb.append("\"fromLon\":"+prop.getProperty("fromLon")+"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
		      
		      return sb.toString();
	}
	
	public static String LocatorFetchCityList()
	{

		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid122\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"stateId\":\""+prop.getProperty("stateId")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
		      return sb.toString();
	}
	
	public static String LocatorFetchStateList()
	{

		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid124\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
		      return sb.toString();
	}
	
	public static String ComplaintRegistration()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid905\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\"");
		    sb.append("},");
			  sb.append("\"body\":{");
			  sb.append("\"tranType\":\""+prop.getProperty("tranType")+"\",");
			  sb.append("\"subTranType\":\""+prop.getProperty("subTranType")+"\",");
			  sb.append("\"txnId\":\""+prop.getProperty("txnId")+"\",");
			  sb.append("\"amount\":\""+prop.getProperty("amount")+"\",");
			  sb.append("\"reason\":\""+prop.getProperty("reason")+"\",");
			  sb.append("\"description\":\""+prop.getProperty("description")+"\",");
			  sb.append("\"reOpenFlag\":\""+prop.getProperty("reOpenFlag")+"\",");
			  sb.append("\"reOpenReferenceId\":\""+prop.getProperty("reOpenReferenceId")+"\",");
			  sb.append("\"bpTxnId\":\""+prop.getProperty("bpTxnId")+"\",");
			  sb.append("\"bpReferenceId\":\""+prop.getProperty("bpReferenceId")+"\",");
			  sb.append("\"bpTxnDate\":\""+prop.getProperty("bpTxnDate")+"\",");
			  sb.append("\"bpAgentId\":\""+prop.getProperty("bpAgentId")+"\",");
			  sb.append("\"bpSubType\":\""+prop.getProperty("bpSubType")+"\",");
			  sb.append("\"bpRemarks\":\""+prop.getProperty("bpRemarks")+"\"");
			  sb.append("},");
			  sb.append("\"footer\":{}");
		      sb.append("}");
		      return sb.toString();
	}
	
	public static String Balance()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("{");
		  sb.append("\"header\":{");
		  sb.append("\"mobNo\":\""+prop.getProperty("mobNo")+"\",");
		    sb.append("\"mType\":\""+prop.getProperty("mType")+"\",");
		    sb.append("\"tType\":\"mid011\",");
		    sb.append("\"bVer\":\""+prop.getProperty("bVer")+"\",");
		    sb.append("\"acc\":\""+prop.getProperty("acc")+"\"");
		  sb.append("},");
		  sb.append("\"body\":{");
		  sb.append("\"pChk\":\""+prop.getProperty("pChk")+"\"");
		  sb.append("},");
		  sb.append("\"footer\":{}");
			sb.append("}");
			return sb.toString();
	}
}

