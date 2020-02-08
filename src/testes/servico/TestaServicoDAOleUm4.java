
package testes.servico;

import persistencia.ServicoDAO;

public class TestaServicoDAOleUm4 {

    public static void main(String[] args)throws Exception {
        System.out.println(ServicoDAO.leUm4(170.05, "303030"));
    }
    
}
