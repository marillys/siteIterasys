package siteIterasys;

import apoio.Apoio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class Busca {
    String url;
    WebDriver driver;

    //Método para ler arquivo csv
    //declara atributos da massa de texto - colunas do arquivo
    String id;
    String termo;
    String resultado;
    String tipo;
    String browser;

    //Construtor para a leitura dos campos
    public Busca(String id, String termo, String resultado, String tipo, String browser) {
        this.id = id;
        this.termo = termo;
        this.resultado = resultado;
        this.tipo = tipo;
        this.browser = browser;
    }

    @Parameterized.Parameters
    //Coleção que informa o local e o nome do arquivo da massa
    public static Collection<String[]> lerArquivo() throws IOException {
        //Chama a coleção lerCSV passando o caminho e o nome da massa
        return lerCSV("db/massaWiki.csv");
    }


    public static  Collection<String[]> lerCSV(String nomeMassa) throws IOException {
        //ler o arquivo csv
        String linha;
        List<String[]> dados = new ArrayList<String[]>();

        //Coloca o arquivo na memória
        BufferedReader arquivo = new BufferedReader(new FileReader(nomeMassa));

        //repete até encontrar uma linha sem valores
        while((linha = arquivo.readLine()) != null)
        {
            //Quebrar em colunas
            String campos[] = linha.split(";");

            dados.add(campos);
        }
        //Fecha o arquivo pra não corromper
        arquivo.close();
        return dados;
    }

    @Before
    public void iniciar()
    {
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
        driver.findElement(By.id("searchInput")).sendKeys(termo);
        //Tira print
        Apoio.print(driver,id+"Pesquisa");
        driver.findElement(By.id("searchInput")).sendKeys(Keys.ENTER);
        driver.findElement(By.linkText(resultado)).click();

        //Tira print
        Apoio.print(driver,id +"ResultadoPesquisa");

        assertEquals(resultado,driver.findElement(By.id("firstHeading")).getText());
    }
}
