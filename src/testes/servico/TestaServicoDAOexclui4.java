/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.servico;

import persistencia.ServicoDAO;

/**
 *
 * @author Vítor Lucas
 */
public class TestaServicoDAOexclui4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        System.out.println(ServicoDAO.exclui4("101010", 200.0));
    }
    
}
