package dados;

import auxiliar.Help;
import dominio.*;

import java.util.ArrayList;
import java.util.Date;

public class DadosBd {

    public static ArrayList<Registro> registrosBD = new ArrayList<Registro>();

    public ArrayList<Colaborador> colaboradoresBD = new ArrayList<Colaborador>();

    public ArrayList<Sala> salasBD = new ArrayList<Sala>();

    public DadosBd() {

        Sala s1 = new Sala("Sala A", "Laboratorio");
        Sala s2 = new Sala("Sala B", "Refeitorio");
        Sala s3 = new Sala("Sala C", "Escrotirio");
        Sala s4 = new Sala("Sala D", "Geral");
        Sala s5 = new Sala("Sala F", "Gerencia");

        //ADICIONA SALAS NA LISTA DE SALAS
        salasBD.add(s1);
        salasBD.add(s2);
        salasBD.add(s3);
        salasBD.add(s4);
        salasBD.add(s5);


        Administrador adm1 = new Administrador("Adm1", "123", "adm@adm.com", "111");

        Colaborador c1 = new Colaborador("JOAO", "111", 1, "Limpeza", 2);
        Colaborador c2 = new Colaborador("RODOLFO", "222", 2, "Tecnico", 3);
        Colaborador c3 = new Colaborador("NICOLAU", "333", 3, "Gerente", 42); // nivel acesso 42 livre acesso.
        Colaborador c4 = new Colaborador("CLAUDIA", "444", 4, "Tecnico", 3);

        //ADICIONA COLABORADORES NA LISTA
        colaboradoresBD.add(c1);
        colaboradoresBD.add(c2);
        colaboradoresBD.add(c3);
        colaboradoresBD.add(c4);

        //LIBERA SALAS DO COLABORADOR C1
        c1.liberarSala(s1);
        c1.liberarSala(s2);
        c1.liberarSala(s3);
        c1.liberarSala(s4);
        c1.liberarSala(s5);

        //LIBERA SALAS DO COLABORADOR C2
        c2.liberarSala(s1);
        c2.liberarSala(s2);
        c2.liberarSala(s3);
        c2.liberarSala(s4);
        c2.liberarSala(s5);

        //LIBERA SALAS DO COLABORADOR C3
        c3.liberarSala(s1);
        c3.liberarSala(s2);
        c3.liberarSala(s3);
        c3.liberarSala(s4);
        c3.liberarSala(s5);

        //LIBERA SALAS DO COLABORADOR C4
        c4.liberarSala(s1);
        c4.liberarSala(s2);
        c4.liberarSala(s3);
        c4.liberarSala(s4);
        c4.liberarSala(s5);

        //--------------------------------------------------
        //CRIA DATAS PARA INSTANCIAR REGISTROS MANUALMENTE
        Date d2 = new Date(2022-1900, 1, 25, 23, 0, 0);
        Date d22 = new Date(2022-1900, 1, 25, 23, 2, 20);

        Date d3 = new Date(2022-1900, 2, 26, 23, 0, 0);
        Date d33 = new Date(2022-1900, 2, 26, 23, 5, 0);

        Date d4 = new Date(2022-1900, 10, 20, 10, 0, 0);
        Date d44 = new Date(2022-1900, 10, 20, 10, 35, 0);

        Date d5 = new Date(2022-1900, 10, 20, 11, 0, 0);
        Date d55 = new Date(2022-1900, 10, 20, 11, 25, 0);
        //----------------------------------------------------------

        //CRIA REGISTROS MANUAL COM DATAS CRIADAS ACIMA -
        // NÃO TESTA SE SALA TA LIBERADA, AS SALAS TEM QUE TA LIBERADA PRA REGISTRO MANUAL
        Registro r1 = new Registro(EnumTipoDeRegistro.ENTRADA, d2, c3, s1);
        Registro r2 = new Registro(EnumTipoDeRegistro.SAIDA, d22, c3, s1);
        Registro r3 = new Registro(EnumTipoDeRegistro.ENTRADA, d3, c3, s5);
        Registro r4 = new Registro(EnumTipoDeRegistro.SAIDA, d33, c3, s5);
        Registro r5 = new Registro(EnumTipoDeRegistro.ENTRADA, d4, c1, s2);
        Registro r6 = new Registro(EnumTipoDeRegistro.SAIDA, d44, c1, s2);
        Registro r7 = new Registro(EnumTipoDeRegistro.ENTRADA, d5, c2, s3);
        Registro r8 = new Registro(EnumTipoDeRegistro.SAIDA, d55, c2, s3);

        //ADICIONA REGISTROS NA LISTA
        registrosBD.add(r1);
        registrosBD.add(r2);
        registrosBD.add(r3);
        registrosBD.add(r4);
        registrosBD.add(r5);
        registrosBD.add(r6);
        registrosBD.add(r7);
        registrosBD.add(r8);

        Help h = new Help();
        //CRIA REGISTROS COM A FUNCAO DE GERAR DATA-HORA
        Registro r9 = new Registro(EnumTipoDeRegistro.ENTRADA, h.retornaData(),c1, s1);
        Registro r10 = new Registro(EnumTipoDeRegistro.SAIDA, h.retornaData(),c1, s1);
        Registro r11 = new Registro(EnumTipoDeRegistro.ENTRADA, h.retornaData(),c2, s2);
        Registro r12 = new Registro(EnumTipoDeRegistro.SAIDA, h.retornaData(),c2, s2);

        //ADICIONA REGISTROS NA LISTA
        registrosBD.add(r9);
        registrosBD.add(r10);
        registrosBD.add(r11);
        registrosBD.add(r12);

    } //construtor
    public DadosBd(int i){
        i=0;
    }

    public ArrayList<Registro> getRegistrosBD() {
        return registrosBD;
    }

    public ArrayList<Colaborador> getColaboradoresBD() {
        return colaboradoresBD;
    }

    public ArrayList<Sala> getSalasBD() {
        return salasBD;
    }
}
