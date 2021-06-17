package gpa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumPuro {
    String url;
    WebDriver driver;

    //Métodos e funções
    @Before
    public void iniciar()
    {
        url = "https://www.submarino.com.br/";
        System.setProperty("webdriver.chrome.driver", "drivers/Chrome/chromedriver.exe");

        //Janela anonima
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--incognito");

        driver = new ChromeDriver(co);
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
