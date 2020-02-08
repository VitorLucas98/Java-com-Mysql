
package testes.servico;

import persistencia.ServicoDAO;

public class TestaServicoDAOleUm2 {

    public static void main(String[] args)throws Exception {
        System.out.println(ServicoDAO.leUm2("2018-02-17"));
    }
    
}
