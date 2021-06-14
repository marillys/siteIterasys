package siteIterasys;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import template.AmbientesParametros;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class BuscaCurso {
    String url;
    WebDriver driver;

    @Before
    public void iniciar()
    {
        //Instanciar a classe que le a classe de properties
        new AmbientesParametros();

        System.out.println("BuscaCurso.java");
        url = AmbientesParametros.URL_APLICACAO;
                //"https://iterasys.com.br/";

        System.setProperty("webdriver.chrome.driver","drivers/Chrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void finalizar(){
        driver.quit();
    }

    @Dado("que acesso o site da Iterasys$")
    public void que_acesso_o_site_da_Iterasys(){
        driver.get(url);
    }

    @Quando("consulto pelo curso {string}")
    public void consulto_pelo_curso(String nomeCurso){
        driver.findElement(By.id("searchtext")).clear();
        driver.findElement(By.id("searchtext")).sendKeys(Keys.chord(nomeCurso));
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
    }

    @Entao("exibe uma lista com curso {string}")
    public void exibe_uma_lista_com_curso(String termo) {
        assertEquals("Cursos › \""+termo+"\"",driver.findElement(By.cssSelector("div.col-md-6")).getText());
        assertEquals("MATRICULE-SE  ",driver.findElement(By.cssSelector("span.comprar")).getText());
    }

    @Quando("clico em Matricule-se$")
    public void clico_em_Matricule_se(){
        driver.findElement(By.cssSelector("span.comprar")).click();
    }

    @Entao("exibe o titulo {string} e o valor {string}")
    public void exibe_o_titulo_e_o_valor(String titulo, String valor){
        assertEquals(titulo,driver.findElement(By.cssSelector("span.item-title")).getText());
        assertEquals(valor,driver.findElement(By.cssSelector("span.new-price")).getText());
    }

    @Entao("exibe mensagem de curso nao encontrado")
    public void exibe_mensagem_de_curso_nao_encontrado(){
        assertEquals("Desculpe não encontramos o curso que procura =(   Conheça nossos Cursos",
                driver.findElement(By.cssSelector("div.alert.alert-warning")).getText());
    }

    @Quando("consulto pelo {string}")
    public void consulto_pelo(String curso){
        driver.findElement(By.id("searchtext")).clear();
        driver.findElement(By.id("searchtext")).sendKeys(Keys.chord(curso));
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
    }


    @Entao("exibe uma lista com {string}")
    public void exibe_uma_lista_com(String curso){
        assertEquals("Cursos › \""+curso+"\"",driver.findElement(By.cssSelector("div.col-md-6")).getText());
        assertEquals("MATRICULE-SE  ",driver.findElement(By.cssSelector("span.comprar")).getText());
    }

    @Entao("exibe o titulo do {string} e o {string}")
    public void exibe_o_titulo_do_e_o(String curso, String valor){
        assertEquals(curso,driver.findElement(By.cssSelector("span.item-title")).getText());
        assertEquals(valor,driver.findElement(By.cssSelector("span.new-price")).getText());
    }
}
