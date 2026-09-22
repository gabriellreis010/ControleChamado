package controlechamado;

import java.time.LocalDateTime;

public class Atendimento {
    private long id;
    private LocalDateTime dataHora;
    private String descricao;
    private Tecnico realizadoPor;
    
    public Atendimento (long id, LocalDateTime dataHora, String descricao, Tecnico realizadoPor ){
        this.id = id;
        this.dataHora = dataHora;
        this.descricao = descricao;
        this.realizadoPor = realizadoPor;
    }

    public Tecnico getRealizadoPor() {
        return realizadoPor;
    }

    public void setRealizadoPor(Tecnico realizadoPor) {
        this.realizadoPor = realizadoPor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void registrar(){
        
    }
    
    
    
    
    
    
    
    
}
