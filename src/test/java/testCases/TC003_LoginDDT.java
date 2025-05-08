package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountpage;
import utilities.DataProviders;
 

public class TC003_LoginDDT extends BaseClass {

	
	
    @Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)//getting dataprovider from different class
	public void verify_loginDDT(String email,String pwd,String exp) 
	{
		logger.info("***Starting TC003_LoginDDT***");
	try {
	// home page
	HomePage hp = new HomePage(driver);
	hp.clickMyAccount();
	hp.clickLogin(); 
	
	
	//login page
    LoginPage lp = new LoginPage(driver);
	lp.setEmail(email);
	//lp.setEmail(p.getProperty("email"));
	lp.setPassword(pwd);
	lp.clickLogin();  
	
	//my account page
	MyAccountpage macc = new MyAccountpage(driver);
	boolean targetPage =macc.isMyAccountPageExists();
	
	if(exp.equalsIgnoreCase("Valid"))
	{
		if(targetPage==true)
		{
			macc.clickLogout();
			Assert.assertTrue(true);
			
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
	if(exp.equalsIgnoreCase("Invalid"))
	{
		if(targetPage==true)
		{
			macc.clickLogout();
			Assert.assertTrue(false);
			
		}
		else
		{
			Assert.assertTrue(true);
		}
	}
	}
	
	catch(Exception e)
	{
		Assert.fail();
	}
	logger.info("***Finished TC003_LoginDDT***"); 
}

}
