package siteIterasys;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConsultaCurso {
    String url;
    WebDriver driver;

    @Before
    public void Iniciar()
    {
        System.out.println("ConsultaCurso.java");
        url = "https://iterasys.com.br/";
        System.setProperty("webdriver.chrome.driver","drivers/Chrome/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void Finalizar()
    {
        driver.quit();
    }

    @Dado("^que visito o site da Iterasys$")
    public void que_visito_o_site_da_Iterasys(){
        driver.get(url);
    }

    @Quando("^preencho a consulta com \"([^\"]*)\" e clico na Lupa$")
    public void preencho_a_consulta_com_e_clico_na_Lupa(String nomeCurso){
        driver.findElement(By.id("searchtext")).sendKeys(nomeCurso);
        driver.findElement(By.id("btn_form_search")).click();
    }

    @Entao("^visualizo a oferta do curso \"([^\"]*)\"$")
    public void visualizo_a_oferta_do_curso(String arg1){

    }

    @Quando("^clico em Matricule-se no curso$")
    public void clico_em_Matricule_se_no_curso(){

    }

    @Entao("^visualizo curso \"([^\"]*)\" no carrinho e seu valor como \"([^\"]*)\"$")
    public void visualizo_curso_no_carrinho_e_seu_valor_como(String arg1, String arg2){

    }
}
