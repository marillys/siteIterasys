package siteIterasys;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false,
        monochrome = true,
        features = { "src/test/resources/" },//Caminho para os .features
        glue = { "/" },//Caminho para o .java
        plugin = { "pretty",
                   "html:target/relatorio1.html",
                   "json:target/relatorio1.json"//,
                   //"com.cucumber.listener.ExtentCucumberFormatter:target/relatorio2/dashboard.html"
        }
)
public class Runner {
}
