/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 256102
 */
public class Cliente extends Pessoa {
    private String endereco; Celular celular;Servico servico;

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Celular getCelular() {
        return celular;
    }

    public void setCelular(Celular celular) {
        this.celular = celular;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Cliente(String endereco) {
        this.endereco = endereco;
    }
    public Cliente(){
    }
    
    public Cliente(String endereco, String cpf, String nome, Celular celular, Servico servico) {
        super(cpf, nome);
        this.endereco = endereco;
        this.celular =celular;
        this.servico = servico;
    }
    public String toString(){
return "DADOS DO CLIENTE: "
        + "\nNome: "+getNome()+
        "\nCPF: "+getCpf()+
        "\nEndereço: "+getEndereco()+
        "\nCelular do Cliente: "+getCelular()+
        "\nServico Fornecido ao Cliente: "+getServico();
}
}
