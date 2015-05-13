package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class ugur {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.n11.com/");
		selenium.start();
	}

	@Test
	public void testUgur() throws Exception {
		selenium.open("/");
		selenium.click("css=img[alt=\"Alışverişin Uğurlu Adresi\"]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Giriş Yap");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=email", "ugur.yenigul@gmail.com");
		selenium.type("id=password", "357ksd");
		selenium.click("id=loginButton");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Kitap");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Yazarlar");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
