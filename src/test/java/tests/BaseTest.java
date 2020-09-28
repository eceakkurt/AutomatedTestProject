package tests;

import config.Settings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class BaseTest {
    public WebDriver driver;
    public HomePage homePage;
    public LoginPage loginPage;
    public RegisterPage registerPage;
    public CartPage cartPage;

    public void setup() {
        if (Settings.BROWSER_TYPE == Settings.BROWSER_CHROME) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        initializePages();
    }

    public void initializePages() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        cartPage = new CartPage(driver);
    }

    public void teardown() {
        driver.quit();
    }
}
