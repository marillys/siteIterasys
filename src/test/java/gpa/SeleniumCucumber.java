package gpa;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import page.HomePage;
import page.ListPage;

import java.util.concurrent.TimeUnit;

public class SeleniumCucumber {
    String url;
    WebDriver driver;

    @Before
    public void iniciar()
    {
        url = "https://www.submarino.com.br/";
        /*System.setProperty("webdriver.chrome.driver", "drivers/Chrome/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);*/

        System.setProperty("webdriver.gecko.driver", "drivers/Firefox/geckodriver.exe");

        FirefoxOptions fo = new FirefoxOptions();

        fo.setCapability("marionette",true);

        driver = new FirefoxDriver(fo);
    }

    @After
    public void finalizar()
    {
        driver.quit();
    }

    @Dado("que acesso o site do Submarino")
    public void que_acesso_o_site_do_submarino() {
        driver.get(url);
    }

    @Quando("busco por {string}")
    public void busco_por(String produto) {
        //Cucumber + Cucumber
        //driver.findElement(By.id("h_search-input")).sendKeys(produto + Keys.ENTER);

        //Cucumber+Selenium +PageObjects
        HomePage homePage = new HomePage(driver);

        homePage.limparCaixaBusca();
        homePage.buscaDandoENTER(produto);
    }

    @Entao("exibe a lista do {string}")
    public void exibe_a_lista_do(String produto) {

        //Assert.assertEquals("geladeira", driver.findElement(By.cssSelector("img.src__Image-xr9q25-0.lkEXOf")).getText());

        ListPage listPage = new ListPage(driver);
        Assert.assertEquals("geladeira",listPage.obterResultadoPagina());

    }

    @Entao("ao clicar no primeiro produto da lista")
    public void ao_clicar_no_primeiro_produto_da_lista() {

    }

    @Entao("exibe a pagina com o {string} e o {string}")
    public void exibe_a_pagina_com_o_e_o(String string, String string2) {

    }

}
