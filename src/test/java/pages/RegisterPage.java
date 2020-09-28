package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void fillForm() {
        click(By.id("uniform-id_gender2"));
        writeText(By.id("customer_firstname"), "axxx");
        writeText(By.id("customer_lastname"), "axxdfffx");
        writeText(By.id("passwd"), "11111");
        selectDropdownOption(By.id("days"), 5);
        selectDropdownOption(By.id("months"), 4);
        selectDropdownOption(By.id("years"), 10);
        writeText(By.id("address1"), "test");
        writeText(By.id("city"), "İzmir");
        selectDropdownOption(By.id("id_state"), 7);
        writeText(By.id("postcode"), "34000");
        selectDropdownOption(By.id("id_country"), 1);
        writeText(By.id("phone_mobile"), "6885");
    }

    public void clickRegister() {
        click(By.id("submitAccount"));
    }
}
