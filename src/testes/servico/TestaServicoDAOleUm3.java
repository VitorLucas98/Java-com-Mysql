
package testes.servico;

import persistencia.ServicoDAO;

public class TestaServicoDAOleUm3 {

    public static void main(String[] args)throws Exception {
        System.out.println(ServicoDAO.leUm3("151515", "2018-04-01"));
    }
    
}
