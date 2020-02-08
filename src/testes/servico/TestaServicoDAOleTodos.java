
package testes.servico;

import persistencia.ServicoDAO;

public class TestaServicoDAOleTodos {

    public static void main(String[] args) throws Exception{
        System.out.println(ServicoDAO.leTodos());
    }
    
}
