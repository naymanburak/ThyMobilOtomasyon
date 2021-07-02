import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

/**
 * @author  Mustafa Burak Nayman
 * @version 1.0
 * @since   2021-07-02
 */

public class StepImplementation extends BaseTest {
    WebDriverWait wait = new WebDriverWait(appiumDriver, 60);


    @Step("<x> saniye beklenildi.")
    public void waitForSecond(int x) throws InterruptedException {
        Thread.sleep(1000 * x);
        System.out.println(x + "saniye beklenildi.");
    }

    @Step("<id> li elemente tikla")
    public void clickById(String id) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).click();
        System.out.println("Elemente tiklandi");
    }

    @Step("<id> li elemente <key> degerini gir")
    public void sendKeysById(String id, String key) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).sendKeys(key);
        System.out.println("Send Keys yazıldı.");
    }

    @Step("<xpath> xpath li elemente tikla")
    public void clickByXpath(String xpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
        System.out.println("Elemente tiklandi");
    }

    @Step("<check> Ucus listesini kontrol et")
    public void checkList(String check){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(check)));
        Assert.assertEquals("SORT AND FILTER", appiumDriver.findElementById(check).getText());
    }
}
