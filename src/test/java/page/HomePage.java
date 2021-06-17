package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    //Construtor
    public HomePage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    //Mapeamento dos elementos
    @FindBy(how = How.ID, using = "h_search-input")
    private WebElement txtBusca;

    @FindBy(how = How.ID, using= "bhf_icon-search")
    private WebElement btnBusca;

    //Ações dos elementos
    public void limparCaixaBusca()
    {
        txtBusca.clear();
    }

    public void buscaDandoENTER(String termo)
    {
        txtBusca.sendKeys(termo+ Keys.ENTER);
    }

    public void buscaClicandoNaLupa(String termo)
    {
        txtBusca.sendKeys(termo);
        btnBusca.click();
    }
}
