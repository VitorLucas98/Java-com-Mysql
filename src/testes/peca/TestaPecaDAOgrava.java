
package testes.peca;

import modelo.Peca;
import persistencia.PecaDAO;

public class TestaPecaDAOgrava {

    public static void main(String[] args)throws Exception {
     Peca pe = new Peca();
     
     pe.setNumeracao(272727);
     pe.setPreco(55.99);
     pe.setDescricao("BlackLight");
     
        System.out.println(PecaDAO.grava(pe));
    }
    
}
