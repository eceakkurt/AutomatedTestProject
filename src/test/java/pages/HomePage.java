package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    private final String url = "http://automationpractice.com/";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToUrl() {
        driver.get(url);
    }

    public void clickSignIn() {
        click(By.className("login"));
    }

    public void checkAccount() {
        assertEquals(By.className("page-heading"), "MY ACCOUNT");
    }

    public void clickSummerDresses() {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.className("sf-menu"));
        List<WebElement> element_list = element.findElements(By.tagName("li"));
        for (WebElement web_element : element_list) {
            if (web_element.getText().equals("DRESSES")) {
                action.moveToElement(web_element).perform();
                WebElement inner_container = web_element.findElement(By.tagName("ul"));
                List<WebElement> inner_elements = inner_container.findElements(By.tagName("li"));
                WebElement target = inner_elements.get(2);
                target.click();
                return;
            }
        }
    }

    public void addToCartDress(int product_index, int scroll_size) {
        scrollPage(scroll_size);
        WebElement row = driver.findElement(By.id("columns"));
        WebElement center_column = row.findElement(By.id("center_column"));
        List<WebElement> center_children = center_column.findElements(By.tagName("ul"));
        for (WebElement item : center_children) {
            if (item.getAttribute("class").equals("product_list grid row")) {
                List<WebElement> element_list = new ArrayList<WebElement>();
                for (WebElement temp : item.findElements(By.tagName("li"))) {
                    if (!temp.getAttribute("class").equals("")) {
                        element_list.add(temp);
                    }
                }
                WebElement liItem = element_list.get(product_index);
                new Actions(driver).moveToElement(liItem).perform();
                WebElement button = liItem.findElement(By.className("product-container"))
                        .findElement(By.className("right-block"))
                        .findElement(By.className("button-container"))
                        .findElement(By.className("ajax_add_to_cart_button"));
                button.click();
                return;
            }
        }
    }

    public void clickContinueShopping() {
        click(By.className("icon-chevron-left"));
    }

    public void searchText() {
        writeText(By.id("search_query_top"), "Summer");
        click(By.name("submit_search"));
    }

    public void goCart() {
        Actions action = new Actions(driver);
        WebElement cart = driver.findElement(By.className("shopping_cart"));
        WebElement a = cart.findElement(By.tagName("a"));
        if (a.getAttribute("title").equals("View my shopping cart")) {
            action.moveToElement(a).perform();
            click(By.id("button_order_cart"));
        }
    }
}
