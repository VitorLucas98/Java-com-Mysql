
package modelo;

public class Atendente extends Funcionario implements SalarioFinal, Comissao {
    private int qtdCliente;

    public int getQtdCliente() {
        return qtdCliente;
    }

    public void setQtdCliente(int qtdCliente) {
        this.qtdCliente = qtdCliente;
    }
   
    public Atendente(int qtdCliente, Double salLiquido, String cpf, String nome) {
        super(salLiquido, cpf, nome);
        this.qtdCliente = qtdCliente;
    }
    public Atendente(){}
    
    public Double SalFinal(){
    return (comiAten * getSalLiquido()) +getSalLiquido();
    }
     public String toString(){
 return "\nDADOS DO ATENDENTE: "+
         "\nCPF: "+getCpf()+
         "\nNome: "+getNome()+
         "\nSalario Liquido: "+getSalLiquido()+
         "\nQuantidade Clientes: "+getQtdCliente()+
         "\nSALÁRIO FINAL DO ATENDENTE: "+SalFinal()+"\n";
 }    
}
