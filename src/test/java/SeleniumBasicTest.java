package test.java;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URL;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumBasicTest {

    @Test
    @Ignore
    public void titleOfDuckDuckGoShouldContainSearchQueryName() throws IOException, InterruptedException {

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:9515"), DesiredCapabilities.chrome());

        synchronized (driver) {
            // synchronized driver is required when using explicit waits
            
            driver.get("https://duckduckgo.com");
            assertThat(driver.getTitle().startsWith("DuckDuckGo"));

            WebElement searchField = driver.findElement(By.id("search_form_input_homepage"));
            WebElement searchButton = driver.findElement(By.id("search_button_homepage"));

            searchField.sendKeys("Fluentlenium");
            searchButton.submit();

            driver.wait(1);
            assertThat(driver.getTitle().toLowerCase().startsWith("Fluentlenium"));
            driver.quit();
        }
    }
}