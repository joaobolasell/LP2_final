package telas;

import dominio.Colaborador;
import dominio.Registro;
import dominio.Sala;

import java.text.DateFormat;
import java.util.ArrayList;

public class TelaColaboradores {

    public static void mostrarColaboradores(ArrayList<Colaborador> c){
        System.out.println("| RELATORIO DE COLABORADORES |");
        for (int i=0; i<c.size(); i++){
            System.out.println("| COLABORADOR "+i+" | NOME: "+c.get(i).getNome()+" | CARGO: "+c.get(i).getCargo()+" | NIVEL DE ACESSO: "+c.get(i).getNivelAcesso()+" |");
        }
    }

    public void mostrarColaboradoresSala(ArrayList<Colaborador> c, ArrayList<Sala> s){
        System.out.println("| RELATORIO DE COLABORADORES COM SALAS LIBERADAS |");
        for (int i=0; i<c.size(); i++){
            System.out.println("| COLABORADOR "+i+" | NOME: "+c.get(i).getNome()+" | CARGO: "+c.get(i).getCargo()+" | NIVEL DE ACESSO: "+c.get(i).getNivelAcesso()+" |");
            System.out.println("| SALAS LIBERADAS PARA O COLABORADOR |");
            for (int j=0; j<s.size(); j++){
                System.out.println("| SALA "+j+" | NOME: "+s.get(j).getNome()+" | TIPO: "+s.get(j).getTipo()+" |");
            }
            System.out.println();
        }
    }

    public void mostrarTudoColaborador(ArrayList<Colaborador> c, ArrayList<Sala> s, ArrayList<Registro> r){

        DateFormat f = DateFormat.getDateInstance(DateFormat.FULL);
        DateFormat hora = DateFormat.getTimeInstance();

        System.out.println("| RELATORIO DE COLABORADORES COMPLETO SALAS LIBERADAS E REGISTROS |\n");
        for (int i=0; i<c.size(); i++){
            System.out.println("| COLABORADOR "+i+" | NOME: "+c.get(i).getNome()+" | CARGO: "+c.get(i).getCargo()+" | NIVEL DE ACESSO: "+c.get(i).getNivelAcesso()+" |");
            System.out.println("| SALAS LIBERADAS PARA O COLABORADOR |");
            for (int j=0; j<s.size(); j++){
                System.out.println("| SALA "+j+" | NOME: "+s.get(j).getNome()+" | TIPO: "+s.get(j).getTipo()+" |");
            }
            System.out.println("| REGISTROS DO COLABORADOR |");
            for (int k=0; k<r.size(); k++){
                if (r.get(k).getUsuarioRegistro() == c.get(i)){
                    System.out.println("| REGISTRO "+k+" | TIPO DE REGISTRO: "+r.get(k).gettRegistro()+" | DATA E HORA: "+f.format(r.get(k).getDataHora())+" "+hora.format(r.get(k).getDataHora())+" | LOCAL DO REGISTRO: "+r.get(k).getSala().getNome()+" "+r.get(k).getSala().getTipo()+" |");
                }
            }
            System.out.println();
        }

    }



}
