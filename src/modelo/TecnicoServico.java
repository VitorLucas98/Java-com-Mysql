
package modelo;
public class TecnicoServico {
    private Servico servico;
    private Tecnico tecnico;

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }
    public TecnicoServico(){
    }

    public TecnicoServico(Servico servico, Tecnico tecnico) {
        this.servico = servico;
        this.tecnico = tecnico;
    }
    public String toString(){
    return "DADOS DO SERVICO: "+getServico()+
            "\nDADOS DO TÉCNICO: "+getTecnico();
    }
}
