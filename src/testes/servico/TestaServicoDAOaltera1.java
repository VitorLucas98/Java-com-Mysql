
package testes.servico;

import modelo.Atendente;
import modelo.Servico;
import persistencia.ServicoDAO;

public class TestaServicoDAOaltera1 {

    public static void main(String[] args)throws Exception {
        Servico ser = new Servico();
        ser.setCodServico("171717");
        ser.setData("2000-01-12");
        ser.setPreco(1500.96);
        Atendente at= new Atendente();
        at.setCpf("101010");
        ser.setAtendente(at);
        System.out.println(ServicoDAO.altera1(ser));
    }
    
}
