package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ListPage {

    public ListPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    //TODO Esse className não etá funcionando
    @FindBy(how = How.CLASS_NAME, using = "full-grid__Title-fvrmdp-0")
    private WebElement lblSetor;

    public String obterResultadoPagina()
    {
        return lblSetor.getText();
    }
}
