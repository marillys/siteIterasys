package template;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AmbientesParametros {
    public static String ENVIROMENT;
    public static String URL_APLICACAO;
    public static String REPORT_NAME;
    public static String REPORT_PATH;
    public static String IMAGE_PATH;
    private static AmbientesParametros ambientesParametros;

    private Properties properties;

    public static AmbientesParametros getInstance()
    {
        if(ambientesParametros == null)
        {
            ambientesParametros = new AmbientesParametros();
        }
        return ambientesParametros;
    }

    public AmbientesParametros(){
        //ler arquivo
        properties = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("ambientes.properties");
            properties.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //aloca os valores
        REPORT_NAME = properties.getProperty("report.name");
        REPORT_PATH = properties.getProperty("report.path");
        ENVIROMENT = properties.getProperty("enviroment");
        IMAGE_PATH = properties.getProperty("image.path");

        //Separa valores conforme ambiente
        switch (ENVIROMENT)
        {
            case "hml":
                URL_APLICACAO = properties.getProperty("hml.url.aplicacao");
                break;

            case "dev":
                URL_APLICACAO = properties.getProperty("dev.url.aplicacao");
            break;
        }

    }
}
