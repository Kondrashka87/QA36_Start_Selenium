import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Login
{
    WebDriver wd;
    @BeforeMethod
   public void preCondition()//open site i browser
    {
    wd = new ChromeDriver();
    wd.get("https://telranedu.web.app/");
    }

    @Test
    public void findElementsOnPage()
    {
        //by tagName
        WebElement element = wd.findElement(By.tagName("div"));
        List <WebElement> divs = wd.findElements(By.tagName("div"));

        //by id
        WebElement element1 = wd.findElement(By.id("root"));

        //by class
        WebElement element2 = wd.findElement(By.className("container"));

        //by name
        wd.findElement(By.name("name"));

        //by link text a href
        wd.findElement(By.linkText("HOME"));
        wd.findElement(By.linkText("ABOUT"));
        wd.findElement(By.partialLinkText("HO"));

    }

    @Test
    public void loginSuccess()
    {
    //open form,
    // wd find item + click,

        WebElement itemLogin = wd.findElement(By.linkText("LOGIN"));
        itemLogin.click();

    // fill form
    // find email + click + clear + type

        WebElement email = wd.findElement(By.name("email"));
        email.click();
        email.clear();
        email.sendKeys("doshka@mail.ru");

    // find password + click + clear + type

        WebElement password = wd.findElement(By.name("password"));
        password.click();
        password.clear();
        password.sendKeys("Dosha1405!");

    // find button login + click
    // submit form

        List <WebElement> buttons = wd.findElements (By.tagName("button"));
        WebElement buttonLogin = buttons.get(0);
        buttonLogin.click();

        Assert.assertEquals("", "");
    }

    @Test
    public void registrationSuccess()
    {
        WebElement log = wd.findElement(By.linkText("LOGIN"));
        log.click();

        WebElement email = wd.findElement(By.name("email"));
        email.click();
        email.clear();
        email.sendKeys("Koshka1@mail.ru");

        WebElement password = wd.findElement(By.name("password"));
        password.clear();
        password.click();
        password.sendKeys("Kotic14025$");

        List <WebElement> buttons = wd.findElements(By.tagName("button"));
        WebElement buttonReg = buttons.get(1);
        buttonReg.click();
        wd.quit();
    }

   @AfterMethod
    public void postCondition()//close browser
    {
     // wd.quit();
    }


}
