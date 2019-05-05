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
import org.testng.annotations.DataProvider;
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

public class dataprovider1 {
	WebDriver driver;
  @Test(dataProvider = "getdata")
  public void f(String username, String password) 
  {
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  System.out.println("Login");
	  driver.findElement(By.linkText("SIGN-OFF")).click();
	  System.out.println("Logout");
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  Set<Cookie> Cookies = driver.manage().getCookies();
	  for(Cookie Cookie:Cookies)
	 System.out.println("The name of cookie is:"+ Cookie.getName());
  }

  @AfterMethod
  public void afterMethod() throws IOException 
  {
	  File Src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyToDirectory(Src, new File("C:\\Users\\ab\\Desktop\\Screenshot\\datapro"));
	  
  }


  @DataProvider
  public Object[][] getdata() {
    return new Object[][] {
      new Object[] { "Suvidyap1", "P@ssword1" },
      new Object[] { "Suvidyap2", "P@ssword2" },
      new Object[] { "Suvidyap3", "P@ssword3" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() 
  {
	  driver.manage().deleteAllCookies();
	  System.out.println("Delete");
  }

  @BeforeTest
  public void beforeTest()
  {
	  driver.get("http://newtours.demoaut.com/mercurywelcome.php");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Close DB Connection");
  }

  @BeforeSuite
  public void beforeSuite() 
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ab\\Desktop\\Testing\\chromedriver.exe");
	  driver= new ChromeDriver();
  }

  @AfterSuite
  public void afterSuite() {
	  driver.close();
  }

}
