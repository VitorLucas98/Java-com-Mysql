
package testes.tecnico;

import modelo.Tecnico;
import modelo.Peca;
import persistencia.TecnicoDAO;

public class TestaTecnicoDAOgrava {
    public static void main(String[] args)throws Exception {
       Tecnico te = new Tecnico();
       
       te.setCpf("636363");
       te.setNome("Jucilei Paquetá");
       te.setSalLiquido(959.99);
       te.setEquipamento("Canivete");
       
       Peca pe = new Peca();
       pe.setNumeracao(212121);
       
       te.setPeca(pe);
        System.out.println(TecnicoDAO.grava(te));
       
 
        
       
    }
    
}
