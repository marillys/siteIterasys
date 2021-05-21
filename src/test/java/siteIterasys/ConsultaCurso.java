package siteIterasys;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class ConsultaCurso {
    @Dado("^que visito o site da Iterasys$")
    public void que_visito_o_site_da_Iterasys(){
    }

    @Quando("^preencho a consulta com \"([^\"]*)\" e clico na Lupa$")
    public void preencho_a_consulta_com_e_clico_na_Lupa(String arg1){

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
