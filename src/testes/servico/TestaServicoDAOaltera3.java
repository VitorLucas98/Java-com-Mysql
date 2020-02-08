
package testes.servico;

import persistencia.ServicoDAO;

public class TestaServicoDAOaltera3 {

    public static void main(String[] args)throws Exception {
        System.out.println(ServicoDAO.altera4("202020", "505050", "2020-12-17", 1500.96));
    }
    
}
