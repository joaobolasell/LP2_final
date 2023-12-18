package telas;

import auxiliar.Help;
import dados.DadosBd;
import dominio.Colaborador;
import dominio.EnumTipoDeRegistro;
import dominio.Registro;
import dominio.Sala;

import java.text.DateFormat;
import java.util.ArrayList;

public class TelaRegistros {

    public void mostraRegistrosSeparado(ArrayList<Registro> r){

        DateFormat f = DateFormat.getDateInstance(DateFormat.FULL);
        DateFormat hora = DateFormat.getTimeInstance();

        System.out.println(" | REGISTROS |");

        for (int i=0; i<r.size(); i++){
            System.out.println("- REGISTRO nº "+i);
            System.out.println("COLABORADOR: "+r.get(i).getUsuarioRegistro().getNome());
            System.out.println("TIPO DE REGISTRO: "+r.get(i).gettRegistro());
            System.out.println("LOCAL DO REGISTRO: "+r.get(i).getSala().getNome()+" "+r.get(i).getSala().getTipo());
            System.out.println("DATA E HORA: "+f.format(r.get(i).getDataHora())+" "+hora.format(r.get(i).getDataHora()));
            System.out.println("----------------------------------------------");
        }

    }

    public void mostrarRegistrosLinha(ArrayList<Registro> r){

        DateFormat f = DateFormat.getDateInstance(DateFormat.FULL);
        DateFormat hora = DateFormat.getTimeInstance();

        System.out.println("| REGISTROS |");

        for (int i=0; i<r.size(); i++){
            System.out.println("| REGISTRO nº "+i+" | COLABORADOR: "+r.get(i).getUsuarioRegistro().getNome()+" | TIPO DE REGISTRO: "+r.get(i).gettRegistro()+" | LOCAL DE REGISTRO: "+r.get(i).getSala().getNome()+" | DATA E HORA: "+f.format(r.get(i).getDataHora())+" "+hora.format(r.get(i).getDataHora())+" |");
        }

    }


    public void efetuarRegistro(ArrayList<Colaborador> c, ArrayList<Sala> s){
        Help h = new Help();

        System.out.println(" *** REGISTRO DE ACESSO MANUAL ***");

        //SELECIONA COLABORADOR
        System.out.println("| COLABORADORES |");
        for (int i=0; i<c.size(); i++){
            System.out.println("| COLABORADOR CODIGO: "+i+" | NOME: "+c.get(i).getNome()+" | CARGO: "+c.get(i).getCargo()+" |");
        }
        System.out.println("-> DIGITE O CODIGO DO COLABORADOR PARA O REGISTRO: ");
        int codCol = h.leInteiro();

        //SELECIONA SALA
        System.out.println("| SALAS |");
        for(int j=0; j<s.size(); j++){
            System.out.println("| SALA CODIGO: "+j+" | NOME: "+s.get(j).getNome()+" | TIPO: "+s.get(j).getTipo()+ " |");
        }
        System.out.println("-> DIGITE O CODIGO DA SALA PARA O REGISTRO: ");
        int codSala = h.leInteiro();

        //SELECIONA TIPO DE REGISTRO ENTRADA OU SAIDA
        System.out.println("-> DIGITE '1' PARA ENTRADA E '0' PARA SAIDA DA SALA "+codSala);
        int codTipo = h.leInteiro();

        boolean resultado = false;
        if (codTipo == 1){
            //CRIA OBJETO REGISTRO VIA colaborador.regisrar
            resultado = c.get(codCol).registrar(EnumTipoDeRegistro.ENTRADA, h.retornaData(), s.get(codSala));

            //ADICIONA NO BANCO DadosBd - GAMBIARRA
            Registro r = new Registro(EnumTipoDeRegistro.ENTRADA, h.retornaData(), c.get(codCol), s.get(codSala));
            DadosBd.registrosBD.add(r);
        } else if (codTipo == 0) {
            //CRIA OBJETO REGISTRO VIA colaborador.regisrar
            resultado = c.get(codCol).registrar(EnumTipoDeRegistro.SAIDA, h.retornaData(), s.get(codSala));

            //ADICIONA NO BANCO DadosBd - GAMBIARRA
            Registro r = new Registro(EnumTipoDeRegistro.SAIDA, h.retornaData(), c.get(codCol), s.get(codSala));
            DadosBd.registrosBD.add(r);
        }

        if (resultado){
            System.out.println(" *** REGISTRADO COM SUCESSO *** ");
        }else{
            System.out.println("ACESSO NEGADO");
        }
    }

    public void efetuarRegistroSalasLiberadas(ArrayList<Colaborador> c, ArrayList<Sala> s){
        Help h = new Help();

        System.out.println(" *** REGISTRO DE ACESSO MANUAL ***");

        //SELECIONA COLABORADOR
        System.out.println("| COLABORADORES |");
        for (int i=0; i<c.size(); i++){
            System.out.println("| COLABORADOR CODIGO: "+i+" | NOME: "+c.get(i).getNome()+" | CARGO: "+c.get(i).getCargo()+" |");
        }
        System.out.println("-> DIGITE O CODIGO DO COLABORADOR PARA O REGISTRO: ");
        int codCol = h.leInteiro();

        //SELECIONA SALA
        System.out.println("| SALAS LIBERADAS PRO COLABORADOR |");
        for (int k=0; k<c.get(codCol).getSalasLiberadas().size(); k++){
            System.out.println(" SALA CODIGO: "+k+" | NOME: "+c.get(codCol).getSalasLiberadas().get(k).getNome()+" | TIPO: "+c.get(codCol).getSalasLiberadas().get(k).getTipo()+" |");
        }
        System.out.println("-> DIGITE O CODIGO DA SALA PARA O REGISTRO: ");
        int codSala = h.leInteiro();

        //SELECIONA TIPO DE REGISTRO ENTRADA OU SAIDA
        System.out.println("-> DIGITE '1' PARA ENTRADA E '0' PARA SAIDA DA SALA "+codSala);
        int codTipo = h.leInteiro();

        //TESTA SE É ENTRADA OU SAIDA E CRIA REGISTRO
        boolean resultado = false;
        if (codTipo == 1){
            //CRIA OBJETO REGISTRO VIA colaborador.regisrar
            resultado = c.get(codCol).registrar(EnumTipoDeRegistro.ENTRADA, h.retornaData(), s.get(codSala));

            //ADICIONA NO BANCO DadosBd
            Registro r = new Registro(EnumTipoDeRegistro.ENTRADA, h.retornaData(), c.get(codCol), s.get(codSala));
//          DadosBd.registrosBD.add(r);
        } else if (codTipo == 0) {
            //CRIA OBJETO REGISTRO VIA colaborador.regisrar
            resultado = c.get(codCol).registrar(EnumTipoDeRegistro.SAIDA, h.retornaData(), s.get(codSala));

            //add no banco
            Registro r = new Registro(EnumTipoDeRegistro.SAIDA, h.retornaData(), c.get(codCol), s.get(codSala));
  //        DadosBd.registrosBD.add(r);
        }

        if (resultado){
            System.out.println(" *** REGISTRADO COM SUCESSO *** ");
        }else{
            System.out.println("ACESSO NEGADO");
        }
    }







}//class






