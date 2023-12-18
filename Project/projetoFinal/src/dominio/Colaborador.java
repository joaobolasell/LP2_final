package dominio;

import java.util.ArrayList;
import java.util.Date;

public class Colaborador extends Usuario {

    private String cpf;
    private int codColaborador;
    private String cargo;
    private int nivelAcesso;
    private ArrayList<Registro> registrosColaborador = new ArrayList<Registro>();
    private ArrayList<Sala> salasLiberadas = new ArrayList<Sala>();

    public Colaborador(String nome, String cpf, int codColaborador, String cargo, int nivelAcesso) {
        if(nome != null && cpf != null && cargo != null){
            this.setNome(nome);
            this.cpf = cpf;
            this.codColaborador = codColaborador;
            this.cargo = cargo;
            this.nivelAcesso = nivelAcesso;
        }else{
            throw new RuntimeException("ERRO");
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(cpf != null){
            this.cpf = cpf;
        }else{
            throw new RuntimeException("ERRO");
        }
    }

    public int getCodColaborador() {
        return codColaborador;
    }

    public void setCodColaborador(int codColaborador) {
        this.codColaborador = codColaborador;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        if(cargo != null){
            this.cargo = cargo;
        }else{
            throw new RuntimeException("ERRO");
        }
    }

    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public ArrayList<Sala> getSalasLiberadas() {
        return salasLiberadas;
    }

    public void liberarSala(Sala s){
        if(s != null){
            salasLiberadas.add(s);
            s.addColaborador(this); //adicionado no feed 4.1 - adiciona na Sala o colaboradore liberado
        }else{
            throw new RuntimeException("ERRO");
        }

    }

    public void desautorizaSala(Sala s){
        if(s != null){
            salasLiberadas.remove(s);
            s.removeColaborador(this); //adicionado no feed 4.1 - removo na Sala o colaborador que foi desautorizado
        }else{
            throw new RuntimeException("ERRO");
        }
    }

    public ArrayList<Registro> getRegistros(){
        return registrosColaborador;
    }

    public ArrayList<Registro> getRegistros(Sala salaP){

        ArrayList<Registro> registrosRetorno = new ArrayList<Registro>(); //CRIA LISTA DE REGISTROS PARA RETORNAR , SE TIVER MAIS DE 1 RETORNO

        for (Registro registro : registrosColaborador) {

            if (registro.getSala() == salaP) {
                registrosRetorno.add(registro);
            }
        }

        return registrosRetorno;
    }

    public ArrayList<Registro> getRegistros(Date dataP){

        ArrayList<Registro> registrosRetorno = new ArrayList<Registro>(); //CRIA LISTA DE REGISTROS PARA RETORNAR , SE TIVER MAIS DE 1 RETORNO

        for (Registro registro : registrosColaborador) {
            if (registro.getDataHora().equals(dataP)) {
                registrosRetorno.add(registro);
            }
        }
        return registrosRetorno;
    }

    public ArrayList<Registro> getRegistros(Sala salaP, Date dataP){

        ArrayList<Registro> registrosRetorno = new ArrayList<Registro>(); //CRIA LISTA DE REGISTROS PARA RETORNAR , SE TIVER MAIS DE 1 RETORNO

        for (Registro registro : registrosColaborador) {
            if ((registro.getSala() == salaP) && (registro.getDataHora().equals(dataP))) {
                registrosRetorno.add(registro);
            }
        }
        return registrosRetorno;
    }


    public boolean registrar (EnumTipoDeRegistro e, Date dataHora, Sala sala){
        if(dataHora != null && sala != null){
            if(this.getNivelAcesso() == 42){ //se tiver acesso 42 registra direto, 42 = acesso total
                Registro r;
                r = new Registro(e, dataHora, this, sala);
                registrosColaborador.add(r);
                return true;
            }
            for (Sala salaLiberada : salasLiberadas) {
                if (sala == salaLiberada) {//registra
                    Registro r;
                    r = new Registro(e, dataHora, this, sala);
                    registrosColaborador.add(r);

                    return true;
                }
            }
        }else{
            throw new RuntimeException("Erro: Sala NULO");
        }
        return false;
    }



}//class



















/* CODIGO MODIFICADO ADICIONADO ENUM NO LUGAR O BOOLEAN
*
* public boolean registrar (boolean tipoRegistro, Date dataHora, Sala sala){
        if(this.getNivelAcesso() == 42){ //se tiver acesso 42 registra direto, 42 = acesso total
            Registro r;
            r = new Registro(tipoRegistro, dataHora, this, sala);
            registrosColaborador.add(r);
            // Help h = new Help();
            // h.addRegistrosBD(r);
            return true;
        }
        for (Sala salaLiberada : salasLiberadas) {
            if (sala == salaLiberada) {//registra
                Registro r;
                r = new Registro(tipoRegistro, dataHora, this, sala);
                registrosColaborador.add(r);
                //Help h = new Help();
                //h.addRegistrosBD(r);
                return true;
            }
        }
        return false;
    }
*
*
* * */
