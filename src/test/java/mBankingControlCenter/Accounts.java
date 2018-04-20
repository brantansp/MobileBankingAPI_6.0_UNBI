package mBankingControlCenter;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import mBankingPageObjectModel.StaticStore;
import mBankingUtilityCenter.ExtentManager;
import mBankingUtilityCenter.HttpConnect;

public class Accounts extends ExtentManager{
	private static String response;
	private static int index;
	public static String request;
	static HttpConnect obj=new HttpConnect();

	public static ExtentReports extent;
	public static ExtentTest extentLogger;
	
	
	@Test
	public static void MyAccountCumulativeofBalance() throws IOException, SQLException {
		request = StaticStore.MyAccountCumulativeofBalance();
		response =sendReq(request, "MyAccountCumulativeofBalance",resourceprop.getProperty("MyAccountCumulativeofBalance"));
		assertResponse(response);
	}
	
	@Test
	public static void Balance() throws IOException, SQLException {
		request = StaticStore.Balance();
		response =sendReq(request, "Balance",resourceprop.getProperty("MyAccountCumulativeofBalance"));
		assertResponse(response);
	}
	
	@Test
	public static void MyAccountBalanceagainsteachaccountbasedonmobilenumber() throws IOException, SQLException {
		request = StaticStore.MyAccountBalanceagainsteachaccountbasedonmobilenumber();
		response =sendReq(request, "MyAccountBalanceagainsteachaccountbasedonmobilenumber",resourceprop.getProperty("MyAccountBalanceagainsteachaccountbasedonmobilenumber"));
		assertResponse(response);
	}
	
	@Test
	public static void MiniStatement() throws IOException, SQLException {
		request = StaticStore.MiniStatement();
		response =sendReq(request, "MiniStatement",resourceprop.getProperty("MiniStatement"));
		assertResponse(response);
	}
	
	@Test
	public static void ValidateTransactionPassword() throws IOException, SQLException {
		request = StaticStore.ValidateTransactionPassword();
		response =sendReq(request, "ValidateTransactionPassword",resourceprop.getProperty("ValidateTransactionPassword"));
		assertResponse(response);
	}
	
	
	@Test
	public static void VerifyUser() throws IOException, SQLException {
		request = StaticStore.VerifyUser();
		response =sendReq(request, "VerifyUser",resourceprop.getProperty("VerifyUser"));
		assertResponse(response);
	}
	
	@Test
	public static void CheckTransactionStatus() throws IOException, SQLException {
		request = StaticStore.CheckTransactionStatus();
		response =sendReq(request, "CheckTransactionStatus",resourceprop.getProperty("CheckTransactionStatus"));
		assertResponse(response);
	}
	
	
	@Test
	public static void GenerateMMID() throws IOException, SQLException {
		request = StaticStore.GenerateMMID();
		response =sendReq(request, "GenerateMMID",resourceprop.getProperty("GenerateMMID"));
		assertResponse(response);
	}
	
	@Test
	public static void TermDepositAccountFetch() throws IOException, SQLException {
		request = StaticStore.TermDepositAccountFetch();
		response =sendReq(request, "TermDepositAccountFetch",resourceprop.getProperty("TermDepositAccountFetch"));
		assertResponse(response);
	}
	
	
	@Test
	public static void TermDepositAccountClosure() throws IOException, SQLException {
		request = StaticStore.TermDepositAccountClosure();
		response =sendReq(request, "TermDepositAccountClosure",resourceprop.getProperty("TermDepositAccountClosure"));
		assertResponse(response);
	}
	
	
	@Test
	public static void TermDepositAccountOpening() throws IOException, SQLException {
		request = StaticStore.TermDepositAccountOpening();
		response =sendReq(request, "TermDepositAccountOpening",resourceprop.getProperty("TermDepositAccountOpening"));
		assertResponse(response);
	}
	
	
	@Test
	public static void TermDepositInterestRate() throws IOException, SQLException {
		request = StaticStore.TermDepositInterestRate();
		response =sendReq(request, "TermDepositInterestRate",resourceprop.getProperty("TermDepositInterestRate"));
		assertResponse(response);
    }
	
	public static void main(String[] args) {
		request = StaticStore.Balance();
		try {
			response =sendReq(request, "Balance",resourceprop.getProperty("MyAccountCumulativeofBalance"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertResponse(response);
	}
}






















	
