
package testes.atendente;

import modelo.Atendente;
import persistencia.AtendenteDAO;

public class TestaAtendenteDAOgrava {

    public static void main(String[] args)throws Exception  {
            Atendente at = new Atendente();
          at.setCpf("505050");
          at.setNome("Halcileia Rabiola");
          at.setSalLiquido(2000.99);
          at.setQtdCliente(26);
          
          System.out.println(AtendenteDAO.grava(at));
    }
    
}
