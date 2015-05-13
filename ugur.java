package denemeler;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class ugurson {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.n11.com/");
		selenium.start();
	}

	@Test
	public void testUgurson() throws Exception {
		selenium.open("/");
		selenium.click("css=img[alt=\"AlÄ±ÅŸveriÅŸin UÄŸurlu Adresi\"]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=GiriÅŸ Yap");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=email", "ugur.yenigul@gmail.com");
		selenium.type("id=password", "357ksd");
		selenium.click("id=loginButton");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Kitap");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Yazarlar");
		selenium.waitForPageToLoad("30000");
		selenium.open("/yazarlar/A");
		selenium.open("/yazarlar/B");
		selenium.open("/yazarlar/C");
		selenium.open("/yazarlar/Ã‡");
		selenium.open("/yazarlar/D");
		selenium.open("/yazarlar/E");
		selenium.open("/yazarlar/F");
		selenium.open("/yazarlar/G");
		selenium.open("/yazarlar/H");
		selenium.open("/yazarlar/I");
		selenium.open("/yazarlar/Ä°");
		selenium.open("/yazarlar/J");
		selenium.open("/yazarlar/K");
		selenium.open("/yazarlar/L");
		selenium.open("/yazarlar/M");
		selenium.open("/yazarlar/N");
		selenium.open("/yazarlar/O");
		selenium.open("/yazarlar/Ö");
		selenium.open("/yazarlar/P");
		selenium.open("/yazarlar/Q");
		selenium.open("/yazarlar/R");
		selenium.open("/yazarlar/S");
		selenium.open("/yazarlar/Ş");
		selenium.open("/yazarlar/T");
		selenium.open("/yazarlar/U");
		selenium.open("/yazarlar/Ü");
		selenium.open("/yazarlar/V");
		selenium.open("/yazarlar/Y");
		selenium.open("/yazarlar/Z");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
