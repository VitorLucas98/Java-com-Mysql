
package testes.tecnicoservico;

import persistencia.TecnicoServicoDAO;

public class TestaTecnicoServicoDAOalteraPorServico {
    public static void main(String[] args) throws Exception {
        System.out.println(TecnicoServicoDAO.alteraPorServico("313131", "131313", "323232", "151515"));
    }
    
}
