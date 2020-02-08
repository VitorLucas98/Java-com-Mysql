
package testes.servico;

import persistencia.ServicoDAO;

public class TestaServicoDAOaltera4 {

    public static void main(String[] args)throws Exception {
        System.out.println(ServicoDAO.altera4("3021-12-12", "101010", "202020", 170.05));
    }
    
}
