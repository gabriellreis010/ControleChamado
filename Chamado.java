package controlechamado;
import java.time.LocalDateTime;
public class Chamado {
    private long id;
    private String titulo;
    private String descricao;
    private Prioridade prioridade;
    private StatusChamado status;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataEncerramento;
    
    
    public Chamado(long id, String titulo, String descricao, Prioridade prioridade, StatusChamado status, LocalDateTime dataAbertura, LocalDateTime dataEncerramento) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = status;
        this.dataAbertura = dataAbertura;
        this.dataEncerramento = dataEncerramento;
        
    }
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade Prioridade) {
        this.prioridade = Prioridade;
    }

    public StatusChamado getStatus() {
        return status;
    }

    public void setStatus(StatusChamado Status) {
        this.status = Status;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(LocalDateTime dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }
    
    public Tecnico tecnico;
    public void atribuirTecnico(Tecnico t){
        this.tecnico = t;
    }
    
    public void alterarStatus(StatusChamado s){
        this.status = s;
    }
    
    public boolean estaAberto(){
        return status ==StatusChamado.ABERTO;
    }
    
    public void encerrar() {
    this.status = StatusChamado.ENCERRADO;
    this.dataEncerramento = LocalDateTime.now();
    }   
    
    public Tecnico getTecnico() {
    return tecnico;
}
    
    
    
    
    
}
