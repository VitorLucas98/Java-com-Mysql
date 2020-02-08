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
public abstract class Pessoa {
    private String cpf; private String nome;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public Pessoa(){
    }
    public Pessoa(String cpf, String nome){
    this.cpf = cpf;
    this.nome = nome;
    }
    public abstract String toString();
}
