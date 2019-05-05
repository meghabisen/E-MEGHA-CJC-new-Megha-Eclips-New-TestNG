package com.cjc.testng;

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
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Hardassert 
{
	public WebDriver driver;
  @Test
  public void login1() 
  {
	  String act_title1 =driver.getTitle();
	  String exp_title2 ="Welcome: Mercury Tours";
	  Assert.assertEquals(act_title1, exp_title2);
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Suvidyap1");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword1");
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  System.out.println("Login Successfully");
	  //boolean act_flag =driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']"));
  }
  @BeforeMethod
  public void cookieDomain() 
  {
	  Set<Cookie>Cookies=driver.manage().getCookies();
	  for(Cookie Cookie:Cookies)
	  {
		  System.out.println("The name of cookie is :"+Cookie.getDomain());
	  }
	  
  }

  @AfterMethod
  public void afterMethod() throws IOException 
  {
	 File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 FileUtils.copyToDirectory(src, new File ("C:\\Users\\ab\\Desktop\\Screenshot"));
	 System.out.println("Capture screen Shot");
  }

  @BeforeClass
  public void maximize() {
	  driver.manage().window().maximize();
	  System.out.println("Maximize the browser");
  }

  @AfterClass
  public void afterClass() 
  {
	  driver.manage().deleteAllCookies();
	  System.out.println("Delete the cookies");
  }

  @BeforeTest
  public void url() 
  {
	  driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	  System.out.println("Site is open");
  }

  @AfterTest
  public void afterTest() 
  {
	  System.out.println("Close db connection");
  }

  @BeforeSuite
  public void openbrowser() 
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ab\\Desktop\\Testing\\chromedriver.exe");
       driver=new ChromeDriver();
	  System.out.println("Browser open");
  }

  @AfterSuite
  public void afterSuite() 
  {
	  driver.close();
  }

}
