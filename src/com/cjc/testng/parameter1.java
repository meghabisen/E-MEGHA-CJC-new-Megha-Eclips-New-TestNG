package com.cjc.testng;

import org.testng.annotations.Test;

import net.bytebuddy.description.type.TypeDescription.Generic.OfTypeVariable.Symbolic;

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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class parameter1 {
	WebDriver driver;
	@Parameters({"unm1", "psd1"})
  @Test(description="1st user")
  public void user1(String uname1 , String pass1) 
  {
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(uname1);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass1);
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  //Boolean Flag= driver.findElement(By.xpath("//img[@src='/images/masts/mast_signon.gif']")).isDisplayed();
	 // driver.findElement(By.linkText("SIGN-ON")).click();
	  System.out.println("Login SuccessFully");
	  driver.findElement(By.linkText("SIGN-OFF")).click();
	  System.out.println("Logout1 SuccessFully");
	  
  }
	@Parameters({"unm2","psd2"})
	@Test(description="2nd user")
	public void user2(String uname2, String pass2)
	{
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(uname2);
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass2);
		  driver.findElement(By.xpath("//input[@name='login']")).click();
		  //Boolean Flag= driver.findElement(By.xpath("//img[@src='/images/masts/mast_signon.gif']")).isDisplayed();
		//  driver.findElement(By.linkText("SIGN-ON")).click();
		  System.out.println("Login SuccessFully");
		  driver.findElement(By.linkText("SIGN-OFF")).click();
		  System.out.println("Logout2 SuccessFully");
	}
	@Parameters({"unm3","psd3"})
	@Test (description="3rd user")
	public void user3(String uname3, String pass3)
	{
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(uname3);
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass3);
		  driver.findElement(By.xpath("//input[@name='login']")).click();
		  //Boolean Flag= driver.findElement(By.xpath("//img[@src='/images/masts/mast_signon.gif']")).isDisplayed();
		 // driver.findElement(By.linkText("SIGN-ON")).click();
		 System.out.println("Login SuccessFully");
		  driver.findElement(By.linkText("SIGN-OFF")).click();
		  System.out.println("Logout3 SuccessFully");
	}
	@Parameters({"unm4","psd4"})
	@Test(description="4th user")
	public void user4invalid(String uname4, String pass4)
	{
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(uname4);
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass4);
		  driver.findElement(By.xpath("//input[@name='login']")).click();
		  //Boolean Flag= driver.findElement(By.xpath("//img[@src='/images/masts/mast_signon.gif']")).isDisplayed();
		  //driver.findElement(By.linkText("SIGN-ON")).click();
		  System.out.println("Login SuccessFully");
		  driver.findElement(By.linkText("SIGN-OFF")).click();
		  System.out.println("Logout4 SuccessFully");
	}
	
  @BeforeMethod
  public void beforeMethod() 
  {
	  Set<Cookie> Cookies = driver.manage().getCookies();
	  for(Cookie Cookie:Cookies)
	  {
		  System.out.println("The name of cookie is:"+Cookie.getName());
	  }
  }

  @AfterMethod
  public void afterMethod() throws IOException {
	 File src=  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 FileUtils.copyToDirectory(src, new File ("C:\\Users\\ab\\Desktop\\Screenshot\\Paramerter"));
	 System.out.println("Screen Shot Capture");
	  
  }

  @BeforeClass
  public void beforeClass() 
  {
	  System.out.println("Maximize the browser");
	  driver.manage().window().maximize();
	  System.out.println("page is maximized");
  }

  @AfterClass
  public void afterClass() 
  {
	  driver.manage().deleteAllCookies();
	  System.out.println("Delete all cookies");
  }
   @Parameters({"url"})
  @BeforeTest
  public void beforeTest(String url) 
  {
	  System.out.println("For open Url");
	  driver.get(url);
  }

  @AfterTest
  public void afterTest() 
  {
	  System.out.println("db Connection Close");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Browser is up");
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ab\\Desktop\\Testing\\chromedriver.exe");
	  driver = new ChromeDriver();
	  System.out.println("Browser is open Sucessfully");
  }

  @AfterSuite
  public void afterSuite() {
	 driver.close();
	  System.out.println("Close the Browser");
  }

}
