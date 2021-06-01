package apoio;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import template.AmbientesParametros;

import java.io.File;
import java.io.IOException;

public class Apoio {

    public static void print(WebDriver driver,String nome) throws IOException {
        //tira uma foto e coloca na memoria
        File foto = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //Salva o print no direorio especificado no .properties
        FileUtils.copyFile(foto,new File(AmbientesParametros.IMAGE_PATH
                +nome+".png"));
    }
}
