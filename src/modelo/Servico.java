/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Vítor Lucas
 */
public class Servico {
    private String codServico; private Double preco;private String data;private Atendente atendente;

    public String getCodServico() {
        return codServico;
    }

    public void setCodServico(String codServico) {
        this.codServico = codServico;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }
    public Servico(){
    }

    public Servico(String codServico, Double preco, String data, Atendente atendente) {
        this.codServico = codServico;
        this.preco = preco;
        this.data = data;
        this.atendente = atendente;
    }
    public String toString(){
    return "DADOS DO SEVIÇO:"
            + " \nCódigo do Serviço: "+getCodServico()+
            "\nPreço: "+getPreco()+
            "\nData: "+getData()+
            "\nServiço feito Pelo Atendente: "+getAtendente();
    }
}
