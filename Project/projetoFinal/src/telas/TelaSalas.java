package telas;


import dominio.Sala;


import java.text.DateFormat;
import java.util.ArrayList;

public class TelaSalas {

    /* IMPRIME SALAS */
    public void mostrarSalas(ArrayList<Sala> s){
        System.out.println("| SALAS |");
        for (int i=0; i<s.size(); i++){
            System.out.println("| SALA "+i+" | NOME: "+s.get(i).getNome()+" | TIPO: "+s.get(i).getTipo()+" |");
        }
    }

    /* IMPRIME SALAS E COLABORADORES LIBERADOS NA SALA*/
    public void mostrarSalasColaboradores(ArrayList<Sala> s){
        System.out.println("| SALAS |");
        for (int i=0; i<s.size(); i++){
            System.out.println("| SALA "+i+" | NOME: "+s.get(i).getNome()+" | TIPO: "+s.get(i).getTipo()+" |");
            System.out.println("| COLABORADORES LIBERADOS NA SALA "+i+" |");
            for (int j=0; j<s.get(i).getColaboradoresLiberados().size(); j++){
                System.out.println("| NOME: "+s.get(i).getColaboradoresLiberados().get(j).getNome()+" | CARGO: "+s.get(i).getColaboradoresLiberados().get(j).getCargo());
            }
            System.out.println();
        }
    }

    /* IMPRIME SALAS COLABORADORES E REGISTROS */
    public void mostrarSalasColaboradoresRegistros(ArrayList<Sala> s){
        DateFormat f = DateFormat.getDateInstance(DateFormat.FULL);
        DateFormat hora = DateFormat.getTimeInstance();
        System.out.println("| SALAS |");
        for (int i=0; i<s.size(); i++){
            System.out.println("| SALA "+i+" | NOME: "+s.get(i).getNome()+" | TIPO: "+s.get(i).getTipo()+" |");
            System.out.println("| COLABORADORES LIBERADOS NA SALA "+i+" |");
            for (int j=0; j<s.get(i).getColaboradoresLiberados().size(); j++){
                System.out.println("| NOME: "+s.get(i).getColaboradoresLiberados().get(j).getNome()+" | CARGO: "+s.get(i).getColaboradoresLiberados().get(j).getCargo());
            }
            System.out.println("| REGISTOS NA SALA "+i+" |");
            for (int k=0; k<s.get(i).getRegistrosNaSala().size(); k++){
                System.out.println("| REGISTRO "+k+" | COLABORADOR: "+s.get(i).getRegistrosNaSala().get(k).getUsuarioRegistro().getNome()+" | TIPO DE REGISTRO: "+s.get(i).getRegistrosNaSala().get(k).gettRegistro()+" | DATA HORA: "+f.format(s.get(i).getRegistrosNaSala().get(k).getDataHora())+" "+hora.format(s.get(i).getRegistrosNaSala().get(k).getDataHora())+" |");
            }
            System.out.println();
        }
    }


}
