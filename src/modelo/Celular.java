/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Celular {
    private String codPlaca;private String modelo;Acessorio acessorio;

    public Acessorio getAcessorio() {
        return acessorio;
    }

    public void setAcessorio(Acessorio acessorio) {
        this.acessorio = acessorio;
    }
    public String getCodPlaca() {
        return codPlaca;
    }

    public void setCodPlaca(String codPlaca) {
        this.codPlaca = codPlaca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public Celular(){
    }
    public Celular(String codPlaca, String modelo, Acessorio acessorio){
    this.codPlaca = codPlaca;
    this.modelo = modelo;
    this.acessorio = acessorio;
    }
    public String toString(){
    return "DADOS DO CELULAR:"
            + "\nCodigo da Placa: "+getCodPlaca()+
            "\nModelo: "+getModelo()+
            "\nACESSORIO VINCULADO AO CELULAR: "+getAcessorio()+"\n";
    }
}
