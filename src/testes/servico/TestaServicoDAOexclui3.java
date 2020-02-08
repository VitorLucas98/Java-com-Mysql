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
public class TestaServicoDAOexclui3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        System.out.println(ServicoDAO.exclui3("151515", "2018-04-01"));
    }
    
}
