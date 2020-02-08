
package testes.tecnico;

import modelo.Peca;
import modelo.Tecnico;
import persistencia.TecnicoDAO;

public class TestaTecnicoDAOaltera1 {

    public static void main(String[] args)throws Exception {
       Tecnico te = new Tecnico();
       te.setCpf("313131");
       te.setNome("Fernandinho Torres");
       te.setSalLiquido(2222.9);
       te.setEquipamento("Agua Raz");
       
       Peca pe = new Peca();
       pe.setNumeracao(212121);
      
       te.setPeca(pe);
        System.out.println(TecnicoDAO.altera1(te));
    }
    
}
