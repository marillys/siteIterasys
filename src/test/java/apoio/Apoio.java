package apoio;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import template.AmbientesParametros;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Apoio {
    static String pastaFoto = new SimpleDateFormat("yyyy-MM-dd HH-mm")
            .format(Calendar.getInstance().getTime());

    public static void print(WebDriver driver,String nomeFoto) throws IOException {
        String nomeArquivo = AmbientesParametros.getInstance().IMAGE_PATH + pastaFoto + "/" + nomeFoto +".png";
        //tira uma foto e coloca na memoria
        File foto = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //Salva o print no direorio especificado no .properties
        FileUtils.copyFile(foto,new File(nomeArquivo));
    }
}
