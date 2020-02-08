
package testes.servico;

import persistencia.ServicoDAO;

public class TestaServicoDAOaltera2 {

    public static void main(String[] args)throws Exception {
        System.out.println(ServicoDAO.altera2("181818", "2020-12-17", "303030", 1500.96));
    }
    
}
