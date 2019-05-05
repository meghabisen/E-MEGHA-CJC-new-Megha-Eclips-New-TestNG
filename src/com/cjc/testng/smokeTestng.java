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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class smokeTestng {
 WebDriver driver;
 @Parameters({"unm1" ,"psd1"})
  @Test(groups= {"smoke"})
  public void user1(String uname1, String pass1) {
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(uname1);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass1);
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	 System.out.println("Login SuccessFully");
	  driver.findElement(By.linkText("SIGN-OFF")).click();
	  System.out.println("Logout1 SuccessFully");

  }
 @Parameters({"unm2" ,"psd2"})
 @Test
 public void user2 (String uname2, String pass2) {
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(uname2);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass2);
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	 System.out.println("Login SuccessFully");
	  driver.findElement(By.linkText("SIGN-OFF")).click();
	  System.out.println("Logout1 SuccessFully");

 }
 @Parameters ({"unm3" ,"psd3"})
 @Test (groups={"smoke"})
 public void user3(String uname3, String pass3) {
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(uname3);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass3);
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	 System.out.println("Login SuccessFully");
	  driver.findElement(By.linkText("SIGN-OFF")).click();
	  System.out.println("Logout3 SuccessFully");

 }
  @BeforeMethod (groups= {"smoke"})
  public void cookiename() 
  {
	  Set<Cookie> Cookies =driver.manage().getCookies();
	  for(Cookie Cookie:Cookies)
	  {
		  System.out.println("The name of Cookie is:"+Cookie.getName());
	  }
  }

  @AfterMethod
  public void screenshot() throws IOException 
  {
	 File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 FileUtils.copyToDirectory(src, new File ("C:\\Users\\ab\\Desktop\\Screenshot\\smoke.jpeg"));
	 System.out.println("Capture Screen Shot");
	  
  }

  @BeforeClass (groups= {"smoke"})
  public void maximize() {
	  driver.manage().window().maximize();
	  System.out.println("Maximize the Browser");
  }

  @AfterClass (groups= {"smoke"})
  public void deletecookies() 
  {
	  driver.manage().deleteAllCookies();
	  System.out.println("Cookies are deleted");
  }
   @Parameters  ({"url"})
  @BeforeTest (groups= {"smoke"})
  public void urlopen(String url1) {
	  driver.get(url1);
  }

  @AfterTest (groups={"smoke"})
  public void dbconnectionclose() 
  {
	  System.out.println("Close the db Connection");
  }
  @BeforeSuite (groups= {"smoke"})
  public void openbrowser() 
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ab\\Desktop\\Testing\\chromedriver.exe");
	  driver= new ChromeDriver();
	  System.out.println("Browser open ");
  }

  @AfterSuite (groups= {"smoke"})
  public void browserclose() {
	  driver.close();
	  System.out.println("close the mercury site");
  }

}
