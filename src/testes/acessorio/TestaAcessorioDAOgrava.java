
package testes.acessorio;

import modelo.Acessorio;
import persistencia.AcessorioDAO;

public class TestaAcessorioDAOgrava {

    public static void main(String[] args) throws Exception {
     Acessorio ac = new Acessorio();
     
    ac.setCodBarra("606060");
    ac.setDescricao("Bastão de self");
    
        System.out.println(AcessorioDAO.grava(ac));
     
    }
    
}
