package com.cjc.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNG1 {
	WebDriver driver;
  @Test(priority=2,description="1st user access the site")
  public void Loginwithvalidds() 
  {
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Suvidyap1");
	  driver.findElement(By.xpath("//input[@type='password']")).sendKeys("P@ssword1");
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	 
	  driver.findElement(By.linkText("SIGN-OFF")).click();
	  System.out.println("logout 1User");
  }
  @Test(priority=3,description="2nd user access the site")
  public void loginwith2user()
  {
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Suvidyap2");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword2");
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  driver.findElement(By.linkText("SIGN-OFF")).click();
	  System.out.println("Logout 2user");
  }
  @Test(priority=1,description="3rd user access the site")
  public void loginwith3user()
  {
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Suvidyap3");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword3");
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  driver.findElement(By.linkText("SIGN-OFF")).click();
	  System.out.println("Logout 3user");
  }
  
  @BeforeMethod
  public void cookiename() {
		Set<Cookie> Cookies=  driver.manage().getCookies();
		for(Cookie Cookie:Cookies)
		{
			System.out.println("The name of cookie is:"+Cookie.getName());
		}
		System.out.println("cookiename in Before name annotation");
  }

  @AfterMethod
  public void capturescreenshot() throws IOException 
  {
	  File Source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFileToDirectory(Source,new File("C:\\Users\\ab\\Desktop\\Screenshot\\Mercury"));
	  
  }

  @BeforeClass
  public void maximizebrowser() 
  {
	  driver.manage().window().maximize();
	  System.out.println("Maximize browser in beforeClass annotation");

  }

  @AfterClass
  public void deletecookies() 
  {
	  driver.manage().deleteAllCookies();
	  System.out.println("Delete all cookies in afterclass annotation");
  }

  @BeforeTest
  public void welcometomercuryURL() 
  {
	  System.out.println("enter url");
	  driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	  System.out.println("Url open in Beforetest annotation");
  }

  @AfterTest
  public void dbconnectionclose() 
  {
	  System.out.println("Close DB connection in After Test Annotation");
  }

  @BeforeSuite
  public void openbrowser() 
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ab\\Desktop\\Testing\\chromedriver.exe");
	  driver= new ChromeDriver();
	  System.out.println("OpenBrowser in beforesuite annotation");
  }

  @AfterSuite
  public void closeurl() 
  {
	  driver.close();
	  System.out.println("Close all Connections in AfterSuite annotation");
  }

}
