import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class AuthorTest {

    private static final String URL = "https://www.n11.com/";
    String fBMail = "testforneleven@gmail.com";
    String fBPass = "test11223344";

    FirefoxDriver driver = new FirefoxDriver();

    @Test
    public void shouldListAuthors() throws InterruptedException {
        driver.navigate().to(URL);
        driver.findElement(By.xpath("//a[@class='btnSignIn']")).click();

        driver.findElement(By.xpath("//form[@id='loginForm']/div[4]")).click();
        Thread.sleep(5000);

        String mainWindow = driver.getWindowHandle();
        Set<String> PopUpHandle = driver.getWindowHandles();
        Iterator<String> itr = PopUpHandle.iterator();
        String fBLoginWindow = "";

        while (itr.hasNext()) {
            if (itr.next() != mainWindow) {
                fBLoginWindow = itr.next().toString();
            }
        }

        driver.switchTo().window(fBLoginWindow);

        /*Facebook Login*/

        WebElement fBMailElement = driver.findElement(By.id("email"));
        WebElement fBPassElement = driver.findElement(By.id("pass"));
        WebElement fBLoginElement = driver.findElement(By.id("u_0_2"));

        fBMailElement.clear();
        fBMailElement.sendKeys(fBMail);

        fBPassElement.clear();
        fBPassElement.sendKeys(fBPass);

        fBLoginElement.click();

        driver.switchTo().window(mainWindow);

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='contentMain']/div/nav/ul/li[8]/h2/a")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//*[@id='contentCategory']/div/div[2]/div[1]/ul/li[1]/a")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//*[@id='contentListing']/div/div/div[2]/section[3]/h2/a")).click();

        for (int i = 2; i < 33; i++) {
            WebElement letter = driver.findElement(By.xpath("//span[contains(@class, 'alphabetSearch')][" + i + "]"));
            char firstLetter = letter.getText().toLowerCase().charAt(0);
            letter.click();

            List<WebElement> authorsList = driver.findElements(By.xpath(".//*[@id='authorsList']/div//li/a"));

            assertTrue(authorsList.size() <= 80);

            for (int j = 0; j < authorsList.size(); j++) {
                assertEquals(firstLetter, authorsList.get(j).getText().toLowerCase().charAt(0));
            }

            String lastName = authorsList.get(authorsList.size() - 1).getText();

            boolean paging = false;
            try {
                WebElement linkSecondPage = driver.findElement(By.xpath(".//*[@id='content']/div[4]/a[2]"));
                linkSecondPage.click();
                paging = true;

            } catch (TimeoutException e) {
                System.err.print(e.getMessage());
            }

            if (paging) {
                authorsList = driver.findElements(By.xpath(".//*[@id='authorsList']/div//li/a"));
                for (int j = 0; j < authorsList.size(); j++) {
                    assertNotEquals(lastName, authorsList.get(j).getText());
                }
            }
        }
    }
}
