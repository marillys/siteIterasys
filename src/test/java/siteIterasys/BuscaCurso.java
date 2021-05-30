package siteIterasys;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class BuscaCurso {
    String url;
    WebDriver driver;

    @Before
    public void iniciar()
    {
        System.out.println("BuscaCurso.java");
        url = "https://iterasys.com.br/";
        System.setProperty("webdriver.chrome.driver","drivers/Chrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void finalizar(){
        driver.quit();
    }

    @Dado("^que acesso o site da Iterasys$")
    public void que_acesso_o_site_da_Iterasys(){
        driver.get(url);
    }

    @Quando("^consulto pelo curso \"([^\"]*)\"$")
    public void consulto_pelo_curso(String nomeCurso){
        driver.findElement(By.id("searchtext")).clear();
        driver.findElement(By.id("searchtext")).sendKeys(Keys.chord(nomeCurso));
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
    }

    @Entao("^exibe uma lista com curso \"([^\"]*)\"$")
    public void exibe_uma_lista_com_curso(String termo) {
        assertEquals("Cursos › \""+termo+"\"",driver.findElement(By.cssSelector("div.col-md-6")).getText());
        assertEquals("MATRICULE-SE  ",driver.findElement(By.cssSelector("span.comprar")).getText());
    }

    @Quando("^clico em Matricule-se$")
    public void clico_em_Matricule_se(){

    }

    @Entao("^exibe o titulo \"([^\"]*)\" e o valor \"([^\"]*)\"$")
    public void exibe_o_titulo_e_o_valor(String arg1, String arg2){

    }
}
