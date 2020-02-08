
package testes.servico;

import persistencia.ServicoDAO;

public class TestaServicoDAOleUm1 {

    public static void main(String[] args)throws Exception {
        System.out.println(ServicoDAO.leUm1("121212"));
    }
    
}
