package siteIterasys;

import apoio.Apoio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import template.AmbientesParametros;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Busca {
    String url;
    WebDriver driver;

    @Before
    public void iniciar()
    {
        new AmbientesParametros();

        System.out.println("BuscaCurso.java");
        url = "https://pt.wikipedia.org";
        System.setProperty("webdriver.chrome.driver","drivers/Chrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void finalizar(){
        driver.quit();
    }

    @Test
    public void buscar() throws IOException {
        driver.get(url);
        driver.findElement(By.id("searchInput")).sendKeys("teste de software");
        Apoio.print(driver,"Pesquisa");
        driver.findElement(By.id("searchInput")).sendKeys(Keys.ENTER);
        driver.findElement(By.linkText("Teste de software")).click();
        Apoio.print(driver,"ResultadoPesquisa");

        assertEquals("Teste de software",driver.findElement(By.id("firstHeading")).getText());
    }
}
