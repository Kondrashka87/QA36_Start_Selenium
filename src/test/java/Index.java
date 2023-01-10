import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Index
{
    WebDriver wd;

    @BeforeMethod
    public void start()
    {
        wd = new ChromeDriver();
        wd.get("file:///C:/Users/size7/Downloads/index.html");
        wd.manage().window().maximize();
    }

    @Test
    public void tableTest()
    {
        //proverit' pravda li v tablize 4 stroki
        List<WebElement> rows = wd.findElements(By.cssSelector("tr"));
        Assert.assertEquals(rows.size(), 4);

        //pravda li chto poslednyaya stroka soderzit Mexico
        WebElement lastRow = wd.findElement(By.cssSelector("tr:last-child"));
        String text = lastRow.getText();
        System.out.println(text);
        //Poland Chine Mexico
        Assert.assertTrue(text.contains("Mexico"));

        //pravda li chto poslednyaya yache'ka soderzit Mexico
        WebElement lastCell = wd.findElement(By.cssSelector("tr:last-child td:last-child"));
        String str = lastCell.getText();
        boolean res = str.contains("Mexico");
        Assert.assertTrue(str.contains("Mexico"));
        Assert.assertTrue(res);
    }

    @Test
    public void itemsTests()
    {
        // find Item1 & click() ===> assert that "div-alert" contains message  "Clicked by Item 1"
        WebElement item1 = wd.findElement(By.cssSelector("li:first-child"));
        item1.click();
        WebElement alert = wd.findElement(By.cssSelector("#alert"));
        String str = alert.getText();
        System.out.println("Text of alert is --->" + alert);
        Assert.assertTrue(str.contains("Clicked by Item 1"));

        // find Item3 & click() ===> assert that "div-alert" contains message  "Clicked by Item 3"
        List <WebElement> items = wd.findElements(By.cssSelector("li"));
        WebElement item3 = items.get(2);
        item3.click();
        WebElement alert3 = wd.findElement(By.cssSelector("#alert"));
        String str3 = alert.getText();
        Assert.assertTrue(str3.contains("Clicked by Item 3"));
    }

    @Test
    public void formTests()
    {
        // fill name & fill surename & click send
        WebElement name = wd.findElement(By.cssSelector("input:first-child"));
        name.click();
        name.clear();
        name.sendKeys("Anna123#");

        WebElement surename = wd.findElement(By.cssSelector("input:last-of-type"));
        surename.click();
        surename.clear();
        surename.sendKeys("Kondrateva");

        List <WebElement> buttons = wd.findElements(By.tagName("button"));
        WebElement send = buttons.get(0);
        send.click();

        // Assert that "div-alert" contains text with name + surename
        WebElement alertname = wd.findElement(By.cssSelector("#alert"));
        String strName = alertname.getText();
        Assert.assertTrue(strName.contains("Anna123# Kondrateva"));
    }

}
