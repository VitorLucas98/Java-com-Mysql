/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.acessorio;

import persistencia.AcessorioDAO;

/**
 *
 * @author Vítor Lucas
 */
public class TestaAcessorioDAOaltera4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        System.out.println(AcessorioDAO.altera4("Suco", "404040", "Frango"));
    }
    
}
