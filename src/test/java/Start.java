import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Start
{
    WebDriver wd;

    @Test
    public void myTest()
    {
        //open browser
        wd = new ChromeDriver();
        wd.get("https://telranedu.web.app/"); //bez sohraneniya istorii

//        wd.navigate().to("https://telranedu.web.app/"); //s sohraneniem
//        wd.navigate().back();
//        wd.navigate().forward();
//        wd.navigate().refresh();

       // wd.close(); // tol'ko esli otkruta 1 vkladka
        wd.quit(); // neskol'ko vkladok
    }

    @Test
    public void secondTest()
    {

    }


}
