
package testes.tecnicoservico;

import persistencia.TecnicoServicoDAO;

public class TestaTecnicoServicoDAOexcluiPorTecnicoServico {

    public static void main(String[] args) throws Exception {
        System.out.println(TecnicoServicoDAO.excluiPorTecnicoServico("313131", "121212"));
    }
    
}
