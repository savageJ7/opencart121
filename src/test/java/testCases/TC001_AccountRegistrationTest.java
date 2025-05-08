package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("***Starting TC001_AccountRegistrationTest***");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("***Clicked on MyAccount link***");
		hp.clickRegister();
		logger.info("***Clicked on Register link***");
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("***Providing Details***");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName("David");//(radndomString());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone("234568971");
		
		// String password = randomAlphanumeric();
		  String password =randomeAplhaNumeric() ;
		regpage.setPassword("password");
		regpage.setConfirmPassword("password");
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("***validating expected message***");
		String confmsg = regpage.getConfirmationMsg();
		
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		}
		
		catch (Exception e)
		{
			logger.error("test failed...");
			logger.debug("Debug Logs");
			Assert.fail();
		}
		logger.info("***finished***");
	}
	
	  
	}

