
package testes.celular;

import modelo.Acessorio;
import persistencia.CelularDAO;
import modelo.Celular;
public class TestaCelularDAOgrava {

    public static void main(String[] args)throws Exception  {
       Celular ce = new Celular();
       
       ce.setCodPlaca("606060");
       ce.setModelo("Blue");
       
       Acessorio ac =new Acessorio();
       ac.setCodBarra("303030");
       
       ce.setAcessorio(ac);
        System.out.println(CelularDAO.grava(ce));
    }
    
}
