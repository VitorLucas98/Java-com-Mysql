
package testes.servico;

import modelo.Atendente;
import modelo.Servico;
import persistencia.ServicoDAO;

public class TestaServicoDAOgrava {
    public static void main(String[] args) throws Exception {
        Servico ser = new Servico();
        
        ser.setCodServico("171717");
        ser.setData("2018-12-11");
        ser.setPreco(56.93);
        
        Atendente at = new Atendente();
        at.setCpf("505050");
        ser.setAtendente(at);
        System.out.println(ServicoDAO.grava(ser));
    }
    
}
