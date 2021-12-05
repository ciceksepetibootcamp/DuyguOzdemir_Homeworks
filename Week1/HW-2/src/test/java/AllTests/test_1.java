package AllTests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class test_1 extends test_CS_web {

    @Test
    public void TC1_Kuponlarım() {
        //-------------------------
        // ---------Login ---------
        //-------------------------
        //---Uye giriş üzerinden---
        driver.get("https://www.ciceksepeti.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='icon-close']")));
        driver.findElement(By.xpath("//span[@class='icon-close']")).click();

        WebElement elementToHover = driver.findElement(By.cssSelector("div[class='header__right-col'] ul[class='user-menu__items  ']>li:nth-of-type(2)"));
        Actions action = new Actions(driver);
        action.moveToElement(elementToHover).build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Üye Girişi')]")));
        driver.findElement(By.xpath("//span[contains(text(), 'Üye Girişi')]")).click();
        driver.findElement(By.id("EmailLogin")).sendKeys("testuserbootcamp@gmail.com");
        driver.findElement(By.id("Password")).sendKeys(" cs_123bcamp_123");
        driver.findElement(By.id("Password")).sendKeys(Keys.ENTER);

        //----Kuponlarım'a git---
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[class='user-menu__items  user-menu__items--login'] li:nth-of-type(2) a")));
        driver.findElement(By.cssSelector("ul[class='user-menu__items  user-menu__items--login'] li:nth-of-type(2) a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[class='account-menu'] li:nth-of-type(2)")));
        driver.findElement(By.cssSelector("ul[class='account-menu'] li:nth-of-type(2)")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4[class='account__section-title']")));
        String kuponHeader =driver.findElement(By.cssSelector("h4[class='account__section-title']")).getText();
        Assert.assertEquals(kuponHeader,"Kuponlarım");
    }
    @Test
    public void TC2_Bos_sifre(){
        //-------------------------
        // ---------Login ---------
        //-------------------------
        //---link üzerinden---
        driver.get("https://www.ciceksepeti.com/uye-girisi");
        driver.findElement(By.id("EmailLogin")).sendKeys("testuserbootcamp@gmail.com");
        driver.findElement(By.id("Password")).sendKeys(" ");
        driver.findElement(By.className("js-login-button")).click();

        //----Warning-doğrulama--
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Password-error")));
        String kuponHeader =driver.findElement(By.id("Password-error")).getText();
        Assert.assertEquals(kuponHeader,"Bu bilginin doldurulması zorunludur.");

    }


}
