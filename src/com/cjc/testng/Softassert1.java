package com.cjc.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Softassert1 {
	
	@Test (priority=1)
	
	public void Test1()
	{
		SoftAssert Softassert = new SoftAssert();
	Softassert.assertEquals(15, 5); 
	System.out.println("1");
	
	Softassert.assertEquals("a","b");
	System.out.println("2");
	
	Softassert.assertAll();
	}
	
	@Test(priority=2)
	public void Test2()
	{
		SoftAssert Softassert1= new SoftAssert();
		Softassert1.assertEquals("True", "True");
		System.out.println("3");
		
		Softassert1.assertEquals(50, 50);
		System.out.println("4");
		
		Softassert1.assertAll();
	}

}
