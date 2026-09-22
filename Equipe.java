package controlechamado;
import java.util.ArrayList;
public class Equipe {
    private long id;
    private String nome;
    private String descricao;
    
    private ArrayList<Tecnico> Tecnico;
    
    public Equipe(long id, String nome, String descricao){
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.Tecnico = new ArrayList<>();
}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void adicionarTecnico(Tecnico tecnico) {
    Tecnico.add(tecnico);
}

    public ArrayList<Tecnico> getTecnicos() {
    return Tecnico;
}
    
    
    
    
}
