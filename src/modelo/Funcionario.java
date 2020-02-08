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
public abstract class Funcionario extends Pessoa {
    private Double salLiquido;

    public Double getSalLiquido() {
        return salLiquido;
    }

    public void setSalLiquido(Double salLiquido) {
        this.salLiquido = salLiquido;
    }
    public Funcionario(){
    }

    public Funcionario(Double salLiquido) {
        this.salLiquido = salLiquido;
    }

    public Funcionario(Double salLiquido, String cpf, String nome) {
        super(cpf, nome);
        this.salLiquido = salLiquido;
    }
    
}
