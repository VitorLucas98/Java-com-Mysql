
package testes.celular;

import modelo.Acessorio;
import modelo.Celular;
import persistencia.CelularDAO;

public class TestaCelularDAOaltera1 {

    public static void main(String[] args)throws Exception  {
        Celular ce = new Celular();
        ce.setModelo("Asus");
        ce.setCodPlaca("606060");
        
        Acessorio ac = new Acessorio();
        ac.setCodBarra("202020");
        
        ce.setAcessorio(ac);
        System.out.println(CelularDAO.altera1(ce));
    }
    
}
