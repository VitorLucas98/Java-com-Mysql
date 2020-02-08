
package modelo;

public class Peca {
    private int numeracao; private Double preco;private String descricao;  

    public int getNumeracao() {
        return numeracao;
    }

    public void setNumeracao(int numeracao) {
        this.numeracao = numeracao;
    }

  
    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

  
    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Peca(){
    }
    public Peca(int numeracao, Double preco, String descricao){
    this.descricao = descricao;
    this.preco=preco;
    this.numeracao = numeracao;
    }
    public String toString(){
    return "\nDADOS DA PEÇA: "
            + "\nNumeração: "+getNumeracao()+
            "\nPreço: "+getPreco()+
            "\nDescrição: "+getDescricao();
    }
}
