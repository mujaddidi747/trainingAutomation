package seleniumTraining;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;


public class firstTest {
    public static WebDriver driver;

    @BeforeTest
    public static void beforeTest(){
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\Muhammad Absar\\Downloads\\chromedriver_win32\\chromedriver.exe");


        driver = new ChromeDriver(); // initialize driver
    }

    @Test
    public  static void firstTest() {

        driver.get("https://www.saucedemo.com/");

        driver.manage().window().maximize();

        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id=\"password\"]"))
                .sendKeys("secret_sauce");

        driver.findElement(By.name("login-button"))
                .click();

        String title = driver.getTitle();

        System.out.println(title + "          ");

        if (title == "KASPER") {
            System.out.println("title is wrong");
        } else {
            System.out.println("THE TITLE IS: " + driver.getTitle());
        }


        driver.findElement(By.id("add-to-cart-sauce-labs-backpack"))
                .click();

        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"))
                .click();
        driver.findElement(By.id("checkout")).click();

 /*  //  String text =   driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText();

    if (text.isEmpty()){

        System.out.println("error as the text is empty");
    }
*/

    }

@AfterTest
    public static void quit(){
   // driver.quit();
}


}
