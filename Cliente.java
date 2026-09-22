package controlechamado;
public class Cliente extends Usuario{
    private String cpfCnpj;
    private String endereco;
    
    public Cliente(int id, String nome, String email, String telefone,
               String cpfCnpj, String endereco) {

    super(id, nome, email, telefone);

    this.cpfCnpj = cpfCnpj;
    this.endereco = endereco;
}

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
}
