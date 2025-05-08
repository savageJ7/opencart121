package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountpage;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void verify_Login()
	{
		logger.info("***Starting TC002_LoginTest***");
		try {
		// home page
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
	//login page
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		
		//logout page
		
		MyAccountpage macc = new MyAccountpage(driver);
		//macc.clickLogout();
	
		//my account page
		//MyAccountpage macc = new MyAccountpage(driver);
		boolean targetPage =macc.isMyAccountPageExists();
		
		
		
		// Assert.assertEquals(targetPage,true,"Login failed");
		  Assert.assertTrue(targetPage);
		}
		
		catch (Exception e)
		{
			Assert.fail();
		}
		  logger.info("***Finished TC002_LoginTest***");
			
		
		
	}
	
	
	
	
	
	  
	}

