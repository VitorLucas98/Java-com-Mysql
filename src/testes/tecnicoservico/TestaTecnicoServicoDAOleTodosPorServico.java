
package testes.tecnicoservico;

import persistencia.TecnicoServicoDAO;

public class TestaTecnicoServicoDAOleTodosPorServico {

    public static void main(String[] args) throws Exception {
        System.out.println(TecnicoServicoDAO.leTodosPorServico("121212"));
    }
    
}
