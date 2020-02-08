
package modelo;

public class Tecnico extends Funcionario implements SalarioFinal,Comissao {
    private String equipamento; private Peca peca;
    
    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }
    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }
    public Tecnico(){
    }
    
    public Tecnico(String equipamento, Double salLiquido, String cpf, String nome, Peca peca) {
        super(salLiquido, cpf, nome);
        this.equipamento = equipamento;
        this.peca = peca;
    }
    public Double SalFinal(){
    return (comiTec * getSalLiquido()) +getSalLiquido();
    }
 public String toString(){
 return "\nDADOS DO TECNICO: "+
         "\nCPF: "+getCpf()+
         "\nNome: "+getNome()+
         "\nSalario Liquido: "+getSalLiquido()+
         "\nEquipamento ultilizado pelo Técnico: "+getEquipamento()+
         "\nPeça utilizada pelo Técnico:"+getPeca()+
         "\nSALÁRIO FINAL DO TÉCNICO: "+SalFinal()+"\n";
 }    

    
}
