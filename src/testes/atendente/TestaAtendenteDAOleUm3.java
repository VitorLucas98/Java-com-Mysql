
package testes.atendente;

import persistencia.AtendenteDAO;

public class TestaAtendenteDAOleUm3 {

    public static void main(String[] args)throws Exception  {
        System.out.println(AtendenteDAO.leUm3(1000.9, 10));
    }
    
}
