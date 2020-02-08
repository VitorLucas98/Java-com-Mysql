
package testes.tecnico;

import modelo.Peca;
import modelo.Tecnico;
import persistencia.TecnicoDAO;

public class TestaTecnicoDAOaltera2 {

    public static void main(String[] args)throws Exception {
        System.out.println(TecnicoDAO.altera2("373737", 265.9, "Arma de fogo", 262626, "Jacinto Leite "));
       /* Tecnico te = new Tecnico();
       te.setNome("Fernandinho Torres");
       te.setCpf("373737");
       te.setSalLiquido(5452.9);
       te.setEquipamento("Nitrato de Alumino");
       
        Peca pe = new Peca();
       pe.setNumeracao(262626);
       
        
        System.out.println(TecnicoDAO.altera2(te));
        */
    }
    
}
