package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void writeEmail() {
        writeText(By.id("email_create"), "bitaksi@test4643829test.com");
    }

    public void clickCreateAccount() {
        click(By.id("SubmitCreate"));
    }

    //Temporary
    public void signIn() {
        writeText(By.id("email"), "test@testtest.com");
        writeText(By.id("passwd"), "123456");
        click(By.id("SubmitLogin"));
    }
}
