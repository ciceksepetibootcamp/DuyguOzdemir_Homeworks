package AllTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class test_2 extends test_CS_web {
    @Test
    public void TC3_yanlıs_sifre(){
        //-------------------------
        // ---------Login ---------
        //-------------------------
        //---link üzerinden---
        driver.get("https://www.ciceksepeti.com/uye-girisi");
        driver.findElement(By.id("EmailLogin")).sendKeys("testuserbootcamp@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("failed_pass");
        driver.findElement(By.className("js-login-button")).click();

        //----popup-doğrulama--
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-body")));
        String kuponHeader =driver.findElement(By.className("modal-body")).getText();
        Assert.assertEquals(kuponHeader,"Mail adresi veya şifre hatalı.Lütfen bilgilerinizi kontrol edip tekrar deneyin.");

    }
    @Test
    public void TC4_sifremi_unuttum () {

        //-------------------------
        // ---------Login ---------
        //-------------------------
        //---link üzerinden---
        driver.get("https://www.ciceksepeti.com/uye-girisi");
        driver.findElement(By.id("EmailLogin")).sendKeys("testuserbootcamp@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("failed_pass");
        driver.findElement(By.className("js-login-button")).click();

        //----popup-doğrulama--
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-body")));
        String kuponHeader =driver.findElement(By.className("modal-body")).getText();
        Assert.assertEquals(kuponHeader,"Mail adresi veya şifre hatalı.Lütfen bilgilerinizi kontrol edip tekrar deneyin.");

        driver.findElement(By.cssSelector("#modalBox > div > div > div.modal-footer > button")).click();
        driver.findElement(By.cssSelector("#userLogin > div.form-group.form-user-login__action > a")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Mail")));
        driver.findElement(By.id("Mail")).click();
    }
}
