package gpa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumPuro {
    String url;
    WebDriver driver;

    //Métodos e funções
    @Before
    public void iniciar()
    {
        url = "https://www.submarino.com.br/";
        System.setProperty("webdriver.chrome.driver", "drivers/Chrome/chromedriver.exe");

        driver = new ChromeDriver();
    }

    @After
    public void finalizar()
    {
        driver.quit();
    }

    @Test
    public void consultaProduto()
    {
        driver.get(url);

        driver.findElement(By.id("h_search-input")).sendKeys("Geladeira" + Keys.ENTER);

        Assert.assertEquals("Geladeira",driver.findElement(By.cssSelector("h1.full-grid__Title-fvrmdp-0.kWHUur")).getText());
    }
}
