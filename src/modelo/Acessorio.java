
package modelo;

public class Acessorio {
    private String codBarra; private String descricao;

    public String getCodBarra() {
        return codBarra;
    }

 
    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Acessorio(){    
    }
    public Acessorio(String codBarra, String descricao){
    this.codBarra = codBarra;
    this.descricao = descricao;
    }
    public String toString(){
    return 
            "\nCodigo de Barras: "+getCodBarra()+
            "\nDescrição: "+getDescricao()+"\n";
    }
}
