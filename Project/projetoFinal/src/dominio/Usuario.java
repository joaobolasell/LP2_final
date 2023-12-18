package dominio;

public class Usuario {
    private String nome;

    public Usuario(){

    }

    public Usuario(String nome) {
        if(nome != null){
            this.nome = nome;
        }else{
            throw new RuntimeException("ERRO");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome != null){
            this.nome = nome;
        }else{
            throw new RuntimeException("ERRO");
        }
    }

    }


