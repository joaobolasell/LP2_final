package dominio;


import java.util.Date;

public class Registro{

    private Date dataHora;
    private Colaborador usuarioRegistro;
    private Sala sala;
    private EnumTipoDeRegistro tRegistro;

    public Registro(EnumTipoDeRegistro e, Date dataHora, Colaborador usuarioRegistro, Sala s) {
        if(usuarioRegistro != null && s != null && dataHora != null){
            this.tRegistro = e;
            this.dataHora = dataHora;
            this.usuarioRegistro = usuarioRegistro;
            this.sala = s;
            s.addRegistrosNaSala(this);
        }else{
            throw new RuntimeException("ERRO");
        }
    }

    public EnumTipoDeRegistro gettRegistro() {
        return tRegistro;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public Colaborador getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public Sala getSala() {
        return sala;
    }


} //class
