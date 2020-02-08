
package testes.tecnicoservico;

import persistencia.TecnicoServicoDAO;

public class TestaTecnicoServicoDAOleTodosPorTecnico {

    public static void main(String[] args) throws Exception {
        System.out.println(TecnicoServicoDAO.leTodosPorTecnico("323232"));
    }
    
}
