package dominio;

public class Administrador extends Usuario{

    private String matricula;
    private String email;
    private String senha;

    public Administrador(String nome, String matricula, String email, String senha) {
        if(email != null){
            this.setNome(nome);
            this.matricula = matricula;
            this.email = email;
            this.senha = senha;
        }else{
            throw new RuntimeException("ERRO");
        }

    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        if(matricula != null){
            this.matricula = matricula;
        }else{
            throw new RuntimeException("ERRO");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email != null){
            this.email = email;
        }else{
            throw new RuntimeException("ERRO");
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if(senha != null){
            this.senha = senha;
        }else{
            throw new RuntimeException("ERRO");
        }
    }
}
