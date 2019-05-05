package com.cjc.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class parameter {
	WebDriver driver;
	@Parameters({"ID" ,"PSWD"})
  @Test
  public void logindetails1(String username1, String password1) 
  {
		System.out.println("enter in login page");
	  driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username1);
	  driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(password1);
	  driver.findElement(By.xpath("//input[@value='Log In']")).click();
	  System.out.println("Login Successfully");
  
	
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("Cookies");
	  Set<Cookie> Cookies= driver.manage().getCookies();
	/*  for(Cookie Cookie:Cookies)
	  {
		  System.out.println("The Name of cookie is :"+Cookie.getName());
	  }*/
	  System.out.println("cookies are get");
  }

  @AfterMethod
  public void afterMethod() throws IOException 
  {
	File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyToDirectory(src, new File("C:\\Users\\ab\\Desktop\\Screenshot\\Paramerter"));
	System.out.println("Screen Shot is capture");
  }

  @BeforeClass
  public void beforeClass() 
  {
	  System.out.println("Maximize The Browser");
	  driver.manage().window().maximize();
	  
  }

  @AfterClass
  public void afterClass()
  {
	  driver.manage().deleteAllCookies();
	  System.out.println("Cookies Deleted");
  }
@Parameters({"Url"})
  @BeforeTest
  public void Url(String Urlnm) 
  {
	  driver.get(Urlnm);
	  System.out.println("Site is open");
  }

  @AfterTest
  public void afterTest() 
  {
	  System.out.println("Close db connection");
  }
@Parameters({"Browser"})
  @BeforeSuite
  public void openbrwser(String browsernm) 
  {
	  if (browsernm.equals("chrome"))
	  {
		  System.out.println("Chrome Browser ");
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ab\\Desktop\\Testing\\chromedriver.exe");
		  driver = new ChromeDriver();
		  System.out.println("Chrome Browser open Successfully");
	  }
	  else if (browsernm.equals("ie"))
	  {
		  System.out.println("ie");
		  System.setProperty("webdriver.internetexplorer.driver", "C:\\Users\\ab\\Desktop\\Testing\\IEDriverServer.exe");
		  driver = new InternetExplorerDriver();
	  }
	  else
	  {
		  System.out.println("Moxila");
		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\ab\\Desktop\\Testing\\geckodriver.exe");
		  driver= new FirefoxDriver();
	  }
  }

  @AfterSuite
  public void afterSuite() {
	  driver.close();
	  System.out.println("Close the browser");
  }

}
