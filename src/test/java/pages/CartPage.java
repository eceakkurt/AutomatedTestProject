package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void checkProduct() {
        WebElement cart_summary = driver.findElement(By.id("cart_summary"));
        WebElement t_body = cart_summary.findElement(By.tagName("tbody"));

        WebElement first_item = t_body.findElement(By.className("first_item"));
        WebElement last_item = t_body.findElement(By.className("last_item"));

        checkSingleProduct(first_item, "Printed Summer Dress", "$28.98");
        checkSingleProduct(last_item, "Printed Chiffon Dress", "$16.40");

        click(By.className("standard-checkout"));
    }

    private void checkSingleProduct(WebElement product, String name, String total) {
        WebElement cart_description = product.findElement(By.className("cart_description"));
        WebElement cart_total = product.findElement(By.className("cart_total"));

        WebElement product_name = cart_description.findElement(By.className("product-name"));
        String name_value = product_name.findElement(By.tagName("a")).getText();
        System.out.println("Actual Value: " + name_value + ", Expected Value: " + name);
        Assert.assertEquals(name, name_value);

        String price_value = cart_total.findElement(By.className("price")).getText();
        System.out.println("Actual Price: " + price_value + ", Expected Price: " + total);
        Assert.assertEquals(total, price_value);
    }

    public void address() {
        click(By.name("processAddress"));
    }

    public void shipping() {
        click(By.id("uniform-cgv"));
        click(By.name("processCarrier"));
    }

    public void payment() {
        WebElement payment = driver.findElement(By.id("HOOK_PAYMENT"));
        List<WebElement> payment_list = payment.findElements(By.tagName("div"));
        payment_list.get(0).findElement(By.className("payment_module")).click();

        WebElement cart_navigation = driver.findElement(By.id("cart_navigation"));
        cart_navigation.findElement(By.className("button-medium")).click();
    }

    public void order() {
        WebElement box = driver.findElement(By.className("box"));
        String box_text = box.getText();
        clickUserInfo();
        orderHistoryDetails();
        String orderReference = getReference();
        Assert.assertTrue(box_text.contains(orderReference));
    }

    private void clickUserInfo() {
        WebElement header_user_info = driver.findElement(By.className("header_user_info"));
        header_user_info.findElement(By.className("account")).click();
    }

    public void orderHistoryDetails() {
        WebElement my_account_list = driver.findElement(By.className("myaccount-link-list"));
        List<WebElement> list = my_account_list.findElements(By.tagName("li"));
        list.get(0).click();
    }

    private String getReference() {
        WebElement order = driver.findElement(By.id("order-list"));
        WebElement tbody = order.findElement(By.tagName("tbody"));
        WebElement first_item = tbody.findElement(By.className("first_item"));
        WebElement history_link = first_item.findElement(By.className("history_link"));
        WebElement a = history_link.findElement(By.tagName("a"));
        return a.getText();
    }
}
