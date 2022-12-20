import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    public void loginSuccess()
    //open form,
    // find button + click,
    // find email + click + type
    // find password + click + type
    // find button login + click
    // fill form,
    // submit
    {
        Assert.assertEquals("", "");
    }
   @AfterMethod
    public void postCondition()//close browser
    {
    wd.quit();
    } 


}
