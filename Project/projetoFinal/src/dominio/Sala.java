package dominio;

import java.util.ArrayList;
import java.util.Date;

public class Sala {

    private String nome;
    private String tipo;



    private ArrayList<Colaborador> colaboradoresLiberados = new ArrayList<Colaborador>();//add feed 4.1 + addColaborador - colaboradoresLiberados dentro da SALA



    private ArrayList<Registro> registrosNaSala = new ArrayList<Registro>();



    public Sala(String nome, String tipo) {
        if(nome != null && tipo != null){
            this.nome = nome;
            this.tipo = tipo;
        }else{
            throw new RuntimeException("ERRO");
        }
    }

    public ArrayList<Registro> getRegistrosNaSala() {
        return registrosNaSala;
    }
    public ArrayList<Colaborador> getColaboradoresLiberados() {
        return colaboradoresLiberados;
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
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if(tipo != null){
            this.tipo = tipo;
        }else{
            throw new RuntimeException("ERRO");
        }
    }

    public void addColaborador(Colaborador c){
        if(c != null){
            colaboradoresLiberados.add(c);
        }else{
            throw new RuntimeException("ERRO");
        }
    }

    public void removeColaborador(Colaborador c){
        if(c != null){
            colaboradoresLiberados.remove(c);
        }else{
            throw new RuntimeException("ERRO");
        }
    }

    public void addRegistrosNaSala (Registro r){ // já foi testado != null no contrutor de registro onde usa esse metodo
        registrosNaSala.add(r);
    }

    public ArrayList<Registro> getRegistros(){
        return registrosNaSala;
    }

    public ArrayList<Registro> getRegistros(Colaborador cP){

        ArrayList<Registro> registrosRetorno = new ArrayList<Registro>(); //CRIA LISTA DE REGISTROS PARA RETORNAR , SE TIVER MAIS DE 1 RETORNO

        for (Registro registro : registrosNaSala) {

            if (registro.getUsuarioRegistro() == cP) {
                registrosRetorno.add(registro);
            }
        }
        return registrosRetorno;

    }



    public ArrayList<Registro> getRegistros(EnumTipoDeRegistro eTR){

        ArrayList<Registro> registrosRetorno = new ArrayList<Registro>(); //CRIA LISTA DE REGISTROS PARA RETORNAR , SE TIVER MAIS DE 1 RETORNO

        for (Registro registro : registrosNaSala) {
            if (registro.gettRegistro().equals(eTR)) {
                registrosRetorno.add(registro);
            }
        }
        return registrosRetorno;

    }

    public ArrayList<Registro> getRegistros(Date dataP) {

        ArrayList<Registro> registrosRetorno = new ArrayList<Registro>(); //CRIA LISTA DE REGISTROS PARA RETORNAR , SE TIVER MAIS DE 1 RETORNO

        for(Registro registro : registrosNaSala){
            if(registro.getDataHora().equals(dataP)){
                registrosRetorno.add(registro);
            }
        }
        return registrosRetorno;

    }

}





