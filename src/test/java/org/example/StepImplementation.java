package org.example;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation {


    @Step("Go to Dillard's Login Page")
    public void gotoLoginPage() throws InterruptedException {
        WebElement loginButton = Driver.webDriver.findElement(By.xpath("//a[text()='Login']"));
        loginButton.click();

        Gauge.writeMessage("Page title is %s", Driver.webDriver.getTitle());
    }

    @Step("Ensure Login Page is displayed")
    public void ensureLoginPageIsDisplayed() throws InterruptedException {
        WebElement loginPageTitle = Driver.webDriver.findElement(By.xpath("//h1[text()='Login']"));

        String text=loginPageTitle.getText();

        assertThat(text.equalsIgnoreCase("Login"));
    }

    @Step("Open the Dillard's homepage")
    public void implementation1() {
        String app_url = System.getenv("APP_URL");
        Driver.webDriver.get(app_url + "/");
        assertThat(Driver.webDriver.getTitle()).startsWith("Dillard's");
    }
}
