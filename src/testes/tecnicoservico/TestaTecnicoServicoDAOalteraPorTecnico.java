
package testes.tecnicoservico;

import persistencia.TecnicoServicoDAO;

public class TestaTecnicoServicoDAOalteraPorTecnico {

    public static void main(String[] args) throws Exception {
        System.out.println(TecnicoServicoDAO.alteraPorTecnico("141414", "353535", "131313"));
    }
    
}
